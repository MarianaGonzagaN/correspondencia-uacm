package uacm.edu.mx.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uacm.edu.mx.model.Fondo;

@Repository
public interface FondoRepository extends JpaRepository<Fondo, Long> {

}
