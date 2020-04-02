package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import modelo.dao.mapper.BaseMapper;
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
	
}
