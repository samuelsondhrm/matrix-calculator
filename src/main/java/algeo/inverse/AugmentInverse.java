package algeo.inverse;

import algeo.core.Matrix;
import algeo.core.MatrixOps;

/**
 * Inverse dengan matriks augmented [A | I] kemudian RREF → [I | A^-1].
 */
public final class AugmentInverse {
    private AugmentInverse() {}

    public static Matrix inverse(Matrix A) {
        return inverse(A, true, MatrixOps.EPS);
    }

    public static Matrix inverse(Matrix A, boolean pivoting, double eps) {
        if (A == null) throw new IllegalArgumentException("Matrix A tidak boleh null");
        if (!A.isSquare()) throw new IllegalArgumentException("Inverse hanya untuk matriks persegi");

        double det = MatrixOps.determinantOBE(A, pivoting, eps);
        if (Math.abs(det) <= eps) throw new IllegalArgumentException("Matriks singular, tidak memiliki inverse");

        int n = A.rows();
        Matrix I = Matrix.identity(n);
        Matrix aug = A.copy().augment(I);
        MatrixOps.rref(aug, pivoting, eps);
        Matrix inv = aug.submatrix(0, n-1, n, 2*n-1);
        return inv;
    }
}
