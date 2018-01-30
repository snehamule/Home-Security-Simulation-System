
package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MotionSensorController;
import controller.FireSensorController;


public class SensorConfigurationUI {
	private JPanel sensorConfigurationPanel;
    private JPanel subPanel;
    private JPanel subPanel2;
    private JPanel subPanel3;
    private JPanel subPanel4;
    private JPanel subPanel5;
    private JPanel subPanel6;
    private JPanel subPanel7;
    private JPanel subPanel8;
    private JPanel subPanel9;
    private JPanel subPanel10;
    private JPanel subPanel11;
    private JComboBox sensorType;
    private JTextField sensorID;
    private JTextField quantity;
    private JComboBox fromHours;
    private JComboBox fromMinutes;
    private JComboBox toHours;
    private JComboBox toMinutes;
    private JComboBox toTime;
    private JLabel sensorInfo;
    private JLabel sensorTime;
    private JLabel sensorTypeName;
    private JLabel sensorName;
    private JLabel sensorqty;
    private JLabel timeFrom;
    private JLabel timeTo;
    private JButton ok;
    private JLabel location;
    private JComboBox locationCombo;
    private String user;
 
    public SensorConfigurationUI(String user) {
    	this.user=user;
        getSensorConfigurator();
    }
    
    public JPanel getSensorConfigurator() {
        sensorConfigurationPanel= new JPanel();
        sensorConfigurationPanel.setLayout(new BoxLayout(sensorConfigurationPanel,BoxLayout.Y_AXIS));
        sensorConfigurationPanel.setSize(new Dimension(800,800));
        
        JLabel sensorInfo = new JLabel("Set Sensor Type");
        sensorInfo.setFont(new Font("Cambria", Font.PLAIN, 24));
        
        JLabel sensorTime = new JLabel("Set Sensor Time");
        sensorTime.setFont(new Font("Cambria", Font.PLAIN, 24)); 
        
        sensorTypeName= new JLabel("Sensor Type"); 
        sensorTypeName.setFont(new Font("Cambria", Font.PLAIN, 20));
        sensorTypeName.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel sensorTypeName = new JLabel("Sensor Type");
        sensorTypeName.setFont(new Font("Cambria", Font.PLAIN, 20));
        sensorTypeName.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel sensorName = new JLabel("Sensor location");
        sensorName.setFont(new Font("Cambria", Font.PLAIN, 20));
        sensorName.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel sensorqty= new JLabel("Sensor Qty");
        sensorqty.setFont(new Font("Cambria", Font.PLAIN, 20));
        
        JLabel timeFrom= new JLabel("Time From");
        timeFrom.setFont(new Font("Cambria", Font.PLAIN, 20));
        timeFrom.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel timeTo= new JLabel("Time To");
        timeTo.setFont(new Font("Cambria", Font.PLAIN, 20));
        //timeTo.setPreferredSize(new Dimension(20,));
        
        JButton ok = new JButton("ADD");
        ok.setFont(new Font("Cambria",Font.BOLD,20));
        ok.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        String[] sensorString = {"Fire", "Motion"};
        JComboBox sensorType = new JComboBox(sensorString);
        sensorType.setFont(new Font("Cambria", Font.PLAIN, 18));
        sensorType.setMaximumSize(new Dimension(100, 30));
        sensorType.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        locationCombo = new JComboBox<>();
        locationCombo.setFont(new Font("cambria",Font.PLAIN,20));
        locationCombo.setMaximumSize(new Dimension(200,30));
        locationCombo.addItem("kitchen");
        locationCombo.addItem("Bedroom");
        locationCombo.addItem("kitchen");
        locationCombo.addItem("Room One");
        locationCombo.addItem("Room Two");
        locationCombo.addItem("Room Three");
        locationCombo.addItem("Room Four");
        locationCombo.addItem("Room Five");
        locationCombo.addItem("Room Six");
        
        JTextField sensorID = new JTextField(5);
        sensorID.setMaximumSize(new Dimension(300, 30));
        sensorID.setFont(new Font("Cambria", Font.PLAIN, 23));
        
        JTextField quantity = new JTextField(5);
        quantity.setMaximumSize(new Dimension(300, 30));
        quantity.setFont(new Font("Cambria", Font.PLAIN, 23));
        
        String[] hourString = new String[25];
        hourString[0] = "Hours";
        for (int i = 1; i < 24; i++) {
            String intHour = Integer.toString(i);
            hourString[i] = intHour;
        }
        String[] minutesString = new String[5];
        minutesString[0] = "Minutes";
        for (int i = 1; i < 5; i++) {
            String intMinute = Integer.toString((i-1)*15);
            minutesString[i] = intMinute;
        }
        JComboBox fromHours = new JComboBox(hourString);
        fromHours.setFont(new Font("Cambria", Font.PLAIN, 20));
        fromHours.setMaximumSize(new Dimension(100, 25));
        fromHours.setAlignmentX(Component.LEFT_ALIGNMENT);
   
        
        JComboBox fromMinutes = new JComboBox(minutesString);
        fromMinutes.setFont(new Font("Cambria", Font.PLAIN, 20));
        fromMinutes.setMaximumSize(new Dimension(100, 25));
   
        
        JComboBox toHours = new JComboBox(hourString);
        toHours.setFont(new Font("Cambria", Font.PLAIN, 20));
        toHours.setMaximumSize(new Dimension(100, 25));
        toHours.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JComboBox toMinutes = new JComboBox(minutesString);
        toMinutes.setFont(new Font("Cambria", Font.PLAIN, 20));
        toMinutes.setMaximumSize(new Dimension(100, 25));
        
        subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.Y_AXIS));
        subPanel.add(sensorTypeName);
        subPanel.add(sensorType);
        
        
        subPanel2 = new JPanel();
        subPanel2.setLayout(new BoxLayout(subPanel2,BoxLayout.Y_AXIS));
        subPanel2.add(sensorName);
        subPanel2.add(locationCombo);
  
        subPanel3 = new JPanel();
        subPanel3.setLayout(new BoxLayout(subPanel3,BoxLayout.Y_AXIS));
        subPanel3.add(sensorqty);
        subPanel3.add(quantity);
        
        subPanel4 = new JPanel();
        subPanel4.setLayout(new FlowLayout());
        subPanel4.add(subPanel);
        subPanel4.add(Box.createHorizontalStrut(50));
        subPanel4.add(subPanel2);
        subPanel4.add(Box.createHorizontalStrut(50));
        subPanel4.add(subPanel3);
        
        subPanel5 = new JPanel();
        subPanel5.setLayout(new BoxLayout(subPanel5,BoxLayout.Y_AXIS));
        subPanel5.add(timeFrom);
        subPanel5.add(fromHours);
        
        subPanel6 = new JPanel();
        subPanel6.setLayout(new BoxLayout(subPanel6,BoxLayout.Y_AXIS));
        subPanel6.add(Box.createVerticalStrut(25));
        subPanel6.add(fromMinutes);
        
        subPanel7 = new JPanel();
        subPanel7.setLayout(new FlowLayout());
        subPanel7.add(subPanel5);
        subPanel7.add(subPanel6);
        
        subPanel8 = new JPanel();
        subPanel8.setLayout(new BoxLayout(subPanel8,BoxLayout.Y_AXIS));
        subPanel8.add(timeTo);
        subPanel8.add(toHours);
        
        subPanel9 = new JPanel();
        subPanel9.setLayout(new BoxLayout(subPanel9,BoxLayout.Y_AXIS));
        subPanel9.add(Box.createVerticalStrut(25));
        subPanel9.add(toMinutes);
       
        subPanel10 = new JPanel();
        subPanel10.setLayout(new FlowLayout());
        subPanel10.add(subPanel8);
        subPanel10.add(subPanel9);
        
        subPanel11 = new JPanel();
        subPanel11.setLayout(new FlowLayout());
        subPanel11.add(subPanel7);
        subPanel11.add(Box.createHorizontalStrut(50));
        subPanel11.add(subPanel10);
  
        sensorConfigurationPanel.add(subPanel4);
        sensorConfigurationPanel.add(subPanel11);
        sensorConfigurationPanel.add(ok);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SensorConfigrationValidationUI v = new SensorConfigrationValidationUI();
                String conid = v.getContractid();
                String from=fromHours.getSelectedItem().toString()+":"+fromMinutes.getSelectedItem().toString();
                String to=toHours.getSelectedItem().toString()+":"+toMinutes.getSelectedItem().toString();
                if(sensorType.getSelectedItem().toString().equals("Fire")){
                	try {
						FireSensorController savefireSensor= new FireSensorController(user, quantity.getText(),from,to,locationCombo.getSelectedItem().toString());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                }else{
                	try {
						MotionSensorController saveMotionSensor =new MotionSensorController(user, quantity.getText(),from,to,locationCombo.getSelectedItem().toString());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                }
            JOptionPane.showMessageDialog(null, "Sensor Information saved in database sucessfully");
		    sensorID.setText("");
		    quantity.setText("");
		    fromHours.setSelectedIndex(0);
		    fromMinutes.setSelectedIndex(0);
		    toHours.setSelectedIndex(0);
		    toMinutes.setSelectedIndex(0);
         }
    });
return sensorConfigurationPanel;
    }

}