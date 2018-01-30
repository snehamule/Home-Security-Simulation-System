
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.DataBaseConnection;

public class FireSensorController {
	private String contractId;
	private String fireSensorQuantiy;
	private String fromTime;
	private String toTime;
	private String area;
	DataBaseConnection db= new DataBaseConnection();
	
	/**
	 * 
	 * @param contractId
	 * @param fireSensorQuantiy
	 * @param fromTime
	 * @param toTime
	 * @param area
	 * @throws IOException
	 */
	public FireSensorController(String contractId,String fireSensorQuantiy,String fromTime,String toTime,String area) throws IOException{
		this.contractId=contractId;
		this.fireSensorQuantiy=fireSensorQuantiy;
		this.fromTime=fromTime;
		this.toTime=toTime;
		this.area=area;
		saveFireSensorInformationInDatabase();
	}
	

	/**
	 * This method save Fire Sensor data.
	 * @throws IOException
	 */
	public void saveFireSensorInformationInDatabase() throws IOException{
		List saveData= new ArrayList<>();
		saveData.add(contractId.trim());
		saveData.add(fireSensorQuantiy.trim());
		saveData.add(fromTime.trim());
		saveData.add(toTime.trim());
		saveData.add(area.trim());
		if(saveData.size()>0){
			db.saveFireSensorDataInDatabase(saveData.toString().substring(1,saveData.toString().length()-1)+ "\n");
		}
	}	
}
