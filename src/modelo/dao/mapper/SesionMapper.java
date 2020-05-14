package modelo.dao.mapper;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.Usuario;

public interface SesionMapper {
	
	public Usuario getUsuarioByUser(@Param("nombreUsuario") String user);
	
	public Integer registerUsuario(@Param("usu") Usuario usu);
	
	public Usuario existsUsuario(@Param("usu") String usu, @Param("cont") String cont);
}
