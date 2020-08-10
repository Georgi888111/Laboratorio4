package ar.com.utn.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.utn.entity.Instrumento;
import ar.com.utn.service.InstrumentoService;

@RestController
@CrossOrigin(origins = "*",
methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})


@RequestMapping(path = "api/v1/instrumento")
public class InstrumentoController {
	@Autowired	
	private InstrumentoService service;

	

	@GetMapping("/")

	@Transactional
	
	
	public ResponseEntity<?> getAll(){
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body
					("{\"Mi mensaje get todos\": \""+e.getMessage()+"\"}");
			
		}
		
		
	}
	
	@GetMapping("/all")

	@Transactional
	
	
	public ResponseEntity<?> getAllAll(){
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findAllAll());
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body
					("{\"Mi mensaje get todos\": \""+e.getMessage()+"\"}");
			
		}
		
		
	}
	

	
	@GetMapping("/{id}")

	@Transactional
	public ResponseEntity<?>  getOne(@PathVariable int id) {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body
					("{\"Mi mensaje get uno\": \""+e.getMessage()+"\"}");
			
		}
		

		
	}	
	
	@PostMapping("/")

	@Transactional
	public ResponseEntity<?> post(@RequestBody Instrumento instrumentoForm) {
		
		try {
		

			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(instrumentoForm));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
					("{\"Mi mensaje post\": \""+e.getMessage()+"\"}");
						
		}
		
	}
	
	@PutMapping("/{id}")

	@Transactional
	public ResponseEntity<?> put(@PathVariable int id, @RequestBody Instrumento instrumentoForm) {
		
		try {
			
			
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, instrumentoForm));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
					("{\"Mi mensaje put\": \""+e.getMessage()+"\"}");
		}
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable int id) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"Mi mensaje delete\": \"" + e.getMessage() + "\"}");
		}

	}

}




