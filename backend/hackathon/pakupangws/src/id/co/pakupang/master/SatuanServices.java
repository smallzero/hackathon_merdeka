package id.co.pakupang.master;

import id.co.pakupang.entity.HargaPemerintah;
import id.co.pakupang.entity.Satuan;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path(value="/pakopang/satuanServices")
@Produces(MediaType.APPLICATION_JSON)
public class SatuanServices {

	@EJB
	private SatuanSession satuanSession;
	
	@Path("/getSatuanList")
	@GET
	public List<Satuan> getSatuanList(){
		return satuanSession.getSatuanList();
	}
	
	@Path("/getSatuan/{id}")
	@GET
	public Satuan getSatuan(@PathParam("id")int id){
		return satuanSession.getSatuan(id);
	}
	
	@Path("/getSatuanByNama/{nama}")
	@GET
	public List<Satuan> getSatuanByNama(
			@PathParam("nama")String nama){
		return satuanSession.getListSatuanByNama(nama);
	}
	
	@Path("/insertSatuan")
	@POST
	public Satuan insertSatuan(
			@FormParam("nama")String nama){
		Satuan st = new Satuan();
		st.setNama(nama);
		satuanSession.insertPasar(st);
		return st;
	}
	
	@Path("/updateSatuan")
	@POST
	public Satuan updateSatuan(@FormParam("id")int id,
			@FormParam("nama")String nama){
		Satuan st = satuanSession.find(id);
		st.setNama(nama);
		satuanSession.updateSatuan(st);
		return st;
	}
	
	@Path("/deleteRowSatuan/{id}")
	@GET
	public Satuan deleteRowSatuan(@PathParam("id")int id){
		return satuanSession.deleteRowSatuan(id);
	}
}
