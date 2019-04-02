package id.co.pakupang.master;

import java.util.Date;
import java.util.List;

import id.co.pakupang.entity.HargaMasyarakat;
import id.co.pakupang.utils.AbstractFacade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class HargaMasyarakatSession extends AbstractFacade<HargaMasyarakat> {

	@PersistenceContext
	private EntityManager em;
	
	public HargaMasyarakatSession() {
		super(HargaMasyarakat.class);
	}
	
	public List<HargaMasyarakat> getHargaMasyarakatList() {
		Query q = em.createNamedQuery("HargaMasyarakat.find");
		return q.getResultList();
	}
	
	public List<HargaMasyarakat> getHargaMasyarakatByKomoditas(int komoditasId){
		Query q = em.createNamedQuery("Pasar.findByKomoditas");
		q.setParameter("komoditasId", komoditasId);
		return q.getResultList();
	}
	
	public HargaMasyarakat getHargaMasyarakat(int id) {
		return super.find(id);
	}
	
	public HargaMasyarakat insertHargaMasyarakat(HargaMasyarakat hm){
		hm.setTglBuat(new Date());
		super.create(hm);
		return hm;
	}
	
	public HargaMasyarakat updateHargaMasyarakat(HargaMasyarakat hm){
		super.edit(hm);
		return hm;
	}
	
	public HargaMasyarakat deleteRowHargaMasyarakat(int id){
		HargaMasyarakat hm = super.find(id);
		super.remove(hm);
		return hm;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	
}
