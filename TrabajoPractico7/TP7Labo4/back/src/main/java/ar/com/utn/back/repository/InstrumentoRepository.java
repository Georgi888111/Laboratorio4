package ar.com.utn.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.utn.back.entity.Instrumento;

public interface InstrumentoRepository extends JpaRepository<Instrumento, Integer> {

}
