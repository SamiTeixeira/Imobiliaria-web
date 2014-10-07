package br.iff.pooa20141.imobiliaria.model.test;

import static org.junit.Assert.*;

import java.util.Date;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.imobiliaria.model.controller.AgendamentoDeVisitaPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistenceRemote;
import br.iff.pooa20141.imobiliaria.model.entity.AgendamentoDeVisita;
import br.iff.pooa20141.imobiliaria.model.entity.Imovel;
import br.iff.pooa20141.imobiliaria.model.entity.Usuario;
import br.iff.pooa20141.imobiliaria.model.entity.Proprietario;
import br.iff.pooa20141.imobiliaria.model.entity.TipoDeImovel;

public class AgendamentoDeVisitaTest {
	
	private AgendamentoDeVisitaPersistenceRemote agendamentoDeVisitaPR;
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
		agendamentoDeVisitaPR = null;
		imovelPR = null;
		usuarioPR = null;
		proprietarioPR = null;
		tipoDeImovelPR = null;
		
		
		try {

			context = JNDILookupClass.getInitialContext();

			agendamentoDeVisitaPR = (AgendamentoDeVisitaPersistenceRemote) context
					.lookup("ejb:ImobiliariaEAR/ImobiliariaEJB/AgendamentoDeVisitaPersistence!br.iff.pooa20141.imobiliaria.model.controller.AgendamentoDeVisitaPersistenceRemote");

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
		proprietario = proprietarioPR.inserir(002,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");
				
		//uidCategoria = UUID.randomUUID().toString();
		tipoDeImovel = tipoDeImovelPR.inserir(002, "venda" ,"Apartamento" , 280.000);
		
		//uidSetor = UUID.randomUUID().toString();
		imovel = imovelPR.inserir( 002 ,1, 1, 1, 1, 1, "Campos/RJ", 1, 1, 1 , proprietario,tipoDeImovel);
				
		//uidCategoria = UUID.randomUUID().toString();
		usuario = usuarioPR.inserir( 002 ,"Ana Mello" , "123.344.122-98" ,"3456782" , "anamel@sea.com" , "campos dos goytacazes");
		
		
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		imovelPR.delete(002);
		usuarioPR.delete(002);
		proprietarioPR.delete(002);
		tipoDeImovelPR.delete(002);
	}
	
	
	@Test
	public void testInserir() {
		//String uid = UUID.randomUUID().toString();
		
		AgendamentoDeVisita agendamentoDeVisita = agendamentoDeVisitaPR.inserir(002, new Date(), "12:30", imovel, usuario);
		
		assertEquals(agendamentoDeVisita.getIdAgendamentoDeVisita(), new Integer(002));
		agendamentoDeVisitaPR.delete(002);
	}
	
	@Test
	public void testupdate() {
		
		agendamentoDeVisitaPR.inserir(002, new Date() , "12:30", imovel, usuario);

		AgendamentoDeVisita agendamentoDeVisitaUp = agendamentoDeVisitaPR.update(002, new Date() , "12:30", imovel, usuario);

		assertEquals(agendamentoDeVisitaUp.getHora(), "12:30" );
		agendamentoDeVisitaPR.delete(002);
	}
	
	@Test
	public void testfind() {
		//String uid = UUID.randomUUID().toString();
		agendamentoDeVisitaPR.inserir(002, new Date() , "12:30", imovel, usuario);

		AgendamentoDeVisita agendamentoDeVisitaUp = agendamentoDeVisitaPR.find(002);

		assertEquals(agendamentoDeVisitaUp.getHora(), "12:30");
		agendamentoDeVisitaPR.delete(002);
	}
	
	@Test
	public void testdelete() {
		//String uid = UUID.randomUUID().toString();
		agendamentoDeVisitaPR.inserir(002, new Date() , "12:30", imovel, usuario);

		agendamentoDeVisitaPR.delete(002);
		assertEquals(agendamentoDeVisitaPR.find(002), null);
	}

	
	
	

}
