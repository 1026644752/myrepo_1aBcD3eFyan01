package com.yanchang.service;


import com.yanchang.entity.One_Level_Data;
import com.yanchang.entity.Three_Level_Data;
import com.yanchang.entity.Two_Level_Data;
import com.yanchang.mapper.A_one_levelMapper;
import com.yanchang.mapper.B_two_levelMapper;
import com.yanchang.mapper.C_three_levelMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static com.yanchang.service.LSDChb.lsd_chb;
import static com.yanchang.service.LSDShouy.lsd_shouy;


@Service
public class main_score {
    @Resource
    private C_three_levelMapper c_three_levelMapper;
    @Resource
    private A_one_levelMapper a_one_levelMapper;
    @Resource
    private B_two_levelMapper b_two_levelMapper;
    public void computeEfficients(int year) {

        // 将结果写入Excel文件
        FileOutputStream output = null;
        try {
            output = new FileOutputStream("SCORE_MATRIX_ALL_FEATURE.xlsx");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Workbook outputWorkbook = new XSSFWorkbook();
        Sheet outputSheet = outputWorkbook.createSheet("Scores");
        //导出表
       Row row0 = outputSheet.createRow(0);
        List<Three_Level_Data> c11 = c_three_levelMapper.selectOriginal("C11", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row0.createCell(i);
            cell.setCellValue(c11.get(i).getData());
        }
        Row row1 = outputSheet.createRow(1);
        List<Three_Level_Data> c21 = c_three_levelMapper.selectOriginal("C21", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row1.createCell(i);
            cell.setCellValue(c21.get(i).getData());
        }
        Row row2 = outputSheet.createRow(2);
        List<Three_Level_Data> c22 = c_three_levelMapper.selectOriginal("C22", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row2.createCell(i);
            cell.setCellValue(c22.get(i).getData());
        }
        Row row3 = outputSheet.createRow(3);
        List<Three_Level_Data> c23 = c_three_levelMapper.selectOriginal("C23", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row3.createCell(i);
            cell.setCellValue(c23.get(i).getData());
        }
        Row row4 = outputSheet.createRow(4);
        List<Three_Level_Data> c24 = c_three_levelMapper.selectOriginal("C24", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row4.createCell(i);
            cell.setCellValue(c24.get(i).getData());
        }
        Row row5 = outputSheet.createRow(5);
        List<Three_Level_Data> c31 = c_three_levelMapper.selectOriginal("C31", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row5.createCell(i);
            cell.setCellValue(c31.get(i).getData());
        }
        Row row6 = outputSheet.createRow(6);
        List<Three_Level_Data> c32 = c_three_levelMapper.selectOriginal("C32", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row6.createCell(i);
            cell.setCellValue(c32.get(i).getData());
        }
        Row row7 = outputSheet.createRow(7);
        List<Three_Level_Data> c33 = c_three_levelMapper.selectOriginal("C33", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row7.createCell(i);
            cell.setCellValue(c33.get(i).getData());
        }
        Row row8 = outputSheet.createRow(8);
        List<Three_Level_Data> c34 = c_three_levelMapper.selectOriginal("C34", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row8.createCell(i);
            cell.setCellValue(c34.get(i).getData());
        }
        Row row9 = outputSheet.createRow(9);
        List<Three_Level_Data> c35 = c_three_levelMapper.selectOriginal("C35", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row9.createCell(i);
            cell.setCellValue(c35.get(i).getData());
        }
        Row row10 = outputSheet.createRow(10);
        List<Three_Level_Data> c36 = c_three_levelMapper.selectOriginal("C36", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row10.createCell(i);
            cell.setCellValue(c36.get(i).getData());
        }
        Row row11 = outputSheet.createRow(11);
        List<Three_Level_Data> c41 = c_three_levelMapper.selectOriginal("C41", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row11.createCell(i);
            cell.setCellValue(c41.get(i).getData());
        }
        Row row12 = outputSheet.createRow(12);
        List<Three_Level_Data> c42 = c_three_levelMapper.selectOriginal("C42", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row12.createCell(i);
            cell.setCellValue(c42.get(i).getData());
        }
        Row row13 = outputSheet.createRow(13);
        List<Three_Level_Data> c43 = c_three_levelMapper.selectOriginal("C43", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row13.createCell(i);
            cell.setCellValue(c43.get(i).getData());
        }
        Row row14 = outputSheet.createRow(14);
        List<Three_Level_Data> c44 = c_three_levelMapper.selectOriginal("C44", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row14.createCell(i);
            cell.setCellValue(c44.get(i).getData());
        }
        Row row15 = outputSheet.createRow(15);
        List<Three_Level_Data> c51 = c_three_levelMapper.selectOriginal("C51", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row15.createCell(i);
            cell.setCellValue(c51.get(i).getData());
        }
        Row row16 = outputSheet.createRow(16);
        List<Three_Level_Data> c52 = c_three_levelMapper.selectOriginal("C52", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row16.createCell(i);
            cell.setCellValue(c52.get(i).getData());
        }
        Row row17 = outputSheet.createRow(17);
        List<Three_Level_Data> c53 = c_three_levelMapper.selectOriginal("C53", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row17.createCell(i);
            cell.setCellValue(c53.get(i).getData());
        }
        Row row18 = outputSheet.createRow(18);
        List<Three_Level_Data> c54 = c_three_levelMapper.selectOriginal("C54", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row18.createCell(i);
            cell.setCellValue(c54.get(i).getData());
        }
        Row row19 = outputSheet.createRow(19);
        List<Three_Level_Data> c55 = c_three_levelMapper.selectOriginal("C55", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row19.createCell(i);
            cell.setCellValue(c55.get(i).getData());
        }
        Row row20 = outputSheet.createRow(20);
        List<Three_Level_Data> C61 = c_three_levelMapper.selectOriginal("C61", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row20.createCell(i);
            cell.setCellValue(C61.get(i).getData());
        }
        Row row21= outputSheet.createRow(21);
        List<Three_Level_Data> C62 = c_three_levelMapper.selectOriginal("C62", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row21.createCell(i);
            cell.setCellValue(C62.get(i).getData());
        }
        Row row22 = outputSheet.createRow(22);
        List<Three_Level_Data> C63 = c_three_levelMapper.selectOriginal("C63", year);
        for (int i = 0; i < 12; i++) {
            Cell cell= row22.createCell(i);
            cell.setCellValue(C63.get(i).getData());
        }


        try {
            outputWorkbook.write(output);
            output.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        String filePath = "SCORE_MATRIX_ALL_FEATURE.xlsx";
        FileInputStream file = null;
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);

        // 数据导入
        double[][] X = new double[23][12];
        for (int i = 0; i < 23; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < 12; j++) {
                Cell cell = row.getCell(j);
                X[i][j] = cell.getNumericCellValue();
            }
        }
        try {
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // 权重和指标数据
        double[] wA = {0.245, 0.1775, 0.1575, 0.155, 0.1625, 0.1025};
        double[] wB1 = {1};
        double[] wB2 = {0.194, 0.136, 0.298, 0.372};
        double[] wB3 = {0.1675, 0.105, 0.185, 0.2125, 0.155, 0.175};
        double[] wB4 = {0.38, 0.236, 0.188, 0.196};
        double[] wB5 = {0.285, 0.155, 0.17, 0.1725, 0.2175};
        double[] wB6 = {0.406, 0.364, 0.23};
        double[] VC11 = {85, 99, 102};
        double[] VC21 = {5.5, 4, 1.5};
        double[] VC22 = {6, 3, 1};
        double[] VC23 = {90, 98, 100};
        double[] VC24 = {75, 85, 95};

        double[] VC31 = {105, 103, 100};
        double[] VC32 = {3200, 2970, 2918};
        double[] VC33 = {2550, 2515, 2500};
        double[] VC34 = {0.4, 0.28, 0.12};
        double[] VC35 = {12550, 12530, 12500};
        double[] VC36 = {35, 32.5, 30};

        double[] VC41 = {12, 5, 0};
        double[] VC42 = {95, 98, 100};
        double[] VC43 = {0.1, 0.05, 0.03};
        double[] VC44 = {0.1, 0.09, 0.07};

        double[] VC51 = {87, 93, 100};
        double[] VC52 = {70, 80, 100};
        double[] VC53 = {20, 16, 14};
        double[] VC54 = {90, 95, 100};
        double[] VC55 = {80, 88, 100};

        double[] VC61 = {30, 15, 5};
        double[] VC62 = {0.05, 0.012, 0.0025};
        double[] VC63 = {28, 12, 2};

        double[][] K = {{40}, {70}, {100}};
        double[][] SAll = new double[80][12];
//1.1 计算全年1-12月的，C11隶属度，B1隶属度，以及各自效能指数
        //读取数据X中第一行
        double[] XB1 = X[0];

        for (int i = 0; i < 12; i++) {
            XB1[i] = X[0][i];
        }

        double[][] LC11 = new double[12][3];
        for (int i = 0; i < 12; i++) {
            LC11[i] = lsd_shouy(VC11, XB1[i]);
        }

        double[] SC11 = new double[12];
        for (int i = 0; i < 12; i++) {
            //SC11[i] = 0;
            for (int j = 0; j < 3; j++) {
                SC11[i] += LC11[i][j] * K[j][0];
            }
        }

        double[][] LB1 = new double[12][3];
        for (int i = 0; i < 12; i++) {
            double[][] LC = {LC11[i]};
            double [][]LC1=transpose(LC);
            for (int j = 0; j < 3; j++) {
                LB1[i][j] =dotProduct(wB1,LC1[j]);
            }
        }
        double[][] SB1=multiply(LB1,K);


        for (int i = 0; i < 12; i++) {
            SAll[0][i] = SC11[i];
            SAll[23][i] = LB1[i][0];
        }


// 2.计算全年1-12月的，C21、C22、C23、C24隶属度，B2隶属度，以及各自效能指数
        //------------------------------------------------------------------------------------------------------------
        // 切片起始行（包括该行）
        int startRow = 1;
        // 切片结束行（不包括该行）
        int endRow = 5;
        // 计算切片的行数
        int numRows = endRow - startRow;
        // 计算列数（假设所有行列数相同）
        int numCols = X[0].length;
        // 创建切片二维数组
        double[][] XB2 = new double[numRows][numCols];
        // 执行切片操作
        for (int i = startRow, j = 0; i < endRow; i++, j++) {
            for (int col = 0; col < numCols; col++) {
                XB2[j][col] = X[i][col];
            }
        }
        double[][] XB3 = new double[11 - 5][numCols];
        for (int i = 5, j = 0; i < 11; i++, j++) {
            for (int col = 0; col < numCols; col++) {
                XB3[j][col] = X[i][col];
            }
        }
        double[][] XB4 = new double[15 - 11][numCols];
        for (int i = 11, j = 0; i < 15; i++, j++) {
            for (int col = 0; col < numCols; col++) {
                XB4[j][col] = X[i][col];
            }
        }
        double[][] XB5 = new double[20 - 15][numCols];
        for (int i = 15, j = 0; i < 20; i++, j++) {
            for (int col = 0; col < numCols; col++) {
                XB5[j][col] = X[i][col];
            }
        }
        double[][] XB6 = new double[23 - 20][numCols];
        for (int i = 20, j = 0; i < 23; i++, j++) {
            for (int col = 0; col < numCols; col++) {
                XB6[j][col] = X[i][col];
            }
        }
        //-----------------------------------------------------------------------------------
        double LC21[][] = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC21[i] = lsd_chb(VC21, XB2[0][i]);
        }

        double SC21[] = new double[12];
        for (int i = 0; i < 12; i++) {
            SC21[i] = LC21[i][0] * K[0][0] + LC21[i][1] * K[1][0] + LC21[i][2] * K[2][0];
        }
        double LC22[][] = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC22[i] = lsd_chb(VC22, XB2[1][i]);
        }

        double SC22[] = new double[12];
        for (int i = 0; i < 12; i++) {
            SC22[i] = LC22[i][0] * K[0][0] + LC22[i][1] * K[1][0] + LC22[i][2] * K[2][0];
        }
        double LC23[][] = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC23[i] = lsd_shouy(VC23, XB2[2][i]);
        }

        double SC23[] = new double[12];
        for (int i = 0; i < 12; i++) {
            SC23[i] = LC23[i][0] * K[0][0] + LC23[i][1] * K[1][0] + LC23[i][2] * K[2][0];
        }
        double LC24[][] = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC24[i] = lsd_shouy(VC24, XB2[3][i]);
        }

        double SC24[] = new double[12];
        for (int i = 0; i < 12; i++) {
            SC24[i] = LC24[i][0] * K[0][0] + LC24[i][1] * K[1][0] + LC24[i][2] * K[2][0];
        }
        double LB2[][] = new double[12][3];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                LB2[i][j] = wB2[0] * LC21[i][j] + wB2[1] * LC22[i][j] + wB2[2] * LC23[i][j] + wB2[3] * LC24[i][j];
            }
        }

        double SB2[] = new double[12];
        for (int i = 0; i < 12; i++) {
            SB2[i] = LB2[i][0] * K[0][0] + LB2[i][1] * K[1][0] + LB2[i][2] * K[2][0];
        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < 12; j++) {
                SAll[i][j] = (i == 2) ? SC21[j] : ((i == 3) ? SC22[j] : ((i == 4) ? SC23[j] : SC24[j]));
            }
        }

        for (int i = 0; i < 12; i++) {
            SAll[25][i] = SB2[i];
        }


// 3.计算全年1-12月的，C31，C32，C33，C34，C35，C36隶属度，B3隶属度，以及各自效能指数
        // Calculate SC31
        double[][] LC31 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC31[i] = lsd_chb(VC31, XB3[0][i]);
        }
        double[][] SC31 = multiply(LC31, K);
        /*    SC31 = transpose(SC31);*/

        // Calculate SC32
        double[][] LC32 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC32[i] = lsd_chb(VC32, XB3[1][i]);
        }
        double[][] SC32 = multiply(LC32, K);


        // Calculate SC33
        double[][] LC33 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC33[i] = lsd_chb(VC33, XB3[2][i]);
        }
        double[][] SC33 = multiply(LC33, K);


        // Calculate SC34
        double[][] LC34 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC34[i] = lsd_chb(VC34, XB3[3][i]);
        }
        double[][] SC34 = multiply(LC34, K);


        // Calculate SC35
        double[][] LC35 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC35[i] = lsd_chb(VC35, XB3[4][i]);
        }
        double[][] SC35 = multiply(LC35, K);


        // Calculate SC36
        double[][] LC36 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC36[i] = lsd_chb(VC36, XB3[5][i]);
        }
        double[][] SC36 = multiply(LC36, K);


        double[][] LB3 = new double[12][3];
        for (int i = 0; i < 12; i++) {
            double[][] LC = {LC31[i], LC32[i], LC33[i], LC34[i], LC35[i], LC36[i]};
            double LC1[][] = transpose(LC);
            /* LB3[0][i] = dotProduct(wB3, LC1[i]);*/
            for (int j = 0; j < 3; j++) {
                LB3[i][j] = dotProduct(wB3, LC1[j]);
            }
        }
        double[][] SB3 = multiply(LB3, K);


        for (int i = 0; i < 12; i++) {
            SAll[i + 5][0] = SC31[i][0];
            SAll[i + 5][1] = SC32[i][0];
            SAll[i + 5][2] = SC33[i][0];
            SAll[i + 5][3] = SC34[i][0];
            SAll[i + 5][4] = SC35[i][0];
            SAll[i + 5][5] = SC36[i][0];
        }
        SAll[25][0] = SB3[0][0];


//         double[] array1 = new double[];
//         double[] array2 = new double[];
//
//         double result = 0.0;
//         for (int i = 0; i < array1.length; i++) {
//            result += array1[i] * array2[i];
//         }

        //XB3按行存储的是B4指标的4个C级指标数据

        //计算C41全年1-12月的效能指数
        double[][] LC41 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC41[i] = lsd_chb(VC41, XB4[0][i]);
        }
        double[][] SC41 = multiply(LC41, K);
        SC41 = transpose(SC41);

        //计算C42全年1-12月的效能指数
        double[][] LC42 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC42[i] = lsd_shouy(VC42, XB4[1][i]);
        }
        double[][] SC42 = multiply(LC42, K);
        SC42 = transpose(SC42);

        //计算C43全年1-12月的效能指数
        double[][] LC43 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC43[i] = lsd_chb(VC43, XB4[2][i]);
        }
        double[][] SC43 = multiply(LC43, K);
        SC43 = transpose(SC43);

        //计算C44全年1-12月的效能指数
        double[][] LC44 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC44[i] = lsd_chb(VC44, XB4[3][i]);
        }
        double[][] SC44 = multiply(LC44, K);
        SC44 = transpose(SC44);

        double[][] LB4 = new double[12][3];
        for (int i = 0; i < 12; i++) {
            double[][] LC = {LC41[i], LC42[i], LC43[i], LC44[i]};
            double[][] LC2 = transpose(LC);
            for (int j = 0; j < 3; j++) {
                LB4[i][j] = dotProduct(wB4, LC2[j]);
            }

        }
        double[][] SB4 = multiply(LB4, K);


        for (int i = 11; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                SAll[i][j] = SC41[i - 11][j];
            }
        }
        SAll[26] = SB4[0];



        // 存储结果
        SAll[0] = SC11;


        // 计算B2及子指标的效能指数

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                XB2[i][j] = X[i + 1][j];
            }
        }


        for (int i = 0; i < 12; i++) {
            LC21[i] = lsd_chb(VC21, XB2[0][i]);
        }
        // 其他子指标请按照类似的方式计算


        for (int i = 0; i < 12; i++) {
            double[][] k1 = transpose(K);
            SC21[i] = dotProduct(LC21[i], k1[0]);
        }
        // 其他效能指数请按照类似的方式计算




        // 5.计算全年1-12月的，C51，C52，C53，C54，C55隶属度，B5隶属度，以及各自效能指数


        double[][] LC51 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC51[i] = lsd_shouy(VC51, XB5[0][i]);
        }
        double[][] SC51 = multiply(LC51, K);
        transpose(SC51);

        double[][] LC52 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC52[i] = lsd_shouy(VC52, XB5[1][i]);
        }
        double[][] SC52 = multiply(LC52, K);
        transpose(SC52);

        double[][] LC53 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC53[i] = lsd_chb(VC53, XB5[2][i]);
        }
        double[][] SC53 = multiply(LC53, K);
        transpose(SC53);

        double[][] LC54 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC54[i] = lsd_shouy(VC54, XB5[3][i]);
        }
        double[][] SC54 = multiply(LC54, K);
        transpose(SC54);

        double[][] LC55 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC55[i] = lsd_shouy(VC55, XB5[4][i]);
        }
        double[][] SC55 = multiply(LC55, K);
        transpose(SC55);

        double[][] LB5 = new double[12][3];
        for (int i = 0; i < 12; i++) {
            double[][] LC={LC51[i], LC52[i], LC53[i], LC54[i], LC55[i]};
            double LC1[][]=transpose(LC);
            for (int j = 0; j < 3; j++) {
                LB5[i][j]=dotProduct(wB5,LC1[j]);
            }
        }
        double[][] SB5=multiply(LB5,K);
        for (int i = 0; i < 12; i++) {
            SAll[15 + i] = SC51[i];
            SAll[27 + i] = SC52[i];
            SAll[39 + i] = SC53[i];
            SAll[51 + i] = SC54[i];
            SAll[63 + i] = SC55[i];
        }
        SAll[27] = SB5[0];

        // 6.计算全年1-12月的，C61，C62，C63隶属度，B6隶属度，以及各自效能指


        double[][] LC61 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC61[i] = lsd_chb(VC61, XB6[0][i]);
        }
        double[][] SC61 = multiply(LC61, K);
        transpose(SC61);

        double[][] LC62 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC62[i] = lsd_chb(VC62, XB6[1][i]);
        }
        double[][] SC62 = multiply(LC62, K);
        transpose(SC62);

        double[][] LC63 = new double[12][];
        for (int i = 0; i < 12; i++) {
            LC63[i] = lsd_chb(VC63, XB6[2][i]);
        }
        double[][] SC63 = multiply(LC63, K);
        transpose(SC63);


        double[][] LB6 = new double[12][3];
        for (int i = 0; i < 12; i++) {
            double[][] LC={LC61[i], LC62[i], LC63[i]};
            double LC1[][]=transpose(LC);
            for (int j = 0; j < 3; j++) {
                LB6[i][j]=dotProduct(wB6,LC1[j]);
            }
        }
        double[][] SB6=multiply(LB6,K);

        for (int i = 0; i < 12; i++) {
            SAll[20 + i] = SC61[i];
            SAll[32 + i] = SC62[i];
            SAll[44 + i] = SC63[i];
        }
        SAll[28] = SB6[0];

     /*   double[][] LA = new double[12][12];
        for (int i = 0; i < 12; i++) {
            LA = multiply(wA, new double[][]{LB1[i], LB2[i], LB3[i], LB4[i], LB5[0], LB6[0]});
        }
        double[][] SA = multiply(LA, K);
        transpose(SA);*/

        double[][] LA = new double[12][3];
        for (int i = 0; i < 12; i++) {
            double[][] LA1={LB1[i], LB2[i], LB3[i],LB4[i],LB5[i],LB6[i]};
            double LA11[][]=transpose(LA1);
            for (int j = 0; j < 3; j++) {
                LA[i][j]=dotProduct(wA,LA11[j]);
            }
        }
        double[][] SA=multiply(LA,K);
        //------------------------------------------------最终结果  SALL  ----------------------------------------------
        SAll[29] = SA[0];

        for (int i = 0; i < 12; i++) {
            One_Level_Data data = new One_Level_Data();
            data.setIndex_name("综合能效");
            data.setMonth(i+1);
            data.setYear(year);
            data.setIndex_num("A");
            data.setData(SA[i][0]);
            a_one_levelMapper.insertA_one_level(data);
        }
        for (int i = 0; i < 12; i++) {
           Two_Level_Data data = new Two_Level_Data();
            data.setIndex_name("计划执行");
            data.setMonth(i+1);
            data.setYear(year);
            data.setIndex_num("B1");
            data.setData(SB1[i][0]);
            b_two_levelMapper.insertB_two_level(data);
        }
        for (int i = 0; i < 12; i++) {
            Two_Level_Data data = new Two_Level_Data();
            data.setIndex_name("设备效率");
            data.setMonth(i+1);
            data.setYear(year);
            data.setIndex_num("B2");
            data.setData(SB2[i]);
            b_two_levelMapper.insertB_two_level(data);
        }
        for (int i = 0; i < 12; i++) {
            Two_Level_Data data = new Two_Level_Data();
            data.setIndex_name("生产物耗");
            data.setMonth(i+1);
            data.setYear(year);
            data.setIndex_num("B3");
            data.setData(SB3[i][0]);
            b_two_levelMapper.insertB_two_level(data);
        }
        for (int i = 0; i < 12; i++) {
            Two_Level_Data data = new Two_Level_Data();
            data.setIndex_name("制丝工艺");
            data.setMonth(i+1);
            data.setYear(year);
            data.setIndex_num("B4");
            data.setData(SB4[i][0]);
            b_two_levelMapper.insertB_two_level(data);
        }
        for (int i = 0; i < 12; i++) {
            Two_Level_Data data = new Two_Level_Data();
            data.setIndex_name("卷接包工艺");
            data.setMonth(i+1);
            data.setYear(year);
            data.setIndex_num("B5");
            data.setData(SB5[i][0]);
            b_two_levelMapper.insertB_two_level(data);
        }
        for (int i = 0; i < 12; i++) {
            Two_Level_Data data = new Two_Level_Data();
            data.setIndex_name("节能减排");
            data.setMonth(i+1);
            data.setYear(year);
            data.setIndex_num("B6");
            data.setData(SB6[i][0]);
            b_two_levelMapper.insertB_two_level(data);
        }


        for (int i = 0; i < 12; i++) {
            c11.get(i).setData(SC11[i]);
            c_three_levelMapper.insertC_three_level(c11.get(i));
            c21.get(i).setData(SC21[i]);
            c_three_levelMapper.insertC_three_level(c21.get(i));
            c22.get(i).setData(SC22[i]);
            c_three_levelMapper.insertC_three_level(c22.get(i));
            c23.get(i).setData(SC23[i]);
            c_three_levelMapper.insertC_three_level(c23.get(i));
            c24.get(i).setData(SC24[i]);
            c_three_levelMapper.insertC_three_level(c24.get(i));
            c31.get(i).setData(SC31[i][0]);
            c_three_levelMapper.insertC_three_level(c31.get(i));
            c32.get(i).setData(SC32[i][0]);
            c_three_levelMapper.insertC_three_level(c32.get(i));
            c33.get(i).setData(SC33[i][0]);
            c_three_levelMapper.insertC_three_level(c33.get(i));
            c34.get(i).setData(SC34[i][0]);
            c_three_levelMapper.insertC_three_level(c34.get(i));
            c35.get(i).setData(SC35[i][0]);
            c_three_levelMapper.insertC_three_level(c35.get(i));
            c36.get(i).setData(SC36[i][0]);
            c_three_levelMapper.insertC_three_level(c36.get(i));
            c41.get(i).setData(SC41[0][i]);
            c_three_levelMapper.insertC_three_level(c41.get(i));
            c42.get(i).setData(SC42[0][i]);
            c_three_levelMapper.insertC_three_level(c42.get(i));
            c43.get(i).setData(SC43[0][i]);
            c_three_levelMapper.insertC_three_level(c43.get(i));
            c44.get(i).setData(SC44[0][i]);
            c_three_levelMapper.insertC_three_level(c44.get(i));
            c51.get(i).setData(SC51[i][0]);
            c_three_levelMapper.insertC_three_level(c51.get(i));
            c52.get(i).setData(SC52[i][0]);
            c_three_levelMapper.insertC_three_level(c52.get(i));
            c53.get(i).setData(SC53[i][0]);
            c_three_levelMapper.insertC_three_level(c53.get(i));
            c54.get(i).setData(SC54[i][0]);
            c_three_levelMapper.insertC_three_level(c54.get(i));
            c55.get(i).setData(SC55[i][0]);
            c_three_levelMapper.insertC_three_level(c55.get(i));
            c55.get(i).setData(SC55[i][0]);
            c_three_levelMapper.insertC_three_level(c55.get(i));
            C61.get(i).setData(SC61[i][0]);
            c_three_levelMapper.insertC_three_level(C61.get(i));
            C62.get(i).setData(SC62[i][0]);
            c_three_levelMapper.insertC_three_level(C62.get(i));
            C63.get(i).setData(SC63[i][0]);
            c_three_levelMapper.insertC_three_level(C63.get(i));
        }

    /*    FileOutputStream output1 = null;
        try {
            output1 = new FileOutputStream("SCORE_MATRIX.xlsx");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Workbook outputWorkbook1 = new XSSFWorkbook();
        Sheet outputSheet1 = outputWorkbook1.createSheet("Scores");

        Row []row =new Row[30];
        for (int i = 0; i < 30; i++) {
            row[i] = outputSheet1.createRow(i);
        }

        for (int i = 0; i < 12; i++) {
            Cell cell0= row[0].createCell(i);
            cell0.setCellValue(c11.get(i).getData());
            Cell cell1= row[1].createCell(i);
            cell1.setCellValue(c21.get(i).getData());

            Cell cell2= row[2].createCell(i);
            cell2.setCellValue(c22.get(i).getData());

            Cell cell3= row[3].createCell(i);
            cell3.setCellValue(c23.get(i).getData());

            Cell cell4= row[4].createCell(i);
            cell4.setCellValue(SC24[i]);

            Cell cell5= row[5].createCell(i);
            cell5.setCellValue(SC31[i][0]);

            Cell cell6= row[6].createCell(i);
            cell6.setCellValue(c32.get(i).getData());

            Cell cell7= row[7].createCell(i);
            cell7.setCellValue(SC33[i][0]);

            Cell cell8= row[8].createCell(i);
            cell8.setCellValue(SC34[i][0]);

            Cell cell9= row[9].createCell(i);
            cell9.setCellValue(SC35[i][0]);

            Cell cell10= row[10].createCell(i);
            cell10.setCellValue(SC36[i][0]);

            Cell cell11= row[11].createCell(i);
            cell11.setCellValue(SC41[0][i]);

            Cell cell12= row[12].createCell(i);
            cell12.setCellValue(SC42[0][i]);

            Cell cell13= row[13].createCell(i);
            cell13.setCellValue(SC43[0][i]);

            Cell cell14= row[14].createCell(i);
            cell14.setCellValue(SC44[0][i]);

            Cell cell15= row[15].createCell(i);
            cell15.setCellValue(SC51[i][0]);

            Cell cell16= row[16].createCell(i);
            cell16.setCellValue(SC52[i][0]);

            Cell cell17= row[17].createCell(i);
            cell17.setCellValue(SC53[i][0]);

            Cell cell18= row[18].createCell(i);
            cell18.setCellValue(SC54[i][0]);

            Cell cell19= row[19].createCell(i);
            cell19.setCellValue(SC55[i][0]);

            Cell cell20= row[20].createCell(i);
            cell20.setCellValue(SC61[i][0]);

            Cell cell21= row[21].createCell(i);
            cell21.setCellValue(SC62[i][0]);

            Cell cell22= row[22].createCell(i);
            cell22.setCellValue(SC63[i][0]);

            Cell cell23= row[23].createCell(i);
            cell23.setCellValue(SB1[i][0]);

            Cell cell24= row[24].createCell(i);
            cell24.setCellValue(SB2[i]);

            Cell cell25= row[25].createCell(i);
            cell25.setCellValue(SB3[i][0]);

            Cell cell26= row[26].createCell(i);
            cell26.setCellValue(SB4[i][0]);

            Cell cell27= row[27].createCell(i);
            cell27.setCellValue(SB5[i][0]);

            Cell cell28= row[28].createCell(i);
            cell28.setCellValue(SB6[i][0]);

            Cell cell29= row[29].createCell(i);
            cell29.setCellValue(SA[i][0]);
        }
        try {
            outputWorkbook1.write(output1);
            output1.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }



    public void Compute(int year){
        FileOutputStream output1 = null;
        try {
            output1 = new FileOutputStream("SCORE_MATRIX.xlsx");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Workbook outputWorkbook1 = new XSSFWorkbook();
        Sheet outputSheet1 = outputWorkbook1.createSheet("Scores");

        Row []row =new Row[30];
        for (int i = 0; i < 30; i++) {
            row[i] = outputSheet1.createRow(i);
        }
        List<Three_Level_Data> c11 = c_three_levelMapper.selectChart("C11", year);
        List<Three_Level_Data> c21 = c_three_levelMapper.selectChart("C21", year);
        List<Three_Level_Data> c22 = c_three_levelMapper.selectChart("C22", year);
        List<Three_Level_Data> c23 = c_three_levelMapper.selectChart("C23", year);
        List<Three_Level_Data> c24 = c_three_levelMapper.selectChart("C24", year);
        List<Three_Level_Data> c31 = c_three_levelMapper.selectChart("C31", year);
        List<Three_Level_Data> c32 = c_three_levelMapper.selectChart("C32", year);
        List<Three_Level_Data> c33 = c_three_levelMapper.selectChart("C33", year);
        List<Three_Level_Data> c34 = c_three_levelMapper.selectChart("C34", year);
        List<Three_Level_Data> c35 = c_three_levelMapper.selectChart("C35", year);
        List<Three_Level_Data> c36 = c_three_levelMapper.selectChart("C36", year);
        List<Three_Level_Data> c41 = c_three_levelMapper.selectChart("C41", year);
        List<Three_Level_Data> c42 = c_three_levelMapper.selectChart("C42", year);
        List<Three_Level_Data> c43 = c_three_levelMapper.selectChart("C43", year);
        List<Three_Level_Data> c44 = c_three_levelMapper.selectChart("C44", year);
        List<Three_Level_Data> c51 = c_three_levelMapper.selectChart("C51", year);
        List<Three_Level_Data> c52 = c_three_levelMapper.selectChart("C52", year);
        List<Three_Level_Data> c53 = c_three_levelMapper.selectChart("C53", year);
        List<Three_Level_Data> c54 = c_three_levelMapper.selectChart("C54", year);
        List<Three_Level_Data> c55 = c_three_levelMapper.selectChart("C55", year);
        List<Three_Level_Data> c61 = c_three_levelMapper.selectChart("C61", year);
        List<Three_Level_Data> c62 = c_three_levelMapper.selectChart("C62", year);
        List<Three_Level_Data> c63 = c_three_levelMapper.selectChart("C63", year);

        List<Two_Level_Data> b1 = b_two_levelMapper.selectChart("B1", year);
        List<Two_Level_Data> b2 = b_two_levelMapper.selectChart("B2", year);
        List<Two_Level_Data> b3 = b_two_levelMapper.selectChart("B3", year);
        List<Two_Level_Data> b4 = b_two_levelMapper.selectChart("B4", year);
        List<Two_Level_Data> b5 = b_two_levelMapper.selectChart("B5", year);
        List<Two_Level_Data> b6 = b_two_levelMapper.selectChart("B6", year);

        List<One_Level_Data> a = a_one_levelMapper.select(year);

        for (int i = 0; i < 12; i++) {
            Cell cell0= row[0].createCell(i);
            cell0.setCellValue(c11.get(i).getData());
            Cell cell1= row[1].createCell(i);
            cell1.setCellValue(c21.get(i).getData());

            Cell cell2= row[2].createCell(i);
            cell2.setCellValue(c22.get(i).getData());

            Cell cell3= row[3].createCell(i);
            cell3.setCellValue(c23.get(i).getData());

            Cell cell4= row[4].createCell(i);
            cell4.setCellValue(c24.get(i).getData());

            Cell cell5= row[5].createCell(i);
            cell5.setCellValue(c31.get(i).getData());

            Cell cell6= row[6].createCell(i);
            cell6.setCellValue(c32.get(i).getData());

            Cell cell7= row[7].createCell(i);
            cell7.setCellValue(c33.get(i).getData());

            Cell cell8= row[8].createCell(i);
            cell8.setCellValue(c34.get(i).getData());

            Cell cell9= row[9].createCell(i);
            cell9.setCellValue(c35.get(i).getData());

            Cell cell10= row[10].createCell(i);
            cell10.setCellValue(c36.get(i).getData());

            Cell cell11= row[11].createCell(i);
            cell11.setCellValue(c41.get(i).getData());

            Cell cell12= row[12].createCell(i);
            cell12.setCellValue(c42.get(i).getData());

            Cell cell13= row[13].createCell(i);
            cell13.setCellValue(c43.get(i).getData());

            Cell cell14= row[14].createCell(i);
            cell14.setCellValue(c44.get(i).getData());

            Cell cell15= row[15].createCell(i);
            cell15.setCellValue(c51.get(i).getData());

            Cell cell16= row[16].createCell(i);
            cell16.setCellValue(c52.get(i).getData());

            Cell cell17= row[17].createCell(i);
            cell17.setCellValue(c53.get(i).getData());

            Cell cell18= row[18].createCell(i);
            cell18.setCellValue(c54.get(i).getData());

            Cell cell19= row[19].createCell(i);
            cell19.setCellValue(c55.get(i).getData());

            Cell cell20= row[20].createCell(i);
            cell20.setCellValue(c61.get(i).getData());

            Cell cell21= row[21].createCell(i);
            cell21.setCellValue(c62.get(i).getData());

            Cell cell22= row[22].createCell(i);
            cell22.setCellValue(c63.get(i).getData());

            Cell cell23= row[23].createCell(i);
            cell23.setCellValue(b1.get(i).getData());

            Cell cell24= row[24].createCell(i);
            cell24.setCellValue(b2.get(i).getData());

            Cell cell25= row[25].createCell(i);
            cell25.setCellValue(b3.get(i).getData());

            Cell cell26= row[26].createCell(i);
            cell26.setCellValue(b4.get(i).getData());

            Cell cell27= row[27].createCell(i);
            cell27.setCellValue(b5.get(i).getData());

            Cell cell28= row[28].createCell(i);
            cell28.setCellValue(b6.get(i).getData());

            Cell cell29= row[29].createCell(i);
            cell29.setCellValue(a.get(i).getData());
        }
        try {
            outputWorkbook1.write(output1);
            output1.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    //---------------------------------------------定义函数--------------------------------------------------------

    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[][] transposedMatrix = new double[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    // 计算向量点乘
    public static double dotProduct(double[] a, double[] b) {
        double result = 0.0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    public static double[][] multiply(double[][] matrix1, double[][] matrix2) {
        // 检查矩阵的合法性
        int numRows1 = matrix1.length;
        int numCols1 = matrix1[0].length;
        int numRows2 = matrix2.length;
        int numCols2 = matrix2[0].length;
        if (numCols1 != numRows2) {
            throw new IllegalArgumentException("第一个矩阵的列数必须等于第二个矩阵的行数");
        }
        double[][] result = new double[numRows1][numCols2];

        for (int i = 0; i < numRows1; i++) {
            for (int j = 0; j < numCols2; j++) {
                double sum = 0.0;
                for (int k = 0; k < numCols1; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

}



