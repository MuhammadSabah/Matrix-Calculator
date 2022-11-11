package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class CalculatorView extends JFrame{
    JButton calculateButton = new JButton("calculate");
    public int r1, c1;
    public int r2, c2;
    private HashMap <String, JTextField> firstMatrixFields = new HashMap<String, JTextField>();
    private HashMap <String, JTextField> secondMatrixFields = new HashMap<String, JTextField>();
    private HashMap <String, JTextField> resultMatrixFields = new HashMap<String, JTextField>();

    public CalculatorView(int row, int column){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(150*row, 50*column);
        this.setLocation(350,100);
        this.setTitle("matrix calculator");
        this.setVisible(true);

        r1 = row; c1 = column;
        r2 = row; c2 = column;

        setHashmapIndex(firstMatrixFields, row*column);
        setHashmapIndex(secondMatrixFields, row*column);
        setHashmapIndex(resultMatrixFields, row*column);

        JPanel m1 = addFields(row, column, firstMatrixFields);
        JPanel m2 = addFields(row, column, secondMatrixFields);
        JPanel mainPanel = new JPanel();
        JPanel resultJPanel = addFields(row, column, resultMatrixFields);

        mainPanel.add(m1);
        mainPanel.add(m2);
        mainPanel.add(calculateButton);
        mainPanel.add(resultJPanel);

        this.add(mainPanel);
    }

    public void setHashmapIndex(HashMap <String, JTextField> hashMap, int n){
        String fieldName = "";
        for (int i = 1; i <= n; i++) {
            fieldName = "";
            fieldName += i;
            JTextField jT = new JTextField(2);
            hashMap.put(fieldName, jT);
        }

    }

    public JPanel addFields(int rows, int columns, HashMap <String, JTextField> hashMap) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, columns));

        int index = 1;
        for (int i = 0; i < columns; i++) {
            for(int j = 0; j< rows; j++){
                panel.add(hashMap.get(String.valueOf(index)));
                index++;               
            }
        }
        return panel;
    }
    public int[][] getFirstMatrix(int row, int column){
        int index = 1;
        int[][] array = new int[row][column];
        for(int i = 0; i<array[0].length; i++){
            for(int j = 0; j<array.length; j++){
                array[i][j] = Integer.parseInt(firstMatrixFields.get(String.valueOf(index)).getText());
                index++;
            }
        }
        return array;
    }
    public int[][] getSecondMatrix(int row, int column){
        int index = 1;
        int[][] array = new int[row][column];
        for(int i = 0; i<array[0].length; i++){
            for(int j = 0; j<array.length; j++){
                array[i][j] = Integer.parseInt(secondMatrixFields.get(String.valueOf(index)).getText());
                index++;
            }
        }
        return array;
    }

    public void setCalculationResult(int[][] result){
        int index = 1;
        for(int i = 0; i<result[0].length; i++){
            for(int j = 0; j<result.length; j++){
                resultMatrixFields.get(String.valueOf(index)).setText(Integer.toString(result[i][j]));
                index++;
            }
        }
    }

    public void addCalculationListener(ActionListener calculationListener){
        calculateButton.addActionListener(calculationListener);
    }
    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
