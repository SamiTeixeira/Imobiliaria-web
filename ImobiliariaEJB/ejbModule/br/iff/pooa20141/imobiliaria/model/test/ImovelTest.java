package br.iff.pooa20141.imobiliaria.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.entity.Imovel;
import br.iff.pooa20141.imobiliaria.model.entity.Proprietario;
import br.iff.pooa20141.imobiliaria.model.entity.TipoDeImovel;



public class ImovelTest {
	
	private ImovelPersistenceRemote imovelPR;
	private ProprietarioPersistenceRemote proprietarioPR;
	private TipoDeImovelPersistenceRemote tipoDeImovelPR;
	Proprietario proprietario;
	TipoDeImovel tipoDeImovel;
	
	@Before
	public void setUp() throws Exception {
		Context context = null;
		imovelPR = null;
		proprietarioPR = null;
		tipoDeImovelPR = null;
		try {
			
			context = JNDILookupClass.getInitialContext();

			imovelPR = (ImovelPersistenceRemote) context
					.lookup("ejb:ImobiliariaEAR/ImobiliariaEJB/ImovelPersistence!br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		
		try {
			
			context = JNDILookupClass.getInitialContext();

			proprietarioPR = (ProprietarioPersistenceRemote) context
					.lookup("ejb:ImobiliariaEAR/ImobiliariaEJB/ProprietarioPersistence!br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		
		try {
			
			context = JNDILookupClass.getInitialContext();

			tipoDeImovelPR = (TipoDeImovelPersistenceRemote) context
					.lookup("ejb:ImobiliariaEAR/ImobiliariaEJB/TipoDeImovelPersistence!br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		
		
		
		//uidSetor = UUID.randomUUID().toString();
		proprietario = proprietarioPR.inserir(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");
		
		//uidCategoria = UUID.randomUUID().toString();
		tipoDeImovel = tipoDeImovelPR.inserir(001, "venda" ,"Apartamento" , 280.000);
		
		
	}
	

	
	@After
	public void tearDown() throws Exception {
		proprietarioPR.delete(001);
		tipoDeImovelPR.delete(001);
	}

	
	@Test
	public void testInserir() {
		
		Imovel imovel = imovelPR.inserir(001,1, 1, 1, 1, 1, "Campos/RJ", 1, 1, 1 , proprietario,tipoDeImovel);
		assertEquals(imovel.getIdImovel(),new Integer(001));
		imovelPR.delete(001);
	}
	
	@Test
	public void testupdate() {
		
		imovelPR.inserir(001,1, 1, 1, 1, 1, "Campos/RJ", 1, 1, 1 , proprietario,tipoDeImovel);

		Imovel imovelUp = imovelPR.update(001,1, 1, 1, 1, 1, "Campos/RJ", 1, 1, 1 , proprietario,tipoDeImovel);

		assertEquals(imovelUp.getEndereco(), "Campos/RJ");
		imovelPR.delete(001);
	}
	
	
	@Test
	public void testfind() {
		
		imovelPR.inserir(001,1, 1, 1, 1, 1, "Campos/RJ", 1, 1, 1 , proprietario,tipoDeImovel);

		Imovel imovelUp = imovelPR.find(001);

		assertEquals(imovelUp.getEndereco(), "Campos/RJ");
		imovelPR.delete(001);
	}
	
	
	@Test
	public void testdelete() {
		
		imovelPR.inserir(001,1, 1, 1, 1, 1, "Campos/RJ", 1, 1, 1 , proprietario,tipoDeImovel);
		imovelPR.delete(001);
		assertEquals(imovelPR.find(001),null);
	}
	
	
}
