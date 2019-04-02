package id.co.pakupang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@NamedQueries({
    @NamedQuery(name="Pasar.find",
            query="SELECT ps FROM Pasar ps"),
    @NamedQuery(name="Pasar.findByLokasi",
            query="SELECT ps FROM Pasar ps WHERE ps.lokasi.id=:lokasiId")        
})

@Table(name = "PASAR")
@TableGenerator(name = "tableSequence", table = "PAKOPANG_SEQUENCE", pkColumnName = "TABLE_SEQ_NAME", valueColumnName = "TABLE_SEQ_VALUE", 
	pkColumnValue = "PASAR", initialValue = 1, allocationSize = 1)
public class Pasar {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableSequence")
	@Column(name = "PASAR_ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "LOKASI_ID", referencedColumnName = "LOKASI_ID")
	private Lokasi lokasi;
	
	@Column( name = "NAMA")
	private String nama;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Lokasi getLokasi() {
		return lokasi;
	}

	public void setLokasi(Lokasi lokasi) {
		this.lokasi = lokasi;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	
}
