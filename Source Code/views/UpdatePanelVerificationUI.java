
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.UpdatedInformationController;

public class UpdatePanelVerificationUI {

    private JPanel mainPanel;
    private JPanel customerPanel;
    private JPanel passwordPanel;
    private JPanel confirmPanel;
    private JTextField customerTextField;
    private JLabel contractLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordTextField;
    private JButton confirm;
    private JPanel displayPanel;
    /**
     * This method will display GUI for update information Verification.
     */
    public UpdatePanelVerificationUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        customerPanel = new JPanel();
        customerPanel.setLayout(new FlowLayout());
        customerPanel.add(Box.createHorizontalStrut(50));
        contractLabel = new JLabel("Enter a Contract ID");
        contractLabel.setFont(new Font("cambria",Font.PLAIN,23));
        customerTextField = new JTextField(20);
        customerTextField.setMaximumSize(new Dimension(200, 25));
        customerTextField.setFont(new Font("cambria",Font.PLAIN,23));
        customerPanel.add(contractLabel);
        customerPanel.add(Box.createHorizontalStrut(10));
        customerPanel.add(customerTextField);
        customerPanel.add(Box.createVerticalStrut(80));

        passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.add(Box.createHorizontalStrut(60));
        passwordLabel = new JLabel("Enter Password");
        passwordLabel.setFont(new Font("cambria",Font.PLAIN,23));
        passwordTextField = new JPasswordField(20);
        passwordTextField.setMaximumSize(new Dimension(200, 25));
        passwordPanel.add(passwordLabel);
        passwordTextField.setFont(new Font("cambria",Font.PLAIN,23));
        passwordPanel.add(Box.createHorizontalStrut(15));
        passwordPanel.add(passwordTextField);
        passwordPanel.add(Box.createVerticalStrut(80));

        confirmPanel = new JPanel();
        confirmPanel.setLayout(new FlowLayout());
        confirm = new JButton("Confirm");
        

        displayPanel = new JPanel();
        confirmPanel.add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatedInformationController update = new UpdatedInformationController();
                String password = new String(passwordTextField.getPassword());
                boolean isValid = update.validatePassword(customerTextField.getText(), password);
                if (isValid!= true){
					JOptionPane.showMessageDialog(null, "Invalid UserName or Password. Please Try Again");
					customerTextField.setText("");
					passwordTextField.setText("");
				}else{
	                List customerInformation = new ArrayList<>();
	                customerInformation = update.fetchCustomerInformation(customerTextField.getText());
	                UpdatedInformationUI disp = new UpdatedInformationUI(customerInformation);
	                mainPanel.remove(customerPanel);
	                mainPanel.remove(passwordPanel);
	                mainPanel.remove(confirmPanel);
	                mainPanel.add(disp.getInfoForm());
	                mainPanel.invalidate();
	                mainPanel.validate();
	                displayPanel = (disp.getInfoForm());
	                mainPanel.add(displayPanel);
                
              
                 }
               }
           });
        customerPanel.setFont(new Font("cambria", Font.PLAIN, 15));
        mainPanel.add(customerPanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(confirmPanel);
        mainPanel.setBackground(Color.yellow);
        mainPanel.setVisible(true);
    }

    public JPanel getUpdateFrontPage() {
        return mainPanel;
    }

}
