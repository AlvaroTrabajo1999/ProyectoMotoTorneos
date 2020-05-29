package modelo.dao;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.EditarMapper;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;
import modelo.pojo.Usuario;

public class EditarDao {
	
	/**
	 * Modifica la moto que se le pasa en la base de datos
	 * @param moto : moto a modificar
	 */
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
	
	/**
	 * Modifica el piloto que se le pasa
	 * @param piloto : piloto a modificar
	 */
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
	
	/**
	 * Modifica el circuito que se le pasa
	 * @param circuito : circuito a modificar
	 */
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
	
	
	public void updateUsuario(Usuario usuario) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EditarMapper maper = sqlSession.getMapper(EditarMapper.class);
			maper.updateUsuario(usuario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	
	public void ganadorCarrera(int participacion, int carrera) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EditarMapper maper = sqlSession.getMapper(EditarMapper.class);
			maper.ganadorCarrera(participacion, carrera);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * Borra un torneo mediante su identificador
	 * @param torneo : identificador del torneo
	 */
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
