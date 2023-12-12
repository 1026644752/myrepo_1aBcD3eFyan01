package com.yanchang.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class GreyRelationAnalysis {
   public static void main(String[] args) {
      try {
         // 读取Excel文件
         FileInputStream file = new FileInputStream("SCORE_MATRIX_ALL_FEATURE.xlsx");
         Workbook workbook = new XSSFWorkbook(file);
         Sheet sheet = workbook.getSheetAt(0);

         // 获取数据
         double[] x0 = new double[12];
         double[][] C_data = new double[23][12];

         // 读取x0
         Row rowX0 = sheet.getRow(0);
         for (int i = 0; i < 12; i++) {
            Cell cell = rowX0.getCell(i);
            x0[i] = cell.getNumericCellValue();
         }

         // 读取C_data
         for (int i = 0; i < 23; i++) {
            Row rowData = sheet.getRow(i);
            for (int j = 0; j < 12; j++) {
               Cell cell = rowData.getCell(j);
               C_data[i][j] = cell.getNumericCellValue();
            }
         }

         // 归一化
         double[] x0_normalized = new double[12];
         double[][] C_data_normalized = new double[23][12];

         for (int i = 0; i < 12; i++) {
            x0_normalized[i] = x0[i] / x0[0];
         }

         for (int i = 0; i < 23; i++) {
            double firstColValue = C_data[i][0];
            for (int j = 0; j < 12; j++) {
               C_data_normalized[i][j] = C_data[i][j] / firstColValue;
            }
         }

         // 计算全局最小值和最大值
         double global_min = Double.MAX_VALUE;
         double global_max = Double.MIN_VALUE;

         for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 12; j++) {
               double diff = Math.abs(C_data_normalized[i][j] - x0_normalized[j]);
               if (diff < global_min) {
                  global_min = diff;
               }
               if (diff > global_max) {
                  global_max = diff;
               }
            }
         }

         // 设置平衡参数
         double rho = 0.5;

         // 计算关联度
         double[][] GRD = new double[23][12];
         double[] mean_GRD = new double[23];

         for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 12; j++) {
               double diff = Math.abs(C_data_normalized[i][j] - x0_normalized[j]);
               GRD[i][j] = (global_min + (rho * global_max)) / (diff + (rho * global_max));
            }
            mean_GRD[i] = calculateMean(GRD[i]);
         }

         // 排序并输出前5个关联度最大的指标
         int[] sortedIndices = sortIndices(mean_GRD);
         String[] names = {"C11", "C21", "C22", "C23", "C24", "C31", "C32", "C33", "C34", "C35", "C36",
                 "C41", "C42", "C43", "C44", "C51", "C52", "C53", "C54", "C55", "C61", "C62", "C63"};

         System.out.println("前5个关联度最大的指标：");
         for (int i = 0; i < 5; i++) {
            System.out.println(names[sortedIndices[i]]);
         }

         // 绘制图表
         // TODO: 绘制图表的Java代码
         file.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static double calculateMean(double[] array) {
      double sum = 0;
      for (double value : array) {
         sum += value;
      }
      return sum / array.length;
   }

   public static int[] sortIndices(double[] array) {
      int length = array.length;
      int[] indices = new int[length];

      for (int i = 0; i < length; i++) {
         indices[i] = i;
      }

      for (int i = 0; i < length - 1; i++) {
         for (int j = 0; j < length - i - 1; j++) {
            if (array[j] < array[j + 1]) {
               double temp = array[j];
               array[j] = array[j + 1];
               array[j + 1] = temp;

               int tempIndex = indices[j];
               indices[j] = indices[j + 1];
               indices[j + 1] = tempIndex;
            }
         }
      }

      return indices;
   }
}

