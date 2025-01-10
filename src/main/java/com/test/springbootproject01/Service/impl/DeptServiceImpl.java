package com.test.springbootproject01.Service.impl;

import com.test.springbootproject01.Service.DeptService;
import com.test.springbootproject01.mapper.DeptLogMapper;
import com.test.springbootproject01.mapper.DeptMapper;
import com.test.springbootproject01.pojo.Dept;
import com.test.springbootproject01.pojo.DeptLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptLogServiceImpl deptLogServiceImpl;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpServiceImpl empService;
    public List<Dept> list(){
        List<Dept> deptList = deptMapper.list();
        return deptList;
    }
    //事务管理注解，如果中间有异常，则回滚，要么整体回滚，要么都提交

    @Override
    @Transactional
    public void delete(Integer id) throws Exception {
        try {
            deptMapper.delete(id);
            /*int i=1/0;*/
            empService.deleteByDeptId(id);
        }finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setOperation("执行了删除部门的操作，此次删除的ID为"+id);
            deptLog.setTime(LocalDateTime.now());
            deptLogServiceImpl.insert(deptLog);
        }
        /*deptMapper.delete(id);
*//*        int i=1/0;*//*
        empService.deleteByDeptId(id);
        DeptLog deptLog = new DeptLog();
        deptLog.setOperation("执行了删除部门的操作，此次删除的ID为"+id);
        deptLog.setTime(LocalDateTime.now());
        deptLogMapper.insert1(deptLog);*/
    }
    public void save(Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.save(dept);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    @Override
    public Dept select(Integer id) {
        return deptMapper.list1(id);
    }
}