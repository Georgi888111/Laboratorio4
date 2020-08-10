package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Instrumento;


public interface InstrumentoRepository extends  JpaRepository<Instrumento, Integer>{

}