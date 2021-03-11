package com.akash.DAO;

import java.util.List;

import com.akash.Model.Contact_Entity;

public interface Contact_DAO {

	public String findContactNameById(Integer ID);
	
	public List<String> findAllContactNames();
	
	public Contact_Entity findByID(Integer ID);
}
