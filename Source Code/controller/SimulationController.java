package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.DataBaseConnection;

public class SimulationController {
	private String contractId;
	private String sensorType;
	DataBaseConnection db= new DataBaseConnection();
	
	/**
	 * Parameterized Constructor
	 * @param contractId
	 */
	public SimulationController(String contractId){
		this.contractId=contractId;
	}
	
	/**
	 * Parameterized Constructor
	 * @param contractId
	 * @param sensorType 
	 */
	
	public SimulationController(String contractId,String sensorType) throws IOException{
		this.contractId=contractId;
		this.sensorType=sensorType;
		saveSimulationDataInDatabase();
	}
	
	
	
	/**
	 * This method save simulation data.
	 * @throws IOException
	 */
	public void saveSimulationDataInDatabase() throws IOException{
		List simulationData= new ArrayList<>();
		simulationData.add(contractId.trim());
		simulationData.add(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()));
		simulationData.add(sensorType.trim());
		if(simulationData.size()>0){
			db.saveSimulationDataInDatabase(simulationData.toString());
		}
	}
	
	public List fetchSimulation(){
        List simulationList= new ArrayList<>();
        simulationList=db.getSimulationFireData(contractId);
        return simulationList;
     }
	
	public List fetchFireArea(){
        List fireArea= new ArrayList<>();
        fireArea=db.getFireArea(contractId);
        return fireArea;
    }

	public List fetchMotionArea() {
        List motionArea= new ArrayList<>();
        motionArea=db.getMotionArea(contractId);
        return motionArea;
	}

	
	public void saveFireSimulation(String user, String area) {
		List fireInformation= new ArrayList<>();
		fireInformation.add(user.trim());
		fireInformation.add(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()).trim());
		fireInformation.add(area.trim());
		if(fireInformation.size()>0){
			try {
				db.saveFireSimulationDataInDatabase(fireInformation.toString().substring(1,fireInformation.toString().length()-1)+ "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void saveMotionSimulation(String user, String area) {
		List fireInformation= new ArrayList<>();
		fireInformation.add(user.trim());
		fireInformation.add(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()).trim());
		fireInformation.add(area.trim());
		if(fireInformation.size()>0){
			try {
				db.saveMotionSimulationDataInDatabase(fireInformation.toString().substring(1,fireInformation.toString().length()-1)+ "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	  }
  }
	
