package calculator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {
    JTextField distanceField;
    JTextField averageConsField;
    JTextField priceField;

    JLabel distanceLabel;
    JLabel averageConsLabel;
    JLabel priceLabel;
    JLabel resultLabel;

    JPanel inputPanel;
    JPanel buttonPanel;

    JButton enterButton;

    JFrame frame;

    Double distanceDouble;
    Double priceDouble;
    Double averageConsDouble;
    Double finalPriceDouble;

    public Calculator() {
        distanceDouble = 0.0;
        priceDouble = 0.0;
        averageConsDouble = 0.0;
        finalPriceDouble = 0.0;

        distanceField = new JTextField(10);
        distanceField.setToolTipText("Please enter the distance here.");

        averageConsField = new JTextField(10);
        averageConsField.setToolTipText("Please enter your average fuel consumption.");

        priceField = new JTextField(10);
        priceField.setToolTipText("Please enter the fuel price.");

        distanceLabel = new JLabel("Distance");
        averageConsLabel = new JLabel("Average consumption");
        priceLabel = new JLabel("Fuel price");
        resultLabel = new JLabel("Trip cost: 0");

        inputPanel = new JPanel();
        inputPanel.add(distanceLabel);
        inputPanel.add(distanceField);
        inputPanel.add(averageConsLabel);
        inputPanel.add(averageConsField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(resultLabel);
        inputPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.setPreferredSize(new Dimension(170, 170));
        inputPanel.setMaximumSize(new Dimension(170, 170));



        enterButton = new JButton();
        enterButton.setText("Enter");
        enterButton.setToolTipText("Submit the entered data.");
        enterButton.addActionListener(this);

        buttonPanel = new JPanel();
        buttonPanel.add(enterButton);
        buttonPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setPreferredSize(new Dimension(100, 50));
        buttonPanel.setMaximumSize(new Dimension(100, 50));



        frame = new JFrame();
        frame.setTitle("Trip cost");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(180, 250);
        frame.getContentPane().add(inputPanel);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            String distanceString = distanceField.getText();
            String priceString = priceField.getText();
            String averageConsString = averageConsField.getText();

            if (CheckDouble(distanceString) == false || CheckDouble(priceString) == false || CheckDouble(averageConsString) == false) {
                resultLabel.setText("Error in input.");
            }
            else {
                distanceDouble = Double.parseDouble(distanceString);
                priceDouble = Double.parseDouble(priceString);
                averageConsDouble = Double.parseDouble(averageConsString);

                finalPriceDouble = averageConsDouble * distanceDouble / 100 * priceDouble;
                resultLabel.setText("Trip cost: " + String.format("%.2f", finalPriceDouble));
            }
        }
    }

    private boolean CheckDouble(String toCheck) {
        try {
            Double.parseDouble(toCheck);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
}
