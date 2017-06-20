package com.kfit.core.repository;

import com.kfit.core.bean.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by davi on 2017/6/20.
 */
public interface EmployeeDao extends JpaRepository<Employee,Long> {
    Page<Employee> findAll(Specification<Employee> specification, Pageable pageable);
}
