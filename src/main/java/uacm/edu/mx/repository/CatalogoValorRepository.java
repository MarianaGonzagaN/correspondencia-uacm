package uacm.edu.mx.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uacm.edu.mx.model.Catalogo;
import uacm.edu.mx.model.CatalogoValores;

@Repository
public interface CatalogoValorRepository extends JpaRepository<CatalogoValores, Long> {

	Set<CatalogoValores> findByCatalogo(Catalogo catalogo);
}
