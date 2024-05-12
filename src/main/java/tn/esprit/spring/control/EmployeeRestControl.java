package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeRestControl {

    @Autowired
    IEmployeService employeeService;

    @GetMapping("/retrieve-all-employees")
    public List<Employe> retrieveAllEmployees() {
        return employeeService.retrieveAllEmployes();
    }

}
