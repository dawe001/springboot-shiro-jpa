package com.kfit.core.repository;

import com.kfit.core.bean.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by davi on 2017/7/16.
 */
public interface DepartmentDao extends JpaRepository<Department,Long> {
}
