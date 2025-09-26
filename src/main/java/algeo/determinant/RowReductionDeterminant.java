package algeo.determinant;

import algeo.core.Matrix;
import algeo.core.MatrixOps;

/**
 * Determinan menggunakan OBE
 */
public final class RowReductionDeterminant {
    private RowReductionDeterminant() {}

    public static double of(Matrix A) {
        return MatrixOps.determinantOBE(A);
    }

    public static double of(Matrix A, boolean pivoting, double eps) {
        return MatrixOps.determinantOBE(A, pivoting, eps);
    }
}
