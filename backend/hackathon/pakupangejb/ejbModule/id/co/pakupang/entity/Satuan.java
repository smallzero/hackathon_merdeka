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
    @NamedQuery(name="Satuan.find",
            query="SELECT st FROM Satuan st"),
    @NamedQuery(name="Satuan.findByNama",
            query="SELECT st FROM Satuan st WHERE st.nama like :nama")
})

@Table(name = "SATUAN")
@TableGenerator(name = "tableSequence", table = "PAKOPANG_SEQUENCE", pkColumnName = "TABLE_SEQ_NAME", valueColumnName = "TABLE_SEQ_VALUE", 
	pkColumnValue = "SATUAN", initialValue = 1, allocationSize = 1)
public class Satuan {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableSequence")
	@Column(name = "SATUAN_ID")
	private Integer id;
	
	@Column(name = "NAMA")
	private String nama;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	
	
}
