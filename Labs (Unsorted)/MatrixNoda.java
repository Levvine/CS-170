
public class MatrixNoda {
    private double[][] matrix;

    int rows;
    int cols;
    int counter = 0;

    // create an empty matrix d of size m n
    public MatrixNoda(double[][] array) {
        matrix = new double[array.length][array[0].length];
        for (int rows = 0; rows < array.length; rows++) {
            for (int cols = 0; cols < array[rows].length; cols++) {
                matrix[rows][cols] = array[rows][cols];
            }
        }
    }

    public MatrixNoda(int rows, int cols) {
        matrix = new double[rows][cols];
    }

    public int numRows() {
        return matrix.length;
    }

    public int numCols() {
        return matrix[0].length;
    }

    public double getElement(int m, int n) {
        return matrix[m][n];
    }

    public void setElement(int l, int m, double input) {
        matrix[l][m] = input;
    }

    public static Matrix sum(Matrix a, Matrix b) {
        int m = a.numRows();
        int n = a[0].numRows();
        double[][] c = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    public static double[][] product(Matrix a, Matrix b) {
        int m1 = a.length;
        int n1 = a[0].length;
        int m2 = b.length;
        int n2 = b[0].length;
        double[][] c = new double[m1][n2];
        for (int i = 0; i < m1; i++)
            for (int j = 0; j < n2; j++)
                for (int k = 0; k < n1; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }

    public double determinant(double A[][], int N) {
        double det = 0;
        if (N == 1) {
            det = A[0][0];
        } else if (N == 2) {
            det = A[0][0] * A[1][1] - A[1][0] * A[0][1];
        } else {
            det = 0;
            for (int j1 = 0; j1 < N; j1++) {
                double[][] m = new double[N - 1][];
                for (int k = 0; k < (N - 1); k++) {
                    m[k] = new double[N - 1];
                }

                for (int i = 1; i < N; i++) {
                    int j2 = 0;

                    for (int j = 0; j < N; j++) {
                        if (j == j1)
                            continue;
                        m[i - 1][j2] = A[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1] * determinant(m, N - 1);
            }
        }
        return det;
    }

    public String toString() {
        String toString = " ";
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                toString += " " + matrix[row][col];
            }
        }
        return toString;
    }
}
