package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.BaseMapper;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;

public class BaseDao {

	public ArrayList<Torneo> getTorneos(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getTorneos();
		} finally {
			sqlSession.close();
		}
	}
	
	public ArrayList<Motocicleta> getMotocicletas(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getMotocicletas();
		} finally {
			sqlSession.close();
		}
	}
	
	public ArrayList<Piloto> getPilotos(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getPilotos();
		} finally {
			sqlSession.close();
		}
	}
	
	public ArrayList<Circuito> getCircuito(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getCircuito();
		} finally {
			sqlSession.close();
		}
	}
	
	public Motocicleta getMotocicletaFromMatricula(String matricula){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getMotocicletaFromMatricula(matricula);
		} finally {
			sqlSession.close();
		}
	}
  
	public Piloto getPilotoFromDni(String dni){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getPilotoFromDni(dni);
		} finally {
			sqlSession.close();
		}
	}
	
	public Circuito getCircuitoFromId(String circuito){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			BaseMapper maper = sqlSession.getMapper(BaseMapper.class);
			return maper.getCircuitoFromId(circuito);
		} finally {
			sqlSession.close();
		}
	}

}
