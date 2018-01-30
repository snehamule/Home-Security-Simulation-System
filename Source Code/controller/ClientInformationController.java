
package controller;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import model.DataBaseConnection;


public class ClientInformationController implements Serializable {
	private String name;
	private String phoneNumber;
	private String email;
	private String contractID;
	private String contractDuration;
	private String contractStartDate;
	private String address;
	private String zip;
	private String state;
	private String country;
	private String password;
	private String emergencyContactFirst;
	private String emergencyContactSecond;

	
	/**
	 *Constructor. 
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
	public ClientInformationController(String name,String phoneNumber,String email,String contractID,String contractDuration,String contractStartDate,
					String address,String zip,String state,String country,String password,String emergencyContactFirst,String emergencyContactSecond){
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.email= email;
		this.contractID=contractID;
		this.contractDuration=contractDuration;
		this.contractStartDate= contractStartDate;
		this.address=address;
		this.zip=zip;
		this.state=state;
		this.country=country;
		this.password=password;
		this.emergencyContactFirst=emergencyContactFirst;
		this.emergencyContactSecond=emergencyContactSecond;
		saveInformationInDataBase();
	}
	
	
	
	/**
	 * This method add user information to the list. 
	 */
	public void saveInformationInDataBase(){
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
			db.saveCustomerInformation(list.toString().substring(1,list.toString().length()-1)+ "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
