package br.iff.pooa20141.imobiliaria.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.entity.TipoDeImovel;

public class TipoDeImovelTest {
	

	private TipoDeImovelPersistenceRemote tipoDeImovelPR;
	@Before
	public void setUp() throws Exception {
		Context context = null;
		tipoDeImovelPR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			tipoDeImovelPR = (TipoDeImovelPersistenceRemote) context
					.lookup("ejb:ImobiliariaEAR/ImobiliariaEJB/TipoDeImovelPersistence!br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInserir() {
		
		TipoDeImovel tipoDeImovel = tipoDeImovelPR.inserir(001, "venda" ,"Apartamento" , 280.000);
		assertEquals(tipoDeImovel.getIdTipoDeImovel(),new Integer(001));
		tipoDeImovelPR.delete(001);
	}
	
	@Test
	public void testupdate() {
	
		tipoDeImovelPR.inserir(001, "venda" ,"Apartamento" , 280.000);

		TipoDeImovel tipoDeImovelUp = tipoDeImovelPR.update(001, "venda" ,"Apartamento" , 280.000);

		assertEquals(tipoDeImovelUp.getDescricao(), "Apartamento");
		tipoDeImovelPR.delete(001);
	}
	
	
	@Test
	public void testfind() {
		
		tipoDeImovelPR.inserir(001, "venda" ,"Apartamento" , 280.000);

		TipoDeImovel tipoDeImovelUp = tipoDeImovelPR.find(001);

		assertEquals(tipoDeImovelUp.getDescricao(), "Apartamento");
		tipoDeImovelPR.delete(001);
	}
	
	@Test
	public void testdelete() {
		
		tipoDeImovelPR.inserir(001, "venda" ,"Apartamento" , 280.000);
		tipoDeImovelPR.delete(001);
		assertEquals(tipoDeImovelPR.find(001),null);
	}

	
}
