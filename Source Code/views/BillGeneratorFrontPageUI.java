
	package views;

	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
	import javax.swing.BoxLayout;
	import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.BillGeneratorController;
import controller.MonthList;

import java.awt.BorderLayout;
	


	public class BillGeneratorFrontPageUI {
	    JPanel customerPanel;
	    JLabel contractIdLabel;
	    JTextField contractIDTextField;
	    JPanel confirmPanel;
	    JButton confirm;
	    JPanel billPanel;
	    JButton month;
	    private JComboBox<String> displayMonth;
	    
	 /**
	 *This method display GUI for bill generation. 
	 */
	public BillGeneratorFrontPageUI() {
	        customerPanel = new JPanel();
	        customerPanel.setLayout(new FlowLayout());
	        customerPanel.add(Box.createHorizontalStrut(50));
	        contractIdLabel = new JLabel("Enter a Contract ID");
	        contractIdLabel.setFont(new Font("cambria",Font.PLAIN,23));
	        contractIDTextField = new JTextField(20);
	        contractIDTextField.setMaximumSize(new Dimension(200, 25));
	        contractIDTextField.setFont(new Font("cambria",Font.PLAIN,23));
	        customerPanel.add(contractIdLabel);
	        customerPanel.add(Box.createHorizontalStrut(10));
	        customerPanel.add(contractIDTextField);
	        customerPanel.add(Box.createVerticalStrut(80));

	        displayMonth=new JComboBox<>();
            displayMonth.setFont(new Font("cambria",Font.PLAIN,20));
	        MonthList month=new MonthList();
	        List <String>monthList=new ArrayList();
	        monthList=month.getMonthList();
	        for(int i=0;i<monthList.size();i++){
	        	displayMonth.addItem(monthList.get(i));
	        }
	        customerPanel.add(displayMonth);
	        confirmPanel = new JPanel();
	        confirmPanel.setLayout(new FlowLayout());
	        confirm = new JButton("Confirm");
	        confirm.setFont(new Font("cambria",Font.PLAIN,23));
	        confirmPanel.add(confirm);
	        
	        billPanel = new JPanel();
	        billPanel.setLayout(new BorderLayout());
            billPanel.add(customerPanel,BorderLayout.NORTH);
	        billPanel.add(confirmPanel,BorderLayout.CENTER);
	        confirm.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent f) {
	            BillGeneratorController billGenerator= new BillGeneratorController(contractIDTextField.getText(), displayMonth.getSelectedItem().toString().trim());
	            billPanel.removeAll();
	            List customerInformation= new ArrayList<>();
                try {
                	customerInformation=billGenerator.fetchCustomerInformation();
				} catch (ParseException e) {
					e.printStackTrace();
				}
	            BillGeneratorTableUI billTable= new BillGeneratorTableUI(customerInformation);
	            billPanel.add(billTable.getBillPanel(),BorderLayout.NORTH);
	            billPanel.invalidate();
	            billPanel.validate();
	            }
	        });
	}
	 
	   public String getContractid(){
	       return contractIDTextField.getText();
	   }
	   
	   public String getMonth(){
	       return displayMonth.getSelectedItem().toString();
	   }
	   
	    public JPanel getValidateIDPass() {
	        return billPanel ;
	    }
	}
	
	

