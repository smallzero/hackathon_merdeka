package id.co.pakupang.security;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import id.co.pakupang.entity.Token;
import id.co.pakupang.entity.User;
import id.co.pakupang.entity.UserToken;
import id.co.pakupang.utils.AbstractFacade;
import id.co.pakupang.utils.MD5Hashing;

@Stateless
@LocalBean
public class UserSession extends AbstractFacade<User> {
	@PersistenceContext
	private EntityManager em;
	
	@EJB
	TokenSession tokenSession;	
	
	static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
	
	public UserSession() {
		super(User.class);
	}
	
	public User getLogOut(String token){
		Token t = tokenSession.findByToken(token);
		t.setLogout(new Date());
		tokenSession.edit(t);
		return t.getUser();
	}
	
	public UserToken getAuthentification(String username, String password){
		UserToken userToken = null;
		
		Query q = em.createNamedQuery("User.findByUsername").setParameter("username", username);
		List<User> listUser = q.getResultList();
		if(listUser.size()>0){
			User user = (User) listUser.get(0);
			if(user.getPassword().equals(MD5Hashing.getMD5Hashing(password))){
				Token token = new Token();
				token.setUser(user);
				Date d = new Date();
				token.setCreated(d);
				token.setToken(MD5Hashing.getMD5Hashing(user.getUsername()+d.getTime()));
				token.setTimeout(new Date(d.getTime()+(30*ONE_MINUTE_IN_MILLIS)));
				token.setLogout(null);
				tokenSession.create(token);	
				
				userToken = new UserToken();
				userToken.setToken(MD5Hashing.getMD5Hashing(user.getUsername()+d.getTime()));
				userToken.setUser(user);
			}
		}
		return userToken;
	}
	
	public Token getAuthentification(String token){
		return tokenSession.getAuthentification(token);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
