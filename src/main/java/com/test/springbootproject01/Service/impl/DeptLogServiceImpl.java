package com.test.springbootproject01.Service.impl;

import com.test.springbootproject01.Service.DeptLogService;
import com.test.springbootproject01.mapper.DeptLogMapper;
import com.test.springbootproject01.pojo.DeptLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Autowired
    private DeptLogMapper deptLogMapper;
    //在事务嵌套的情况下在事务中重新创建一个事务
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(DeptLog deptLog) {
        deptLogMapper.insertDeptLog(deptLog);
    }
}
