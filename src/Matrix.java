public class Matrix {
    private final int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = this.copyMatrix(matrix);
    }

    public int[][] getMatrix() {
        return matrix;
    }

    private int[][] copyMatrix(int[][] matrix) {
        int[][] copiedMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copiedMatrix[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                copiedMatrix[i][j] = matrix[i][j];
            }
        }

        return copiedMatrix;
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printSymbols() {
        if (matrix.length == 0) {
            System.out.println("Массив пуст");
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print((char)matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Matrix convertToSymbols() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[][] mtrx = copyMatrix(this.matrix);

        for (int i = 0; i < mtrx.length; i++) {
            for (int j = 0; j < mtrx[i].length; j++) {
                if (mtrx[i][j] > alphabet.length()) {
                    mtrx[i][j] = alphabet.charAt((mtrx[i][j] - 1) % alphabet.length());
                } else {
                    mtrx[i][j] = alphabet.charAt(mtrx[i][j] - 1);
                }
            }
        }

        return new Matrix(mtrx);
    }
}
