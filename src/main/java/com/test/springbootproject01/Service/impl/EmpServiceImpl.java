package com.test.springbootproject01.Service.impl;


import com.test.springbootproject01.Service.EmpService;
import com.test.springbootproject01.mapper.EmpMapper;
import com.test.springbootproject01.pojo.Emp;
import com.test.springbootproject01.pojo.PojoBean;
import com.test.springbootproject01.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PojoBean select(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        PojoBean pojoBean = new PojoBean();
        pojoBean.setTotal(empMapper.count());
        pojoBean.setRows(empMapper.list(name,gender,begin,end,(page-1)*pageSize,pageSize));
        System.out.println((page-1)*pageSize);
        System.out.println(pageSize);
        return pojoBean;
    }

    @Override
    public void delete(Integer[] ids) {
        /*StringBuilder sb=new StringBuilder();
        sb.append("(");
        for (int i = 0; i < ids.length; i++) {
            if(i!=ids.length-1){
                sb.append(ids[i]+",");
            }
            else{
                sb.append(ids[i]);
            }
        }
        sb.append(")");
        String str=sb.toString();*/
        /*List<Integer> idsList = Arrays.asList(ids);*/
        empMapper.delete(ids);
    }

    @Override
    public void insert(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setPassword("123456");
        empMapper.insert(emp);
    }

    @Override
    public Emp selectId(Integer id) {
        return empMapper.selectId(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
    @Override
    public void upload(String image){
    }

    @Override
    public Emp login(Emp emp) {
        Emp emp1=empMapper.login(emp);
        return emp1;
    }

    public void deleteByDeptId(Integer id) {
        empMapper.deleteByDeptId(id);
    }
}
