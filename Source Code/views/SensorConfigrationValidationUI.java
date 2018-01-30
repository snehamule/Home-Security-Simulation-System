
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SensorConfigrationValidationUI {
    
    JPanel customerPanel;
    JLabel contractLabel;
    JTextField customerTextField;
    JPanel passwordPanel;
    JLabel passwordLabel;
    JTextField passwordTextField;
    JPanel confirmPanel;
    JButton confirm;
    JPanel sensorConfigurationPanel;
    
   /**
 * this display GUI for Sensor Configuration
 */
public SensorConfigrationValidationUI() {
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
        confirm.setFont(new Font("cambria",Font.PLAIN,23));
        confirmPanel.add(confirm);
        
        sensorConfigurationPanel = new JPanel();
        sensorConfigurationPanel.setLayout(new BoxLayout(sensorConfigurationPanel,BoxLayout.Y_AXIS));
        sensorConfigurationPanel.add(customerPanel);
        sensorConfigurationPanel.add(passwordPanel);
        sensorConfigurationPanel.add(confirmPanel);
        
        confirm.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent f) {
            sensorConfigurationPanel.removeAll();
            SensorConfigurationUI s = new SensorConfigurationUI(customerTextField.getText().trim());
            sensorConfigurationPanel.add(s.getSensorConfigurator());
            sensorConfigurationPanel.invalidate();
            sensorConfigurationPanel.validate();
            sensorConfigurationPanel.setVisible(true);
            getContractid();
            }
        });
}
 
   public String getContractid(){
       String contractId = customerTextField.getText();
       return contractId;
   }
   
    public JPanel getSensorConfigurationPanel() {
        return sensorConfigurationPanel ;
    }

}