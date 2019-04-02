package id.co.pakupang.master;

import id.co.pakupang.entity.HargaMasyarakat;
import id.co.pakupang.entity.HargaPemerintah;
import id.co.pakupang.entity.Komoditas;
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
@Path(value="/pakopang/hargaMasyarakatServices")
@Produces(MediaType.APPLICATION_JSON)
public class HargaMasyarakatServices {

	@EJB
	private HargaMasyarakatSession hargaMasyarakatSession;
	
	@EJB
	private KomoditasSession komoditasSession;
	
	@EJB
	private SatuanSession satuanSession;
	
	@EJB
	private LokasiSession lokasiSession;
	
	@Path("/getHargaMasyarakatList")
	@GET
	public List<HargaMasyarakat> getHargaMasyarakatList(){
		return hargaMasyarakatSession.getHargaMasyarakatList();
	}
	
	@Path("/getHargaMasyarakat/{id}")
	@GET
	public HargaMasyarakat getHargaMasyarakat(@PathParam("id")int id){
		return hargaMasyarakatSession.getHargaMasyarakat(id);
	}
	
	@Path("/getListPasarByKomoditas/{komoditasId}")
	@GET
	public List<HargaMasyarakat> getHargaMasyarakatByKomoditas(
			@PathParam("komoditasId")int komoditasId){
		return hargaMasyarakatSession.getHargaMasyarakatByKomoditas(komoditasId);
	}
	
	@Path("/insertHargaMasyarakat")
	@POST
	public HargaMasyarakat insertHargaMasyarakat(
			@FormParam("jnsPusatKomoditas")String jnsPusatKomoditas,
			@FormParam("komoditas")Integer komoditas,
			@FormParam("harga")Double harga,
			@FormParam("perSatuan")String perSatuan,
			@FormParam("stok")Double stok,
			@FormParam("satuan")Integer satuan,
			@FormParam("lokasi")Integer lokasi,
			@FormParam("latitude")String latitude,
			@FormParam("longitude")String longitude){
		HargaMasyarakat hrgm = new HargaMasyarakat();
		hrgm.setJnsPusatKomoditas(jnsPusatKomoditas);
		hrgm.setKomoditas(komoditasSession.find(komoditas));
		hrgm.setHarga(harga);
		hrgm.setPerSatuan(perSatuan);
		hrgm.setStok(stok);
		hrgm.setSatuan(satuanSession.find(satuan));
		hrgm.setLokasi(lokasiSession.find(lokasi));
		hrgm.setLatitude(latitude);
		hrgm.setLongitude(longitude);
		hargaMasyarakatSession.insertHargaMasyarakat(hrgm);
		return hrgm;
	}
	
	@Path("/updateHargaMasyarakat")
	@POST
	public HargaMasyarakat updateHargaMasyarakat(@FormParam("id")int id,
			@FormParam("jnsPusatKomoditas")String jnsPusatKomoditas,
			@FormParam("komoditas")Integer komoditas,
			@FormParam("harga")Double harga,
			@FormParam("perSatuan")String perSatuan,
			@FormParam("stok")Double stok,
			@FormParam("satuan")Integer satuan,
			@FormParam("lokasi")Integer lokasi,
			@FormParam("latitude")String latitude,
			@FormParam("longitude")String longitude){
		HargaMasyarakat hrgm = hargaMasyarakatSession.find(id);
		hrgm.setJnsPusatKomoditas(jnsPusatKomoditas);
		hrgm.setKomoditas(komoditasSession.find(komoditas));
		hrgm.setHarga(harga);
		hrgm.setPerSatuan(perSatuan);
		hrgm.setStok(stok);
		hrgm.setSatuan(satuanSession.find(satuan));
		hrgm.setLokasi(lokasiSession.find(lokasi));
		hrgm.setLatitude(latitude);
		hrgm.setLongitude(longitude);
		hargaMasyarakatSession.updateHargaMasyarakat(hrgm);
		return hrgm;
	}
	
	@Path("/deleteRowHargaMasyarakat/{id}")
	@GET
	public HargaMasyarakat deleteRowHargaMasyarakat(@PathParam("id")int id){
		return hargaMasyarakatSession.deleteRowHargaMasyarakat(id);
	}
}
