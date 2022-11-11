package Model;



public class CalculatorModel{
    public int rows;
    public int columns;

    private int[][] resultMatrix;

    public CalculatorModel(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
    }

    public void addTwoMatrices(int[][] a, int[][] b){

        int rows = a.length;
        int columns = a[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        resultMatrix = result;
    }

    public void multiplyTwoMatrices(int[][] a, int[][] b){
        int rows = a.length;
        int columns = a[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = a[i][j] * b[i][j];
            }
        }
        resultMatrix = result;
    }

    public int[][] getMatrixValue(){
        return resultMatrix;
    }
}
