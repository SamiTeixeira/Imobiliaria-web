package br.iff.pooa20141.imobiliaria.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.entity.Usuario;

public class UsuarioTest {
	
	private UsuarioPersistenceRemote usuarioPR;

	@Before
	public void setUp() throws Exception {
		Context context = null;
		usuarioPR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			usuarioPR = (UsuarioPersistenceRemote) context
					.lookup("ejb:ImobiliariaEAR/ImobiliariaEJB/UsuarioPersistence!br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInserir() {
		
		Usuario usuario = usuarioPR.inserir(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");
		assertEquals(usuario.getIdUsuario(),new Integer(001));
		usuarioPR.delete(001);
	}
	
	@Test
	public void testupdate() {
		
		usuarioPR.inserir(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");

		Usuario usuarioUp = usuarioPR.update(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");

		assertEquals(usuarioUp.getNome(), "Ana Mello");
		usuarioPR.delete(001);
	}

	@Test
	public void testfind() {
		
		usuarioPR.inserir(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");

		Usuario usuarioUp = usuarioPR.find(001);

		assertEquals(usuarioUp.getNome(), "Ana Mello");
		usuarioPR.delete(001);
	}
	
	
	@Test
	public void testdelete() {
		
		usuarioPR.inserir(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");
		usuarioPR.delete(001);
		assertEquals(usuarioPR.find(001),null);
	}


	
	
}
