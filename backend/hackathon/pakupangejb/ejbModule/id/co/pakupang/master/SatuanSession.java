package id.co.pakupang.master;

import java.util.List;

import id.co.pakupang.entity.Komoditas;
import id.co.pakupang.entity.Pasar;
import id.co.pakupang.entity.Satuan;
import id.co.pakupang.utils.AbstractFacade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class SatuanSession extends AbstractFacade<Satuan>{

	@PersistenceContext
	private EntityManager em;
	
	public SatuanSession() {
		super(Satuan.class);
	}
	
	public Satuan getSatuan(int id) {
		return super.find(id);
	}
	
	public List<Satuan> getSatuanList() {
		Query q = em.createNamedQuery("Satuan.find");
		return q.getResultList();
	}
	
	public List<Satuan> getListSatuanByNama(
			String nama) {
		nama = nama;
		Query q = em.createNamedQuery("Satuan.findByNama");
		q.setParameter("nama", "%"+nama+"%");
		return q.setMaxResults(5).getResultList();
	}
	
	public Satuan insertPasar(Satuan st){
		super.create(st);
		return st;
	}
	
	public Satuan updateSatuan(Satuan st){
		super.edit(st);
		return st;
	}
	
	public Satuan deleteRowSatuan(int id){
		Satuan st = super.find(id);
		super.remove(st);
		return st;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
