package id.co.pakupang.master;

import id.co.pakupang.entity.LaporKecurangan;
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
@Path(value="/pakopang/laporKecuranganServices")
@Produces(MediaType.APPLICATION_JSON)
public class LaporKecuranganServices {

	@EJB
	private LaporKecuranganSession laporKecuranganSession;
	
	@Path("/getLaporKecuranganList")
	@GET
	public List<LaporKecurangan> getLaporKecuranganList(){
		return laporKecuranganSession.getLaporKecuranganList();
	}
	
	@Path("/getLokasi/{id}")
	@GET
	public LaporKecurangan getLaporKecurangan(@PathParam("id")int id){
		return laporKecuranganSession.getLaporKecurangan(id);
	}
	
	@Path("/insertLaporKecurangan")
	@POST
	public LaporKecurangan insertLaporKecurangan(
			@FormParam("subjek")String subjek,
			@FormParam("deskripsi")String deskripsi,
			@FormParam("lokasi")String lokasi,
			@FormParam("latitude")String latitude,
			@FormParam("longitude")String longitude){
		LaporKecurangan lpk = new LaporKecurangan();
		lpk.setSubjek(subjek);
		lpk.setDeskripsi(deskripsi);
		lpk.setLokasi(lokasi);
		lpk.setLatitude(latitude);
		lpk.setLongitude(longitude);
		laporKecuranganSession.insertLaporKecurangan(lpk);
		return lpk;
	}
	
	@Path("/updateLokasi")
	@POST
	public LaporKecurangan updateLaporKecurangan(@FormParam("id")int id,
			@FormParam("subjek")String subjek,
			@FormParam("deskripsi")String deskripsi,
			@FormParam("lokasi")String lokasi,
			@FormParam("latitude")String latitude,
			@FormParam("longitude")String longitude){
		LaporKecurangan lpk = laporKecuranganSession.find(id);
		lpk.setSubjek(subjek);
		lpk.setDeskripsi(deskripsi);
		lpk.setLokasi(lokasi);
		lpk.setLatitude(latitude);
		lpk.setLongitude(longitude);
		laporKecuranganSession.updateLaporKecurangan(lpk);
		return lpk;
	}
	
	@Path("/deleteRowLaporKecurangan/{id}")
	@GET
	public LaporKecurangan deleteRowLaporKecurangan(@PathParam("id")int id){
		return laporKecuranganSession.deleteRowLaporKecurangan(id);
	}
}
