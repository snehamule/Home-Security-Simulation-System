
package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.UpdatedInformationController;


public class SimulateValidationUI {

    JPanel customerPanel;
    JLabel contractIdLabel;
    JTextField customerTextField;
    JPanel passwordPanel;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JPanel confirmPanel;
    JButton confirm;
    JPanel simulationPanel;

    
    /**
     * This will display GUI for Simulation Validataion.
     */
    public SimulateValidationUI() {
        customerPanel = new JPanel();
        customerPanel.setLayout(new FlowLayout());
        customerPanel.add(Box.createHorizontalStrut(50));
        contractIdLabel = new JLabel("Enter a Contract ID");
        contractIdLabel.setFont(new Font("cambria", Font.PLAIN, 23));
        customerTextField = new JTextField(20);
        customerTextField.setMaximumSize(new Dimension(200, 25));
        customerTextField.setFont(new Font("cambria", Font.PLAIN, 23));
        customerPanel.add(contractIdLabel);
        customerPanel.add(Box.createHorizontalStrut(10));
        customerPanel.add(customerTextField);
        customerPanel.add(Box.createVerticalStrut(80));

        passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.add(Box.createHorizontalStrut(60));
        passwordLabel = new JLabel("Enter Password");
        passwordLabel.setFont(new Font("cambria", Font.PLAIN, 23));
        passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(new Dimension(200, 25));
        passwordPanel.add(passwordLabel);
        passwordField.setFont(new Font("cambria", Font.PLAIN, 23));
        passwordPanel.add(Box.createHorizontalStrut(15));
        passwordPanel.add(passwordField);
        passwordPanel.add(Box.createVerticalStrut(80));

        confirmPanel = new JPanel();
        confirmPanel.setLayout(new FlowLayout());
        confirm = new JButton("Confirm");
        confirm.setFont(new Font("cambria", Font.PLAIN, 23));
        confirmPanel.add(confirm);

        simulationPanel = new JPanel();
        simulationPanel.setLayout(new BoxLayout(simulationPanel, BoxLayout.Y_AXIS));
        simulationPanel.add(customerPanel);
        simulationPanel.add(passwordPanel);
        simulationPanel.add(confirmPanel);

        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f) {
                simulationPanel.removeAll();
                UpdatedInformationController update = new UpdatedInformationController();
                String password2 = new String(passwordField.getPassword());
                boolean isValid = update.validatePassword(customerTextField.getText(), password2);
                if (isValid != true) {
                    JOptionPane.showMessageDialog(null, "Invalid Password. Please Try Again");
                    customerTextField.setText("");
                    passwordField.setText("");
                } else {
                    SimulationStartPageUI simulationStart = new SimulationStartPageUI(customerTextField.getText());
                    simulationPanel.add(simulationStart.getStartSimulationpanel());
                    simulationPanel.invalidate();
                    simulationPanel.validate();
                }
            }
        });
    }
    public String getConID() {
        return customerTextField.getText();
    }

    public JPanel getValidateSimulation() {
        return simulationPanel;
    }

}
