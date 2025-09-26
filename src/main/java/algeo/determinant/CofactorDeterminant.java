package algeo.determinant;

import algeo.core.Matrix;
import algeo.core.MatrixOps;

/**
 * Determinan menggunakan ekspansi kofaktor
 */
public final class CofactorDeterminant {
    private CofactorDeterminant() {}

    public static double of(Matrix A) {
        return of(A, MatrixOps.EPS);
    }

    public static double of(Matrix A, double eps) {
        if (A == null) throw new IllegalArgumentException("Matriks tidak boleh kosong");
        if (!A.isSquare()) throw new IllegalArgumentException("Matriks harus merupakan matriks persegi");
        return detRecursive(A, eps);
    }

    private static double detRecursive(Matrix A, double eps) {
        int n = A.rows();
        if (n == 1) return A.get(0, 0);
        if (n == 2) return A.get(0,0) * A.get(1,1) - A.get(0,1) * A.get(1,0);

        double det = 0.0;
        for (int col = 0; col < n; col++) {
            double[][] minor = new double[n-1][n-1];
            for (int i = 1; i < n; i++) {
                int mj = 0;
                for (int j = 0; j < n; j++) {
                    if (j == col) continue;
                    minor[i-1][mj++] = A.get(i, j);
                }
            }
            Matrix M = new Matrix(minor);
            double sub = detRecursive(M, eps);
            double sign = ((col & 1) == 0) ? 1.0 : -1.0; 
            det += sign * A.get(0, col) * sub;
        }
        if (Math.abs(det) < eps) return 0.0;
        return det;
    }
}
