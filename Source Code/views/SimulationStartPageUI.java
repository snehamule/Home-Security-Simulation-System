package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.SimulationController;

import java.awt.FlowLayout;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import javax.swing.JOptionPane;


public class SimulationStartPageUI {
    private JPanel simulationPanel;
    private JButton confirm;
    private JButton confirmDeactivate;
    private JComboBox sensorType;
    private JComboBox motionType;
    private String user;
    private JComboBox area;
    private JCheckBox fireCheckBox;
    private JCheckBox motionCheckBox;
    private JLabel selectLocation;
    private JLabel selectLocationm;
    private JPanel fireComboBox;
    private JPanel motionComboBox;
    private JLabel fireAt;
    private JLabel motionAt;
    
    public SimulationStartPageUI(String user) {
        this.user=user;
        getStartSimulationpanel();
    }
   
    public SimulationStartPageUI() {
        
    }
   
    /** 
     * This method will display GUI for Simulation of  Fire and Motion Sensor. 
     * @return
     */
    public JPanel getStartSimulationpanel() {
        
        fireAt = new JLabel("");
        fireAt.setFont(new Font("cambria",Font.PLAIN,23));
        
        motionAt = new JLabel("");
        motionAt.setFont(new Font("cambria",Font.PLAIN,23));
        
        fireComboBox = new JPanel();
        motionComboBox = new JPanel();
        
        fireComboBox.setLayout(new FlowLayout());
        motionComboBox.setLayout(new FlowLayout());
        
        simulationPanel = new JPanel();
        simulationPanel.setLayout(new BoxLayout(simulationPanel, BoxLayout.Y_AXIS));
        simulationPanel.setPreferredSize(new Dimension(500,500));
        
        SimulationController sm= new SimulationController(user);
        List fireSensor=new ArrayList<>();
        fireSensor=sm.fetchFireArea();

        area= new JComboBox<>();
        fireCheckBox= new JCheckBox("Check the box to simulate fire sensors");
        fireCheckBox.setFont(new Font("Cambria",Font.PLAIN,24));
        fireCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        selectLocation = new JLabel("Select the sensor Location");
        selectLocation.setFont(new Font("cambria",Font.PLAIN,23));
        
        selectLocationm = new JLabel("Select the sensor Location");
        selectLocationm.setFont(new Font("cambria",Font.PLAIN,23));
        
        sensorType = new JComboBox();
        sensorType.setFont(new Font("cambria",Font.PLAIN,24));
        sensorType.setMaximumSize(new Dimension(200,30));
        sensorType.setAlignmentX(Component.CENTER_ALIGNMENT);
        for(int i=0;i<fireSensor.size();i++){
        	sensorType.addItem(fireSensor.get(i).toString().trim());
        }
        motionCheckBox=new JCheckBox("Check the box to simulate motion sensor");
        motionCheckBox.setFont(new Font("Cambria",Font.PLAIN,24));
        motionCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        List motionSensor=new ArrayList<>();
        motionSensor=sm.fetchMotionArea();
        
        motionType = new JComboBox();
        motionType.setFont(new Font("cambria",Font.PLAIN,24));
        motionType.setAlignmentX(Component.CENTER_ALIGNMENT);
        motionType.setMaximumSize(new Dimension(200,30));
        for(int i=0;i<motionSensor.size();i++){
        	motionType.addItem(motionSensor.get(i).toString().trim());
        }
        
        sensorType.setFont(new Font("Cambria", Font.PLAIN, 25));
        sensorType.setMaximumSize(new Dimension(200, 30));
        sensorType.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        simulationPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirm = new JButton("Confirm");
        confirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirm.setFont(new Font("Cambria", Font.PLAIN, 24));
        confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                Date d=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
                String currentDateTimeString = sdf.format(d).trim();
                String time1 = currentDateTimeString.substring(0, 2);
                String time2 = currentDateTimeString.substring(3,5);
                String amPm = currentDateTimeString.substring(6);
                Double currentHour = Double.parseDouble(time1);
                Double currentMinute = Double.parseDouble(time2);
                Double currentTime = 0.0;
                if(amPm.equals("PM")&&currentHour!=12.0)
                currentTime = (currentHour+12+currentMinute/60);
                else currentTime = (currentHour+currentMinute/60);
           
                int fireCounter =0;
                int motionCounter =0;
                String line1=null;
                     try {
                    	 FileReader fileReaderFire = new FileReader("sensorInformation.txt");
           BufferedReader bufferedReader
                    = new BufferedReader(fileReaderFire);
   
                     while ((line1 = bufferedReader.readLine()) != null) {
                         if (line1.startsWith(user) && line1.contains(sensorType.getSelectedItem().toString())) {
                           
                             String[] splitter = line1.split(",");
                             String stringFrom = splitter[2];
                             String[] stringFromhour = stringFrom.split(":");
                             Double timeFrom = Double.parseDouble(stringFromhour[0].trim())+Double.parseDouble(stringFromhour[1].trim())/60;
                          
                            String stringTo = splitter[3];
                            String[] stringTohour = stringTo.split(":");
                            Double timeTo = Double.parseDouble(stringTohour[0].trim())+Double.parseDouble(stringTohour[1].trim())/60;
                            if (currentTime>timeFrom && currentTime<timeTo) {
                                fireCounter =1;
                         }       
                }
            }
            bufferedReader.close();
        }
            
         catch (FileNotFoundException ex) {
            System.out.println("Unable to open file sensorInformation.txt");
        } catch (IOException ex) {
            System.out.println("Error reading file sensorInformation.txt");
        }
      String line2=null;
      try {
     
            FileReader fileReaderMotion = new FileReader("saveMotionSensorInformation.txt");
            BufferedReader bufferedReaderMotion = new BufferedReader(fileReaderMotion);
	         while ((line2 = bufferedReaderMotion.readLine()) != null) {
	             if (line2.startsWith(user) && line2.contains(motionType.getSelectedItem().toString())) {
	                 String[] splitterMotion = line2.split(",");
	                 String stringFromMotion = splitterMotion[2];
	                 String[] stringFromhourMotion = stringFromMotion.split(":");
	                 Integer timeFromMotion = Integer.parseInt(stringFromhourMotion[0].trim())+Integer.parseInt(stringFromhourMotion[1].trim())/60;
	                 
	                 String stringToMotion = splitterMotion[3];
	                 String[] stringTohourMotion = stringToMotion.split(":");
	                 Integer timeToMotion = Integer.parseInt(stringTohourMotion[0].trim())+Integer.parseInt(stringTohourMotion[1].trim())/60;
	                 if (currentTime>timeFromMotion && currentTime<timeToMotion) {
	                    motionCounter =1;
	                 }
	            }
	        }
            bufferedReaderMotion.close();
        }
         catch (FileNotFoundException ex) {
            System.out.println("Unable to open file saveMotionSensorInformation.txt ");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file saveMotionSensorInformation.txt");
        }
         
        
        
            if((fireCounter==1 && fireCheckBox.isSelected()) || (motionCounter==1 && motionCheckBox.isSelected())) {
                JPanel alarmPanel = new JPanel();
            alarmPanel.setLayout(new BoxLayout(alarmPanel,BoxLayout.Y_AXIS));            
            List customerInformation=new ArrayList<>();
            List fire=new ArrayList<>();
            List motion=new ArrayList<>();
            //SimulateValidationUI v = new SimulateValidationUI();
            List arr= new ArrayList();
            SimulationController simulate= new SimulationController(user);
        
            int fireStatus=0;
            int motionStatus=0;
            
            if(fireCheckBox.isSelected()&&fireCounter==1){
            	simulate.saveFireSimulation(user,sensorType.getSelectedItem().toString());
                    fireStatus=1;
            }
           
            
            if(motionCheckBox.isSelected()&&motionCounter==1){
            	simulate.saveMotionSimulation(user,motionType.getSelectedItem().toString());
                    motionStatus=1;
            }
          
		arr=simulate.fetchSimulation();
		for(int i=0;i<arr.size();i++){
			
		}
		String sensor=sensorType.getSelectedItem().toString();
		
			simulationPanel.remove(sensorType);
	

                            AlarmPanelUI alarm= new AlarmPanelUI(arr,user);
                            
                                    confirm.setVisible(false);
                                    simulationPanel.removeAll();
                                    if(fireStatus==1 && fireCounter==1){
                                    simulationPanel.add(alarm.getFirePanel());
                                    fireAt.setText("Triggered at Location: "+sensorType.getSelectedItem().toString());
                                    fireAt.setAlignmentX(Component.CENTER_ALIGNMENT);
                                    simulationPanel.add(fireAt);
                                    }
                                    if(motionStatus==1 && motionCounter==1){
                                    simulationPanel.add(alarm.getMotionPanel());
                                    motionAt.setText("Triggered at Location: "+motionType.getSelectedItem().toString());
                                    motionAt.setAlignmentX(Component.CENTER_ALIGNMENT);
                                    simulationPanel.add(motionAt);
                                    }
				simulationPanel.add(alarm.getAlarmtrigger());
				simulationPanel.invalidate();
				simulationPanel.validate();
				
            }
            
            else {
                JOptionPane.showMessageDialog(null, "Simulation time do not match. Try with different settings");
            }
		}
	});
   
      
        fireComboBox.add(selectLocation);
        fireComboBox.add(sensorType);
        motionComboBox.add(selectLocationm);
        motionComboBox.add(motionType);
        simulationPanel.add(fireCheckBox);
        simulationPanel.add(fireComboBox);
      
        simulationPanel.add(motionCheckBox);
        simulationPanel.add(motionComboBox);
     
        simulationPanel.add(Box.createVerticalStrut(20));
        simulationPanel.add(confirm);
   
        return simulationPanel;
    }
    
   int statusFire =0; 
   int statusMotion=0;
   
   
   public int getFireCheckBoxStatus() {
   
   if (fireCheckBox.isSelected()){
        statusFire = 1;
   }
   return statusFire;
   }
   
   
   public int getMotionCheckBoxStatus() {
   if (motionCheckBox.isSelected()){
        statusMotion = 1;
   }
   return statusMotion;
   }
   
   public String getfireLocation() {
       return sensorType.getSelectedItem().toString();
   }
   
   public String getMotionLocation() {
       return motionType.getSelectedItem().toString();
   }
    
}
