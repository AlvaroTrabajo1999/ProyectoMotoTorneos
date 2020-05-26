package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.BaseMapper;
import modelo.pojo.Carrera;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;
import modelo.pojo.Usuario;

public class BaseDao {

	/**
	 * saca de la base de datos un array list con todos los torneos
	 * @return
	 */
	public ArrayList<Torneo> getTorneos(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getTorneos();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * saca todas las motocicletas de la base de datos en forma de array list
	 * @return
	 */
	public ArrayList<Motocicleta> getMotocicletas(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getMotocicletas();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * saca todos los pilotos de la base de datos en forma de array list
	 * @return
	 */
	public ArrayList<Piloto> getPilotos(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getPilotos();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * saca todos los circuitos de la base de datos en forma de arraylist 
	 * @return
	 */
	public ArrayList<Circuito> getCircuito(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getCircuito();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * saca la moto a la que le pertence la matricula
	 * @param matricula : matricula de la moto que se desea obtener
	 * @return
	 */
	public Motocicleta getMotocicletaFromMatricula(String matricula){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getMotocicletaFromMatricula(matricula);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * saca al piloto al que le pertence el dni
	 * @param dni : dni del piloto que se desea obtener
	 * @return
	 */
	public Piloto getPilotoFromDni(String dni){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getPilotoFromDni(dni);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * saca un circuito por medio de su id
	 * @param circuito : identificador del circuito
	 * @return
	 */
	public Circuito getCircuitoFromId(int circuito){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getCircuitoFromId(circuito);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * Saca al usuario a quien le pertenezzca la id 
	 * @param id : id del usuario deseado
	 * @return
	 */
	public Usuario getUsuario(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getUsuario(id);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * Obtiene el torneo mediante el nombre de este
	 * @param nombre : nombre del torneo 
	 * @return
	 */
	public Torneo getTorneoByName(String nombre){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getTorneoByName(nombre);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * saca el torneo mediante su identificador
	 * @param id : identificador del torneo
	 * @return
	 */
	public Torneo getTorneoById(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getTorneoById(id);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * toma todas las carreras que pertenecen a un torneo
	 * @param torneo : identificador del torneo
	 * @return
	 */
	public ArrayList<Carrera> getCarrerasByTorneo(int torneo){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getCarrerasByTorneo(torneo);
		} finally {
			sqlSession.close();
		}
	}
}
