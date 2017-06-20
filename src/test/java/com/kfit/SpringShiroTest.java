package com.kfit;

import com.kfit.core.bean.Employee;
import com.kfit.core.repository.UserInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;


/**
 * Created by davi on 2017/6/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class SpringShiroTest {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    public void test() throws Exception {
        userInfoRepository.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                Path<Long> id=root.get("id");
                Path<String> name=root.get("name");
                root.join("department",JoinType.LEFT);
                Predicate p1=cb.and(cb.le(id,10));
                p1=cb.and(p1,cb.like(name,"%"+"a"+"%"));
                return null;
            }
        }, new PageRequest(0, 3, new Sort(Sort.Direction.DESC, "id")));

    }
}
