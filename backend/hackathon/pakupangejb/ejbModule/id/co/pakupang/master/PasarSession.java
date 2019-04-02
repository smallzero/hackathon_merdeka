package id.co.pakupang.master;

import id.co.pakupang.entity.Pasar;
import id.co.pakupang.utils.AbstractFacade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class PasarSession extends AbstractFacade<Pasar>{

	@PersistenceContext
	private EntityManager em;
	
	public PasarSession() {
		super(Pasar.class);
	}
	
	public List<Pasar> getPasarList() {
		Query q = em.createNamedQuery("Pasar.find");
		return q.getResultList();
	}
	
	public List<Pasar> getPasarByLokasi(int lokasiId){
		Query q = em.createNamedQuery("Pasar.findByLokasi");
		q.setParameter("lokasiId", lokasiId);
		return q.getResultList();
	}

	public Pasar getPasar(int id) {
		return super.find(id);
	}
	
	public Pasar insertPasar(Pasar ps){
		super.create(ps);
		return ps;
	}
	
	public Pasar updatePasar(Pasar ps){
		super.edit(ps);
		return ps;
	}
	
	public Pasar deleteRowPasar(int id){
		Pasar ps = super.find(id);
		super.remove(ps);
		return ps;
	}	
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
