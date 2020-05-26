package modelo.dao;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.AnadirMapper;
import modelo.pojo.Carrera;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Participacion;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;

public class AnadirDao {

	/**
	 * inserta en la base de datos el participante proporcionado
	 * @param part : participante proporcionado
	 */
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
	
	/**
	 * inserta en la base de datos una motocicleta
	 * @param moto : motocicleta que se desea añadir a la base de datos
	 */
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
	
	/**
	 * inserta en la base de datos un piloto
	 * @param pilot : piloto a insertar
	 */
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
	
	/**
	 * inserta un circuito en la base de datos
	 * @param circuito : circuito que se desea insertar 
	 */
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
	
	/**
	 * inserta un torneo en la base de datos
	 * @param torneo : torneo que se desea insertar
	 */
	public void insertTorneo(Torneo torneo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnadirMapper maper = sqlSession.getMapper(AnadirMapper.class);
			maper.insertTorneo(torneo);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * inserta en una carrera en la base de datos
	 * @param carrera : carrera que se desea insertar
	 */
	public void insertCarrera(Carrera carrera) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnadirMapper maper = sqlSession.getMapper(AnadirMapper.class);
			maper.insertCarrera(carrera);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * inserta una participacion en la base de datos
	 * @param participacion : participacion que se desea insertar
	 */
	public void insertParticipacion(Participacion participacion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnadirMapper maper = sqlSession.getMapper(AnadirMapper.class);
			maper.insertParticipacion(participacion);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
