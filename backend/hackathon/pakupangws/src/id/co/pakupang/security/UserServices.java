/*package id.co.pakupang.security;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.logging.Logger;

import id.co.pakupang.security.UserSession;
import id.co.promise.procurement.entity.Token;
import id.co.promise.procurement.entity.User;
import id.co.promise.procurement.entity.UserToken;

@Stateless
@Path(value = "/procurement/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserServices {
	final static Logger logger = Logger.getLogger(UserServices.class);
	
	@EJB
	UserSession userSession;
	
	@Path("/getLogOut/{token}")
	@GET
	public User getLogOut(@PathParam("token")String token){
		Token tokenObj = userSession.getAuthentification(token);
		tokenObj.getUser().getId();
		return userSession.getLogOut(token);
	}

	@Path(value = "/getAuthentification")
	@POST
	public UserToken getAuthentification(@FormParam("username") String username,
			@FormParam("password") String password,
			@Context HttpServletRequest request) {

		UserToken user = userSession.getAuthentification(username, password);
		if(user == null){
			logger.error("{status_login : Failed, username : "+username+", url : /user/getAuthentification}");
			return null;
		} else {
			logger.info("{status_login : Success, user :" + user.getUser().getUsername()
					+ ", message : Login, url : /user/getAuthentification}");
			return user;
		}
	}
}
*/