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
         //创造线性回归对象
         SimpleRegression regression = new SimpleRegression();
         //k值-----------------------------------------------
         double[] k1 = new double[23];
         for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 12; j++) {
               regression.addData(x_year[i],C_data[i][j]);
            }
            k1[i] = regression.getSlope();
         }

       /*  double[] y_IND = C_data[0];
         //创造线性回归对象
         SimpleRegression regression = new SimpleRegression();
         // 添加数据点 (X, Y)
         for (int i = 0; i < x_year.length; i++) {
            regression.addData(x_year[i],y_IND[i]);
            System.out.println(y_IND[i]);
         }
         // k值-----------------------------------------------------------
         double k1 = regression.getSlope();
         // 判断是否单调
         for (int i = 1; i < y_IND.length; i++) {
            if (y_IND[i] - y_IND[i-1] < 0) {
               System.out.println("结合线性拟合与统计学，C11效能指数总体不呈单调增加趋势");
               return;
            }
         }

         System.out.println("结合线性拟合与统计学，C11效能指数总体呈单调增加趋势");*/

         file.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
