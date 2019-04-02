package id.co.pakupang.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@NamedQueries({
    @NamedQuery(name="LaporKecurangan.find",
            query="SELECT st FROM Satuan st")
})

@Table(name = "LAPOR_KECURANGAN")
@TableGenerator(name = "tableSequence", table = "PAKOPANG_SEQUENCE", pkColumnName = "TABLE_SEQ_NAME", valueColumnName = "TABLE_SEQ_VALUE", 
	pkColumnValue = "LAPOR_KECURANGAN", initialValue = 1, allocationSize = 1)
public class LaporKecurangan {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableSequence")
	@Column(name = "LAPOR_KECURANGAN_ID")
	private Integer id;
	
	@Column(name = "SUBJEK")
	private String subjek;
	
	@Column(name = "DESKRIPSI")
	private String deskripsi;
	
	@Column(name = "LOKASI")
	private String lokasi;
	
	@Column(name = "LATITUDE")
	private String latitude;
	
	@Column(name = "LONGITUDE")
	private String longitude;
	
	@Column(name = "TGLLAPOR")
	private Date tglLapor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubjek() {
		return subjek;
	}

	public void setSubjek(String subjek) {
		this.subjek = subjek;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getLokasi() {
		return lokasi;
	}

	public void setLokasi(String lokasi) {
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

	public Date getTglLapor() {
		return tglLapor;
	}

	public void setTglLapor(Date tglLapor) {
		this.tglLapor = tglLapor;
	}

	
}
