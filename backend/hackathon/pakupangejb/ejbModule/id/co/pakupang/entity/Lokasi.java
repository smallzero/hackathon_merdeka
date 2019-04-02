package id.co.pakupang.entity;

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
    @NamedQuery(name="Lokasi.find",
            query="SELECT lk FROM Lokasi lk"),
    @NamedQuery(name="Lokasi.findByNama",
    query="SELECT lk FROM Lokasi lk WHERE lk.nama like :nama")
})

@Table(name = "LOKASI")
@TableGenerator(name = "tableSequence", table = "PAKOPANG_SEQUENCE", pkColumnName = "TABLE_SEQ_NAME", valueColumnName = "TABLE_SEQ_VALUE", 
	pkColumnValue = "LOKASI", initialValue = 1, allocationSize = 1)
public class Lokasi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableSequence")
	@Column(name = "LOKASI_ID")
	private Integer id;
	
	@Column(name = "PARENT_ID")
	private Integer parentId;
	
	@Column(name = "NAMA")
	private String nama;
	
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
	
}
