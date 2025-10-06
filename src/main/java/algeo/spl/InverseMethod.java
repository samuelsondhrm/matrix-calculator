package algeo.spl;

import algeo.core.Matrix;
import algeo.core.NumberFmt;
import algeo.inverse.AugmentInverse;
import algeo.io.MatrixIO;

public class InverseMethod {
    public static void inverseMethod() {
        Matrix M = MatrixIO.inputMatrix();
        solveInverse(M);
    }

    public static void solveInverse(Matrix M) {
        int rows = M.rows();
        int cols = M.cols();

        // ekspektasi: augmented matrix dengan kolom = rows + 1
        if (cols != rows + 1) {
            System.out.println("Input harus berupa matriks augmented (n x (n+1)).");
            return;
        }

        Matrix A = M.submatrix(0, rows - 1, 0, cols - 2);
        Matrix B = M.colAsMatrix(cols - 1);

        if (!A.isSquare()) {
            System.out.println("Matriks koefisien harus persegi.");
            return;
        }

        int n = A.rows();

        try {
            Matrix inv = AugmentInverse.inverse(A); 

            for (int i = 0; i < n; i++) {
                double xi = 0.0;
                for (int j = 0; j < n; j++) {
                    xi += inv.get(i, j) * B.get(j, 0);
                }
                System.out.println("Solusi: x" + (i + 1) + " = " + NumberFmt.format3(xi));
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Matriks tidak memiliki inverse.");
        }
    }
}