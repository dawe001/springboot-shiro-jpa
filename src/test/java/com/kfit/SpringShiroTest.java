package com.kfit;

import com.alibaba.fastjson.JSON;
import com.kfit.core.bean.Department;
import com.kfit.core.bean.Employee;
import com.kfit.core.repository.DepartmentDao;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void test() throws Exception {
        Page<Employee> employeePage = employeeDao.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                Path<Long> id = root.get("id");
                Path<String> name = root.get("name");
                root.join("department", JoinType.LEFT);
                Predicate p1 = cb.equal(id, 10);
                Predicate p2 = cb.like(name, "%" + "a" + "%");
                criteriaQuery.multiselect(id, name);
                criteriaQuery.where(p1, p2);
                return null;
            }
        }, new PageRequest(0, 3, new Sort(Sort.Direction.DESC, "id")));
        List<Employee> list = employeePage.getContent();
        System.out.println(JSON.toJSONString(list));

    }


    @Test
    public void test1() throws Exception {
//        Employee employee = new Employee();
//        employee.setName(null);
        Department department = new Department();
        department.setName("d1");
        Map collection = new HashMap();
        collection.put("ssssss1","png");
        collection.put("ssssss2","png");
//        department.setImageSet(collection);
//        employeeDao.save(employee);
//        System.out.println(employee.getName().get());
        departmentDao.save(department);
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
