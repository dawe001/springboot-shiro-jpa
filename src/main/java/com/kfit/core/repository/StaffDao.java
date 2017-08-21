package com.kfit.core.repository;

import com.kfit.core.bean.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by davi on 2017/8/14.
 */
public interface StaffDao extends JpaRepository<Staff,Integer> {
}
