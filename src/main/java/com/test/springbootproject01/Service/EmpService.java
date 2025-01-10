package com.test.springbootproject01.Service;

import com.aliyuncs.exceptions.ClientException;
import com.test.springbootproject01.pojo.Emp;
import com.test.springbootproject01.pojo.PojoBean;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public interface EmpService {
    public PojoBean select(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);
    public void delete(Integer [] ids);
    public void insert(Emp emp);
    public Emp selectId(Integer id);
    public void update(Emp emp);
    public void upload(String image) throws FileNotFoundException, ClientException;
    public Emp login(Emp emp);
    public void deleteByDeptId(Integer id);
}
