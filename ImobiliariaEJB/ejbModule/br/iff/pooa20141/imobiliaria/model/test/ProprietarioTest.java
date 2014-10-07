package br.iff.pooa20141.imobiliaria.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.entity.Proprietario;




public class ProprietarioTest {
	
	private ProprietarioPersistenceRemote proprietarioPR;
	
	@Before
	public void setUp() throws Exception {
		Context context = null;
		proprietarioPR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			proprietarioPR = (ProprietarioPersistenceRemote) context
					.lookup("ejb:ImobiliariaEAR/ImobiliariaEJB/ProprietarioPersistence!br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInserir() {
		
		Proprietario proprietario = proprietarioPR.inserir(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");
		assertEquals(proprietario.getIdproprietario(),new Integer(001));
		proprietarioPR.delete(001);
	}
	
	@Test
	public void testupdate() {
		
		proprietarioPR.inserir(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");

		Proprietario proprietarioUp = proprietarioPR.update(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");

		assertEquals(proprietarioUp.getNome(), "Ana Mello");
		proprietarioPR.delete(001);
	}
	
	
	@Test
	public void testfind() {
		
		proprietarioPR.inserir(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");

		Proprietario proprietarioUp = proprietarioPR.find(001);

		assertEquals(proprietarioUp.getNome(), "Ana Mello");
		proprietarioPR.delete(001);
	}
	
	@Test
	public void testdelete() {
		
		proprietarioPR.inserir(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");
		proprietarioPR.delete(001);
		assertEquals(proprietarioPR.find(001),null);
	}

	
	

}
