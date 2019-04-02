package id.co.pakupang.security;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import id.co.pakupang.entity.Token;
import id.co.pakupang.utils.AbstractFacade;

@LocalBean
@Stateless
public class TokenSession extends AbstractFacade<Token> {
	@PersistenceContext
	private EntityManager em;

	static final long ONE_MINUTE_IN_MILLIS = 60000;// millisecs

	public TokenSession() {
		super(Token.class);
	}

	public Token findByToken(String token) {
		Query q = em.createNamedQuery("Token.findByToken").setParameter(
				"token", token);
		return (Token) q.getSingleResult();
	}

	public Token getAuthentification(String strToken) {
		Query q = em.createNamedQuery("Token.findByToken").setParameter(
				"token", strToken);
		try {
			Token token = (Token) q.getSingleResult();
			Date date = new Date();
			if (date.getTime() > token.getTimeout().getTime()) {
				token.setLogout(date);
				super.edit(token);
				return null;
			} else if (token.getLogout() != null) {
				return null;
			} else {
				token.setTimeout(new Date(date.getTime()
						+ (30 * ONE_MINUTE_IN_MILLIS)));
				return token;
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
