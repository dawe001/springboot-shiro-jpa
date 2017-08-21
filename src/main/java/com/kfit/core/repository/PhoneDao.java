package com.kfit.core.repository;

import com.kfit.core.bean.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by davi on 2017/8/14.
 */
public interface PhoneDao extends JpaRepository<Phone,Long> {
}
