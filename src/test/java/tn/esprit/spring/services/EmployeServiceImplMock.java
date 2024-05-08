package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class EmployeServiceImplMock {

    @Mock
    EmployeRepository employeRepository;
    // EmployeRepository employeRepository = Mockito.mock(EmployeRepository.class);

    @InjectMocks
    EmployeServiceImpl employeService;

    Employe employe = new Employe("test", "test", "test", true, Role.INGENIEUR);

    List<Employe> employes = new ArrayList<Employe>() {
        {
            add(new Employe("test", "test", "test", true, Role.INGENIEUR));
            add(new Employe("test", "test", "test", true, Role.INGENIEUR));
        }
    };

    @Test
    public void testRetrieveEmploye() {
        Mockito.when(employeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(employe));
        Employe employe1 = employeService.retrieveEmploye("2");
        Assertions.assertNotNull(employe1);
    }

    @Test
    public void testAddEmploye() {
        Mockito.when(employeRepository.save(Mockito.any(Employe.class))).thenReturn(employe);
        Employe addedEmploye =  employeService.addEmploye(employe);
        Assertions.assertNotNull(addedEmploye, "The added employee should not be null !");
    }

    @Test
    public void testRetreiveAll() {
        Mockito.when(employeRepository.findAll()).thenReturn(employes);
        List<Employe> retrievedEmployees = employeService.retrieveAllEmployes();
        Assertions.assertNotEquals(employes.size(), retrievedEmployees.size(), "The expected size is : " + employes.size());
    }

}
