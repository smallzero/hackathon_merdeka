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
@Table(name = "PROMISE_T1_USER")
@TableGenerator( name = "tableSequence", table = "PROMISE_SEQUENCE", pkColumnName = "TABLE_SEQ_NAME", valueColumnName = "TABLE_SEQ_VALUE", 
pkColumnValue = "PROMISE_T1_USER", initialValue = 1, allocationSize = 1 )
@NamedQueries({
    @NamedQuery(name="User.findByUsername",
                query="SELECT user FROM User user WHERE user.username = :username")
})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableSequence")
	@Column(name = "USER_ID")
	private Integer id;
	
	@Column(name = "USERNAME", length=50)
	private String username;
	
	@Column(name = "PASSWORD", length=100)
	private String password;

	@Column(name = "EMAIL", length = 100)
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
