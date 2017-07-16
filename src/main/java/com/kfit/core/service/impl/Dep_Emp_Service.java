package com.kfit.core.service.impl;

import com.kfit.core.repository.DepartmentDao;
import com.kfit.core.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by davi on 2017/7/16.
 */
public class Dep_Emp_Service {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;
}
