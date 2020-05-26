package modelo.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import modelo.dao.SesionDao;
import modelo.pojo.Usuario;


@Stateless
@LocalBean
public class SesionEJB {
	
	/**
	 * obtiene un usuario actualmente logueado
	 * @param session
	 * @return
	 */
	public Usuario usuarioLogeado(HttpSession session) {
		Usuario usuario = null;
		if (session != null) {
			usuario = (Usuario) session.getAttribute("usuario");
		}
		return usuario;
	}

	/**
	 * cierra la sesion de un usuario logueado
	 * @param session
	 */
	public void logoutUsuario(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
	}
	
	/**
	 * comprueba la existencia de un usuario mediante su nombre y contraseña
	 * @param usu : nombre del usuario
	 * @param cont : contraseña del usuario
	 * @return
	 */
	public Usuario existsUsuario(String usu, String cont) {
		SesionDao dao = new SesionDao();
		return dao.existsUsuario(usu, cont);
	}
	
	/**
	 * insera un usuario en la base de datos
	 * @param usu : usuario a insertar
	 */
	public void registerUsuario(Usuario usu) {
		SesionDao dao = new SesionDao();
		dao.registerUsuario(usu);;
	}
	
	/**
	 * obtiene un usuario mediante su nombre de usuario
	 * @param user : nombre de usuario
	 * @return
	 */
	public Usuario getUsuarioByUser(String user){
		SesionDao dao = new SesionDao();
		return dao.getUsuarioByUser(user);
	}
	
	/**
	 * mete en sesion el usuario seleccionado
	 * @param session : usuario que incia sesion
	 * @param usuario
	 */
	public void loginUsuario(HttpSession session, Usuario usuario) {
		if (session != null) {
			session.setAttribute("usuario", usuario);
		}
	}
}
