package uacm.edu.mx;

import java.util.Optional;

import uacm.edu.mx.model.Catalogo;

public class Datos {
	
	public static Optional<Catalogo> crearCatalogoTest() {
        return Optional.of(new Catalogo("Catalgo Controller"));
    }


}
