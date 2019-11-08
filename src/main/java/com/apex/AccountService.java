package com.apex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountService {
	
	private static Map<String,Account> accounts=new HashMap<String,Account>();
	
	static{
		accounts.put("1",new Account("1","admin"));
		accounts.put("2",new Account("2","user"));
		accounts.put("3",new Account("3","rubys"));
		accounts.put("4",new Account("4","测试"));
	}
	
	public Account get(String id){
		return accounts.get(id);
	}
	
	public void insert(Account acc){
		if(acc.getId()==null||"".equals(acc.getId()))
			acc.setId(""+new Double(100* Math.random()).intValue());
		accounts.put(acc.getId(),acc);
	}
	
	public void remove(String id){
		accounts.remove(id);
	}
	
	public List<Account> findAll(){
		return new ArrayList<Account>(accounts.values());
	}

}
