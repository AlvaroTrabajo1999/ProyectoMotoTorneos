package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.RecordsMapper;
import modelo.pojo.Circuito;
import modelo.pojo.MejoresVueltasRecord;
import modelo.pojo.MultimediaCircuito;

public class RecordsDao {

	public MultimediaCircuito getMultimediaCircuitoById( int idCircuito){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			RecordsMapper maper = sqlSession.getMapper(RecordsMapper.class);
			return maper.getMultimediaCircuitoById(idCircuito);
		} finally {
			sqlSession.close();
		}
	}
	
	public Circuito getCircuitoById( int idCircuito){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			RecordsMapper maper = sqlSession.getMapper(RecordsMapper.class);
			return maper.getCircuitoById(idCircuito);
		} finally {
			sqlSession.close();
		}
	}
	
	public ArrayList<MejoresVueltasRecord> getMejoresVueltasRecords(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			RecordsMapper maper = sqlSession.getMapper(RecordsMapper.class);
			return maper.getMejoresVueltasRecords();
		} finally {
			sqlSession.close();
		}
	}
	
}
