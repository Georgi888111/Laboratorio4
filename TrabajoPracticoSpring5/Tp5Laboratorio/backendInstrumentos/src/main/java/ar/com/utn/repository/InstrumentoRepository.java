package ar.com.utn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.utn.entity.Instrumento;

public interface InstrumentoRepository extends  JpaRepository<Instrumento, Integer>{

}
