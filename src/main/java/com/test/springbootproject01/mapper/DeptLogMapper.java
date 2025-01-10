package com.test.springbootproject01.mapper;

import com.test.springbootproject01.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    @Insert("insert into springboottest.deptlog(deptlog.operation,deptlog.OperationDate) value (#{operation},#{time})")
    public void insertDeptLog(DeptLog deptLog);
}
