package modelo.dao;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.RecordsMapper;
import modelo.pojo.MejorVueltaCircuito;

public class RecordsDao {

	public MejorVueltaCircuito getMejorVueltaCircuitoById(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			RecordsMapper maper = sqlSession.getMapper(RecordsMapper.class);
			return maper.getMejorVueltaCircuitoById(id);
		} finally {
			sqlSession.close();
		}
	}
	
}
