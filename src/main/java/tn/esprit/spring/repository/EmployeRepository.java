package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> { }