package id.co.pakupang.master;

import id.co.pakupang.entity.HargaMasyarakat;
import id.co.pakupang.entity.Komoditas;

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
@Path(value="/pakopang/komoditasServices")
@Produces(MediaType.APPLICATION_JSON)
public class KomoditasServices {
	
	@EJB
	private KomoditasSession komoditasSession;
	
	@Path("/getKomoditasList")
	@GET
	public List<Komoditas> getKomoditasList(){
		return komoditasSession.getKomoditasList();
	}
	
	@Path("/getKomoditas/{id}")
	@GET
	public Komoditas getKomoditas(@PathParam("id")int id){
		return komoditasSession.getKomoditas(id);
	}
	
	@Path("/getKomoditasByNama/{nama}")
	@GET
	public List<Komoditas> getKomoditasByNama(
			@PathParam("nama")String nama){
		return komoditasSession.getListKomoditasByNama(nama);
	}
	
	@Path("/insertKomoditas")
	@POST
	public Komoditas insertKomoditas(
			@FormParam("parentId")Integer parentId,
			@FormParam("nama")String nama){
		Komoditas kom = new Komoditas();
		kom.setParentId(parentId);
		kom.setNama(nama);
		komoditasSession.insertKomoditas(kom);
		return kom;
	}
	
	@Path("/updateKomoditas")
	@POST
	public Komoditas updateKomoditas(@FormParam("id")int id,
			@FormParam("parentId")Integer parentId,
			@FormParam("nama")String nama){
		Komoditas kom = komoditasSession.find(id);
		kom.setParentId(parentId);
		kom.setNama(nama);
		komoditasSession.updateKomoditas(kom);
		return kom;
	}
	
	@Path("/deleteRowKomoditas/{id}")
	@GET
	public Komoditas deleteRowKomoditas(@PathParam("id")int id){
		return komoditasSession.deleteRowKomoditas(id);
	}
}
