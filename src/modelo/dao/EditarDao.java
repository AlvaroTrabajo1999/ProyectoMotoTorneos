package modelo.dao;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.EditarMapper;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;

public class EditarDao {
	
	public void updateMoto(Motocicleta moto) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EditarMapper maper = sqlSession.getMapper(EditarMapper.class);
			maper.updateMoto(moto);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void updatePiloto(Piloto piloto) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EditarMapper maper = sqlSession.getMapper(EditarMapper.class);
			maper.updatePiloto(piloto);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void updateCircuito(Circuito circuito) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EditarMapper maper = sqlSession.getMapper(EditarMapper.class);
			maper.updateCircuito(circuito);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void borrarTorneo(int torneo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EditarMapper maper = sqlSession.getMapper(EditarMapper.class);
			maper.borrarTorneo(torneo);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
}
