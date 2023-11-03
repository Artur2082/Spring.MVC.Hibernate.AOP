package ua.javaPro.spring.mvc_hibernate_aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.javaPro.spring.mvc_hibernate_aop.entity.Employee;
import ua.javaPro.spring.mvc_hibernate_aop.service.EmployeeService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/")
    public String showAllEmployees(Model model){
       List<Employee> allEmployees = employeeService.getAll();
       model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmp(employee);
        return "redirect:/";
    }
    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.getEmp(id);
        model.addAttribute("employee", employee);
    return "employee-info";
    }
    @RequestMapping("deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id, Model model){
        employeeService.deleteEmp(id);
    return "redirect:/";
    }
}
