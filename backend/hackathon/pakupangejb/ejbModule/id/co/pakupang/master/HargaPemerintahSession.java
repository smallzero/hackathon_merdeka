package id.co.pakupang.master;

import java.util.List;

import id.co.pakupang.entity.HargaMasyarakat;
import id.co.pakupang.entity.HargaPemerintah;
import id.co.pakupang.utils.AbstractFacade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class HargaPemerintahSession extends AbstractFacade<HargaPemerintah>{
	
	@PersistenceContext
	private EntityManager em;
	
	public HargaPemerintahSession() {
		super(HargaPemerintah.class);
	}
	
	public List<HargaPemerintah> getHargaPemerintahList() {
		Query q = em.createNamedQuery("Pasar.find");
		return q.getResultList();
	}
	
	public HargaPemerintah getHargaPemerintah(int id) {
		return super.find(id);
	}
	
	public HargaPemerintah insertHargaPemerintah(HargaPemerintah hrgPemerintah){
		super.create(hrgPemerintah);
		return hrgPemerintah;
	}
	
	public HargaPemerintah updateHargaPemerintah(HargaPemerintah hrgPemerintah){
		super.edit(hrgPemerintah);
		return hrgPemerintah;
	}
	
	public HargaPemerintah deleteRowHargaPemerintah(int id){
		HargaPemerintah hrgPemerintah = super.find(id);
		super.remove(hrgPemerintah);
		return hrgPemerintah;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
