package algeo.spl;

import algeo.core.*;
import algeo.determinant.*;

public class JumlahSolusi {
  public static int cekJumlahSolusiM(Matrix M) {
    int rows = M.rows();
    int cols = M.cols();

    Matrix A = M.submatrix(0, rows - 1, 0, cols - 2);
    int n = A.cols(); // Jumlah variabel

    if (A.isSquare()) {
      double detA = CofactorDeterminant.of(A);
      if (Math.abs(detA) > MatrixOps.EPS) {
        return 1;
      }
    }

    int rankA = MatrixOps.cekRank(A);
    int rankM = MatrixOps.cekRank(M);

    if (rankA < rankM) {
      return 0;
    } else if (rankA == rankM) {
      if (rankA == n) {
        return 1;
      } else {
        return 2;
      }
    }

    return 0;
  }
}
