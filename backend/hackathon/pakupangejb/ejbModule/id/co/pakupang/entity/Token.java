package id.co.pakupang.entity;

import java.util.Date;

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
@Table(name = "PROMISE_T2_TOKEN")
@TableGenerator( name = "tableSequence", table = "PROMISE_SEQUENCE", pkColumnName = "TABLE_SEQ_NAME", 
	valueColumnName = "TABLE_SEQ_VALUE", pkColumnValue = "PROMISE_T2_TOKEN", initialValue = 1, allocationSize = 1 )
@NamedQueries({
	@NamedQuery(name="Token.findByToken",
    		query="SELECT t FROM Token t WHERE t.token = :token")
})
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableSequence")
	@Column(name = "TOKEN_ID")
	private Integer id;
	
	@Column(name="TOKEN")
	private String token;
	
	@Column(name="CREATED")
	private Date created;
	
	@Column(name="TIMEOUT")
	private Date timeout;
	
	@Column(name="LOGOUT")
	private Date logout;

	@OneToOne
	@JoinColumn(name ="USER_ID", referencedColumnName = "USER_ID")
	private User user;
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getLogout() {
		return logout;
	}

	public void setLogout(Date logout) {
		this.logout = logout;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTimeout() {
		return timeout;
	}

	public void setTimeout(Date timeout) {
		this.timeout = timeout;
	}
	
	
	
}
