package modelo.dao.mapper;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.Usuario;

public interface SesionMapper {
	
	/**
	 * obtiene un usuario mediante su nombre de usuario
	 * @param user : nombre de usuario
	 * @return
	 */
	public Usuario getUsuarioByUser(@Param("nombreUsuario") String user);

	/**
	 * insera un usuario en la base de datos
	 * @param usu : usuario a insertar
	 */
	public Integer registerUsuario(@Param("usu") Usuario usu);
	
	/**
	 * comprueba la existencia de un usuario mediante su nombre y contraseña
	 * @param usu : nombre del usuario
	 * @param cont : contraseña del usuario
	 * @return
	 */
	public Usuario existsUsuario(@Param("usu") String usu, @Param("cont") String cont);
}
