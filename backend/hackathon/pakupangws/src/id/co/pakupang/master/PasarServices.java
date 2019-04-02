package id.co.pakupang.master;

import id.co.pakupang.entity.HargaPemerintah;
import id.co.pakupang.entity.Pasar;

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
@Path(value="/pakopang/pasarServices")
@Produces(MediaType.APPLICATION_JSON)
public class PasarServices {

	@EJB
	private PasarSession pasarSession;
	
	@EJB
	private LokasiSession lokasiSession;
	
	@Path("/getPasarList")
	@GET
	public List<Pasar> getPasarList(){
		return pasarSession.getPasarList();
	}
	
	@Path("/getListPasarByProvinsi/{lokasiId}")
	@GET
	public List<Pasar> getPasarByLokasi(
			@PathParam("lokasiId")int lokasiId){
		return pasarSession.getPasarByLokasi(lokasiId);
	}
	
	@Path("/getPasar/{id}")
	@GET
	public Pasar getPasar(@PathParam("id")int id){
		return pasarSession.getPasar(id);
	}
	
	@Path("/insertPasar")
	@POST
	public Pasar insertPasar(
			@FormParam("lokasi")Integer lokasi,
			@FormParam("nama")String nama){
		Pasar ps = new Pasar();
		ps.setLokasi(lokasiSession.find(lokasi));
		ps.setNama(nama);
		pasarSession.insertPasar(ps);
		return ps;
	}
	
	@Path("/updatePasar")
	@POST
	public Pasar updatePasar(@FormParam("id")int id,
			@FormParam("lokasi")Integer lokasi,
			@FormParam("nama")String nama){
		Pasar ps = pasarSession.find(id);
		ps.setLokasi(lokasiSession.find(lokasi));
		ps.setNama(nama);
		pasarSession.updatePasar(ps);
		return ps;
	}
	
	@Path("/deleteRowPasar/{id}")
	@GET
	public Pasar deleteRowPasar(@PathParam("id")int id){
		return pasarSession.deleteRowPasar(id);
	}
}
