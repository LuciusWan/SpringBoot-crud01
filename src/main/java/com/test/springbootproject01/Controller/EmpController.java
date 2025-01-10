package com.test.springbootproject01.Controller;

import com.test.springbootproject01.Service.EmpService;
import com.test.springbootproject01.pojo.Dept;
import com.test.springbootproject01.pojo.Emp;
import com.test.springbootproject01.pojo.PojoBean;
import com.test.springbootproject01.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result emp(String name, Short gender, LocalDate begin, LocalDate end,
                      @RequestParam(defaultValue = "1") Integer page,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        PojoBean pb=empService.select(name,gender,begin,end,page,pageSize);
        return Result.success(pb);
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids") Integer [] ids) {
        log.info("删除所选员工数据");
        empService.delete(ids);
        return Result.success();
    }
    @PostMapping
    public Result insert(@RequestBody Emp emp){
        log.info("添加员工数据，员工的username是{}",emp.getUsername());
        empService.insert(emp);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result select(@PathVariable("id") Integer id) {
        log.info("根据id{}查询数据",id);
        Emp emp1=empService.selectId(id);
        return Result.success(emp1);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("{}修改数据",emp.getUsername());
        empService.update(emp);
        return Result.success();
    }
}
