import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GuiCalculator extends JFrame {

    private JTextField num1Field, num2Field, resultField;

    public GuiCalculator() {
        setTitle("Simple GUI Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new GridLayout(6, 2, 5, 5));

        // Components
        add(new JLabel("First Number:"));
        num1Field = new JTextField();
        add(num1Field);

        add(new JLabel("Second Number:"));
        num2Field = new JTextField();
        add(num2Field);

        add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        // Buttons
        add(createButton("Add", e -> calculate("+")));
        add(createButton("Subtract", e -> calculate("-")));
        add(createButton("Multiply", e -> calculate("*")));
        add(createButton("Divide", e -> calculate("/")));

        add(createButton("Clear", e -> clearFields()));
        add(createButton("Exit", e -> System.exit(0)));
    }

    private JButton createButton(String text, ActionListener action) {
        JButton btn = new JButton(text);
        btn.addActionListener(action);
        return btn;
    }

    private void calculate(String op) {
        try {
            double a = Double.parseDouble(num1Field.getText());
            double b = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (op) {
                case "+": result = a + b; break;
                case "-": result = a - b; break;
                case "*": result = a * b; break;
                case "/":
                    if (b == 0) {
                        resultField.setText("Cannot divide by zero");
                        return;
                    }
                    result = a / b;
                    break;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    private void clearFields() {
        num1Field.setText("");
        num2Field.setText("");
        resultField.setText("");
    }

    public static void main(String[] args) {
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("CI environment detected — GUI not started!");
            return;
        }

        SwingUtilities.invokeLater(() -> new GuiCalculator().setVisible(true));
    }
}