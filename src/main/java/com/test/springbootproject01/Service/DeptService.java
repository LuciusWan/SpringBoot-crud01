package com.test.springbootproject01.Service;

import com.test.springbootproject01.pojo.Dept;
import com.test.springbootproject01.pojo.Emp;
import com.test.springbootproject01.pojo.Result;

import java.util.List;

public interface DeptService {
    public List<Dept> list();
    public void delete(Integer id) throws Exception;
    public void save(Dept dept);
    public void update(Dept dept);
    public Dept select(Integer id);
}
