package tn.esprit.spring.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Employe;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmlpoyeServiceImplTest {

    @Autowired
    IEmployeService es;

    @Test
    @Order(1)
    public void testRetrieveAllEmployees() {
        // List<Employe> listEmployes = es.retrieveAllEmployes();
        // Assertions.assertEquals(1, listEmployes.size());
        // Assertions.assertNotNull(listEmployes);
    }
    
}
