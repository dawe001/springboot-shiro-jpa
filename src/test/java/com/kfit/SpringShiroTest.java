package com.kfit;

import com.kfit.core.bean.Employee;
import com.kfit.core.repository.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;


/**
 * Created by davi on 2017/6/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class SpringShiroTest {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void test() throws Exception {
        Page<Employee> employeePage = employeeDao.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                Path<Long> id = root.get("id");
                Path<String> name = root.get("name");
                root.join("department", JoinType.LEFT);
                Predicate p1 = cb.le(id, 10);
                Predicate p2 = cb.like(name, "%" + "a" + "%");
                cb.and(p1, p2);
//                criteriaQuery.where(p1, p2);//和上面等效
                return null;
            }
        }, new PageRequest(0, 3, new Sort(Sort.Direction.DESC, "id")));
        System.out.println(employeePage);

    }


    @Test
    public void test1() throws Exception {
        List<Employee> employeePage = employeeDao.queryByname("a");
        Assert.isInstanceOf(employeePage.getClass(), List.class);
    }

//    @Test
//    public void test2() throws Exception {
//        List<Map<String, Object>> employeePage = employeeDao.queryByname1("a");
//        for (Map<String, Object> map : employeePage) {
//            Map<String, Object> m = map;//此处会报错，jpa返回的是对象数组，不是map
//            System.out.println(map);
//        }
//        Assert.isInstanceOf(employeePage.getClass(), List.class);
//    }


}
