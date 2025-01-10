package com.test.springbootproject01.mapper;

import com.test.springbootproject01.pojo.Dept;
import com.test.springbootproject01.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
/*    @Select("select * from springboottest.dept")*/
    public List<Dept> list();
    public void delete(Integer id);
    public void save(Dept dept);
    public void update(Dept dept);
    public Dept list1(Integer id);
    @Insert("insert into springboottest.deptlog(deptlog.operation,deptlog.OperationDate) value (#{operation},#{time})")
    public void insert1(DeptLog deptLog);
}
