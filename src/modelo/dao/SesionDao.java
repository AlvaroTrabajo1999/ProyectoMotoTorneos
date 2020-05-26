package modelo.dao;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.SesionMapper;
import modelo.pojo.Usuario;

public class SesionDao {
	
	/**
	 * obtiene un usuario mediante su nombre de usuario
	 * @param user : nombre de usuario
	 * @return
	 */
	public Usuario getUsuarioByUser(String user){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			SesionMapper maper = sqlSession.getMapper(SesionMapper.class);
			return maper.getUsuarioByUser(user);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * insera un usuario en la base de datos
	 * @param usu : usuario a insertar
	 */
	public void registerUsuario(Usuario usu) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			SesionMapper maper = sqlSession.getMapper(SesionMapper.class);
			maper.registerUsuario(usu);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * comprueba la existencia de un usuario mediante su nombre y contraseña
	 * @param usu : nombre del usuario
	 * @param cont : contraseña del usuario
	 * @return
	 */
	public Usuario existsUsuario(String usu, String cont) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			SesionMapper maper = sqlSession.getMapper(SesionMapper.class);
			return maper.existsUsuario(usu, cont);
		} finally {
			sqlSession.close();
		}
	}
}
