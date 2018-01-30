package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.DataBaseConnection;


public class MotionSensorController {
	private String contractId;
	private String MotionSensorQuantiy;
	private String fromTime;
	private String toTime;
	private String area;
	DataBaseConnection db= new DataBaseConnection();
	
	
	/**
	 * Parameterized Constructor
	 * @param contractId
	 * @param MotionSensorQuantiy
	 * @param fromTime
	 * @param toTime
	 * @param area
	 * @throws IOException
	 */
	public MotionSensorController(String contractId,String MotionSensorQuantiy,String fromTime,String toTime,String area) throws IOException{
		this.contractId=contractId;
		this.MotionSensorQuantiy = MotionSensorQuantiy;
		this.fromTime=fromTime;
		this.toTime=toTime;
		this.area=area;
		saveMotionInformationInDatabase();
	}
	

	/**
	 * This method save Motion sensor data.
	 * @throws IOException
	 */
	public void saveMotionInformationInDatabase() throws IOException{
		List saveData= new ArrayList<>();
		saveData.add(contractId.trim());
		saveData.add(MotionSensorQuantiy.trim());
		saveData.add(fromTime.trim());
		saveData.add(toTime.trim());
		saveData.add(area.trim());
		if(saveData.size()>0){
			db.saveMotionSensorDataInDatabase(saveData.toString().substring(1,saveData.toString().length()-1)+ "\n");
		}
	}	
}
