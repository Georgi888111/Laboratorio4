package ar.com.utn.back.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.utn.back.entity.Instrumento;
import ar.com.utn.back.repository.InstrumentoRepository;

@Service
public class InstrumentoService {

	@Autowired
	private InstrumentoRepository repository;

	@Transactional
	public List<Instrumento> findAll() throws Exception {

		try {
			List<Instrumento> entities = repository.findAll();

			return entities;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Transactional
	public List<Instrumento> findAllEnabled() throws Exception {

		try {
			List<Instrumento> entities = new ArrayList<Instrumento>();
			List<Instrumento> aux = repository.findAll();
			for (Instrumento instrumento : aux) {
				if (instrumento.isEstaHabilitado()) {
					entities.add(instrumento);
				}
			}

			return entities;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Transactional
	public Instrumento findById(int id) throws Exception {
		try {
			Optional<Instrumento> varOptional = repository.findById(id);
			Instrumento entity = varOptional.get();

			return entity;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}

	public boolean delete(int id) throws Exception {

		try {
			Instrumento entity = new Instrumento();
			if (repository.existsById(id)) {
				Optional<Instrumento> entityOptional = repository.findById(id);
				entity = entityOptional.get();
				entity.setEstaHabilitado(false);
				entity = repository.save(entity);

			}
			if (!entity.isEstaHabilitado()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	@Transactional
	public Instrumento save(Instrumento instrumentoForm) throws Exception {

		try {

			instrumentoForm = repository.save(instrumentoForm);

			return instrumentoForm;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}
	
	@Transactional
	public Instrumento update(int id, Instrumento instrumentoForm) throws Exception {

		try {
			Optional<Instrumento> entityOptional = repository.findById(id);

			Instrumento entity = entityOptional.get();

			entity = repository.save(instrumentoForm);

			return entity;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}

}
