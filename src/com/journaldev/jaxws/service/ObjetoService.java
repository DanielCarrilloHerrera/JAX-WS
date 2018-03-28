package com.journaldev.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.journaldev.jaxws.beans.Objeto;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC) 
public interface ObjetoService {
	
	@WebMethod
	public boolean addObjeto(Objeto o);
	
	@WebMethod
	public boolean deleteObjeto(int id);
	
	@WebMethod
	public Objeto getObjeto(int id);
	
	@WebMethod
	public Objeto[] getAllObjetos();

}
