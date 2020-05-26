package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.MultimediaMapper;
import modelo.pojo.MultimediaCircuito;
import modelo.pojo.MultimediaMotocicleta;
import modelo.pojo.MultimediaPiloto;

public class MultimediaDao {
	
	/**
	 * obtiene toda la multimedia de los circuitos y lo guarda en un array list
	 * @return
	 */
	public ArrayList<MultimediaCircuito> getMultimediaCircuitos(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			MultimediaMapper maper = sqlSession.getMapper(MultimediaMapper.class);
			return maper.getMultimediaCircuitos();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * obtiene toda la multimedia de las motocicletas y lo guarda en un array list
	 * @return
	 */
	public ArrayList<MultimediaMotocicleta> getMultimediaMotocicletas(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			MultimediaMapper maper = sqlSession.getMapper(MultimediaMapper.class);
			return maper.getMultimediaMotocicletas();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * obtiene toda la multimedia de los pilotos y lo guarda en un array list
	 * @return
	 */
	public ArrayList<MultimediaPiloto> getMultimediaPilotos(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			MultimediaMapper maper = sqlSession.getMapper(MultimediaMapper.class);
			return maper.getMultimediaPilotos();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * obtiene toda la multimedia de los pilotos filtrando por id de piloto
	 * @return
	 */
	public MultimediaPiloto getMultimediaPilotoById(String piloto){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			MultimediaMapper maper = sqlSession.getMapper(MultimediaMapper.class);
			return maper.getMultimediaPilotoById(piloto);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * obtiene toda la multimedia de los circuitos filtrando por id del circuito
	 * @return
	 */
	public MultimediaCircuito getMultimediaCircuitoById(int circuito){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			MultimediaMapper maper = sqlSession.getMapper(MultimediaMapper.class);
			return maper.getMultimediaCircuitoById(circuito);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * obtiene toda la multimedia de las moto filtrando por id de piloto
	 * @return
	 */
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
