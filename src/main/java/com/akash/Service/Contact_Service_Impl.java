package com.akash.Service;

import java.util.List;

import com.akash.DAO.Contact_DAO;
import com.akash.Model.Contact_Entity;

public class Contact_Service_Impl implements Contact_Service{

	public Contact_DAO contactDao;
	
	public void setContactDao(Contact_DAO contactDao) {
		this.contactDao = contactDao;
	}

	public String getContactNameByID(Integer ID) {
		
		String ContactNameById = contactDao.findContactNameById(ID);
		
		String LogicAppliedName = ContactNameById.toUpperCase();
		
		return LogicAppliedName;
	}

	public List<String> getAllContactNames() {
		
		List<String> AllContactNames = contactDao.findAllContactNames();
		
		return AllContactNames;
	}

	public Contact_Entity getByID(Integer ID) {
		Contact_Entity findByID = contactDao.findByID(ID);
		return findByID;
	}

}
