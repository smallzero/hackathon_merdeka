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
    @NamedQuery(name="HargaPemerintah.find",
            query="SELECT hrg FROM HargaPemerintah hrg"),
    @NamedQuery(name="HargaPemerintah.findByKomoditas",
            query="SELECT hrg FROM HargaPemerintah hrg WHERE hrg.komoditas.id=:komoditasId"),
    @NamedQuery(name="HargaPemerintah.findByProvinsi",
            query="SELECT hrg FROM HargaPemerintah hrg WHERE hrg.lokasi.id=:lokasiId") 
})
@Table(name = "HARGA_PEMERINTAH")
@TableGenerator(name = "tableSequence", table = "PAKOPANG_SEQUENCE", pkColumnName = "TABLE_SEQ_NAME", valueColumnName = "TABLE_SEQ_VALUE", 
	pkColumnValue = "HARGA_PEMERINTAH", initialValue = 1, allocationSize = 1)
public class HargaPemerintah {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableSequence")
	@Column(name = "HARGA_PEMERINTAH_ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "KOMODITAS_ID", referencedColumnName = "KOMODITAS_ID")
	private Komoditas komoditas;
	
	@Column(name = "TGL_BUAT")
	private Date tglBuat;
	
	@Column(name = "HARGA")
	private Double harga;
	
	@ManyToOne
	@JoinColumn(name = "LOKASI_ID", referencedColumnName = "LOKASI_ID")
	private Lokasi lokasi;
	
	@OneToOne
	@JoinColumn(name = "SATUAN_ID", referencedColumnName = "SATUAN_ID")
	private Satuan satuan;
	
	@Column(name = "KUANTITAS")
	private Integer kuantitas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Komoditas getKomoditas() {
		return komoditas;
	}

	public void setKomoditas(Komoditas komoditas) {
		this.komoditas = komoditas;
	}

	public Date getTglBuat() {
		return tglBuat;
	}

	public void setTglBuat(Date tglBuat) {
		this.tglBuat = tglBuat;
	}

	public Double getHarga() {
		return harga;
	}

	public void setHarga(Double harga) {
		this.harga = harga;
	}

	public Lokasi getLokasi() {
		return lokasi;
	}

	public void setLokasi(Lokasi lokasi) {
		this.lokasi = lokasi;
	}

	public Satuan getSatuan() {
		return satuan;
	}

	public void setSatuan(Satuan satuan) {
		this.satuan = satuan;
	}

	public Integer getKuantitas() {
		return kuantitas;
	}

	public void setKuantitas(Integer kuantitas) {
		this.kuantitas = kuantitas;
	}

	
}
