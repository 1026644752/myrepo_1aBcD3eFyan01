package com.yanchang.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.yanchang.entity.Data_01;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class Main {
    public  List<Data_01> Search() {

        //存储数据 传递给前端
        List<Data_01> data01List = new ArrayList<Data_01>();
        Data_01 data1 = null;

        try {
            FileInputStream file = new FileInputStream("SCORE_MATRIX.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            double[][] Data = new double[sheet.getLastRowNum() + 1][sheet.getRow(0).getLastCellNum()];
            for (int i = 0; i < Data.length; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < Data[i].length; j++) {
                    Cell cell = row.getCell(j);
                    Data[i][j] = cell.getNumericCellValue();
                }
            }

            int mFea = Data.length;
            int nSmp = Data[0].length;

            double[][] Data_sort = new double[mFea][nSmp];
            int[][] Index_sort = new int[mFea][nSmp];
            for (int i = 0; i < mFea; i++) {
                for (int j = 0; j < nSmp; j++) {
                    Data_sort[i][j] = Data[i][j];
                    Index_sort[i][j] = j;
                }
                sort(Data_sort[i], Index_sort[i]);
            }

            for (int i = 0; i < mFea; i++) {
                for (int j = 0; j < nSmp; j++) {
                    Index_sort[i][j] ++;
                }
            }

            String []feature_name_C = {"C11","C21","C22","C23","C24","C31","C32","C33","C34","C35","C36","C41","C42","C43","C44","C51","C52","C53","C54","C55","C61","C62","C63"};



            //--------------------------A--------------------------------------------------------

            double min_A = Data_sort[29][0];
            int min_A_month = Index_sort[29][0];
            System.out.println("A指标年度最小值是：" + min_A + "      A指标年度最小值所在月份是：" + min_A_month + "月");
            data1 = new Data_01("A","A指标年度最小值是：" + min_A + "<br>       A指标年度最小值所在月份是：" + min_A_month + "月");
            data01List.add(data1);



            int index_min_A_Cfeature = findIndex(Index_sort, 0,0,22, min_A_month);
            System.out.println("对综合效能指标A最低值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_min_A_Cfeature]);
            data1 = new Data_01("A","对综合效能指标A最低值影响最大的C级指标是：" + feature_name_C[index_min_A_Cfeature]);
            data01List.add(data1);


            double max_A = Data_sort[29][nSmp - 1];
            int max_A_month = Index_sort[29][nSmp - 1];
            System.out.println("A指标年度最大值是：" + max_A + "      A指标年度最大值所在月份是：" + max_A_month + "月");
            data1 = new Data_01("A","A指标年度最大值是：" + max_A + "<br>       A指标年度最大值所在月份是：" + max_A_month + "月");
            data01List.add(data1);


            int index_max_A_Cfeature = findIndex(Index_sort, nSmp - 1,0,22, max_A_month);
            System.out.println("对综合效能指标A最高值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_max_A_Cfeature]);
            data1 = new Data_01("A","对综合效能指标A最高值影响最大的C级指标是："+feature_name_C[index_max_A_Cfeature]);
            data01List.add(data1);


            //B1---------------------------------------------------------------------------------------------------------
            double min_B1 = Data_sort[23][0];
            int min_B1_month = Index_sort[23][0];
            System.out.println("B1指标年度最小值是：" + min_B1 + "</br>      B1指标年度最小值所在月份是：" + min_B1_month + "月");
            data1 = new Data_01("B1","B1指标年度最小值是：" + min_B1 + "<br>      B1指标年度最小值所在月份是：" + min_B1_month + "月");
            data01List.add(data1);

            int index_min_B1_Cfeature = findIndex(Index_sort, 0,0,0, min_B1_month);
            System.out.println("对综合效能指标B1最低值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_min_B1_Cfeature]);
            data1 = new Data_01("B1","对综合效能指标B1最低值影响最大的C级指标是："+feature_name_C[index_min_B1_Cfeature]);
            data01List.add(data1);

            double max_B1 = Data_sort[23][nSmp - 1];
            int max_B1_month = Index_sort[23][nSmp - 1];
            System.out.println("B1指标年度最大值是：" + max_B1 + "B1指标年度最大值所在月份是：" + max_B1_month + "月");
            data1 = new Data_01("B1","B1指标年度最大值是：" + max_B1 + "<br> B1指标年度最大值所在月份是：" + max_B1_month + "月");
            data01List.add(data1);

            int index_max_B1_Cfeature = findIndex(Index_sort, nSmp - 1,0,0, max_B1_month);
            System.out.println("对综合效能指标B1最高值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_max_B1_Cfeature]);
            data1 = new Data_01("B1","对综合效能指标B1最高值影响最大的C级指标是："+feature_name_C[index_max_B1_Cfeature]);
            data01List.add(data1);


            //B2-------------------------------------------------------------------------------------------------------
            double min_B2 = Data_sort[24][0];
            int min_B2_month = Index_sort[24][0];
            System.out.println("B2指标年度最小值是：" + min_B2 + "      B2指标年度最小值所在月份是：" + min_B2_month + "月");
            data1 = new Data_01("B2","B2指标年度最小值是：" + min_B2 + "<br>       B2指标年度最小值所在月份是：" + min_B2_month + "月");
            data01List.add(data1);



            int index_min_B2_Cfeature = findIndex(Index_sort, 0,1,4, min_B2_month);
            System.out.println("对综合效能指标B2最低值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_min_B2_Cfeature]);
            data1 = new Data_01("B2","对综合效能指标B2最低值影响最大的C级指标是："+feature_name_C[index_min_B2_Cfeature]);
            data01List.add(data1);

            double max_B2 = Data_sort[24][nSmp - 1];
            int max_B2_month = Index_sort[24][nSmp - 1];
            System.out.println("B2指标年度最大值是：" + max_B2 + "      B2指标年度最大值所在月份是：" + max_B2_month + "月");
            data1 = new Data_01("B2","B2指标年度最大值是：" + max_B2 + "<br>       B2指标年度最大值所在月份是：" + max_B2_month + "月");
            data01List.add(data1);

            int index_max_B2_Cfeature = findIndex(Index_sort, nSmp - 1,1,4, max_B2_month);
            System.out.println("对综合效能指标B2最高值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_max_B2_Cfeature]);
            data1 = new Data_01("B2","对综合效能指标B2最高值影响最大的C级指标是：" + feature_name_C[index_max_B2_Cfeature]);
            data01List.add(data1);

            //B3-------------------------------------------------------------------------------------------------------
            double min_B3 = Data_sort[25][0];
            int min_B3_month = Index_sort[25][0];
            System.out.println("B3指标年度最小值是：" + min_B3 + "      B3指标年度最小值所在月份是：" + min_B3_month + "月");
            data1 = new Data_01("B3","B3指标年度最小值是：" + min_B3 + "<br>       B3指标年度最小值所在月份是：" + min_B3_month + "月");
            data01List.add(data1);


            int index_min_B3_Cfeature = findIndex(Index_sort, 0,5,10, min_B3_month);
            System.out.println("对综合效能指标B3最低值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_min_B3_Cfeature]);
            data1 = new Data_01("B3","对综合效能指标B3最低值影响最大的C级指标是：" + feature_name_C[index_min_B3_Cfeature]);
            data01List.add(data1);

            double max_B3 = Data_sort[25][nSmp - 1];
            int max_B3_month = Index_sort[25][nSmp - 1];
            System.out.println("B2指标年度最大值是：" + max_B3 + "      B3指标年度最大值所在月份是：" + max_B3_month + "月");
            data1 = new Data_01("B3","B2指标年度最大值是：" + max_B3 + "<br>       B3指标年度最大值所在月份是：" + max_B3_month + "月");
            data01List.add(data1);

            int index_max_B3_Cfeature = findIndex(Index_sort, nSmp - 1,5,10, max_B3_month);
            System.out.println("对综合效能指标B3最高值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_max_B3_Cfeature]);
            data1 = new Data_01("B3","对综合效能指标B3最高值影响最大的C级指标是：" + feature_name_C[index_max_B3_Cfeature]);
            data01List.add(data1);

            //B4-------------------------------------------------------------------------------------------------------
            double min_B4 = Data_sort[26][0];
            int min_B4_month = Index_sort[26][0];
            System.out.println("B4指标年度最小值是：" + min_B4 + "      B4指标年度最小值所在月份是：" + min_B4_month + "月");
            data1 = new Data_01("B4","B4指标年度最小值是：" + min_B4 + "<br>       B4指标年度最小值所在月份是：" + min_B4_month + "月");
            data01List.add(data1);

            int index_min_B4_Cfeature = findIndex(Index_sort, 0,11,14, min_B4_month);
            System.out.println("对综合效能指标B4最低值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_min_B4_Cfeature]);
            data1 = new Data_01("B4","对综合效能指标B4最低值影响最大的C级指标是：" + feature_name_C[index_min_B4_Cfeature]);
            data01List.add(data1);


            double max_B4 = Data_sort[26][nSmp - 1];
            int max_B4_month = Index_sort[26][nSmp - 1];
            System.out.println("B4指标年度最大值是：" + max_B4 + "      B4指标年度最大值所在月份是：" + max_B4_month + "月");
            data1 = new Data_01("B4","B4指标年度最大值是：" + max_B4 + "<br>       B4指标年度最大值所在月份是：" + max_B4_month + "月");
            data01List.add(data1);

            int index_max_B4_Cfeature = findIndex(Index_sort, nSmp - 1, 11, 14, max_B4_month);
            System.out.println("对综合效能指标B4最高值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_max_B4_Cfeature]);
            data1 = new Data_01("B4","对综合效能指标B4最高值影响最大的C级指标是：" + feature_name_C[index_max_B4_Cfeature]);
            data01List.add(data1);

            //B5--------------------------------------------------------------------------------------------------------

            double min_B5 = Data_sort[27][0];
            int min_B5_month = Index_sort[27][0];
            System.out.println("B5指标年度最小值是：" + min_B5 + "      B5指标年度最小值所在月份是：" + min_B5_month + "月");
            data1 = new Data_01("B5","B5指标年度最小值是：" + min_B5 + "<br>       B5指标年度最小值所在月份是：" + min_B5_month + "月");
            data01List.add(data1);


            int index_min_B5_Cfeature = findIndex(Index_sort, 0, 15, 19, min_B5_month);
            System.out.println("对综合效能指标B5最低值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_min_B5_Cfeature]);
            data1 = new Data_01("B5","对综合效能指标B5最低值影响最大的C级指标是：" + feature_name_C[index_min_B5_Cfeature]);
            data01List.add(data1);


            double max_B5 = Data_sort[27][nSmp - 1];
            int max_B5_month = Index_sort[27][nSmp - 1];
            System.out.println("B5指标年度最大值是：" + max_B5 + "      B5指标年度最大值所在月份是：" + max_B5_month + "月");
            data1 = new Data_01("B5","B5指标年度最大值是：" + max_B5 + "<br>       B5指标年度最大值所在月份是：" + max_B5_month + "月");
            data01List.add(data1);

            int index_max_B5_Cfeature = findIndex(Index_sort, nSmp - 1, 15, 19, max_B5_month);
            System.out.println("对综合效能指标B5最高值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_max_B5_Cfeature]);
            data1 = new Data_01("B5","对综合效能指标B5最高值影响最大的C级指标是：" + feature_name_C[index_max_B5_Cfeature]);
            data01List.add(data1);

           // B6------------------------------------------------------------------------------------------------------
            double min_B6 = Data_sort[28][0];
            int min_B6_month = Index_sort[28][0];
            System.out.println("B6指标年度最小值是：" + min_B6 + "      B6指标年度最小值所在月份是：" + min_B6_month + "月");
            data1 = new Data_01("B6","B6指标年度最小值是：" + min_B6 + " <br>      B6指标年度最小值所在月份是：" + min_B6_month + "月");
            data01List.add(data1);

            int index_min_B6_Cfeature = findIndex(Index_sort, 0, 20, 22, min_B6_month);
            System.out.println("对综合效能指标B6最低值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_min_B6_Cfeature]);

            data1 = new Data_01("B6","对综合效能指标B6最低值影响最大的C级指标是：" + feature_name_C[index_min_B6_Cfeature]);
            data01List.add(data1);

            double max_B6 = Data_sort[28][nSmp - 1];
            int max_B6_month = Index_sort[28][nSmp - 1];
            System.out.println("B6指标年度最大值是：" + max_B6 + "      B6指标年度最大值所在月份是：" + max_B6_month + "月");
            data1 = new Data_01("B6","B6指标年度最大值是：" + max_B6 + " <br>      B6指标年度最大值所在月份是：" + max_B6_month + "月");
            data01List.add(data1);

            int index_max_B6_Cfeature = findIndex(Index_sort, 0, 20, 22, max_B6_month);
            System.out.println("对综合效能指标B6最高值影响最大的C级指标是：");
            System.out.println(feature_name_C[index_max_B6_Cfeature]);
            data1 = new Data_01("B6","对综合效能指标B6最高值影响最大的C级指标是：" + feature_name_C[index_max_B6_Cfeature]);
            data01List.add(data1);
            // ---------------------------------------------------------------------------------------------------------

            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data01List;
    }


    private static void sort(double[] arr, int[] index) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    int tempIndex = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = tempIndex;
                }
            }
        }
    }

    private static int findIndex(int[][] arr, int col,int begin,int end, int value) {

        for (int i = begin; i <= end; i++) {
            if (arr[i][col] == value)
                return i;
        }
        return begin;
    }


}


