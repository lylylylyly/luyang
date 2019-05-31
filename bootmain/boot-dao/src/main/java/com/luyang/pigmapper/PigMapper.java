package com.luyang.pigmapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.luyang.pigbean.PigBean;

@Mapper
public interface PigMapper {
	@Select("select * from pig where id=#{id}")
	PigBean getOne(int id);
	
	@Update("update pig set name=#{name},name1=#{name1} where id=#{id}")
	void changeOne(PigBean pig);
	
	@Insert("insert into pig(name) values(#{name})")
	void addOne(PigBean pig);
}
