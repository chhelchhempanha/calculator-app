import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, modButton, clearButton;

    public Calculator() {
        setTitle("Calculator");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 5, 5));

        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberField = new JTextField();
        firstNumberField.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberField = new JTextField();
        secondNumberField.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setFont(new Font("Arial", Font.PLAIN, 20));

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        modButton = new JButton("%");
        clearButton = new JButton("Clear");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        modButton.addActionListener(this);
        clearButton.addActionListener(this);

        inputPanel.add(firstNumberLabel);
        inputPanel.add(firstNumberField);
        inputPanel.add(secondNumberLabel);
        inputPanel.add(secondNumberField);
        inputPanel.add(resultLabel);
        inputPanel.add(resultField);

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(modButton);
        buttonPanel.add(clearButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double firstNumber = Double.parseDouble(firstNumberField.getText());
            double secondNumber = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = firstNumber + secondNumber;
            } else if (e.getSource() == subtractButton) {
                result = firstNumber - secondNumber;
            } else if (e.getSource() == multiplyButton) {
                result = firstNumber * secondNumber;
            } else if (e.getSource() == divideButton) {
                result = firstNumber / secondNumber;
            } else if (e.getSource() == modButton) {
                result = firstNumber % secondNumber;
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
