// Calculator.java
// A simple calculator using Java AWT and Swing for basic mathematical operations

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder currentInput;
    private double result;
    private String operator;
    private boolean startNewNumber;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "CE", "%", "±"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        currentInput = new StringBuilder();
        result = 0;
        operator = "";
        startNewNumber = true;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.matches("[0-9]") || cmd.equals(".")) {
            if (startNewNumber) {
                currentInput.setLength(0);
                startNewNumber = false;
            }
            if (!(cmd.equals(".") && currentInput.toString().contains("."))) {
                currentInput.append(cmd);
                display.setText(currentInput.toString());
            }
        } else if (cmd.equals("C")) {
            currentInput.setLength(0);
            result = 0;
            operator = "";
            display.setText("0");
            startNewNumber = true;
        } else if (cmd.equals("CE")) {
            currentInput.setLength(0);
            display.setText("0");
            startNewNumber = true;
        } else if (cmd.equals("±")) {
            if (currentInput.length() > 0) {
                if (currentInput.charAt(0) == '-')
                    currentInput.deleteCharAt(0);
                else
                    currentInput.insert(0, '-');
                display.setText(currentInput.toString());
            }
        } else if (cmd.equals("%")) {
            if (currentInput.length() > 0) {
                double val = Double.parseDouble(currentInput.toString()) / 100.0;
                currentInput = new StringBuilder(Double.toString(val));
                display.setText(currentInput.toString());
            }
        } else if (cmd.equals("=")) {
            calculate(Double.parseDouble(currentInput.length() > 0 ? currentInput.toString() : "0"));
            display.setText(Double.toString(result));
            operator = "";
            startNewNumber = true;
        } else { // Operator
            if (currentInput.length() > 0) {
                if (!operator.isEmpty()) {
                    calculate(Double.parseDouble(currentInput.toString()));
                } else {
                    result = Double.parseDouble(currentInput.toString());
                }
                operator = cmd;
                startNewNumber = true;
            } else if (!operator.isEmpty()) {
                operator = cmd;
            }
        }
    }

    private void calculate(double num) {
        switch (operator) {
            case "+":
                result += num;
                break;
            case "-":
                result -= num;
                break;
            case "*":
                result *= num;
                break;
            case "/":
                if (num != 0) result /= num;
                else display.setText("Error");
                break;
            default:
                result = num;
        }
        currentInput = new StringBuilder(Double.toString(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculator().setVisible(true);
        });
    }
}
