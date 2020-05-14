package modelo.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import modelo.dao.SesionDao;
import modelo.pojo.Usuario;


@Stateless
@LocalBean
public class SesionEJB {

	public Usuario usuarioLogeado(HttpSession session) {
		Usuario usuario = null;
		if (session != null) {
			usuario = (Usuario) session.getAttribute("usuario");
		}
		return usuario;
	}

	public void logoutUsuario(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
	}
	
	public Usuario existsUsuario(String usu, String cont) {
		SesionDao dao = new SesionDao();
		return dao.existsUsuario(usu, cont);
	}
	
	public void registerUsuario(Usuario usu) {
		SesionDao dao = new SesionDao();
		dao.registerUsuario(usu);;
	}
	
	public Usuario getUsuarioByUser(String user){
		SesionDao dao = new SesionDao();
		return dao.getUsuarioByUser(user);
	}
	
}
