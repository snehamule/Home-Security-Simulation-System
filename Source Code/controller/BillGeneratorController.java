package controller;

import java.text.ParseException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.DataBaseConnection;

public class BillGeneratorController {
	private String userName;
	private String month;
	DataBaseConnection db = new DataBaseConnection();
	
	//Default Constructor
	BillGeneratorController(){
		
	}
	
	/**
	 * Parameterized Constructor
	 * @param userName
	 * @param month
	 */
	public BillGeneratorController(String  userName, String month){
		this.userName=userName;
		this.month=month;
	}
	
	
	/**
	 * This method retrieve user Information and perform calculation to generate bill.
	 * @return billInformation
	 * @throws ParseException
	 */
	public List fetchCustomerInformation() throws ParseException {
		List<String>billInformation=new ArrayList<>();
		List<String> customerInformation=Arrays.asList(db.getUserInformation(userName).toString().split(","));
		List<String>sensorInformation=Arrays.asList(db.getFireSensorInformation(userName).toString().split(","));
		List<String>motionSensorInformation=Arrays.asList(db.getMotionSensorInformation(userName).toString().split(","));
		List<String> simulationFireInformation=Arrays.asList(db.getSimulationInformation(userName).toString().split(","));
		List<String> simulationMotionInformation=Arrays.asList(db.MotionSimulationDateData(userName).toString().split(","));
		String contractStartDate=customerInformation.get(5);
		String billMonth=getMonth(contractStartDate);
             
		int fireInstalltioncharges=240;
		int motionCharges=200;
		int fireCounter=simulationFireInformation.size();
		int motionCounter=simulationMotionInformation.size();
		if(customerInformation!=null){
			billInformation.add(customerInformation.get(0));
			billInformation.add(customerInformation.get(1));
			String address=customerInformation.get(6)+" "+customerInformation.get(7)+" "+customerInformation.get(8)+" "+customerInformation.get(9);
			billInformation.add(address);
			billInformation.add(customerInformation.get(2));
			billInformation.add(customerInformation.get(11));
			billInformation.add(customerInformation.get(12));
			billInformation.add(billMonth);
			billInformation.add(fireCounter*50+"");
			billInformation.add(fireCounter*20+"");
		}
		int total=0;
		total=(fireCounter)*50+(fireCounter*20);
		if(billMonth.trim().equals(month.trim())){
			int fireSensorQuantity=0;
			int motionSensorQuantity=0;
			if(sensorInformation!=null){
				fireSensorQuantity=Integer.parseInt(sensorInformation.get(1).trim());
			}
			if(motionSensorInformation!=null){
				motionSensorQuantity=Integer.parseInt(motionSensorInformation.get(1).trim());
			}
			billInformation.add(fireInstalltioncharges+"");
			billInformation.add(motionCharges+"");
			billInformation.add(fireSensorQuantity*100+"");
			billInformation.add(motionSensorQuantity*50+"");
			total=fireInstalltioncharges+motionCharges+fireSensorQuantity*100+motionSensorQuantity*50;
			if(fireCounter*50!=0){
				total=total+fireCounter*50;
			}
			if(motionCounter*20!=0){
				total=total+motionCounter*20;
			}
			billInformation.add(total+"");
			}else{
				billInformation.add(total+"");
			}
		return billInformation;
 }
	
	
		
/**
 * This method take date input and return month in string format. 
 * @param date
 * @return month
 */
public String getMonth(String date){
	String month="";
	String dateString=date.split("-")[0];
    dateString=dateString.trim();
	switch(dateString){
        case "01":month = "January";
            	  break;
        case "02":month = "February";
            	  break;
        case "03":month = "March";
            	  break;
        case "04":month = "April";
            	  break;
        case "05":month = "May";
            	  break;
        case "06":month = "June";
            	  break;	
        case "07":month = "July";
            	  break;
        case "08":month = "August";
            	  break;
        case "09":month = "September";
            	  break;
        case "10":month = "October";
            	  break;
        case "11":month = "November";
            	  break;
        case "12":month = "December";
            	  break;
        default:month = "Invalid month";
            	break;
    } 
 return month;
	
}
	

}
