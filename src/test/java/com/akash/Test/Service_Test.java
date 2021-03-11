package com.akash.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.akash.DAO.Contact_DAO;
import com.akash.Modal.EDapp;
import com.akash.Model.Contact_Entity;
import com.akash.Service.Contact_Service_Impl;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class Service_Test {

	private static Contact_Service_Impl service = null;
	
	@BeforeAll
	public static void init() {

		// proxy object
		Contact_DAO ProxyDao = EasyMock.createMock(Contact_DAO.class);

		// proxy object behavior for contactService_Test1
		EasyMock.expect(ProxyDao.findContactNameById(101)).andReturn("Akash");

		// proxy object behavior for contactService_Test2
		List<String> names = new ArrayList<String>();
		names.add("Akash");
		names.add("sky");
		names.add("Eren");
		EasyMock.expect(ProxyDao.findAllContactNames()).andReturn(names);
		
		// proxy object behavior for contactModel_Test1
		Contact_Entity c = new Contact_Entity();
		c.setID(201);
		c.setName("Akash");
		c.setNumber(9004700782l);
		EasyMock.expect(ProxyDao.findByID(201)).andReturn(c);
		
		// save behavior
		EasyMock.replay(ProxyDao);

		// inject mock object
		service = new Contact_Service_Impl();
		service.setContactDao(ProxyDao);
	}

	@Test
	@Ignore
	public void contactService_Test1() {

		String contactNameByID = service.getContactNameByID(101);
		String encryptText = EDapp.encryptText(contactNameByID);
		System.out.println("Result of contactService_Test1 : "+ encryptText);
		assertNotNull(contactNameByID);
	}
	
	@Test
	@Ignore
	public void contactService_Test2() {
		
		List<String> allContactNames = service.getAllContactNames();
		System.out.println("Result of contactService_Test2 : "+ allContactNames);
		assertNotNull(allContactNames);
	}
	
	@Test
	public void contactModel_Test1() {
		
		Contact_Entity byID = service.getByID(201);
		System.out.println("Result of contactModel_Test1 : "+byID.getID()+" "+byID.getName()+" "+byID.getNumber());
		assertNotNull(byID);
	}

}
