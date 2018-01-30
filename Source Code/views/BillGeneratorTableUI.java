
package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class BillGeneratorTableUI {
    private JPanel billPanel;
   
    public BillGeneratorTableUI(List customerInformation) {
        customerInformation = Arrays.asList(customerInformation.toString().split(","));
        billPanel = new JPanel();
        billPanel.setLayout(new BorderLayout());
        if (customerInformation.size() == 10) {
            String id = customerInformation.get(0).toString().replace('[', Character.MIN_VALUE);
            String cost = customerInformation.get(9).toString().replace(']', Character.MIN_VALUE); 
            String data[][] = {{"Service Contract ID", id}, {"Name", customerInformation.get(1).toString()}, {"Address", customerInformation.get(2).toString()}, {"Customer phone no.", customerInformation.get(3).toString()}, {"Emergency Contact number 1", customerInformation.get(4).toString()}, {"Emergency Contact no. 2", customerInformation.get(5).toString()}, {"Contract Start Month", customerInformation.get(6).toString()}, {"Calling charges for fire", customerInformation.get(7).toString()}, {"Callling charges for intrusion", customerInformation.get(8).toString()}, {"Fire sensor installation", "0"}, {"Motion sensor installation", "0"}, {"Fire sensor charges", "0"}, {"Motion sensor charge", "0"}, {"Total Charges", cost}};
            String column[] = {"", ""};
            JTable table = new JTable(data, column);
            table.setSize(100, 150);
            table.setRowHeight(30);
            table.getTableHeader().setFont(new Font("Cambira", Font.BOLD, 25));
            table.setFont(new Font("Cambria", Font.PLAIN, 25));
            JScrollPane sp = new JScrollPane(table);
            billPanel.add(sp, BorderLayout.PAGE_START);
        }
        if (customerInformation.size() == 14) {
            String id = customerInformation.get(0).toString().replace('[', Character.MIN_VALUE);
            String cost = customerInformation.get(13).toString().replace(']', Character.MIN_VALUE); 
            String data[][] = {{"Service Contract ID", id}, {"Name", customerInformation.get(1).toString()}, {"Address", customerInformation.get(2).toString()}, {"Customer phone no.", customerInformation.get(3).toString()}, {"Emergency Contact number 1", customerInformation.get(4).toString()}, {"Emergency Contact no. 2", customerInformation.get(5).toString()}, {"Contract start Month", customerInformation.get(6).toString()}, {"Calling charges for fire", customerInformation.get(7).toString()}, {"Callling charges for intrusion", customerInformation.get(8).toString()}, {"Fire sensor installation", customerInformation.get(9).toString()}, {"Motion sensor installation", customerInformation.get(10).toString()}, {"Fire sensor charges", customerInformation.get(11).toString()}, {"Motion sensor charge", customerInformation.get(12).toString()}, {"Total Charges", cost}};
            String column[] = {"", ""};
            JTable table = new JTable(data, column);
            table.setSize(100, 150);
            table.setRowHeight(30);
            table.getTableHeader().setFont(new Font("Cambira", Font.BOLD, 25));
            table.setFont(new Font("Cambria", Font.PLAIN, 25));
            JScrollPane sp = new JScrollPane(table);
            billPanel.add(sp, BorderLayout.PAGE_START);
        }
    }

    public JPanel getBillPanel() {
        return billPanel;
    }

}
