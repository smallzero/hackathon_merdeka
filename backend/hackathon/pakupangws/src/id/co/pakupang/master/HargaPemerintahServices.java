package id.co.pakupang.master;

import id.co.pakupang.entity.HargaPemerintah;
import id.co.pakupang.entity.Lokasi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@Path(value="/pakopang/hargaPemerintahServices")
@Produces(MediaType.APPLICATION_JSON)
public class HargaPemerintahServices {
	
	@EJB
	private HargaPemerintahSession hargaPemerintahSession;
	
	@EJB
	private KomoditasSession komoditasSession;
	
	@EJB
	private LokasiSession lokasiSession;
	
	@EJB
	private SatuanSession satuanSession;
	
	private DateFormat format = new SimpleDateFormat("yyyy-MM-DD");

	@Path("/getHargaPemerintahList")
	@GET
	public List<HargaPemerintah> getHargaPemerintahList(){
		return hargaPemerintahSession.getHargaPemerintahList();
	}
	
	@Path("/getHargaPemerintah/{id}")
	@GET
	public HargaPemerintah getHargaPemerintah(@PathParam("id")int id){
		return hargaPemerintahSession.getHargaPemerintah(id);
	}
	
	@Path("/insertHargaPemerintah")
	@POST
	public HargaPemerintah insertHargaPemerintah(
			@FormParam("komoditas")Integer komoditas,
			@FormParam("tglBuat")String tglBuat,
			@FormParam("harga")Double harga,
			@FormParam("lokasi")Integer lokasi,
			@FormParam("satuan")Integer satuan,
			@FormParam("kuantitas")Integer kuantitas){
		HargaPemerintah hrg = new HargaPemerintah();
		try{
		hrg.setKomoditas(komoditasSession.find(komoditas));
		hrg.setTglBuat(format.parse(tglBuat));
		hrg.setHarga(harga);
		hrg.setLokasi(lokasiSession.find(lokasi));
		hrg.setSatuan(satuanSession.find(satuan));
		hrg.setKuantitas(kuantitas);
		hargaPemerintahSession.insertHargaPemerintah(hrg);
		}catch(ParseException e){
			e.printStackTrace();
		}
		return hrg;
	}
	
	@Path("/updateHargaPemerintah")
	@POST
	public HargaPemerintah updateHargaPemerintah(
			@FormParam("id")int id,
			@FormParam("komoditas")Integer komoditas,
			@FormParam("tglBuat")String tglBuat,
			@FormParam("harga")Double harga,
			@FormParam("lokasi")Integer lokasi,
			@FormParam("satuan")Integer satuan,
			@FormParam("kuantitas")Integer kuantitas){
		HargaPemerintah hrg = hargaPemerintahSession.find(id);	
		try{
		hrg.setKomoditas(komoditasSession.find(komoditas));
		hrg.setTglBuat(format.parse(tglBuat));
		hrg.setHarga(harga);
		hrg.setLokasi(lokasiSession.find(lokasi));
		hrg.setSatuan(satuanSession.find(satuan));
		hrg.setKuantitas(kuantitas);
		hargaPemerintahSession.updateHargaPemerintah(hrg);
		}catch(ParseException e){
			e.printStackTrace();
		}
		return hrg;
	}
	
	@Path("/deleteRowHargaPemerintah/{id}")
	@GET
	public HargaPemerintah deleteRowHargaPemerintah(@PathParam("id")int id){
		return hargaPemerintahSession.deleteRowHargaPemerintah(id);
	}
}
