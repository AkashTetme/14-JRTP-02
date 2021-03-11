package com.akash.Service;

import java.util.List;

import com.akash.Model.Contact_Entity;

public interface Contact_Service {

	public String getContactNameByID(Integer ID);

	public List<String> getAllContactNames();
	
	public Contact_Entity getByID(Integer ID);
}
