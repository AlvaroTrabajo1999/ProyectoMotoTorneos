package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.MultimediaMapper;
import modelo.pojo.MultimediaCircuito;
import modelo.pojo.MultimediaMotocicleta;
import modelo.pojo.MultimediaPiloto;

public class MultimediaDao {
	
	public ArrayList<MultimediaCircuito> getMultimediaCircuitos(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			MultimediaMapper maper = sqlSession.getMapper(MultimediaMapper.class);
			return maper.getMultimediaCircuitos();
		} finally {
			sqlSession.close();
		}
	}
	
	public ArrayList<MultimediaMotocicleta> getMultimediaMotocicletas(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			MultimediaMapper maper = sqlSession.getMapper(MultimediaMapper.class);
			return maper.getMultimediaMotocicletas();
		} finally {
			sqlSession.close();
		}
	}
	
	public ArrayList<MultimediaPiloto> getMultimediaPilotos(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			MultimediaMapper maper = sqlSession.getMapper(MultimediaMapper.class);
			return maper.getMultimediaPilotos();
		} finally {
			sqlSession.close();
		}
	}
	
	public MultimediaPiloto getMultimediaPilotoById(String piloto){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			MultimediaMapper maper = sqlSession.getMapper(MultimediaMapper.class);
			return maper.getMultimediaPilotoById(piloto);
		} finally {
			sqlSession.close();
		}
	}
	
	public MultimediaCircuito getMultimediaCircuitoById(String circuito){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			MultimediaMapper maper = sqlSession.getMapper(MultimediaMapper.class);
			return maper.getMultimediaCircuitoById(circuito);
		} finally {
			sqlSession.close();
		}
	}
	
	public MultimediaMotocicleta getMultimediaMotocicletasById(String moto){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			MultimediaMapper maper = sqlSession.getMapper(MultimediaMapper.class);
			return maper.getMultimediaMotocicletasById(moto);
		} finally {
			sqlSession.close();
		}
	}
}
