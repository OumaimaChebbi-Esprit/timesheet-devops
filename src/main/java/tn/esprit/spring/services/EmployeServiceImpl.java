package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeServiceImpl implements IEmployeService {

    @Autowired
    EmployeRepository employeRepository;

    private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

    @Override
    public List<Employe> retrieveAllEmployes() {
        try {
            return employeRepository.findAll();
        } catch (Exception exception) {
            l.error("An error occurs while retrieving employees");
        }
        return new ArrayList<>();
    }

    @Override
    public Employe addEmploye(Employe e) {
        Employe employe = null;
        try {
            employe = employeRepository.save(e);
            l.info("Employee added successfully");
        } catch (Exception exception) {
            l.error("An error occurs while adding the employee");
        }
        return employe;
    }

    @Override
    public void deleteEmploye(String id) {
        try {
            employeRepository.deleteById(Long.parseLong(id));
            l.info("Employee deleted successfully");
        } catch (Exception e) {
            l.error("An error occurs while deleting the employee");
        }
    }

    @Override
    public Employe updateEmploye(Employe e) {
        Employe employe = null;
        try {
            employe = employeRepository.save(e);
            l.info("Employee updated successfully");
        } catch (Exception exception) {
            l.error("An error occurs while updating the employee");
        }
        return employe;
    }

    @Override
    public Employe retrieveEmploye(String id) {
        Employe employe = null;
        try {
            employe =  employeRepository.findById(Long.parseLong(id)).get();
        } catch (Exception exception) {
            l.error("An error occurs while retrieving the employee");
        }
        return employe;
    }
}
