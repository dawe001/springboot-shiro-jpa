package com.kfit.core.repository;

import com.kfit.core.bean.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Tuple;

/**
 * Created by davi on 2017/7/29.
 */
public interface SysRoleDao extends JpaRepository<SysRole, Long> {
    Page<Tuple> findAll(Specification<Tuple> specification, Pageable pageable);
}
