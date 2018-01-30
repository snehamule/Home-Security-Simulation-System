
package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame; s
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.ClientInformationController;


public class ClientInformationUI extends JFrame {
    private JPanel mainPanel;
	 private JPanel namePanel;
	 private JPanel phoneNumberPanel;
	 private JPanel emailPanel;
	 private JPanel cotractIdPanel;
	 private JPanel contractDurationPanel;
	 private JPanel startDatePanel;
	 private JPanel addressPanel;
	 private JPanel zipPanel;
	 private JPanel statePanel;
	 private JPanel countryPanel;
	 private JPanel passwordPanel;
	 private JPanel rewritePasswordPanel;
	 private JPanel emergencyContactFirstPanel;
	 private JPanel  emergencyContactSecondPanel;
	 private JPanel buttonPanel;
	 private JLabel nameLabel; 
	 private JTextField nameTextField;
	 private JLabel phoneNumberLabel; 
	 private JTextField phoneNumberTextField;
	 private JLabel emailLabel; 
	 private JTextField emailTextField;
	 private JLabel contractIdLabel; 
	 private JTextField contractIdTextField;
	 private JLabel addressLabel; 
	 private JTextField addressTextField;
	 private JLabel zipLabel; 
	 private JTextField zipTextField;
	 private JLabel stateLabel; 
	 private JTextField stateTextField;
	 private JLabel countryLabel; 
	 private JTextField countryTextField;
	 private JLabel passwordLabel; 
	 private JPasswordField passwordTextField;
	 private JLabel rewritePasswordLabel; 
	 private JPasswordField rewritePasswordTextField;
	 private JLabel emergencyContactFirstLabel; 
	 private JTextField emergencyContactFirstTextField;
	 private JLabel emergencyContactSecondLabel; 
	 private JTextField emergencyContactSecondTextField;
	 private JLabel startDateLabel;
	 private JLabel contractDurationLabel;
	 private JRadioButton sixMonthDuration;
	 private JRadioButton oneYearDuration;
	 private JRadioButton twoYearDuration;
	 private JRadioButton threeYearDuration;
	 private JRadioButton fiveYearDuration;
	 private JButton confirm;
	 private ButtonGroup buttonGroup;
	 private JTextField startDateTextField;
	 private JButton startDateButton;
	
    
    /**
     * This method will display GUI for Client Information
     */
    public ClientInformationUI() {
		mainPanel= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(800, 500));
		namePanel= new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		nameLabel = new JLabel("Name"); 
        nameLabel.setFont(new Font("Cambria",Font.PLAIN,23));
		nameLabel.setAlignmentX(LEFT_ALIGNMENT);
		nameTextField = new JTextField(20);
        nameTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		nameTextField.setMaximumSize(new Dimension(500,25));
		namePanel.add(nameLabel);
		namePanel.add(Box.createHorizontalStrut(200));
		namePanel.add(nameTextField);
		
		phoneNumberPanel= new JPanel();
		phoneNumberPanel.setLayout(new BoxLayout(phoneNumberPanel, BoxLayout.X_AXIS));
		phoneNumberLabel = new JLabel("Phone Number"); 
        phoneNumberLabel.setFont(new Font("Cambria",Font.PLAIN,23));
		phoneNumberTextField = new JTextField(20);
		phoneNumberTextField.setMaximumSize(new Dimension(500,25));
        phoneNumberTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		phoneNumberPanel.add(phoneNumberLabel);
		phoneNumberPanel.add(Box.createHorizontalStrut(110));
		phoneNumberPanel.add(phoneNumberTextField);
		
		emailPanel= new JPanel();
		emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
		emailLabel = new JLabel("Email"); 
        emailLabel.setFont(new Font("Cambria",Font.PLAIN,23));
		emailTextField = new JTextField(20);
		emailTextField.setMaximumSize(new Dimension(500,25));
        emailTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		emailPanel.add(emailLabel);
		emailPanel.add(Box.createHorizontalStrut(200));
		emailPanel.add(emailTextField);
		
		cotractIdPanel= new JPanel();
		cotractIdPanel.setLayout(new BoxLayout(cotractIdPanel, BoxLayout.X_AXIS));
		contractIdLabel = new JLabel("Contract ID"); 
        contractIdLabel.setFont(new Font("Cambria",Font.PLAIN,23));
        contractIdLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		contractIdTextField = new JTextField(20);
        contractIdTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		contractIdTextField.setMaximumSize(new Dimension(500,25));
		cotractIdPanel.add(contractIdLabel);
		cotractIdPanel.add(Box.createHorizontalStrut(145));
		cotractIdPanel.add(contractIdTextField);
		
		contractDurationPanel=new JPanel();
		cotractIdPanel.setLayout(new BoxLayout(cotractIdPanel, BoxLayout.X_AXIS));
		contractDurationLabel= new JLabel("Contract Duration");
        contractDurationLabel.setFont(new Font("Cambria",Font.PLAIN,23));
        contractDurationLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		buttonGroup= new ButtonGroup();
		sixMonthDuration= new JRadioButton("6 Month");
		sixMonthDuration.setSelected(true);
		oneYearDuration= new JRadioButton("1 Year");
		twoYearDuration= new JRadioButton("2 Year");
		threeYearDuration= new JRadioButton("3 Year");
		fiveYearDuration= new JRadioButton("5 Year");
		buttonGroup.add(sixMonthDuration);
		buttonGroup.add(oneYearDuration);
		buttonGroup.add(twoYearDuration);
		buttonGroup.add(threeYearDuration);
		buttonGroup.add(fiveYearDuration);
		contractDurationPanel.add(contractDurationLabel);
		contractDurationPanel.add(sixMonthDuration);
		contractDurationPanel.add(oneYearDuration);
		contractDurationPanel.add(twoYearDuration);
		contractDurationPanel.add(threeYearDuration);
		contractDurationPanel.add(fiveYearDuration);
                
		startDatePanel = new JPanel();
		startDatePanel.setLayout(new BoxLayout(startDatePanel, BoxLayout.X_AXIS));
		startDateButton =new JButton("Select Start Date");
        startDateButton.setFont(new Font("cambria",Font.PLAIN,20));
		startDateLabel= new JLabel("Start Date");
        startDateLabel.setFont(new Font("Cambria",Font.PLAIN,23));
		startDateTextField = new JTextField();
		startDateTextField = new JTextField(25);
        startDateTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		final JFrame f = new JFrame();
		startDateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			   startDateTextField.setText(new DateSelectorUI(f).convertSelectedDate());
			}
		});
		startDateTextField.setMaximumSize(new Dimension(100,25));
		startDatePanel.add(startDateLabel);
		startDatePanel.add(Box.createHorizontalStrut(160));
		startDatePanel.add(startDateTextField);
		startDatePanel.add(Box.createHorizontalStrut(50));
		startDatePanel.add(startDateButton);
		
		
		addressPanel= new JPanel();
		addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.X_AXIS));
		addressLabel = new JLabel("Address"); 
        addressLabel.setFont(new Font("Cambria",Font.PLAIN,23));
		addressTextField = new JTextField(20);
        addressTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		addressTextField.setMaximumSize(new Dimension(500,25));
		addressPanel.add(addressLabel);
		addressPanel.add(Box.createHorizontalStrut(180));
		addressPanel.add(addressTextField);

		statePanel= new JPanel();
		statePanel.setLayout(new BoxLayout(statePanel, BoxLayout.X_AXIS));
		stateLabel = new JLabel("State"); 
        stateLabel.setFont(new Font("Cambria",Font.PLAIN,23));
		stateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		stateTextField = new JTextField(20);
		stateTextField.setMaximumSize(new Dimension(500,25));
        stateTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		statePanel.add(stateLabel);
		statePanel.add(Box.createHorizontalStrut(210));
		statePanel.add(stateTextField);
		
		zipPanel= new JPanel();
		zipPanel.setLayout(new BoxLayout(zipPanel, BoxLayout.X_AXIS));
		zipLabel = new JLabel("Zip code"); 
        zipLabel.setFont(new Font("Cambria",Font.PLAIN,23));
		zipTextField = new JTextField(20);
		zipTextField.setMaximumSize(new Dimension(500,25));
        zipTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		zipPanel.add(zipLabel);
		zipPanel.add(Box.createHorizontalStrut(180));
		zipPanel.add(zipTextField);
	
		
		countryPanel= new JPanel();
		countryPanel.setLayout(new BoxLayout(countryPanel, BoxLayout.X_AXIS));
		countryLabel = new JLabel("Country"); 
        countryLabel.setFont(new Font("Cambria",Font.PLAIN,23));
		countryTextField = new JTextField(20);
        countryTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		countryTextField.setMaximumSize(new Dimension(500,25));
		countryPanel.add(countryLabel);
		countryPanel.add(Box.createHorizontalStrut(180));
		countryPanel.add(countryTextField);
		
		passwordPanel= new JPanel();
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		passwordLabel = new JLabel("Set Password"); 
        passwordLabel.setFont(new Font("Cambria",Font.PLAIN,23));
		passwordTextField = new JPasswordField(20);
		passwordTextField.setMaximumSize(new Dimension(500,25));
        passwordTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		passwordPanel.add(passwordLabel);
		passwordPanel.add(Box.createHorizontalStrut(130));
		passwordPanel.add(passwordTextField);
		
		rewritePasswordPanel= new JPanel();
		rewritePasswordPanel.setLayout(new BoxLayout(rewritePasswordPanel, BoxLayout.X_AXIS));
		rewritePasswordLabel = new JLabel("Re- Write Password");
        rewritePasswordLabel.setFont(new Font("Cambria",Font.PLAIN,23));
		rewritePasswordTextField = new JPasswordField(20);
        rewritePasswordTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		rewritePasswordTextField.setMaximumSize(new Dimension(500,25));
		rewritePasswordPanel.add(rewritePasswordLabel);
		rewritePasswordPanel.add(Box.createHorizontalStrut(65));
		rewritePasswordPanel.add(rewritePasswordTextField);
		
		emergencyContactFirstPanel= new JPanel();
		emergencyContactFirstPanel.setLayout(new BoxLayout(emergencyContactFirstPanel, BoxLayout.X_AXIS));
		emergencyContactFirstLabel = new JLabel("Emergency Contact No 1"); 
        emergencyContactFirstLabel.setFont(new Font("Cambria",Font.PLAIN,23));
		emergencyContactFirstTextField = new JTextField(20);
        emergencyContactFirstTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		emergencyContactFirstTextField.setMaximumSize(new Dimension(500,25));
		emergencyContactFirstPanel.add(emergencyContactFirstLabel);
		emergencyContactFirstPanel.add(Box.createHorizontalStrut(20));
		emergencyContactFirstPanel.add(emergencyContactFirstTextField);
		
		
		emergencyContactSecondPanel= new JPanel();
		emergencyContactSecondPanel.setLayout(new BoxLayout(emergencyContactSecondPanel, BoxLayout.X_AXIS));
		emergencyContactSecondLabel = new JLabel("Emergency Contact No 2"); 
        emergencyContactSecondLabel.setFont(new Font("Cambria",Font.PLAIN,23));
        emergencyContactSecondLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		emergencyContactSecondTextField = new JTextField(20);
        emergencyContactFirstTextField.setFont(new Font("Cambria",Font.PLAIN,23));
		emergencyContactSecondTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
        emergencyContactSecondTextField.setFont(new Font("Cambria",Font.PLAIN,23));
        emergencyContactSecondTextField.setMaximumSize(new Dimension(500,25));
		emergencyContactSecondPanel.add(emergencyContactSecondLabel);
		emergencyContactSecondPanel.add(Box.createHorizontalStrut(20));
		emergencyContactSecondPanel.add(emergencyContactSecondTextField);
		
		
		buttonPanel= new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		confirm=new JButton("Confirm");
        confirm.setFont(new Font("cambria",Font.PLAIN,23));
		ActionListener al= new confirmActionListener();
		confirm.addActionListener(al);
		buttonPanel.add(confirm);
				
		mainPanel.add(namePanel);
        namePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(phoneNumberPanel);
        phoneNumberPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(emailPanel);
        emailPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(contractDurationPanel);
        contractDurationPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(cotractIdPanel);
        cotractIdPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(startDatePanel);
        startDatePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(addressPanel);
        addressPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(countryPanel);
        countryPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(zipPanel);
        zipPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(statePanel);
        statePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(emergencyContactFirstPanel);
        emergencyContactFirstPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(emergencyContactSecondPanel);
        emergencyContactSecondPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(passwordPanel);
        passwordPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(rewritePasswordPanel);
        rewritePasswordPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(buttonPanel);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.setVisible(true);
    }
    
    	class confirmActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==confirm){
				String name= nameTextField.getText();
				 String phoneNumber=phoneNumberTextField.getText();
				 String email=emailTextField.getText();
				 String contractID=contractIdTextField.getText();
				 String contractDuration = "";
				 if(sixMonthDuration.isSelected()){
					 contractDuration="Six Month";
				 }else if(oneYearDuration.isSelected()){
					 contractDuration="One Year";
				 }else if(twoYearDuration.isSelected()){
					 contractDuration="Two Year";
				 } else{
					 contractDuration="Five Year";
				 }
				 String address=addressTextField.getText();
				 String zip=zipTextField.getText();
				 String state=stateTextField.getText();
				 String country=countryTextField.getText();
				 String password= new String(passwordTextField.getPassword());
				 String rewritePassword= new String(rewritePasswordTextField.getPassword());
				 String emergencyContactFirst=emergencyContactFirstTextField.getText();
				 String emergencyContactSecond=emergencyContactSecondTextField.getText();
				 boolean flag =true;
				if(emergencyContactSecond.trim().length()!=10){
					JOptionPane.showMessageDialog(null, "Second emergency Contact Number is Invalid. Contact Number should have exactly 10 numbers");
					flag=false;
				}	
				if(!(zip.matches("[0-9]+"))){
					JOptionPane.showMessageDialog(null, "Zip code is invalid. Zip code should contains only numbers.");
					flag=false;
				}	
				if(emergencyContactFirst.trim().length()!=10){
					JOptionPane.showMessageDialog(null, "First emergency Contact Number is Invalid. Contact Number should have exactly 10 numbers");
					flag=false;
				}
				if(phoneNumber.trim().length()!=10){
					JOptionPane.showMessageDialog(null, "Phone number Contact Number is Invalid. Contact Number should have exactly 10 numbers");
					flag=false;
				}
				if(!(password.equals(rewritePassword))){
					JOptionPane.showMessageDialog(null, "Passwords are not exactly match.Please Enter password again");
					passwordTextField.setText("");
					rewritePasswordTextField.setText("");
					flag=false;
				}
				if(flag){
					ClientInformationController client= new ClientInformationController(name,phoneNumber,email,contractID,contractDuration,
							startDateTextField.getText(),address,zip,state,country,password,emergencyContactFirst,emergencyContactSecond);
					JOptionPane.showMessageDialog(null, "Information Saved sucessfully!!");
					mainPanel.setVisible(false);
				}
		}
	
	}
	
  }
    public JPanel getInfoForm(){
		return mainPanel;
	}
}