package ua.javaPro.spring.mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.javaPro.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

   @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class)
                .getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmp(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmp(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmp(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        session.remove(employee);
    }

}
