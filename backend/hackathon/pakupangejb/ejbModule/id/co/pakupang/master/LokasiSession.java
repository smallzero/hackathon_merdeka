package id.co.pakupang.master;

import java.util.List;

import id.co.pakupang.entity.Komoditas;
import id.co.pakupang.entity.Lokasi;
import id.co.pakupang.utils.AbstractFacade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class LokasiSession extends AbstractFacade<Lokasi>{

	@PersistenceContext
	private EntityManager em;
	
	public LokasiSession() {
		super(Lokasi.class);
	}
	
	public List<Lokasi> getLokasiList() {
		Query q = em.createNamedQuery("Lokasi.find");
		return q.getResultList();
	}
	
	public List<Lokasi> getListLokasiByNama(
			String nama) {
		nama = nama;
		Query q = em.createNamedQuery("Lokasi.findByNama");
		q.setParameter("nama", "%"+nama+"%");
		return q.setMaxResults(5).getResultList();
	}

	public Lokasi getLokasi(int id) {
		return super.find(id);
	}	
	
	public Lokasi insertLokasi(Lokasi lok){
		super.create(lok);
		return lok;
	}
	
	public Lokasi updateLokasi(Lokasi lok){
		super.edit(lok);
		return lok;
	}
	
	public Lokasi deleteRowLokasi(int id){
		Lokasi lok = super.find(id);
		super.remove(lok);
		return lok;
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
