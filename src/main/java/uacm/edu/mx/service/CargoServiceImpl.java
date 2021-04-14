package uacm.edu.mx.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.Cargo;
import uacm.edu.mx.repository.AbstractBaseRepositoryImpl;
import uacm.edu.mx.repository.CargoRepository;



@Service
@Transactional
public class CargoServiceImpl extends AbstractBaseRepositoryImpl<Cargo,Integer> implements CargoService {

	private CargoRepository carpetaFisicaRepository;

	public CargoServiceImpl(CargoRepository cargoRepository) {
		super(cargoRepository);
	}

	@Override
	public Page<Cargo> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
