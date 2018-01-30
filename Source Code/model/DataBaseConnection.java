package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class DataBaseConnection {
	
	
	/**
	 * This method save customer Information in customerInformation.txt file.
	 * @param customerData
	 * @throws IOException
	 */
	public void saveCustomerInformation(String customerData) throws IOException {
		BufferedWriter writer= new BufferedWriter(new FileWriter("customerInformation.txt",true));
		try {
			writer.write(customerData.toString());
            writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			writer.close();
		}
	}
	
	
	
	/**
	 * This method update a customer Information in updateCustomerInformation file.
	 * @param customerData
	 * @param name
	 * @throws IOException
	 */
	public void updateCustomerInformation(String customerData,String name) throws IOException {
		BufferedReader reader=null;
		BufferedWriter out=null;
		List<String> dataFromFile = new ArrayList();
		try{
			reader=new BufferedReader(new FileReader("customerInformation.txt"));
			String line = null;
			while ((line=reader.readLine()) != null ) {
				String[] args = line.split(",");
				if(!args[0].equalsIgnoreCase(name)){
					dataFromFile.add(line);
				}
			}
			reader.close();
	        out = new BufferedWriter(new FileWriter("customerInformation.txt"));
	        for (String data : dataFromFile) {
	            out.write(data );
	            out.newLine();
	        }
	        out.write(customerData);
	    } catch (Exception e){
	    	e.printStackTrace();
	    
		}finally{
			out.flush();
	        out.close();
		}
	}
	
	
	

	/**
	 * This method validate username and password. 
	 * If userName and password are valid then set flag to true else set flag to false.
	 * @param userName
	 * @param password
	 * @return flag
	 */
	public boolean validateUserNamePassword(String userName, String password) {
		BufferedReader reader = null;
		boolean flag=false;
		try{
			reader=new BufferedReader(new FileReader("customerInformation.txt"));
			String line = null;
			while ((line=reader.readLine()) != null ) {
				String[] dataFromFile=line.split(",");
				if(userName.trim().equals(dataFromFile[0])){
					if(password.trim().equals(dataFromFile[10].trim())){
						flag=true;
						return flag;
					}else{
						flag=false;
						return flag;
					}
				}
				
			}
			
	   }catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	
	
	
	/**
	 * This method will retrieve user information
	 * @param userName
	 * @return
	 */
	public List getUserInformation(String userName) {
		BufferedReader reader = null;
		List<String> customerInfo= new ArrayList<>();
		try{
			reader=new BufferedReader(new FileReader("customerInformation.txt"));
			String line = null;
			while ((line=reader.readLine()) != null ) {
				String[] dataFromFile=line.split(",");
				if(userName.equals(dataFromFile[0])){
					customerInfo.add(line); 
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return customerInfo;
	}
	
	
	/**
	 * This method retrieve a sensor information.
	 * @param userName
	 * @return
	 */
	public List getFireSensorInformation(String userName) {
		BufferedReader reader = null;
		List<String> fireInformation= new ArrayList<>();
		try{
			reader=new BufferedReader(new FileReader("sensorInformation.txt"));
			String line = null;
			while ((line=reader.readLine()) != null ) {
				String[] dataFromFile=line.split(",");
				if(userName.trim().equals(dataFromFile[0].trim())){
					fireInformation.add(line);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fireInformation;
		
	}


	/**
	 * This method retrive a simulation information.
	 * @param contractId
	 * @return
	 */
	public List getSimulationInformation(String contractId) {
		BufferedReader reader = null;
		List<String> simulationInformation= new ArrayList<>();
		try{
			reader=new BufferedReader(new FileReader("simulationInformation.txt"));
			String line = null;
			while ((line=reader.readLine()) != null ) {
				String[] dataFromFile=line.split(",");
				if(contractId.trim().equals(dataFromFile[0].trim())){
					simulationInformation.add(dataFromFile[1]);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return simulationInformation;
	}

	

	/**
	 * This method save simulation information in  simulationInformation.txt.
	 * @param simulation
	 * @throws IOException
	 */
	public void saveSimulationDataInDatabase(String simulation) throws IOException {
		BufferedWriter writer= new BufferedWriter(new FileWriter("simulationInformation.txt",true));
		try {
			writer.write(simulation.toString());
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			writer.close();
		}
	}


	/**
	 * This method save Fire sensor infomation in sensorInformation.txt
	 * @param sensor
	 * @throws IOException
	 */
	public void saveFireSensorDataInDatabase(String sensor) throws IOException {
		BufferedWriter writer= new BufferedWriter(new FileWriter("sensorInformation.txt",true));
		try {
			writer.write(sensor.toString()+ "\n");
            writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			writer.close();
		}
	}


	/**
	 * This method will retrive data for fire simulation.
	 * @param userName
	 * @return
	 */
	public List getSimulationFireData(String userName) {
			BufferedReader reader = null;
			List<String> fireSimulation= new ArrayList<>();
			try{
				reader=new BufferedReader(new FileReader("customerInformation.txt"));
				String line = null;
				while ((line=reader.readLine()) != null ) {
					String[] dataFromFile=line.split(",");
					if(userName.trim().equals(dataFromFile[0].trim())){
						fireSimulation.add(dataFromFile[10]);
						fireSimulation.add(dataFromFile[11]);
						fireSimulation.add(dataFromFile[12]);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return fireSimulation;
		}
		
		

/**
 * This method retrieve data of motion sensor simulation.
 * @param userName
 * @return motionSimulation
 */
public List MotionSimulationDateData(String userName) {
	BufferedReader reader = null;
	List<String> motionSimulation= new ArrayList<>();
	try{
		reader=new BufferedReader(new FileReader("simulationMotionInformations.txt"));
		String line = null;
		while ((line=reader.readLine()) != null ) {
			String[] dataFromFile=line.split(",");
			if(userName.trim().equals(dataFromFile[0].trim())){
				motionSimulation.add(dataFromFile[1]);
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return motionSimulation;
}



/**
 * This method save motion sensor data in saveMotionSensorInformation.txt file.
 * @param sensor
 * @throws IOException
 */
public void saveMotionSensorDataInDatabase(String sensor) throws IOException {
	BufferedWriter writer= new BufferedWriter(new FileWriter("saveMotionSensorInformation.txt",true));
	try {
		writer.write(sensor.toString());
		writer.newLine();
		writer.newLine();
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
		writer.close();
	}
}



/**
 * This Method Retrive Motion Sensor Information.
 * @param userName
 * @return
 */
public List getMotionSensorInformation(String userName) {
	BufferedReader reader = null;
	List<String> motionSensorInfo= new ArrayList<>();
	try{
		reader=new BufferedReader(new FileReader("saveMotionSensorInformation.txt"));
		String line = null;
		while ((line=reader.readLine()) != null ) {
			String[] dataFromFile=line.split(",");
			if(userName.trim().equals(dataFromFile[0].trim())){
				motionSensorInfo.add(line);
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return motionSensorInfo;
	
}


/**
 * This method Retrive area of fire sensor where fire sensor installed.
 * @param userName
 * @return
 */
public List getFireArea(String userName) {
	BufferedReader reader = null;
	List<String> customerInfo= new ArrayList<>();
	try{
		reader=new BufferedReader(new FileReader("sensorInformation.txt"));
		String line = null;
		while ((line=reader.readLine()) != null ) {
			String[] dataFromFile=line.split(",");
			if(userName.equals(dataFromFile[0])){
				customerInfo.add(dataFromFile[4]);  
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return customerInfo;
}


/**
 * This method Retrive area of Motion sensor where fire sensor installed.
 * @param userName
 * @return
 */
public List getMotionArea(String userName) {
	BufferedReader reader = null;
	List<String> customerInfo= new ArrayList<>();
	try{
		reader=new BufferedReader(new FileReader("saveMotionSensorInformation.txt"));
		String line = null;
		while ((line=reader.readLine()) != null ) {
			String[] dataFromFile=line.split(",");
			if(userName.equals(dataFromFile[0])){
				customerInfo.add(dataFromFile[4]);  
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return customerInfo;
}


/**
 * this method save  fire sensor simulation data in databse.
 * @param string
 */
public void saveFireSimulationDataInDatabase(String fire)  throws IOException{
		BufferedWriter writer= new BufferedWriter(new FileWriter("simulationInformation.txt",true));
		try {
			writer.write(fire.toString());
			writer.newLine();
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			writer.close();
		}
		
	}


/**
 * This method save motion sensor simulation data in database.
 * @param string
 * @throws IOException 
 */
public void saveMotionSimulationDataInDatabase(String motion) throws IOException {
	BufferedWriter writer= new BufferedWriter(new FileWriter("simulationMotionInformations.txt",true));
	try {
		writer.write(motion.toString());
		writer.newLine();
		writer.newLine();
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
		writer.close();
	}
}

}


	



