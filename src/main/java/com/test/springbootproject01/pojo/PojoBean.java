package com.test.springbootproject01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PojoBean {
    private Long total;
    private List<Emp> rows;
}
