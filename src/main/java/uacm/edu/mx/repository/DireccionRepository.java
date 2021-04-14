package uacm.edu.mx.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacm.edu.mx.model.Direccion;


@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer> {

}