package com.journaldev.jaxws.service;

import com.journaldev.jaxws.beans.Objeto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;

@WebService(endpointInterface = "com.journaldev.jaxws.service.ObjetoService")
public class ObjetoServiceImpl {

private static Map<Integer,Objeto> objetos = new HashMap<Integer, Objeto>();
	
	public boolean addObjeto(Objeto o) {
		// TODO Auto-generated method stub
		if(objetos.get(o.getId()) != null)
			return false;
		
		objetos.put(o.getId(), o);
		return true;
	}

	public boolean deleteObjeto(int id) {
		// TODO Auto-generated method stub
		if(objetos.get(id) == null)
			return false;
		
		objetos.remove(id);
		return true;
	}

	public Objeto getObjeto(int id) {
		// TODO Auto-generated method stub
		return objetos.get(id);
	}

	public Objeto[] getAllObjetos() {
		// TODO Auto-generated method stub
		Set<Integer> ids = objetos.keySet();
		Objeto[] o = new Objeto[ids.size()];
		int i = 0;
		for(Integer id : ids) {
			o[i] = objetos.get(id);
			i++;
		}
		return o;
	}

}
