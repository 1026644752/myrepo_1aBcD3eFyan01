package com.yanchang.service;

public class LSDShouy {
   public static double[] calculateMembership(double[] v, double x) {
      double[] R = new double[3];
      double R0 = 0;

      // 计算R1
      if (v[0] < x && x < v[1]) {
         R[0] = (v[1] - x) / (v[1] - v[0]);
      } else if (x >= v[1]) {
         R[0] = 0;
      } else if (x < v[0]) {
         R[0] = 1;
      }

      // 计算R2
      if (v[0] <= x && x <= v[1]) {
         R[1] = (x - v[0]) / (v[1] - v[0]);
      } else if (v[1] < x && x < v[2]) {
         R[1] = (v[2] - x) / (v[2] - v[1]);
      } else if (v[2] <= x || x <= v[0]) {
         R[1] = 0;
      }

      // 计算R3
      if (v[1] <= x && x <= v[2]) {
         R[2] = (x - v[1]) / (v[2] - v[1]);
      } else if (x <= v[1]) {
         R[2] = 0;
      }

      return R;
   }

   public static double[] lsd_shouy(double[] v, double x) {

      double[] result = calculateMembership(v, x);

/*      // 打印结果
      System.out.println("隶属度值：");
      for (int i = 0; i < result.length; i++) {
         System.out.println("R" + (i+1) + ": " + result[i]);
      }*/
      return result;
   }
}

