package com.journaldev.jaxws.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.journaldev.jaxws.beans.Objeto;
import com.journaldev.jaxws.beans.Person;
import com.journaldev.jaxws.service.ObjetoService;
import com.journaldev.jaxws.service.PersonService;

public class SOAPPublisherClient {

	public static void main(String[] args) throws MalformedURLException {
		URL wsdlURL1 = new URL("http://localhost:8080/JAXWS-Tomcat/personWS?wsdl");
		URL wsdlURL2 = new URL("http://localhost:8080/JAXWS-Tomcat/objetoWS?wsdl");
		//Check above URL in browser, you should see WSDL file
		
		//Creating QName using targetNamespace and name
		QName qname1 = new QName("http://service.jaxws.journaldev.com/", "PersonServiceImplService");
		QName qname2 = new QName("http://service.jaxws.journaldev.com/", "ObjetoServiceImplService");
		
		Service service1 = Service.create(wsdlURL1, qname1);
		Service service2 = Service.create(wsdlURL2, qname2);
		
		//We need to pass interface and model beans to client
		PersonService ps = service1.getPort(PersonService.class);
		ObjetoService os = service2.getPort(ObjetoService.class);
		
		Person p1 = new Person();
		p1.setName("Daniel");
		p1.setId(1);
		p1.setAge(30);
		
		Person p2 = new Person();
		p2.setName("Jose");
		p2.setId(2);
		p2.setAge(25);
		
		Objeto o1 = new Objeto();
		o1.setColor("Azul");
		o1.setId(3);
		o1.setNombre("Camiseta");
		
		Objeto o2 = new Objeto();
		o2.setColor("Rojo");
		o2.setId(4);
		o2.setNombre("Manta");
		
		//Add persons and objects
		System.out.println("Add Person Status="+ps.addPerson(p1));
		System.out.println("Add Person Status="+ps.addPerson(p2));
		System.out.println("Add Object Status="+os.addObjeto(o1));
		System.out.println("Add Object Status="+os.addObjeto(o2));
		
		//get person and object
		System.out.println(ps.getPerson(1));
		System.out.println(os.getObjeto(3));
		
		//get all persons and objects
		System.out.println(Arrays.asList(ps.getAllPersons()));
		System.out.println(Arrays.asList(os.getAllObjetos()));
		
		//delete person
		System.out.println("Delete Person Status="+ps.deletePerson(2));
		System.out.println("Delete Objeto Status="+os.deleteObjeto(4));
		
		//get all persons
		System.out.println(Arrays.asList(ps.getAllPersons()));
		System.out.println(Arrays.asList(os.getAllObjetos()));
	}
}
