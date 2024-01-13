package com.yanchang.service;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;




public class data_analysis_code {
   public static void main(String[] args) {
      try {
         FileInputStream file = new FileInputStream(new File("SCORE_MATRIX.xlsx"));
         XSSFWorkbook workbook = new XSSFWorkbook(file);

         Sheet sheet = workbook.getSheetAt(0);

         // 1.对C级指标效能指数的分析：
         double[][] C_data = new double[23][12];
         for (int i = 0; i < 23; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < 12; j++) {
               Cell cell = row.getCell(j);
               C_data[i][j] = cell.getNumericCellValue();
            }
         }

         double[] C_max = new double[23];
         double[] C_min = new double[23];
         double[] C_mean = new double[23];
         double[] C_median = new double[23];
         double[] C_var = new double[23];

         for (int i = 0; i < 23; i++) {
            double maxVal = C_data[i][0];
            double minVal = C_data[i][0];
            double sum = 0;
            for (int j = 0; j < 12; j++) {
               double val = C_data[i][j];
               if (val > maxVal) {
                  maxVal = val;
               }
               if (val < minVal) {
                  minVal = val;
               }
               sum += val;
            }
            C_max[i] = maxVal;
            C_min[i] = minVal;
            C_mean[i] = sum / 12;

            double[] sortedVals = C_data[i].clone();
            Arrays.sort(sortedVals);
            C_median[i] = sortedVals[sortedVals.length / 2];

            double variance = 0;
            for (int j = 0; j < 12; j++) {
               variance += Math.pow(C_data[i][j] - C_mean[i], 2);
            }
            C_var[i] = variance / 12;
         }

         // 总体趋势以C11为例
         double[] x_year = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
//         double[][] X = new double[x_year.length][2];
//         for (int i = 0; i < x_year.length; i++) {
//            X[i][0] = 1;  // 截距项
//            X[i][1] = x_year[i];
//         }
         double[][]X = {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7},{1,8},{1,9},{1,10},{1,11},{1,12}};

         double[] k1 = new double[23];
         double[] S = new double[23];
         for (int i = 0; i < 23; i++) {
            double[] y_IND = C_data[i];
            //斜率统计法判断该指标全年、半年的总体变化的趋势。
            // 构造最小二乘法求解器
            SimpleRegression regression = new SimpleRegression();

            // 添加样本点进行拟合
            for (int j=0; j<X.length; j++) {
               regression.addData(x_year[j], y_IND[j]);
            }

            // 获取模型参数
            double intercept = regression.getIntercept();
            double slope = regression.getSlope();
            k1[i] = slope;
            //计算一阶向后差分绝对值之和S=∑_(i=1)^n▒|x_i-x_(i-1) |
            S[i] = 0;
            for (int j = 1; j < X.length; j++) {
               S[i] +=Math.abs(y_IND[j]-y_IND[j-1]);
            }



         }

//------------------------------------！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
         for (int i = 0; i < 23; i++) {
            if (S[i] == Math.abs(C_data[i][11]-C_data[i][0])&&k1[i]>0){

               System.out.println("该序列单调增加趋势");
            } else if (S[i] == Math.abs(C_data[i][11]-C_data[i][0])&&k1[i]<0) {
               System.out.println("该序列单调减少趋势");
            }else if (S[i] > Math.abs(C_data[i][11]-C_data[i][0])){
               double Amp = Math.abs(C_data[i][11]-C_data[i][0])/S[i];
               System.out.println("该序列不呈严格的单调变化，有一定的震荡趋势,震荡程度大小是Amp = " + Amp);
            }
         }

         //测试输出
         for (double num : k1){
            System.out.println(num+"\n");
         }
         //测试输出



         file.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
