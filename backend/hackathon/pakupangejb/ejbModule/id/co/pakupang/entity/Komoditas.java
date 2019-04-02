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
    @NamedQuery(name="Komoditas.find",
            query="SELECT kom FROM Komoditas kom"),
    @NamedQuery(name="Komoditas.findByNama",
            query="SELECT kom FROM Komoditas kom WHERE kom.nama like :nama")
})

@Table(name = "KOMODITAS")
@TableGenerator(name = "tableSequence", table = "PAKOPANG_SEQUENCE", pkColumnName = "TABLE_SEQ_NAME", valueColumnName = "TABLE_SEQ_VALUE", 
	pkColumnValue = "KOMODITAS", initialValue = 1, allocationSize = 1)
public class Komoditas {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableSequence")
	@Column(name = "KOMODITAS_ID")
	private Integer id;
	
	@Column(name = "PARENT_ID")
	private Integer parentId;
	
	@Column(name = "NAMA")
	private String nama;

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
	
}
