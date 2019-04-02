package id.co.pakupang.master;

import java.util.Date;
import java.util.List;

import id.co.pakupang.entity.LaporKecurangan;
import id.co.pakupang.entity.Lokasi;
import id.co.pakupang.utils.AbstractFacade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class LaporKecuranganSession extends AbstractFacade<LaporKecurangan>{

	@PersistenceContext
	private EntityManager em;
	
	public LaporKecuranganSession() {
		super(LaporKecurangan.class);
	}
	
	public List<LaporKecurangan> getLaporKecuranganList() {
		Query q = em.createNamedQuery("Lokasi.find");
		return q.getResultList();
	}
	
	public LaporKecurangan getLaporKecurangan(int id) {
		return super.find(id);
	}	
	
	public LaporKecurangan insertLaporKecurangan(LaporKecurangan lpk){
		lpk.setTglLapor(new Date());
		super.create(lpk);
		return lpk;
	}
	
	public LaporKecurangan updateLaporKecurangan(LaporKecurangan lpk){
		super.edit(lpk);
		return lpk;
	}
	
	public LaporKecurangan deleteRowLaporKecurangan(int id){
		LaporKecurangan lpk = super.find(id);
		super.remove(lpk);
		return lpk;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
