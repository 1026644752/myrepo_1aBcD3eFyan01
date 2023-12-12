//package com.yanchang;
//
//public class math_test {
//
//    import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//    public class Main {
//        public static void main(String[] args) {
//            String filePath = "data2021.xlsx";
//
//            try {
//                FileInputStream file = new FileInputStream(filePath);
//                Workbook workbook = new XSSFWorkbook(file);
//                Sheet sheet = workbook.getSheetAt(0);
//
//                // 数据导入
//                double[][] X = new double[23][12];
//                for (int i = 0; i < 23; i++) {
//                    Row row = sheet.getRow(i);
//                    for (int j = 0; j < 12; j++) {
//                        Cell cell = row.getCell(j);
//                        X[i][j] = cell.getNumericCellValue();
//                    }
//                }
//                file.close();
//
//                // 权重和指标数据
//                double[] wA = {0.245, 0.1775, 0.1575, 0.155, 0.1625, 0.1025};
//                double[] wB1 = {1};
//                double[] wB2 = {0.194, 0.136, 0.298, 0.372};
//                double[] wB3 = {0.1675, 0.105, 0.185, 0.2125, 0.155, 0.175};
//                double[] wB4 = {0.38, 0.236, 0.188, 0.196};
//                double[] wB5 = {0.285, 0.155, 0.17, 0.1725, 0.2175};
//                double[] wB6 = {0.406, 0.364, 0.23};
//
//                double[] VC11 = {85, 99, 102};
//                double[] VC21 = {5.5, 4, 1.5};
//                double[] VC22 = {6, 3, 1};
//                double[] VC23 = {90, 98, 100};
//                double[] VC24 = {75, 85, 95};
//
//                double[] VC31 = {105, 103, 100};
//                double[] VC32 = {3200, 2970, 2918};
//                double[] VC33 = {2550, 2515, 2500};
//                double[] VC34 = {0.4, 0.28, 0.12};
//                double[] VC35 = {12550, 12530, 12500};
//                double[] VC36 = {35, 32.5, 30};
//
//                double[] VC41 = {12, 5, 0};
//                double[] VC42 = {95, 98, 100};
//                double[] VC43 = {0.1, 0.05, 0.03};
//                double[] VC44 = {0.1, 0.09, 0.07};
//
//                double[] VC51 = {87, 93, 100};
//                double[] VC52 = {70, 80, 100};
//                double[] VC53 = {20, 16, 14};
//                double[] VC54 = {90, 95, 100};
//                double[] VC55 = {80, 88, 100};
//
//                double[] VC61 = {30, 15, 5};
//                double[] VC62 = {0.05, 0.012, 0.0025};
//                double[] VC63 = {28, 12, 2};
//
//                double[] K = {40, 70, 100};
//%1.1 计算全年1-12月的，C11隶属度，B1隶属度，以及各自效能指数
//                double[] XB1 = X[1,:];
//                for (int i = 0; i < 12; i++) {
//                    XB1[i] = X[0][i] * 100;
//                }
//
//                double[][] LC11 = new double[12][3];
//                for (int i = 0; i < 12; i++) {
//                    LC11[i] = lsd_shouy(VC11, XB1[i]);
//                }
//
//                double[] SC11 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    SC11[i] = 0;
//                    for (int j = 0; j < 3; j++) {
//                        SC11[i] += LC11[i][j] * K[j];
//                    }
//                }
//
//                double[] LB1 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    LB1[i] = 0;
//                    for (int j = 0; j < 1; j++) {
//                        LB1[i] += wB1[j] * LC11[i][j];
//                    }
//                }
//
//                for (int i = 0; i < 12; i++) {
//                    SAll[0][i] = SC11[i];
//                    SAll[23][i] = LB1[i];
//                }
//
//                // 输出SAll数组的值
//                for (int i = 0; i < 30; i++) {
//                    for (int j = 0; j < 12; j++) {
//                        System.out.print(SAll[i][j] + " ");
//                    }
//                    System.out.println();
//                }
//%% 2.计算全年1-12月的，C21、C22、C23、C24隶属度，B2隶属度，以及各自效能指数
//                        XB2 = X[2:5,:];
//                for (int i = 0; i < 4; i++) {
//                    for (int j = 0; j < 12; j++) {
//                        XB2[i][j] = X[i + 1][j] * 100;
//                    }
//                }
//
//                for (int i = 0; i < 12; i++) {
//                    LC21[i] = lsd_chb(VC21, XB2[0]);
//                }
//
//                SC21 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    SC21[i] = LC21[i][0] * K[0] + LC21[i][1] * K[1] + LC21[i][2] * K[2];
//                }
//
//                for (int i = 0; i < 12; i++) {
//                    LC22[i] = lsd_chb(VC22, XB2[1]);
//                }
//
//                SC22 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    SC22[i] = LC22[i][0] * K[0] + LC22[i][1] * K[1] + LC22[i][2] * K[2];
//                }
//
//                for (int i = 0; i < 12; i++) {
//                    LC23[i] = lsd_shouy(VC23, XB2[2]);
//                }
//
//                SC23 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    SC23[i] = LC23[i][0] * K[0] + LC23[i][1] * K[1] + LC23[i][2] * K[2];
//                }
//
//                for (int i = 0; i < 12; i++) {
//                    LC24[i] = lsd_shouy(VC24, XB2[3]);
//                }
//
//                SC24 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    SC24[i] = LC24[i][0] * K[0] + LC24[i][1] * K[1] + LC24[i][2] * K[2];
//                }
//
//                for (int i = 0; i < 12; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        LB2[i][j] = wB2[0] * LC21[i][j] + wB2[1] * LC22[i][j] + wB2[2] * LC23[i][j] + wB2[3] * LC24[i][j];
//                    }
//                }
//
//                SB2 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    SB2[i] = LB2[i][0] * K[0] + LB2[i][1] * K[1] + LB2[i][2] * K[2];
//                }
//
//                for (int i = 1; i <= 4; i++) {
//                    for (int j = 0; j < 12; j++) {
//                        SAll[i][j] = (i == 2) ? SC21[j] : ((i == 3) ? SC22[j] : ((i == 4) ? SC23[j] : SC24[j]));
//                    }
//                }
//
//                for (int i = 0; i < 12; i++) {
//                    SAll[25][i] = SB2[i];
//                }
//
//                // 输出SAll数组的值
//                for (int i = 0; i < 30; i++) {
//                    for (int j = 0; j < 12; j++) {
//                        System.out.print(SAll[i][j] + " ");
//                    }
//                    System.out.println();
//                }
//%% 3.计算全年1-12月的，C31，C32，C33，C34，C35，C36隶属度，B3隶属度，以及各自效能指数
//                double[][] XB3 = X[6:11,:];
//                double[] VC31 = {105, 103, 100};
//                double[] VC32 = {3200, 2970, 2918};
//                double[] VC33 = {2550, 2515, 2500};
//                double[] VC34 = {0.4, 0.28, 0.12};
//                double[] VC35 = {12550, 12530, 12500};
//                double[] VC36 = {35, 32.5, 30};
//                double K = 1.0; // Assign the value of K
//
//                // Calculate SC31
//                double[] LC31 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    LC31[i] = lsd_chb(VC31, XB3[0][i]);
//                }
//                double[] SC31 = multiply(LC31, K);
//                SC31 = transpose(SC31);
//
//                // Calculate SC32
//                double[] LC32 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    LC32[i] = lsd_chb(VC32, XB3[1][i]);
//                }
//                double[] SC32 = multiply(LC32, K);
//                SC32 = transpose(SC32);
//
//                // Calculate SC33
//                double[] LC33 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    LC33[i] = lsd_chb(VC33, XB3[2][i]);
//                }
//                double[] SC33 = multiply(LC33, K);
//                SC33 = transpose(SC33);
//
//                // Calculate SC34
//                double[] LC34 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    LC34[i] = lsd_chb(VC34, XB3[3][i]);
//                }
//                double[] SC34 = multiply(LC34, K);
//                SC34 = transpose(SC34);
//
//                // Calculate SC35
//                double[] LC35 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    LC35[i] = lsd_chb(VC35, XB3[4][i]);
//                }
//                double[] SC35 = multiply(LC35, K);
//                SC35 = transpose(SC35);
//
//                // Calculate SC36
//                double[] LC36 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    LC36[i] = lsd_chb(VC36, XB3[5][i]);
//                }
//                double[] SC36 = multiply(LC36, K);
//                SC36 = transpose(SC36);
//
//                double[] wB3 = {0.1675, 0.105, 0.185, 0.2125, 0.155, 0.175};
//                double[] LB3 = new double[12];
//                for (int i = 0; i < 12; i++) {
//                    double[] LC = {LC31[i], LC32[i], LC33[i], LC34[i], LC35[i], LC36[i]};
//                    LB3[i] = dotProduct(wB3, LC);
//                }
//                double[] SB3 = multiply(LB3, K);
//                SB3 = transpose(SB3);
//
//                double[][] SAll = new double[27][12];
//                for (int i = 0; i < 12; i++) {
//                    SAll[i + 5][0] = SC31[i];
//                    SAll[i + 5][1] = SC32[i];
//                    SAll[i + 5][2] = SC33[i];
//                    SAll[i + 5][3] = SC34[i];
//                    SAll[i + 5][4] = SC35[i];
//                    SAll[i + 5][5] = SC36[i];
//                }
//                SAll[25][0] = SB3[0];
//
//                // Print SAll
//                for (double[] row : SAll) {
//                    System.out.println(Arrays.toString(row));
//                }
//            }
//
//            public static double lsd_chb(double[] VC, double XB) {
//                // Implementation of lsd_chb function
//                // Return the result
//            }
//
//            public static double[] multiply(double[] array, double scalar) {
//                double[] result = new double[array.length];
//                for (int i = 0; i < array.length; i++) {
//                    result[i] = array[i] * scalar;
//                }
//                return result;
//            }
//            public static double dotProduct(double[] array1, double[] array2) {
//                double result = 0.0;
//                for (int i = 0; i < array1.length; i++) {
//                    result += array1[i] * array2[i];
//                }
//%% 4.计算全年1-12月的，C41，C42，C43，C44隶属度，B4隶属度，以及各自效能指数
//                double[][] XB4 = X[11:15,:];
//                //XB3按行存储的是B4指标的4个C级指标数据
//                double[] VC41 = {12, 5, 0};            //成本型
//                double[] VC42 = {95, 98, 100};     //收益型
//                double[] VC43 = {0.1, 0.05, 0.03}; //成本型
//                double[] VC44 = {0.1, 0.09, 0.07}; //成本型
//
//                //计算C41全年1-12月的效能指数
//                double[][] LC41 = new double[12][];
//                for (int i = 0; i < 12; i++) {
//                    LC41[i] = lsd_chb(VC41, XB4[0][i]);
//                }
//                double[][] SC41 = multiply(LC41, K);
//                SC41 = transpose(SC41);
//
//                //计算C42全年1-12月的效能指数
//                double[][] LC42 = new double[12][];
//                for (int i = 0; i < 12; i++) {
//                    LC42[i] = lsd_shouy(VC42, XB4[1][i]);
//                }
//                double[][] SC42 = multiply(LC42, K);
//                SC42 = transpose(SC42);
//
//                //计算C43全年1-12月的效能指数
//                double[][] LC43 = new double[12][];
//                for (int i = 0; i < 12; i++) {
//                    LC43[i] = lsd_chb(VC43, XB4[2][i]);
//                }
//                double[][] SC43 = multiply(LC43, K);
//                SC43 = transpose(SC43);
//
//                //计算C44全年1-12月的效能指数
//                double[][] LC44 = new double[12][];
//                for (int i = 0; i < 12; i++) {
//                    LC44[i] = lsd_chb(VC44, XB4[3][i]);
//                }
//                double[][] SC44 = multiply(LC44, K);
//                SC44 = transpose(SC44);
//
//                double[] wB4 = {0.38, 0.236, 0.188, 0.196}; //B4指标的子指标C41，C42，C43，C44的权重[wB41,wB42,wB43,wB44]
//                double[][] LB4 = new double[12][];
//                for (int i = 0; i < 12; i++) {
//                    double[][] LC = {LC41[i], LC42[i], LC43[i], LC44[i]};
//                    LB4[i] = dotProduct(wB4, LC);
//                }
//                double[][] SB4 = multiply(LB4, K);
//                SB4 = transpose(SB4);
//
//                double[][] SAll = new double[27][12];
//                for (int i = 11; i < 15; i++) {
//                    for (int j = 0; j < 12; j++) {
//                        SAll[i][j] = SC41[i - 11][j];
//                    }
//                }
//                SAll[26] = SB4[0];
//
//                // Print SAll
//                for (double[] row : SAll) {
//                    System.out.println(Arrays.toString(row));
//                }
//            }
//
//
//
//            public static double[][] multiply(double[][] array, double scalar) {
//                double[][] result = new double[array.length][array[0].length];
//                for (int i = 0; i < array.length; i++) {
//                    for (int j = 0; j < array[0].length; j++) {
//                        result[i][j] = array[i][j] * scalar;
//                    }
//                }
//                return result;
//            }
//
//            public static double[] dotProduct(double[] array1, double[][] array2) {
//                double[] result = new double[array2[0].length];
//                for (int i = 0; i < array2[0].length; i++) {
//                    for (int j = 0; j < array1.length; j++) {
//                        result[i] += array1[j] * array2[j][i];
//                    }
//                }
//                return result;
//            }
//            // 计算B1效能指数
//            double[] LB1 = new double[12];
//            for (int i = 0; i < 12; i++) {
//                LB1[i] = dotProduct(wB1, LC11[i]);
//            }
//
//            // 存储结果
//            double[][] SAll = new double[30][12];
//            SAll[0] = SC11;
//            SAll[23] = SB1;
//
//            // 计算B2及子指标的效能指数
//            double[][] XB2 = new double[4][12];
//            for (int i = 0; i < 4; i++) {
//                for (int j = 0; j < 12; j++) {
//                    XB2[i][j] = X[i + 1][j];
//                }
//            }
//
//            double[][] LC21 = new double[12][3];
//            for (int i = 0; i < 12; i++) {
//                LC21[i] = lsd_chb(VC21, XB2[0][i]);
//            }
//            // 其他子指标请按照类似的方式计算
//
//            double[][] SC21 = new double[12][3];
//            for (int i = 0; i < 12; i++) {
//                SC21[i] = dotProduct(LC21[i], K);
//            }
//            // 其他效能指数请按照类似的方式计算
//
//            // 将结果写入Excel文件
//            FileOutputStream output = new FileOutputStream("SCORE_MATRIX_ALL_FEATURE.xlsx");
//            Workbook outputWorkbook = new XSSFWorkbook();
//            Sheet outputSheet = outputWorkbook.createSheet("Scores");
//
//            for (int i = 0; i < 30; i++) {
//                Row row = outputSheet.createRow(i);
//                for (int j = 0; j < 12; j++) {
//                    Cell cell = row.createCell(j);
//                    cell.setCellValue(SAll[i][j]);
//                }
//            }
//
//            outputWorkbook.write(output);
//            output.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//%% 5.计算全年1-12月的，C51，C52，C53，C54，C55隶属度，B5隶属度，以及各自效能指数
//    double[][] XB5 = X[16:20,:];
//	for (int i = 0; i < 5; i++) {
//        System.arraycopy(X, 15 + i * 12, XB5[i], 0, 12);
//    }
//
//    double[] VC51 = {87, 93, 100};
//    double[] VC52 = {70, 80, 100};
//    double[] VC53 = {20, 16, 14};
//    double[] VC54 = {90, 95, 100};
//    double[] VC55 = {80, 88, 100};
//
//    double[][] LC51 = new double[12][];
//	for (int i = 0; i < 12; i++) {
//        LC51[i] = lsd_shouy(VC51, XB5[0][i]);
//    }
//    double[] SC51 = matrixMultiply(LC51, K);
//    transpose(SC51);
//
//    double[][] LC52 = new double[12][];
//	for (int i = 0; i < 12; i++) {
//        LC52[i] = lsd_shouy(VC52, XB5[1][i]);
//    }
//    double[] SC52 = matrixMultiply(LC52, K);
//    transpose(SC52);
//
//    double[][] LC53 = new double[12][];
//	for (int i = 0; i < 12; i++) {
//        LC53[i] = lsd_chb(VC53, XB5[2][i]);
//    }
//    double[] SC53 = matrixMultiply(LC53, K);
//    transpose(SC53);
//
//    double[][] LC54 = new double[12][];
//	for (int i = 0; i < 12; i++) {
//        LC54[i] = lsd_shouy(VC54, XB5[3][i]);
//    }
//    double[] SC54 = matrixMultiply(LC54, K);
//    transpose(SC54);
//
//    double[][] LC55 = new double[12][];
//	for (int i = 0; i < 12; i++) {
//        LC55[i] = lsd_shouy(VC55, XB5[4][i]);
//    }
//    double[] SC55 = matrixMultiply(LC55, K);
//    transpose(SC55);
//
//    double[] wB5 = {0.285, 0.155, 0.17, 0.1725, 0.2175};
//    double[][] LB5 = new double[12][];
//	for (int i = 0; i < 12; i++) {
//        LB5[i] = matrixMultiply(wB5, new double[][]{LC51[i], LC52[i], LC53[i], LC54[i], LC55[i]});
//    }
//    double[] SB5 = matrixMultiply(LB5, K);
//    transpose(SB5);
//
//    double[][] SAll = new double[X.length][12];
//	for (int i = 0; i < 12; i++) {
//        SAll[15 + i] = SC51[i];
//        SAll[27 + i] = SC52[i];
//        SAll[39 + i] = SC53[i];
//        SAll[51 + i] = SC54[i];
//        SAll[63 + i] = SC55[i];
//    }
//    SAll[27] = SB5;
//
//%% 6.计算全年1-12月的，C61，C62，C63隶属度，B6隶属度，以及各自效能指
//
//    double[][] XB6 = X[21:23,:];
//	for (int i = 0; i < 3; i++) {
//        System.arraycopy(X, 20 + i * 12, XB6[i], 0, 12);
//    }
//
//    double[] VC61 = {30, 15, 5};
//    double[] VC62 = {0.05, 0.012, 0.0025};
//    double[] VC63 = {28, 12, 2};
//
//    double[][] LC61 = new double[12][];
//	for (int i = 0; i < 12; i++) {
//        LC61[i] = lsd_chb(VC61, XB6[0][i]);
//    }
//    double[] SC61 = matrixMultiply(LC61, K);
//    transpose(SC61);
//
//    double[][] LC62 = new double[12][];
//	for (int i = 0; i < 12; i++) {
//        LC62[i] = lsd_chb(VC62, XB6[1][i]);
//    }
//    double[] SC62 = matrixMultiply(LC62, K);
//    transpose(SC62);
//
//    double[][] LC63 = new double[12][];
//	for (int i = 0; i < 12; i++) {
//        LC63[i] = lsd_chb(VC63, XB6[2][i]);
//    }
//    double[] SC63 = matrixMultiply(LC63, K);
//    transpose(SC63);
//
//    double[] wB6 = {0.406, 0.364, 0.23};
//    double[][] LB6 = new double[12][];
//	for (int i = 0; i < 12; i++) {
//        LB6[i] = matrixMultiply(wB6, new double[][]{LC61[i], LC62[i], LC63[i]});
//    }
//    double[] SB6 = matrixMultiply(LB6, K);
//    transpose(SB6);
//
//    double[][] SAll = new double[X.length][12];
//	for (int i = 0; i < 12; i++) {
//        SAll[20 + i] = SC61[i];
//        SAll[32 + i] = SC62[i];
//        SAll[44 + i] = SC63[i];
//    }
//    SAll[28] = SB6;
//
//    double[] wA = {0.245, 0.1775, 0.1575, 0.155, 0.1625, 0.1025};
//    double[][] LA = new double[12][];
//	for (int i = 0; i < 12; i++) {
//        LA[i] = matrixMultiply(wA, new double[][]{LB1[i], LB2[i], LB3[i], LB4[i], LB5[i], LB6[i]});
//    }
//    double[] SA = matrixMultiply(LA, K);
//    transpose(SA);
//    SAll[29] = SA;
//
//    // 保存为.mat文件
//    MatFileWriter matFileWriter = new MatFileWriter();
//	matFileWriter.write(new File("SCORE_MATRIX_ALL_FEATURE.mat"), SAll);
//
//    // 保存为.xlsx文件
//	try (XSSFWorkbook workbook = new XSSFWorkbook()) {
//        XSSFSheet sheet = workbook.createSheet("Sheet1");
//        for (int row = 0; row < SAll.length; row++) {
//            XSSFRow excelRow = sheet.createRow(row);
//            for (int col = 0; col < SAll[row].length; col++) {
//                XSSFCell excelCell = excelRow.createCell(col);
//                excelCell.setCellValue(SAll[row][col]);
//            }
//        }
//        try (FileOutputStream outputStream = new FileOutputStream("SCORE_MATRIX_ALL_FEATURE.xlsx")) {
//            workbook.write(outputStream);
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public static double[][] transpose(double[][] matrix) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        double[][] transposedMatrix = new double[cols][rows];
//
//        for (int i = 0; i < cols; i++) {
//            for (int j = 0; j < rows; j++) {
//                transposedMatrix[i][j] = matrix[j][i];
//            }
//        }
//
//        return transposedMatrix;
//    }
//}
//    public static double[] lsd_chb(double[] v, double x) {
//        double[] R = new double[3];
//        double R0 = 0;
//
//        // 计算R1
//        if (v[1] < x && x < v[0]) {
//            R[0] = (x - v[1]) / (v[0] - v[1]);
//        } else if (x > v[0]) {
//            R[0] = 1;
//        } else {
//            R[0] = 0;
//        }
//
//        // 计算R2
//        if (v[1] <= x && x <= v[0]) {
//            R[1] = (v[0] - x) / (v[0] - v[1]);
//        } else if (v[2] < x && x < v[1]) {
//            R[1] = (x - v[2]) / (v[1] - v[2]);
//        } else {
//            R[1] = 0;
//        }
//
//        // 计算R3
//        if (v[2] <= x && x <= v[1]) {
//            R[2] = (v[1] - x) / (v[1] - v[2]);
//        } else if (x <= v[2]) {
//            R[2] = 1;
//        } else {
//            R[2] = 0;
//        }
//
//        return R;
//    }
//
//    // 计算隶属度lsd_shouy
//    public static double[] lsd_shouy(double[] v, double x) {
//        double[] R = new double[3];
//        double R0 = 0;
//
//        // 计算R1
//        if (v[1] < x && x < v[0]) {
//            R[0] = (x - v[1]) / (v[0] - v[1]);
//        } else if (x > v[0]) {
//            R[0] = 1;
//        } else {
//            R[0] = 0;
//        }
//
//        // 计算R2
//        if (v[1] <= x && x <= v[0]) {
//            R[1] = (v[0] - x) / (v[0] - v[1]);
//        } else if (v[2] < x && x < v[1]) {
//            R[1] = (x - v[2]) / (v[1] - v[2]);
//        } else {
//            R[1] = 0;
//        }
//
//        // 计算R3
//        if (v[2] <= x && x <= v[1]) {
//            R[2] = (v[1] - x) / (v[1] - v[2]);
//        } else if (x <= v[2]) {
//            R[2] = 1;
//        } else {
//            R[2] = 0;
//        }
//
//        return R;
//    }
//
//    // 计算向量点乘
//    public static double dotProduct(double[] a, double[] b) {
//        double result = 0.0;
//        for (int i = 0; i < a.length; i++) {
//            result += a[i] * b[i];
//        }
//        return result;
//    }
//}
//
//
//
//
