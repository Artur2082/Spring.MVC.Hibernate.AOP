package ua.javaPro.spring.mvc_hibernate_aop.dao;

import ua.javaPro.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAll();

  public void saveEmp(Employee employee);

  public Employee getEmp(int id);
  public void deleteEmp(int id);

}
