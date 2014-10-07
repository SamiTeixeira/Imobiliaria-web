package br.iff.pooa20141.imobiliaria.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.imobiliaria.model.controller.PropostaPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.entity.Proposta;
import br.iff.pooa20141.imobiliaria.model.entity.Imovel;
import br.iff.pooa20141.imobiliaria.model.entity.Usuario;
import br.iff.pooa20141.imobiliaria.model.entity.Proprietario;
import br.iff.pooa20141.imobiliaria.model.entity.TipoDeImovel;



public class PropostaTest {
	
	private PropostaPersistenceRemote propostaPR;
	private ImovelPersistenceRemote imovelPR;
	private UsuarioPersistenceRemote usuarioPR;
	private ProprietarioPersistenceRemote proprietarioPR;
	private TipoDeImovelPersistenceRemote tipoDeImovelPR;
	Imovel imovel;
	Usuario usuario;
	Proprietario proprietario;
	TipoDeImovel tipoDeImovel;
	
	
	@Before
	public void setUp() throws Exception {
		Context context = null;
		propostaPR = null;
		usuarioPR = null;
		imovelPR = null;
		proprietarioPR = null;
		tipoDeImovelPR = null;
		
		try {
		
			context = JNDILookupClass.getInitialContext();

			propostaPR = (PropostaPersistenceRemote) context
					.lookup("ejb:ImobiliariaEAR/ImobiliariaEJB/PropostaPersistence!br.iff.pooa20141.imobiliaria.model.controller.PropostaPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
			
		try {
			
			context = JNDILookupClass.getInitialContext();

			imovelPR = (ImovelPersistenceRemote) context
					.lookup("ejb:ImobiliariaEAR/ImobiliariaEJB/ImovelPersistence!br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		
		try {

			context = JNDILookupClass.getInitialContext();

			usuarioPR = (UsuarioPersistenceRemote) context
					.lookup("ejb:ImobiliariaEAR/ImobiliariaEJB/UsuarioPersistence!br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistenceRemote");

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
		
		//uidSetor = UUID.randomUUID().toString();
		usuario = usuarioPR.inserir(001,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");
				
		//uidCategoria = UUID.randomUUID().toString();
		imovel = imovelPR.inserir(001,1, 1, 1, 1, 1, "Campos/RJ", 1, 1, 1 , proprietario,tipoDeImovel);

		
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		imovelPR.delete(001);
		proprietarioPR.delete(001);
		tipoDeImovelPR.delete(001);
		usuarioPR.delete(001);
		
	}
	
	@Test
	public void testInserir() {
		
		Proposta proposta = propostaPR.inserir(001, "aguardando aprovação", 2300.50, imovel, usuario );
		assertEquals(proposta.getIdProposta(),new Integer(001));
		propostaPR.delete(001);
	}
	
	
	@Test
	public void testupdate() {
		
		propostaPR.inserir(001, "aguardando aprovação", 2300.50, imovel, usuario );

		Proposta propostaUp = propostaPR.update(001, "aguardando aprovação", 2300.50, imovel, usuario);

		assertEquals(propostaUp.getSatatus(), "aguardando aprovação");
		propostaPR.delete(001);
	}
	
	
	@Test
	public void testfind() {
		
		propostaPR.inserir(001, "aguardando aprovação", 2300.50, imovel, usuario );

		Proposta propostaUp = propostaPR.find(001);

		assertEquals(propostaUp.getSatatus(), "aguardando aprovação");
		propostaPR.delete(001);
	}
	

	
	@Test
	public void testdelete() {
		
		propostaPR.inserir(001,"aguardando aprovação", 2300.50, imovel, usuario );
		propostaPR.delete(001);
		assertEquals(propostaPR.find(001),null);
	}
	
}
