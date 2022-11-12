package Model;

public class CalculatorModel {

    private int[][] resultMatrix;

    public CalculatorModel(int row, int column){
        resultMatrix = new int[row][column];
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
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < a.length; k++)
                    resultMatrix[i][j] = b[j][k] * a[k][i];
            }
        }
    }

    public int[][] getMatrixValue() {
        return resultMatrix;
    }
}
