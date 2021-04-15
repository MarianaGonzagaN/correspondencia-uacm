package uacm.edu.mx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uacm.edu.mx.model.CatalogoValores;

@Repository
public interface CatalogoValorRepository extends JpaRepository<CatalogoValores, Long> {

}
