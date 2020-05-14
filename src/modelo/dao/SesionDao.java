package modelo.dao;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.SesionMapper;
import modelo.pojo.Usuario;

public class SesionDao {
	
	public Usuario getUsuarioByUser(String user){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			SesionMapper maper = sqlSession.getMapper(SesionMapper.class);
			return maper.getUsuarioByUser(user);
		} finally {
			sqlSession.close();
		}
	}
	
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
