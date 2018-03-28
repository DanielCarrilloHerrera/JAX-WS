package com.journaldev.jaxws.service;

import com.journaldev.jaxws.beans.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;

@WebService(endpointInterface = "com.journaldev.jaxws.service.PersonService")
public class PersonServiceImpl {

	private static Map<Integer,Person> persons = new HashMap<Integer, Person>();
	
	public boolean addPerson(Person p) {
		// TODO Auto-generated method stub
		if(persons.get(p.getId()) != null)
			return false;
		
		persons.put(p.getId(), p);
		return true;
	}

	public boolean deletePerson(int id) {
		// TODO Auto-generated method stub
		if(persons.get(id) == null)
			return false;
		
		persons.remove(id);
		return true;
	}

	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return persons.get(id);
	}

	public Person[] getAllPersons() {
		// TODO Auto-generated method stub
		Set<Integer> ids = persons.keySet();
		Person[] p = new Person[ids.size()];
		int i = 0;
		for(Integer id : ids) {
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}

}
