package com.kfit.core.repository;

import com.kfit.core.bean.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by davi on 2017/6/20.
 */
public interface EmployeeDao extends JpaRepository<Employee,Long> {
    Page<Employee> findAll(Specification<Employee> specification, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from employee where name like %?1%")
    List<Employee> queryByname(String name);
}
