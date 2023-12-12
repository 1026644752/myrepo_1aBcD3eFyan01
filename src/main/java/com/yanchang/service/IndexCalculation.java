package com.yanchang.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
@Service
public class IndexCalculation {

    public void IndexCalculation() {
        try {
            // Load the Excel file
            FileInputStream fis = new FileInputStream("SCORE_MATRIX.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            // Read the data
            double[][] data = new double[sheet.getLastRowNum() + 1][sheet.getRow(0).getLastCellNum()];
            for (int i = 0; i < data.length; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < data[i].length; j++) {
                    Cell cell = row.getCell(j);
                    data[i][j] = cell.getNumericCellValue();
                }
            }
            double[] A_data = data[29];
            double[][] C_data = new double[23][12];
            for (int i = 0; i < 23; i++) {
                C_data[i] = getRowData(data, i);
            }
            double[][] B_data = new double[6][12];
            for (int i = 0; i < 6; i++) {
                B_data[i] = getRowData(data, i + 23);
            }

            // Calculate mean
            double[] Mean_C = new double[C_data.length];
            for (int i = 0; i < C_data.length; i++) {
                Mean_C[i] = calculateMean(C_data[i]);
            }
            double[] Mean_B = new double[B_data.length];
            for (int i = 0; i < B_data.length; i++) {
                Mean_B[i] = calculateMean(B_data[i]);
            }

            double Mean_A = calculateMean(A_data);

            // Calculate variance
            double[] Var_C = new double[C_data.length];

            for (int i = 0; i < C_data.length; i++) {
                Var_C[i] = calculateVariance(C_data[i],Mean_C[i]);
            }

            double[] Var_B = new double[B_data.length];

            for (int i = 0; i < B_data.length; i++) {
                Var_B[i] = calculateVariance(B_data[i],Mean_B[i]);
            }

            double Var_A = calculateVariance(A_data, Mean_A);


            // Calculate standard deviation
            double[] Std_C = calculateStandardDeviation(Var_C);
            double[] Std_B = calculateStandardDeviation(Var_B);
            double Std_A = Math.sqrt(Var_A);

            // Calculate range
            double[] Range_C = new double[C_data.length];
            for (int i = 0; i < Range_C.length; i++) {
                Range_C[i] = calculateRange(C_data[i]);
            }
            double[] Range_B = new double[B_data.length];
            for (int i = 0; i < Range_B.length; i++) {
                Range_B[i] = calculateRange(B_data[i]);
            }
            double Range_A = calculateRange(A_data);

            // Calculate covariance
            double[][] Cov_C = calculateCovariance(C_data);
            double[][] Cov_B = calculateCovariance(B_data);

            // Calculate correlation coefficient
            double[][] Corr_C_r = calculateCorrelationCoefficient(C_data);
            double[][] Corr_B_r = calculateCorrelationCoefficient(B_data);

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double[] getRowData(double[][] data, int rowIndex) {
        return data[rowIndex];
    }

    private static double calculateMean(double[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    private static double calculateVariance(double[] data, double mean) {
        double variance = 0;
        for (double value : data) {
            variance += Math.pow(value - mean, 2);
        }
        variance /= data.length;

        return variance;
    }

    private static double[] calculateStandardDeviation(double[] variance) {
        double[] stdDeviation = new double[variance.length];
        for (int i = 0; i < variance.length; i++) {
            stdDeviation[i] = Math.sqrt(variance[i]);
        }
        return stdDeviation;
    }

    private static double calculateRange(double[] data) {
        double range = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (double value : data) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        range = max - min;
        return range;
    }

    private static double[][] calculateCovariance(double[][] data) {

        double[] Mean = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            Mean[i] = calculateMean(data[i]);
        }

        return calculateVarianceMatrix(data,Mean);
    }

    private static double[][] calculateCorrelationCoefficient(double[][] data) {
        double[][] covariance = calculateCovariance(data);
        double[][] correlationCoefficient = new double[covariance.length][covariance.length];
        for (int i = 0; i < covariance.length; i++) {
            for (int j = 0; j < covariance.length; j++) {
                correlationCoefficient[i][j] = covariance[i][j] / (Math.sqrt(covariance[i][i]) * Math.sqrt(covariance[j][j]));
            }
        }
        return correlationCoefficient;
    }

    private static double[][] calculateVarianceMatrix(double[][] data, double[] mean) {
        double[][] varianceMatrix = new double[data.length][data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                varianceMatrix[i][j] = calculateCovariance(data[i], mean[i], data[j], mean[j]);
            }
        }
        return varianceMatrix;
    }

    private static double calculateCovariance(double[] data1, double mean1, double[] data2, double mean2) {
        double covariance = 0;
        for (int i = 0; i < data1.length; i++) {
            covariance += (data1[i] - mean1) * (data2[i] - mean2);
        }
        covariance /= data1.length;
        return covariance;
    }
}


