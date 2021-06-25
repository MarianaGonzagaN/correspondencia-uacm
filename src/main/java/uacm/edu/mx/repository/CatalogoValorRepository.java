package uacm.edu.mx.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uacm.edu.mx.model.Catalogo;
import uacm.edu.mx.model.CatalogoValores;

@Repository
public interface CatalogoValorRepository extends JpaRepository<CatalogoValores, Long> {

	Set<CatalogoValores> findByCatalogo(Catalogo catalogo);
	
	@Query("SELECT cv FROM CatalogoValores cv LEFT JOIN cv.catalogo c ON cv.catalogo=c.id ")
	List<CatalogoValores> getCatalogoandValores();
	
	@Query("Select cv FROM CatalogoValores cv INNER JOIN Catalogo c ON cv.catalogo=c.id WHERE c.nombre=:nombre")
	List<CatalogoValores> getValoresCatalogoByNombre(@Param("nombre") String nombre);
}
