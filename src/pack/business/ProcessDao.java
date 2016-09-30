package pack.business;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pack.mybatis.SqlMapConfig;

public class ProcessDao {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List selectDataAll(){
		SqlSession sqlsession = factory.openSession();
		List list = null;
		
		try {
			sqlMapperInter inter = (sqlMapperInter)sqlsession.getMapper(sqlMapperInter.class);
			list = inter.selectDataAll();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(sqlsession != null) sqlsession.close();
		}
		
		return list;
	}
	
	public DataDto selectdataById(String id){
	
			SqlSession sqlsession = factory.openSession();
			DataDto dto = null;
			
			try {
				sqlMapperInter inter = (sqlMapperInter)sqlsession.getMapper(sqlMapperInter.class);
				dto = (DataDto) inter.selectDataById(id);
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				if(sqlsession != null) sqlsession.close();
			}
			
			return dto;
		}
		
	public boolean insertData(DataDto dto){
		boolean b = false;
		SqlSession sqlsession = factory.openSession();
		try {
			sqlMapperInter inter = (sqlMapperInter)sqlsession.getMapper(sqlMapperInter.class);
			if(inter.insertData(dto) > 0) b = true;
			sqlsession.commit();
		} catch (Exception e) {
			
		}finally {
			if(sqlsession != null) sqlsession.close();
		}
		return b;
	}
	
	public boolean updateData(DataDto dto){
		boolean b = false;
		SqlSession sqlsession = factory.openSession();
		try {
			sqlMapperInter inter = (sqlMapperInter)sqlsession.getMapper(sqlMapperInter.class);
			//비번비교
			DataDto dto2 = inter.selectDataById(dto.getId());
			if(dto2.isCheckPasswd(dto.getPassword()) == false){
				return b;
			}
			if(inter.updateData(dto) > 0) b = true;
			sqlsession.commit();
		} catch (Exception e) {
			sqlsession.rollback();
		}finally {
			if(sqlsession != null) sqlsession.close();
		}
		return b;
	}

	
	public boolean deleteData(String id){
		boolean b = false;
		SqlSession sqlsession = factory.openSession();
		try {
			sqlMapperInter inter = (sqlMapperInter)sqlsession.getMapper(sqlMapperInter.class);
			if(inter.deleteData(id) > 0) b = true;
			sqlsession.commit();
		} catch (Exception e) {
			sqlsession.rollback();
		}finally {
			if(sqlsession != null) sqlsession.close();
		}
		return b;
	}
	
}
