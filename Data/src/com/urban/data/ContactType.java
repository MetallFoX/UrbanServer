package com.urban.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface ContactType {
	
	public Integer getId();
	
	public String getName();
	
	public Set<Contact> getContact();
	
	
	public enum Type {
	    PHONE(1, "Телефон"), EMAIL(2, "e-mail"), WEB(3, "Сайт"), SKYPE(4, "Skype");

	    private static Map<Long, Type> searchMap = new HashMap<Long, Type>();

	    static{
	        //FIXME: id duplicated here and in initializer
	        searchMap.put(1L, PHONE);
	        searchMap.put(2L, EMAIL);
	        searchMap.put(3L, WEB);
	        searchMap.put(4L, SKYPE);
	    }
	    private String contactName;

	    public String getContactName() {
	        return contactName;
	    }

	    Type(long id, String name){
	        this.contactName = name;
	        //searchMap.put(id, this); compilation error!
	    }

	    public static Type getTypeById(long id){
	        return searchMap.get(id);
	    }
	}

}
