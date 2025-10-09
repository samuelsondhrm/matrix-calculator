package algeo.core;

public final class MatrixOps {
  private MatrixOps() {} 

    public static final double EPS = 1e-15;
  public static Matrix ref(Matrix M) {
    Matrix mCopy = M.copy();
    int rP = 0;
    int cP = 0;
    int rows = mCopy.rows();
    int cols = mCopy.cols();

    while (rP < rows && cP < cols) {
      System.out.println("\nLangkah " + (rP + 1) + ", memproses Kolom " + (cP + 1));

      if (mCopy.get(rP, cP) == 1.0) {
        for (int i = rP + 1; i < rows; i++) {
          double factor = mCopy.get(i, cP);
          if (factor != 0) {
            mCopy.addRowMultiple(i, rP, -factor);
            System.out.println(
                "Eliminasi baris "
                    + (i + 1)
                    + " (R"
                    + (i + 1)
                    + " - "
                    + factor
                    + "*B"
                    + (rP + 1)
                    + "):");

            System.out.println(mCopy);
          }
        }
        rP++;
        cP++;
        continue;
      }

      int i_max = rP;
      for (int i = rP; i < rows; i++) {
        if (Math.abs(mCopy.get(i, cP)) > Math.abs(mCopy.get(i_max, cP))) {
          i_max = i;
        }
      }

      if (mCopy.get(i_max, cP) == 0) {
        System.out.println("Kolom ini hanya berisi nol. Pindah ke kolom berikutnya.\n");
        cP++;
      } else {
        if (rP != i_max) {
          mCopy.swapRows(rP, i_max);
          System.out.println("Tukar baris " + (rP + 1) + " dan " + (i_max + 1) + ":");
          System.out.println(mCopy);
        }

        double pivotValue = mCopy.get(rP, cP);
        mCopy.scaleRow(rP, 1.0 / pivotValue);
        System.out.println(
            "Bentuk leading one pada baris " + (rP + 1) + "R" + (rP + 1) + "/" + pivotValue);
        System.out.println(mCopy);

        for (int i = rP + 1; i < rows; i++) {
          double factor = mCopy.get(i, cP);
          if (factor != 0) {
            mCopy.addRowMultiple(i, rP, -factor);
            System.out.println(
                "Eliminasi baris "
                    + (i + 1)
                    + " (R"
                    + (i + 1)
                    + " - "
                    + factor
                    + "*R"
                    + (rP + 1)
                    + "):");
            System.out.println(mCopy);
          }
        }
        rP++;
        cP++;
      }
    }
    return mCopy;
  }

  public static Matrix rref(Matrix M) {
    int rows = M.rows();
    int cols = M.cols();

    Matrix mCopy = ref(M);

    System.out.println("\n--- Tahap Eliminasi Mundur (Gauss-Jordan) ---");

    for (int i = rows - 1; i >= 0; i--) {
      int cP = -1;

      for (int j = 0; j < cols; j++) {
        if (mCopy.get(i, j) == 1.0) {
          cP = j;
          break;
        }
      }

      if (cP == -1) {
        continue;
      }

      for (int k = i - 1; k >= 0; k--) {
        double factor = mCopy.get(k, cP);
        if (factor != 0) {
          mCopy.addRowMultiple(k, i, -factor);
          System.out.println(
              "Eliminasi baris "
                  + (k + 1)
                  + " (R"
                  + (k + 1)
                  + " - "
                  + factor
                  + "*R"
                  + (i + 1)
                  + "):");
          System.out.println(mCopy);
        }
      }
    }
        return mCopy;
  }

  public static int cekRank(Matrix A) {
    if (A == null) {
      return 0;
    }

    Matrix M = ref(A);

    int rows = M.rows();
    int cols = M.cols();
    int barisTidakNol = 0;

    for (int i = 0; i < rows; i++) {
      boolean isZeroRow = true;
      for (int j = 0; j < cols; j++) {
        if (Math.abs(M.get(i, j)) > EPS) {
          isZeroRow = false;
          break;
        }
      }
      if (!isZeroRow) {
        barisTidakNol++;
      }
    }
    return barisTidakNol;
  }



}
