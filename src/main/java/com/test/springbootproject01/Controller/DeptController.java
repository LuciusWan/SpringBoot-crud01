package com.test.springbootproject01.Controller;
import com.test.springbootproject01.Service.DeptService;
import com.test.springbootproject01.pojo.Dept;
import com.test.springbootproject01.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    Dept dp=new Dept();
    @Autowired
    private DeptService deptService;
    @GetMapping()
    public Result list(){
        log.info("查询所有部门数据");
        List<Dept> depts= deptService.list();
        return Result.success(depts);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("删除所选部门数据");
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping()
    public Result save(@RequestBody Dept dept){
        log.info("添加部门{}", dept);
        deptService.save(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){
        log.info("根据ID{}查询部门", id);
        dp=deptService.select(id);
        return Result.success(dp);
    }
    @PutMapping()
    public Result update(@RequestBody Dept dept){
        log.info("修改部门{}", dept);
        deptService.update(dept);
        return Result.success();
    }

}
