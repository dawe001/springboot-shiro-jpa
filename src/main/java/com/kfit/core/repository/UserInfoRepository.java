package com.kfit.core.repository;

import com.kfit.core.bean.Employee;
import com.kfit.core.bean.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

/**
 * UserInfo持久化类;
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
public interface UserInfoRepository extends CrudRepository<UserInfo,Long>{
	
	/**通过username查找用户信息;*/
	UserInfo findByUsername(String username);

}
