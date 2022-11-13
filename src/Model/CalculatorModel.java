package Model;

public class CalculatorModel {

    private int row, column;
    private int[][] resultMatrix;

    public CalculatorModel(int row, int column){
        resultMatrix = new int[row][column];
        this.row = row;
        this.column = column;
    }

    public void addTwoMatrices(int[][] a, int[][] b) {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                resultMatrix[i][j] = a[i][j] + b[i][j];
            }
        }
    }

    public void subTwoMatrices(int[][] a, int[][] b) {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                resultMatrix[i][j] = a[i][j] - b[i][j];
            }
        }
    }

    public void multiplyTwoMatrices(int[][] a, int[][] b) {
        int [][] result = new int[row][column];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < b[0].length; k++)
                    result[i][j] += a[i][k] * b[k][j];
            }
        }
        resultMatrix = result;
    }

    public int[][] getMatrixValue() {
        return resultMatrix;
    }
}
