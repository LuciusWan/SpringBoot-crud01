package com.test.springbootproject01.mapper;

import com.test.springbootproject01.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select count(*) from springboottest.emp")
    public Long count();
    /*@Select("select * from springboottest.emp limit #{page},#{pageSize}")*/
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);
    public int delete(Integer [] ids);
    public int insert(Emp emp);
    public int update(Emp emp);
    public Emp selectId(Integer id);
    public Emp login(Emp emp);
    public void deleteByDeptId(Integer id);
}
