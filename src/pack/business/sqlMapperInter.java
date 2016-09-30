package pack.business;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface sqlMapperInter { // sql을 메소드에 메핑
	@Select("select * from membertab")
	public List<DataDto> selectDataAll();
	
	@Select("select * from membertab where id=#{id}")
	public DataDto selectDataById(String id);
	
	@Insert("insert into membertab values(#{id},#{name},#{password},now())")
	public int insertData(DataDto dto);
	
	@Update("update sangdata set name=#{name} where id=#{id}")
	public int updateData(DataDto dto);
	
	@Delete("delete from membertab where id = #{id}")
	public int deleteData(String id);
}
