import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WaterPaymentApp extends JFrame {

    private JTextField nameField, amountField;
    private JLabel messageLabel;
    private double remainingWater = 1000; // Example: liters remaining

    public WaterPaymentApp() {
        setTitle("Water Payment System");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 1, 5, 5));

        // Welcome message
        JLabel welcome = new JLabel("Welcome to the Water Payment App!", JLabel.CENTER);
        add(welcome);

        // Name input
        add(new JLabel("Enter your name:"));
        nameField = new JTextField();
        add(nameField);

        // Pay water button
        JButton payButton = new JButton("Pay Water");
        add(payButton);

        // Amount input
        add(new JLabel("Enter payment amount:"));
        amountField = new JTextField();
        add(amountField);

        // Confirm Payment button
        JButton confirmButton = new JButton("Confirm Payment");
        add(confirmButton);

        // Remaining water button
        JButton remainingButton = new JButton("Check Remaining Water");
        add(remainingButton);

        // Message display
        messageLabel = new JLabel("", JLabel.CENTER);
        add(messageLabel);

        // Action listeners
        payButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name first!");
            } else {
                messageLabel.setText("Hello " + name + "! Enter amount to pay.");
            }
        });

        confirmButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText().trim());
                if (amount <= 0) {
                    JOptionPane.showMessageDialog(this, "Enter a valid amount!");
                    return;
                }
                // Example: 1 unit of money = 1 liter
                remainingWater -= amount;
                JOptionPane.showMessageDialog(this, "Payment of " + amount + " accepted!");
                messageLabel.setText("Thank you for your payment!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Could you enter a valid number?");
            }
        });

        remainingButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Remaining water: " + remainingWater + " liters");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WaterPaymentApp().setVisible(true));
    }
}