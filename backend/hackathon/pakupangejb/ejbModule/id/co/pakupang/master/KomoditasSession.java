package id.co.pakupang.master;

import java.util.List;

import id.co.pakupang.entity.Komoditas;
import id.co.pakupang.utils.AbstractFacade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class KomoditasSession extends AbstractFacade<Komoditas>{

	@PersistenceContext
	private EntityManager em;
	
	public KomoditasSession() {
		super(Komoditas.class);
	}

	public List<Komoditas> getKomoditasList() {
		Query q = em.createNamedQuery("Komoditas.find");
		return q.getResultList();
	}
	
	public List<Komoditas> getListKomoditasByNama(
			String nama) {
		nama = nama;
		Query q = em.createNamedQuery("Komoditas.findByNama");
		q.setParameter("nama", "%"+nama+"%");
		return q.setMaxResults(5).getResultList();
	}

	public Komoditas getKomoditas(int id) {
		return super.find(id);
	}	
	
	public Komoditas insertKomoditas(Komoditas kom){
		super.create(kom);
		return kom;
	}
	
	public Komoditas updateKomoditas(Komoditas kom){
		super.edit(kom);
		return kom;
	}
	
	public Komoditas deleteRowKomoditas(int id){
		Komoditas kom = super.find(id);
		super.remove(kom);
		return kom;
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
