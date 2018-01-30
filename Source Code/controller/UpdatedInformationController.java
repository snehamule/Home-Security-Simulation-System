
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.DataBaseConnection;
import views.UpdatedInformationUI;


public class UpdatedInformationController {
	DataBaseConnection db= new DataBaseConnection();
	 public UpdatedInformationController(){
		 
	 }


	
	/**
	 * this Method verify username and password
	 * @param userName
	 * @param password
	 * @return isValid
	 */
	public boolean validatePassword(String userName, String password) {
		boolean isValid=db.validateUserNamePassword(userName.trim(),password.trim());
		return isValid;
	}

	
	
	/**
	 * This method retrive customer information
	 * @param userName
	 * @return
	 */
	public List fetchCustomerInformation(String userName) {
		List<String> customerInformation= new ArrayList<>();
		customerInformation=db.getUserInformation(userName);
		return customerInformation;
	}
	
	

	/**
	 * This method update a customer Information.
	 * @param name
	 * @param phoneNumber
	 * @param email
	 * @param contractID
	 * @param contractDuration
	 * @param contractStartDate
	 * @param address
	 * @param zip
	 * @param state
	 * @param country
	 * @param password
	 * @param emergencyContactFirst
	 * @param emergencyContactSecond
	 */
	public void updateInformation(String name, String phoneNumber, String email, String contractID, String contractDuration,
			String contractStartDate, String address, String zip, String state, String country, String password,
			String emergencyContactFirst, String emergencyContactSecond) {
		DataBaseConnection db= new DataBaseConnection();
		ArrayList list= new ArrayList();
		list.add(contractID);
		list.add(name);
		list.add(phoneNumber);
		list.add(email);
		list.add(contractDuration);
		list.add(contractStartDate);
		list.add(address);
		list.add(zip);
		list.add(state);
		list.add(country);
		list.add(password);
		list.add(emergencyContactFirst);
		list.add(emergencyContactSecond);
		try {
			db.updateCustomerInformation(list.toString().substring(1,list.toString().length()-1),contractID);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
