package algeo.inverse;

import algeo.core.Matrix;
import algeo.core.MatrixOps;
import algeo.determinant.CofactorDeterminant;

/**
 * Inverse menggunakan adjoin : A^-1 = adj(A) / det(A).
 */
public final class AdjointInverse {
    private AdjointInverse() {}

    public static Matrix inverse(Matrix A) {
        return inverse(A, MatrixOps.EPS);
    }

    public static Matrix inverse(Matrix A, double eps) {
        if (A == null) throw new IllegalArgumentException("Matriks tidak boleh kosong");
        if (!A.isSquare()) throw new IllegalArgumentException("Matriks harus merupakan matriks persegi");

        int n = A.rows();
        double det = CofactorDeterminant.of(A, eps);
        if (Math.abs(det) <= eps) throw new IllegalArgumentException("Matriks singular, tidak memiliki inverse");

        Matrix adj = new Matrix(n, n);
        // adj(A) = transpose dari matrix kofaktor
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double[][] minor = new double[n-1][n-1];
                for (int r = 0, mi = 0; r < n; r++) {
                    if (r == i) continue;
                    for (int c = 0, mj = 0; c < n; c++) {
                        if (c == j) continue;
                        minor[mi][mj++] = A.get(r, c);
                    }
                    mi++;
                }
                double cof = CofactorDeterminant.of(new Matrix(minor), eps);
                double sign = (((i + j) & 1) == 0) ? 1.0 : -1.0;
                adj.set(j, i, sign * cof);
            }
        }

        // bagi adjoin dengan determinan
        Matrix inv = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inv.set(i, j, adj.get(i, j) / det);
            }
        }
        return inv;
    }
}
