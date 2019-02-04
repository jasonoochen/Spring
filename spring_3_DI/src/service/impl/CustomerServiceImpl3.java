package service.impl;

import java.util.Date;
import java.util.*;

import service.ICustomerService;

/*
 * 客户的业务层实现类
 */

public class CustomerServiceImpl3 implements ICustomerService {
	
	private String[] myStrs;
	private List<String> myList;
	private Set<String> mySet;
	private Map<String, String> myMap;
	private Properties myProps;
	
	public void setMyStrs(String[] myStrs) {
		this.myStrs = myStrs;
	}

	public void setMyList(List<String> myList) {
		this.myList = myList;
	}

	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}

	public void setMyMap(Map<String, String> myMap) {
		this.myMap = myMap;
	}

	public void setMyProps(Properties myProps) {
		this.myProps = myProps;
	}

	@Override
	public void saveCustomer() {
		System.out.println("业务层调用持久层");
		System.out.println(Arrays.toString(myStrs));
		System.out.println(myList);
		System.out.println(myMap);
		System.out.println(myProps);
//		customerDao.saveCustomer();
	}

}
