package com.urban.data;

import java.util.HashMap;
import java.util.Map;

public interface ContactType {
	
	public Integer getId();
	
	public String getName();
	
    public Type getType();
	
	
	public enum Type {
	    PHONE(1, "Телефон"), EMAIL(2, "e-mail"), WEB(3, "Сайт"), SKYPE(4, "Skype"),
        VK(5, "Вконтакте"), FACEBOOK(6, "Facebook"), OK(7, "Одноклассники");

	    private static Map<Long, Type> searchMap = new HashMap<Long, Type>();

	    static{
	        //FIXME: id duplicated here and in initializer
	        searchMap.put(1L, PHONE);
	        searchMap.put(2L, EMAIL);
	        searchMap.put(3L, WEB);
	        searchMap.put(4L, SKYPE);
            searchMap.put(5L, VK);
            searchMap.put(6L, FACEBOOK);
            searchMap.put(7L, OK);
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
