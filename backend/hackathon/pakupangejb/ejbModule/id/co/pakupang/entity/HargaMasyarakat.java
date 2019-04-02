package id.co.pakupang.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@NamedQueries({
    @NamedQuery(name="HargaMasyarakat.find",
            query="SELECT hrgm FROM HargaMasyarakat hrgm"),
    @NamedQuery(name="HargaMasyarakat.findByKomoditas",
            query="SELECT hrgm FROM HargaMasyarakat hrgm WHERE hrgm.komoditas.id =:komoditasId")
})

@Table(name = "HARGA_MASYARAKAT")
@TableGenerator(name = "tableSequence", table = "PAKOPANG_SEQUENCE", pkColumnName = "TABLE_SEQ_NAME", valueColumnName = "TABLE_SEQ_VALUE", 
	pkColumnValue = "HARGA_MASYARAKAT", initialValue = 1, allocationSize = 1)
public class HargaMasyarakat {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableSequence")
	@Column(name = "HARGA_MASYARAKAT_ID")
	private Integer id;
	
	@Column(name = "JENIS_PUSAT_KOMODITAS")
	private String jnsPusatKomoditas;
	
	@ManyToOne
	@JoinColumn(name = "KOMODITAS_ID", referencedColumnName = "KOMODITAS_ID")
	private Komoditas komoditas;
	
	@Column(name = "HARGA")
	private Double harga;
	
	@Column(name = "PERSATUAN")
	private String perSatuan;
	
	@Column(name = "TGL_BUAT")
	private Date tglBuat;
	
	@Column(name = "STOK")
	private Double stok;
	
	@ManyToOne
	@JoinColumn(name = "SATUAN_ID", referencedColumnName = "SATUAN_ID")
	private Satuan satuan;
	
	@OneToOne
	@JoinColumn(name = "LOKASI_ID", referencedColumnName = "LOKASI_ID")
	private Lokasi lokasi;
	
	@Column(name = "LATITUDE")
	private String latitude;
	
	@Column(name = "LONGITUDE")
	private String longitude;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJnsPusatKomoditas() {
		return jnsPusatKomoditas;
	}

	public void setJnsPusatKomoditas(String jnsPusatKomoditas) {
		this.jnsPusatKomoditas = jnsPusatKomoditas;
	}

	public Komoditas getKomoditas() {
		return komoditas;
	}

	public void setKomoditas(Komoditas komoditas) {
		this.komoditas = komoditas;
	}

	public Double getHarga() {
		return harga;
	}

	public void setHarga(Double harga) {
		this.harga = harga;
	}

	public String getPerSatuan() {
		return perSatuan;
	}

	public void setPerSatuan(String perSatuan) {
		this.perSatuan = perSatuan;
	}

	public Date getTglBuat() {
		return tglBuat;
	}

	public void setTglBuat(Date tglBuat) {
		this.tglBuat = tglBuat;
	}

	public Double getStok() {
		return stok;
	}

	public void setStok(Double stok) {
		this.stok = stok;
	}

	public Satuan getSatuan() {
		return satuan;
	}

	public void setSatuan(Satuan satuan) {
		this.satuan = satuan;
	}

	public Lokasi getLokasi() {
		return lokasi;
	}

	public void setLokasi(Lokasi lokasi) {
		this.lokasi = lokasi;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	
}
