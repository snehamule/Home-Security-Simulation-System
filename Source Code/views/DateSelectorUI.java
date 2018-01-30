package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class DateSelectorUI 
{
		private String day = "";
		private JDialog dialog;
        private int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        private int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        private JLabel dateLabel ;        
        JButton[] dateButtonArray ;
        
      
        public DateSelectorUI(JFrame mainJFrame) 
        {
        	dialog = new JDialog();
            dialog.setModal(true);
        	dateLabel= new JLabel("", JLabel.CENTER);
        	dateButtonArray=new JButton[60];
            String[] days = { "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" };
            JPanel datePanel = new JPanel(new GridLayout(7, 7));
            datePanel.setPreferredSize(new Dimension(450, 140));
                for (int x = 0; x < dateButtonArray.length; x++) 
                {		
	        		final int selection = x;
	                dateButtonArray[x] = new JButton();
	                dateButtonArray[x].setFocusPainted(false);
	                if (x > 6)
	                	dateButtonArray[x].addActionListener(new ActionListener(){
	                    public void actionPerformed(ActionEvent ae) {
	                        day = dateButtonArray[selection].getActionCommand();
	                        dialog.dispose();
	                     }
	                });
	                if (x < 7){
	                     dateButtonArray[x].setText(days[x]);
	                     dateButtonArray[x].setForeground(Color.red);
	                }
	               datePanel.add(dateButtonArray[x]);
                }
                JPanel previousPanel = new JPanel(new GridLayout(1, 3));
                JButton previousButton = new JButton("<< Previous");
                previousButton.addActionListener(new ActionListener() 
                {
                   public void actionPerformed(ActionEvent ae){
                       month--;
                       showDate();
                   }
                });
                previousPanel.add(previousButton);
                previousPanel.add(dateLabel);
                JButton nextButton = new JButton("Next >>");
                nextButton.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e){
                         month++;
                        showDate();
                    }
                });
                previousPanel.add(nextButton);
                dialog.add(datePanel, BorderLayout.CENTER);
                dialog.add(previousPanel, BorderLayout.SOUTH);
                showDate();
                dialog.pack();
                dialog.setLocationRelativeTo(mainJFrame);
                dialog.setVisible(true);
        }
 
        public String convertSelectedDate()
        {
        	if (day.equals(""))
        		return day;
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.set(year, month, Integer.parseInt(day));
            return sdf.format(cal.getTime());
        }
        
        /**
         * This method will display selected date in text format.
         */
        public void showDate() 
        {
        	java.util.Calendar cal= null;
        	java.text.SimpleDateFormat  sdf= null;
        	for (int x = 7; x < dateButtonArray.length; x++){
        		dateButtonArray[x].setText("");
      	        sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");	
                cal = java.util.Calendar.getInstance();			
        	}
        	cal.set(year, month, 1); 
        	int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        	int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        	for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
        	dateButtonArray[x].setText("" + day);
        	dateLabel.setText(sdf.format(cal.getTime()));
        	dialog.setTitle("Select Contract Start Date");
        }
 
      
}
 

