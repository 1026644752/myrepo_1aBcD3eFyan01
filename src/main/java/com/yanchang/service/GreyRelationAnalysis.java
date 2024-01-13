package com.yanchang.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class GreyRelationAnalysis {
   public static void main(String[] args) {
      try {
         // Load the Excel file
         FileInputStream fis = new FileInputStream("SCORE_MATRIX.xlsx");
         Workbook workbook = new XSSFWorkbook(fis);
         Sheet sheet = workbook.getSheetAt(0);

         // 读取数据
         double[] x0 = getRowData(sheet.getRow(29));
         double[][] C_data = new double[23][12];
         for (int i = 0; i < 23; i++) {
            C_data[i] = getRowData(sheet.getRow(i));
         }
         //计算各指标与综合效能指标A的全局最小分量离差绝对值与最大分量离差绝对值--------------------------------------------------
         // 归一化（首项归一化）
         double x0_1st = x0[0];
         for (int i = 0; i < x0.length; i++) {
            x0[i] /= x0_1st;
         }

         // Normalize C_data
         double[][] C_data_normal = new double[23][12];
         for (int i = 0; i < 23; i++) {
            double C_data_1st = C_data[i][0];
            for (int j = 0; j < 12; j++) {
               C_data_normal[i][j] = C_data[i][j] / C_data_1st;
            }
         }

         // 计算各指标与综合效能指标A的全局最小分量离差绝对值与最大分量离差绝对值
         double [] global_min = new double[23];
         double [] global_max = new double[23];
         for (int i = 0; i < 23; i++) {
            global_min[i] = Double.MAX_VALUE;
            global_max[i] = Double.MIN_VALUE;
         }
         for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 12; j++) {
               double diff = Math.abs(C_data_normal[i][j] - x0[j]);
               if (diff < global_min[i]) {
                  global_min[i] = diff;
               }
               if (diff > global_max[i]) {
                  global_max[i] = diff;
               }
            }
         }

      //计算各指标与综合效能指标A的全局最小分量离差绝对值与最大分量离差绝对值--------------------------------------------------end


         // 计算灰色关联系数向量
         double[][] GRD = new double[23][12];
         for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 12; j++) {
               GRD[i][j] = (global_min[i] + 0.5 * global_max[i]) / (Math.abs(C_data_normal[i][j] - x0[j]) + 0.5 * global_max[i]);
            }
         }

         // Calculate mean GRD
         double[] Mean_GRD = new double[23];
         for (int i = 0; i < 23; i++) {
            double sum = 0;
            for (int j = 0; j < 12; j++) {
               sum += GRD[i][j];
            }
            Mean_GRD[i] = sum / 12;
         }

         // Sort Mean_GRD and get the top 5 indices
         int[] index = new int[23];
         for (int i = 0; i < 23; i++) {
            index[i] = i;
         }
         for (int i = 0; i < 23 - 1; i++) {
            for (int j = 0; j < 23 - 1 - i; j++) {
               if (Mean_GRD[j] < Mean_GRD[j + 1]) {
                  double temp = Mean_GRD[j];
                  Mean_GRD[j] = Mean_GRD[j + 1];
                  Mean_GRD[j + 1] = temp;

                  int tempIndex = index[j];
                  index[j] = index[j + 1];
                  index[j + 1] = tempIndex;
               }
            }
         }
         String []feature_name_C = {"C11","C21","C22","C23","C24","C31","C32","C33","C34","C35","C36","C41","C42","C43","C44","C51","C52","C53","C54","C55","C61","C62","C63"};

         // 前5个对综合效能A关联度最大的指标
         double[][] Temp = new double[5][12];
         for (int i = 0; i < 5; i++) {
            Temp[i] = GRD[index[i]];
            System.out.println(feature_name_C[index[i]]);
         }



         fis.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private static double[] getRowData(Row row) {
      int lastCellNum = row.getLastCellNum();
      double[] rowData = new double[lastCellNum];
      for (int i = 0; i < lastCellNum; i++) {
         Cell cell = row.getCell(i);
         rowData[i] = cell.getNumericCellValue();
      }
      return rowData;
   }
}


