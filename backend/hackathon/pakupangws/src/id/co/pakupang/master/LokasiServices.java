package id.co.pakupang.master;

import id.co.pakupang.entity.Komoditas;
import id.co.pakupang.entity.Lokasi;

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
@Path(value="/pakopang/lokasiServices")
@Produces(MediaType.APPLICATION_JSON)
public class LokasiServices {
	
	@EJB
	private LokasiSession lokasiSession;
	
	@Path("/getLokasiList")
	@GET
	public List<Lokasi> getLokasiList(){
		return lokasiSession.getLokasiList();
	}
	
	@Path("/getLokasi/{id}")
	@GET
	public Lokasi getLokasi(@PathParam("id")int id){
		return lokasiSession.getLokasi(id);
	}
	
	@Path("/getLokasiByNama/{nama}")
	@GET
	public List<Lokasi> getLokasiByNama(
			@PathParam("nama")String nama){
		return lokasiSession.getListLokasiByNama(nama);
	}
	
	@Path("/insertLokasi")
	@POST
	public Lokasi insertLokasi(
			@FormParam("parentId")Integer parentId,
			@FormParam("nama")String nama,
			@FormParam("latitude")String latitude,
			@FormParam("longitude")String longitude){
		Lokasi pr = new Lokasi();
		pr.setParentId(parentId);
		pr.setNama(nama);
		pr.setLatitude(latitude);
		pr.setLongitude(longitude);
		lokasiSession.insertLokasi(pr);
		return pr;
	}
	
	@Path("/updateLokasi")
	@POST
	public Lokasi updateLokasi(@FormParam("id")int id,
			@FormParam("parentId")Integer parentId,
			@FormParam("nama")String nama,
			@FormParam("latitude")String latitude,
			@FormParam("longitude")String longitude){
		Lokasi pr = lokasiSession.find(id);
		pr.setParentId(parentId);
		pr.setNama(nama);
		pr.setLatitude(latitude);
		pr.setLongitude(longitude);
		lokasiSession.updateLokasi(pr);
		return pr;
	}
	
	@Path("/deleteRowLokasi/{id}")
	@GET
	public Lokasi deleteRowLokasi(@PathParam("id")int id){
		return lokasiSession.deleteRowLokasi(id);
	}
}
