
package views;

import java.awt.Color;
import java.awt.Component;
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

import controller.UpdatedInformationController;


public class AlarmPanelUI{
    private JButton confirmButton;
    private JPanel alarmInformationPanel;
    private JPanel callPanel;
    private JPanel firePanel;
    private JPanel motionPanel;
    private JLabel callingLabel;
    private JLabel callingTwoLabel;
    private JLabel fireAlarmLabel;
    private JLabel motionAlarmLabel;
    private JLabel enterPassword;
    private JPasswordField password;
    private JButton confirmButtonDeactivate;
    private JLabel call;
    private JLabel phone;
    List customerInformation= new ArrayList();
    private String user;
    
    public AlarmPanelUI() {
        
    }
    
    /**
     * This method display GUI for alaram simulation.
     * @param customerInfo
     * @param user
     */
    public AlarmPanelUI(List customerInfo,String user) {
    	customerInformation=customerInfo;
        alarmInformationPanel = new JPanel();
        alarmInformationPanel.setLayout(new BoxLayout(alarmInformationPanel, BoxLayout.Y_AXIS));

        callPanel = new JPanel();
        callPanel.setLayout(new FlowLayout());

        firePanel = new JPanel();
        firePanel.setLayout(new BoxLayout(firePanel,BoxLayout.Y_AXIS));
        
        motionPanel = new JPanel();
        motionPanel.setLayout(new BoxLayout(motionPanel,BoxLayout.Y_AXIS));

        fireAlarmLabel = new JLabel("Fire Alarm Activated");
        fireAlarmLabel.setForeground(Color.red);
        fireAlarmLabel.setFont(new Font("Cambria", Font.BOLD, 30));
        fireAlarmLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        motionAlarmLabel = new JLabel("Motion Alarm Activated");
        motionAlarmLabel.setForeground(Color.red);
        motionAlarmLabel.setFont(new Font("Cambria", Font.BOLD, 30));
        motionAlarmLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        phone= new JLabel();
        callingLabel = new JLabel("Calling");
        callingLabel.setForeground(Color.red);
        callingLabel.setFont(new Font("Cambria", Font.PLAIN, 20));
        
        phone.setText((String) customerInformation.get(1));
        phone.setForeground(Color.red);
        phone.setFont(new Font("Cambria", Font.PLAIN, 20));

        callingTwoLabel = new JLabel("Calling");
        callingTwoLabel.setForeground(Color.red);
        callingTwoLabel.setFont(new Font("Cambria", Font.PLAIN, 20));
        call= new JLabel();
        call.setText((String) customerInformation.get(2));
        call.setForeground(Color.red);
        call.setFont(new Font("Cambria", Font.PLAIN, 20));

        callPanel.add(callingLabel);
        callPanel.add(phone);
        callPanel.add(callingTwoLabel);
        callPanel.add(call);
        
        enterPassword = new JLabel("Enter password to stop alarm");
        enterPassword.setFont(new Font("Cambria", Font.BOLD, 20));
        enterPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        password = new JPasswordField(20);
        password.setMaximumSize(new Dimension(300,50));
        password.setAlignmentX(Component.CENTER_ALIGNMENT);

        confirmButton = new JButton("confirmButton");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setFont(new Font("cambria",Font.PLAIN,24));
        confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                UpdatedInformationController update= new UpdatedInformationController();
				String password2 =new String(password.getPassword());
				boolean isValid=update.validatePassword(user,password2);
				if (isValid!= true){
					JOptionPane.showMessageDialog(null, "Invalid Password. Please Try Again");
					password.setText("");
                }else{
					JOptionPane.showMessageDialog(null, "Password accepted!!");
					fireAlarmLabel.setText("Fire Alarm Deactivated");
		            motionAlarmLabel.setText("Intrusion alarm Deactivated");
					phone.setVisible(false);
					callingLabel.setVisible(false);
					callingTwoLabel.setVisible(false);
					call.setVisible(false);
					confirmButton.setVisible(false);
                    password.setVisible(false);
                    enterPassword.setVisible(false);               
				}
             }   
		});
        
        confirmButton.setFont(new Font("Cambria", Font.PLAIN, 25));
        firePanel.add(fireAlarmLabel);
        motionPanel.add(motionAlarmLabel);
        confirmButtonDeactivate= new JButton("confirmButton");
        confirmButtonDeactivate.setFont(new Font("cambria",Font.PLAIN,30));

        alarmInformationPanel.add(callPanel);
        alarmInformationPanel.add(enterPassword);
        alarmInformationPanel.add(Box.createVerticalStrut(30));
        alarmInformationPanel.add(password);
        alarmInformationPanel.add(Box.createVerticalStrut(30));
        alarmInformationPanel.add(confirmButton);
        }
    
        public JPanel getAlarmtrigger(){
        	return alarmInformationPanel;
        }
        
        public JPanel getFirePanel(){
            return firePanel;
        }
        
        public JPanel getMotionPanel(){
            return motionPanel;
        }
   
}
