// SUBMITTED BY: ALAN HUANG
// HELPED BY: NOBODY

public class Matrix {

    private double[][] matrix;

    public Matrix(double[][] array) {
        matrix = new double[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                matrix[row][column] = array[row][column];
            }
        }
    }

    public Matrix(int rows, int columns) {
        matrix = new double[rows][columns];
    }

    public int numRows() {
        return matrix.length;
    }

    public int numCols() {
        return matrix[0].length;
    }

    public double getElement(int r, int c) {
        return matrix[r][c];
    }

    public void setElement(int r, int c, double value) {
        matrix[r][c] = value;
    }

    public static MatrixNoda sum(MatrixNoda a, MatrixNoda b) {
        if ((a.numRows() != b.numRows()) || (a.numCols() != b.numCols()))
            return null;
        MatrixNoda sum = new MatrixNoda(a.numRows(), a.numCols());
        for (int row = 0; row < sum.numRows(); row++) {
            for (int col = 0; col < sum.numCols(); col++) {
                sum.setElement(row, col, a.getElement(row, col) + b.getElement(row, col));
            }
        }
        return sum;
    }

    public static MatrixNoda product(MatrixNoda a, MatrixNoda b) {
        if ((a.numRows() != b.numCols()) || (a.numCols() != b.numRows()))
            return null;
        MatrixNoda product = new MatrixNoda(a.numRows(), b.numCols());
        for (int row = 0; row < product.numRows(); row++) {
            for (int col = 0; col < product.numCols(); col++) {
                int value = 0;
                for (int i = 0; i < b.numRows(); i++) {
                    value += a.getElement(row, i) * b.getElement(i, col);
                }
                product.setElement(row, col, value);
            }
        }
        return product;
    }

    public MatrixNoda subMatrix(int deletedRow, int deletedCol) {
        if ((deletedRow >= matrix.length) || (deletedCol >= matrix[0].length) || (matrix.length == 1)
                || (matrix[0].length == 1)) {
            return null;
        }

        MatrixNoda subMatrix = new MatrixNoda(matrix.length - 1, matrix[0].length - 1);
        for (int row = 0; row < matrix.length; row++) {
            if (row == deletedRow)
                continue;
            for (int column = 0; column < matrix[row].length; column++) {
                if (column == deletedCol)
                    continue;
                subMatrix.setElement((row < deletedRow ? row : row - 1),
                                     (column < deletedCol ? column : column - 1),
                                     matrix[row][column]);
            }
        }
        return subMatrix;
    }

    public Double determinant() {
        if (matrix.length != matrix[0].length)  {
            return null;
        }
        
        if (matrix.length == 1)
            return matrix[0][0];

        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        // det[A] = ax - bx + cx
        // If [x] = [[a, b][c, d]] then x = ad - bc
        if (matrix.length > 2) {
            double determinant = 0;
            for (int c = 0; c < matrix[0].length; c++) {
                determinant += (1 + (c %2) * -2) * matrix[0][c] * this.subMatrix(0, c).determinant();
            }
            return determinant;
        }
        return 1.0;
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                s += matrix[row][col] + "\t";
            }
            s += "\n";
        }
        return s;
    }

}
