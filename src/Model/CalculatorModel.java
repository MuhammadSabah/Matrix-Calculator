package Model;

public class CalculatorModel {

    private int row, column;
    private int[][] resultMatrix;

    public CalculatorModel(int row, int column){
        resultMatrix = new int[row][column];
        this.row = row;
        this.column = column;
    }

    public int[][] getResultMatrix() {
        return resultMatrix;
    }
    public void setResultMatrix(int[][] resultMatrix){
        this.resultMatrix = resultMatrix;
    }
}
