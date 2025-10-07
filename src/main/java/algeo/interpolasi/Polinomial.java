package algeo.interpolasi;

import algeo.core.*;
import algeo.spl.*;
import java.util.Scanner;

public class Polinomial {
  public static void polinomial() {
    double[][] data = inputTitikSampel();
    int n = data.length;

    Matrix A = new Matrix(n, n);

    for (int i = 0; i < n; i++) {
      double x = data[i][0];
      for (int j = 0; j < n; j++) {
        A.set(i, j, Math.pow(x, j));
      }
    }

    Matrix Y = new Matrix(n, 1);
    for (int i = 0; i < n; i++) {
      Y.set(i, 0, data[i][1]);
    }

    Matrix augmentedM = A.augment(Y);
    System.out.println(augmentedM);
    GaussJordan.makeReductedEchelon(augmentedM);
    Gauss.finishSPL(augmentedM);
  }

  public static double[][] inputTitikSampel() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Masukkan jumlah titik sampel: ");
    int n = scanner.nextInt();

    double[][] data = new double[n][2];

    for (int i = 0; i < n; i++) {
      System.out.print("Titik " + (i + 1) + ": ");
      String line = scanner.nextLine();
      String[] tokens = line.trim().split("\\s+");

      if (tokens.length != 2) {
        System.out.println("Format input salah. Harap masukkan dua nilai (x dan y).");
        i--;
        continue;
      }

      try {
        data[i][0] = Double.parseDouble(tokens[0]);
        data[i][1] = Double.parseDouble(tokens[1]);
      } catch (NumberFormatException e) {
        System.out.println("Input tidak valid. Harap masukkan angka.");
        i--;
        continue;
      }
    }

    scanner.close();
    return data;
  }
}
