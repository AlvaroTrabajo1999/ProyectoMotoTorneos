package modelo.dao;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.RecordsMapper;
import modelo.pojo.MejorVueltaCircuito;

public class RecordsDao {
	
	/**
	 * obtenemos la mejor vuelta de un circuito mediante su identificador
	 * @param id : identificador del circuito
	 * @return
	 */
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
