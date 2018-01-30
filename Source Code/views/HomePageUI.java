package views;

import java.awt.*;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import controller.BillGeneratorController;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

        

 
public class HomePageUI extends JFrame {
    private JPanel sidePanel;
    private JButton createNewUser;
    private JButton updateExistingUser;
    private JButton simulatation;
    private JButton sensorConfiguration;
    private JButton generateBill;
    private JPanel informationPanel;
    private  Container container;
    /**
     * Creates buttons in the main panel and sets the actions to be followed by these buttons
     * 
     */
    public HomePageUI() {
        container = getContentPane();
        container.setLayout(new FlowLayout());
        actionListenerImplementation  actionListener= new actionListenerImplementation();

        sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setPreferredSize(new Dimension(300, 700));
        sidePanel.setAlignmentX(CENTER_ALIGNMENT);

        informationPanel = new JPanel();
        informationPanel.setLayout(new BorderLayout());
        informationPanel.setPreferredSize(new Dimension(800, 500));

        createNewUser = new JButton("Create Client");
        createNewUser.setFont(new Font("Cambria", Font.BOLD, 23));
        createNewUser.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        createNewUser.setMaximumSize(new Dimension(400, 50));
        createNewUser.setPreferredSize(new Dimension(300, 30));
        createNewUser.addActionListener(actionListener);

        updateExistingUser = new JButton("Update Client");
        updateExistingUser.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        updateExistingUser.setMaximumSize(new Dimension(400, 50));
        updateExistingUser.setPreferredSize(new Dimension(300, 30));
        updateExistingUser.setFont(new Font("Cambria", Font.BOLD, 23));
        updateExistingUser.addActionListener(actionListener);

        simulatation = new JButton("Simulate");
        simulatation.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        simulatation.setMaximumSize(new Dimension(400, 50));
        simulatation.setPreferredSize(new Dimension(300, 30));
        simulatation.setFont(new Font("Cambria", Font.BOLD, 23));
        simulatation.addActionListener(actionListener);
        
        sensorConfiguration = new JButton("Sensor Configuration");
        sensorConfiguration.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        sensorConfiguration.setMaximumSize(new Dimension(400, 50));
        sensorConfiguration.setPreferredSize(new Dimension(300, 30));
        sensorConfiguration.setFont(new Font("Cambria", Font.BOLD, 23));
        sensorConfiguration.addActionListener(actionListener);
        
        generateBill = new JButton("Generate Bill");
        generateBill.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        generateBill.setMaximumSize(new Dimension(400, 50));
        generateBill.setPreferredSize(new Dimension(300, 30));
        generateBill.setFont(new Font("Cambria", Font.BOLD, 23));
        generateBill.addActionListener(actionListener);
        

        sidePanel.add(Box.createVerticalStrut(50));
        sidePanel.add(createNewUser);
        sidePanel.add(Box.createVerticalStrut(20));
        sidePanel.add(updateExistingUser);
        sidePanel.add(Box.createVerticalStrut(20));
        sidePanel.add(simulatation);
        sidePanel.add(Box.createVerticalStrut(20));
        sidePanel.add(sensorConfiguration);
        sidePanel.add(Box.createVerticalStrut(20));
        sidePanel.add(generateBill);
        sidePanel.setBackground(new Color(224, 224, 224));

        container.add(sidePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
   class actionListenerImplementation implements ActionListener{
       public void actionPerformed(ActionEvent e) {
    	   if(e.getSource()==createNewUser){
        		 for (int m = container.getComponentCount();m>1;m--) {
                     container.remove(m-1);
                  }
                 ClientInformationUI client = new ClientInformationUI();
                 container.add(client.getInfoForm());
                 pack();
                 setLocationRelativeTo(null);
                 setVisible(true);
         }else if(e.getSource()==updateExistingUser){
        	 for (int m = container.getComponentCount();m>1;m--) {
                 container.remove(m-1);
             }
             UpdatePanelVerificationUI update = new UpdatePanelVerificationUI();
             container.add(update.getUpdateFrontPage());
             container.invalidate();
             container.validate();
             pack();
             setLocationRelativeTo(null);
             setVisible(true);
        }else if(e.getSource()==simulatation){
        	 for (int m = container.getComponentCount();m>1;m--) {
                 container.remove(m-1);
             }
            SimulateValidationUI simulate = new SimulateValidationUI();
            container.add(simulate.getValidateSimulation());
            pack();
            setLocationRelativeTo(null);
    		
    	}else if(e.getSource()==sensorConfiguration){
    		  for (int m = container.getComponentCount();m>1;m--) {
                  container.remove(m-1);
              }
              SensorConfigrationValidationUI sensor = new SensorConfigrationValidationUI();
              container.add(sensor.getSensorConfigurationPanel());
              container.invalidate();
              container.validate();
              pack();
              setLocationRelativeTo(null);
              setVisible(true);
   
    	}else{
    		if(e.getSource()==generateBill){
    			for (int m = container.getComponentCount();m>1;m--) {
                    container.remove(m-1);
                }
                BillGeneratorFrontPageUI bill = new BillGeneratorFrontPageUI();
                container.add(bill.getValidateIDPass());
                container.invalidate();
                container.validate();
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
    		
    		}    
    
    	}
 
       }
   } 
    public static void createAndShowGUI() {
        HomePageUI homePage = new HomePageUI();
        homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
