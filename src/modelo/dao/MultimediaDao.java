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
}
