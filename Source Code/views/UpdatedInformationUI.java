
package views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
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


public class UpdatedInformationUI extends JPanel{
	private JPanel mainPanel;
	 private JPanel namePanel;
	 private JPanel phoneNumberPanel;
	 private JPanel emailPanel;
	 private JPanel cotractIdPanel;
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
	 private JButton confirm;
	
	List customerInformation= new ArrayList<>();
	
	
	/**
	 * This method will display GUI for update Information.
	 * @param customerInfo
	 */
	public UpdatedInformationUI(List customerInfo){
		customerInformation=Arrays.asList(customerInfo.toString().split(","));
		mainPanel= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

		namePanel= new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		nameLabel = new JLabel("Name"); 
        nameLabel.setFont(new Font("Cambria",Font.PLAIN,20));
		nameLabel.setAlignmentX(LEFT_ALIGNMENT);
		nameTextField = new JTextField(20);
		nameTextField.setFont(new Font("Cambria",Font.PLAIN,20));
        if((String) customerInformation.get(1)!=null){
        	   nameTextField.setText(((String) customerInformation.get(1)).trim());
         }
		nameTextField.setMaximumSize(new Dimension(500,25));
		namePanel.add(nameLabel);
		namePanel.add(Box.createHorizontalStrut(130));
		namePanel.add(nameTextField);
		
		phoneNumberPanel= new JPanel();
		phoneNumberPanel.setLayout(new BoxLayout(phoneNumberPanel, BoxLayout.X_AXIS));
		phoneNumberLabel = new JLabel("Phone Number"); 
		phoneNumberLabel.setFont(new Font("Cambria",Font.PLAIN,20));
        phoneNumberTextField = new JTextField(20);
		phoneNumberTextField.setFont(new Font("Cambria",Font.PLAIN,20));
        if((String) customerInformation.get(2)!=null){
        	 phoneNumberTextField.setText(((String) customerInformation.get(2)).trim());
		}
		phoneNumberTextField.setMaximumSize(new Dimension(500,25));
		phoneNumberPanel.add(phoneNumberLabel);
		phoneNumberPanel.add(Box.createHorizontalStrut(80));
		phoneNumberPanel.add(phoneNumberTextField);

		emailPanel= new JPanel();
		emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
		emailLabel = new JLabel("Email"); 
        emailLabel.setFont(new Font("Cambria",Font.PLAIN,20));
		emailTextField = new JTextField(20);
        emailTextField.setFont(new Font("Cambria",Font.PLAIN,20));
		if((String) customerInformation.get(3)!=null){
			emailTextField.setText(((String) customerInformation.get(3)).trim());
		}
		emailTextField.setMaximumSize(new Dimension(500,25));
		emailPanel.add(emailLabel);
		emailPanel.add(Box.createHorizontalStrut(130));
		emailPanel.add(emailTextField);
		
		
		cotractIdPanel= new JPanel();
		cotractIdPanel.setLayout(new BoxLayout(cotractIdPanel, BoxLayout.X_AXIS));
		contractIdLabel = new JLabel("Contract ID"); 
        contractIdLabel.setFont(new Font("Cambria",Font.PLAIN,20));
		contractIdTextField = new JTextField(20);
        contractIdTextField.setFont(new Font("Cambria",Font.PLAIN,20));
		if((String) customerInformation.get(0)!=null){
			contractIdTextField.setText(((String) customerInformation.get(0)).trim().substring(1,customerInformation.get(0).toString().length()));
		}
		contractIdTextField.setMaximumSize(new Dimension(500,25));
		cotractIdPanel.add(contractIdLabel);
		cotractIdPanel.add(Box.createHorizontalStrut(100));
		cotractIdPanel.add(contractIdTextField);
		
		addressPanel= new JPanel();
		addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.X_AXIS));
		addressLabel = new JLabel("Address"); 
        addressLabel.setFont(new Font("Cambria",Font.PLAIN,20));
		addressTextField = new JTextField(20);
        addressTextField.setFont(new Font("Cambria",Font.PLAIN,20));
		if((String) customerInformation.get(6)!=null){
			addressTextField.setText(((String) customerInformation.get(6)).trim());
		}
		addressTextField.setMaximumSize(new Dimension(500,25));
		addressPanel.add(addressLabel);
		addressPanel.add(Box.createHorizontalStrut(110));
		addressPanel.add(addressTextField);

		
		statePanel= new JPanel();
		statePanel.setLayout(new BoxLayout(statePanel, BoxLayout.X_AXIS));
		stateLabel = new JLabel("State"); 
        stateLabel.setFont(new Font("Cambria",Font.PLAIN,20));
		stateLabel.setAlignmentX(LEFT_ALIGNMENT);
		stateTextField = new JTextField(20);
        stateTextField.setFont(new Font("Cambria",Font.PLAIN,20));
		if((String) customerInformation.get(8)!=null){
			stateTextField.setText(((String) customerInformation.get(8)).trim());
		}
		stateTextField.setMaximumSize(new Dimension(500,25));
		statePanel.add(stateLabel);
		statePanel.add(Box.createHorizontalStrut(140));
		statePanel.add(stateTextField);
		
		
		
		zipPanel= new JPanel();
		zipPanel.setLayout(new BoxLayout(zipPanel, BoxLayout.X_AXIS));
		zipLabel = new JLabel("Zip code"); 
        zipLabel.setFont(new Font("Cambria",Font.PLAIN,20));
		zipTextField = new JTextField(20);
        zipTextField.setFont(new Font("Cambria",Font.PLAIN,20));
		if((String) customerInformation.get(7)!=null){
			zipTextField.setText(((String) customerInformation.get(7)).trim());
		}
		zipTextField.setMaximumSize(new Dimension(500,25));
		zipPanel.add(zipLabel);
		zipPanel.add(Box.createHorizontalStrut(120));
		zipPanel.add(zipTextField);
	
	
		countryPanel= new JPanel();
		countryPanel.setLayout(new BoxLayout(countryPanel, BoxLayout.X_AXIS));
		countryLabel = new JLabel("Country"); 
        countryLabel.setFont(new Font("Cambria",Font.PLAIN,20));
		countryTextField = new JTextField(20);
        countryTextField.setFont(new Font("Cambria",Font.PLAIN,20));
		if((String) customerInformation.get(9)!=null){
			countryTextField.setText(((String) customerInformation.get(9)).trim());
		}
		countryTextField.setMaximumSize(new Dimension(500,25));
		countryPanel.add(countryLabel);
		countryPanel.add(Box.createHorizontalStrut(120));
		countryPanel.add(countryTextField);
		
		passwordPanel= new JPanel();
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		passwordLabel = new JLabel("Set Password"); 
        passwordLabel.setFont(new Font("Cambria",Font.PLAIN,20));
		passwordTextField = new JPasswordField(20);
        passwordTextField.setFont(new Font("Cambria",Font.PLAIN,20));
		passwordTextField.setMaximumSize(new Dimension(500,25));
		passwordPanel.add(passwordLabel);
		passwordPanel.add(Box.createHorizontalStrut(90));
		passwordPanel.add(passwordTextField);
		
                
		rewritePasswordPanel= new JPanel();
		rewritePasswordPanel.setLayout(new BoxLayout(rewritePasswordPanel, BoxLayout.X_AXIS));
		rewritePasswordLabel = new JLabel("Re- Write Password"); 
        rewritePasswordLabel.setFont(new Font("cambria",Font.PLAIN,20));
		rewritePasswordTextField = new JPasswordField(20);
        rewritePasswordTextField.setFont(new Font("cambria",Font.PLAIN,20));
		rewritePasswordTextField.setMaximumSize(new Dimension(500,25));
		rewritePasswordPanel.add(rewritePasswordLabel);
		rewritePasswordPanel.add(Box.createHorizontalStrut(50));
		rewritePasswordPanel.add(rewritePasswordTextField);
		
		emergencyContactFirstPanel= new JPanel();
		emergencyContactFirstPanel.setLayout(new BoxLayout(emergencyContactFirstPanel, BoxLayout.X_AXIS));
		emergencyContactFirstLabel = new JLabel("Emergency Contact No 1"); 
        emergencyContactFirstLabel.setFont(new Font("cambria",Font.PLAIN,20));
		emergencyContactFirstTextField = new JTextField(20);
		if((String) customerInformation.get(11)!=null){
			emergencyContactFirstTextField.setText(((String) customerInformation.get(11)).trim());
		}
		
		emergencyContactFirstTextField.setMaximumSize(new Dimension(500,25));
        emergencyContactFirstTextField.setFont(new Font("cambria",Font.PLAIN,20));
		emergencyContactFirstPanel.add(emergencyContactFirstLabel);
		emergencyContactFirstPanel.add(Box.createHorizontalStrut(30));
		emergencyContactFirstPanel.add(emergencyContactFirstTextField);
		
		
		emergencyContactSecondPanel= new JPanel();
		emergencyContactSecondPanel.setLayout(new BoxLayout(emergencyContactSecondPanel, BoxLayout.X_AXIS));
		emergencyContactSecondLabel = new JLabel("Emergency Contact No 2"); 
        emergencyContactSecondLabel.setFont(new Font("cambria",Font.PLAIN,20));
		emergencyContactSecondTextField = new JTextField(20);
        emergencyContactSecondTextField.setFont(new Font("cambria",Font.PLAIN,20));
		if((String) customerInformation.get(12)!=null){
			emergencyContactSecondTextField.setText(((String) customerInformation.get(12)).trim());
		}
		emergencyContactSecondTextField.setMaximumSize(new Dimension(500,25));
		emergencyContactSecondPanel.add(emergencyContactSecondLabel);
		emergencyContactSecondPanel.add(Box.createHorizontalStrut(30));
		emergencyContactSecondPanel.add(emergencyContactSecondTextField);
		
		
		buttonPanel= new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		confirm=new JButton("Update Information");
		ActionListener al= new confirmActionListener();
		confirm.addActionListener(al);
		buttonPanel.add(confirm);
		
		mainPanel.add(namePanel);
		mainPanel.add(phoneNumberPanel);
		mainPanel.add(emailPanel);
		mainPanel.add(cotractIdPanel);
		mainPanel.add(addressPanel);
		mainPanel.add(countryPanel);
		mainPanel.add(zipPanel);
		mainPanel.add(statePanel);
		mainPanel.add(emergencyContactFirstPanel);
		mainPanel.add(emergencyContactSecondPanel);
		mainPanel.add(passwordPanel);
		mainPanel.add(rewritePasswordPanel);
		mainPanel.add(buttonPanel);
		mainPanel.setVisible(true);
	}

	public JPanel getInfoForm(){
		return mainPanel;
	}
	
	class confirmActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==confirm){
				String name= nameTextField.getText();
				 String phoneNumber=phoneNumberTextField.getText();
				 String email=emailTextField.getText();
				 String contractID=contractIdTextField.getText();
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
				if(password.trim().length()==0 || rewritePassword.trim().length()==0){
					JOptionPane.showMessageDialog(null, "Password Flield can not be blank.Please enter valid password");
					flag=false;
				}
				
				if(phoneNumber.trim().length()!=10){
					JOptionPane.showMessageDialog(null, "Phone number Contact Number is Invalid. Contact Number should have exactly 10 numbers");
					flag=false;
				}
				if(flag){
					UpdatedInformationController update = new UpdatedInformationController();
					update.updateInformation(name,phoneNumber,email,contractID,(String) customerInformation.get(4),
						(String) customerInformation.get(5),address,zip,state,country,password,emergencyContactFirst,emergencyContactSecond);
					JOptionPane.showMessageDialog(null, "Information Updated sucessfully!!");
					mainPanel.setVisible(false);
				}
		}
	
	
	}
}
	
	
	
	
	
	
	
	

	}

