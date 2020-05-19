package modelo.dao;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.AnadirMapper;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Participacion;
import modelo.pojo.Piloto;

public class AnadirDao {

	public void insertParticipante(Participacion part) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnadirMapper maper = sqlSession.getMapper(AnadirMapper.class);
			maper.insertParticipante(part);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertMotocicleta(Motocicleta moto) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnadirMapper maper = sqlSession.getMapper(AnadirMapper.class);
			maper.insertMotocicleta(moto);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertPiloto(Piloto pilot) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnadirMapper maper = sqlSession.getMapper(AnadirMapper.class);
			maper.insertPiloto(pilot);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertCircuito(Circuito circuito) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnadirMapper maper = sqlSession.getMapper(AnadirMapper.class);
			maper.insertCircuito(circuito);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
