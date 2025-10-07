package algeo.io;

import algeo.core.Matrix;
import java.util.Scanner;

public class MatrixIO {
  // Scanner global untuk konsistensi dengan Menu
  private static Scanner scanner = new Scanner(System.in);

  public static Matrix inputMatrix() {

    System.out.print("Masukkan jumlah baris: ");
    int rows = scanner.nextInt();
    System.out.print("Masukkan jumlah kolom: ");
    int cols = scanner.nextInt();

    if (rows <= 0 || cols <= 0) {
      throw new IllegalArgumentException("Jumlah baris dan kolom harus lebih dari 0.");
    }

    double[][] doublearrayIn = new double[rows][cols];

    System.out.println(
        "Masukkan elemen matriks (dipisahkan spasi dan tekan ENTER setiap barisnya):");

    scanner.nextLine();

    for (int i = 0; i < rows; i++) {
      String line = scanner.nextLine();
      String[] tokens = line.trim().split("\\s+");
      if (tokens.length != cols) {
        System.out.println("Jumlah elemen tidak sesuai dengan jumlah kolom. Silakan coba lagi.");
        i--;
        continue;
      }
      for (int j = 0; j < cols; j++) {
        try {
          doublearrayIn[i][j] = Double.parseDouble(tokens[j]);
        } catch (NumberFormatException e) {
          System.out.println("Input tidak valid. Silakan masukkan angka.");
          i--;
          break;
        }
      }
    }

    Matrix matrixIn = new Matrix(doublearrayIn);
    return matrixIn;
  }
}
