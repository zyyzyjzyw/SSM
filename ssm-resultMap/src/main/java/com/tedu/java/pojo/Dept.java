package com.tedu.java.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer deptId;
    private String deptName;
    private List<Emp> emps;
}
