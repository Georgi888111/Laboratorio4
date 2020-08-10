package ar.com.utn.back.controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.com.utn.back.entity.Instrumento;
import ar.com.utn.back.service.InstrumentoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "instrumento")
public class InstrumentoController {

	@Autowired
	private InstrumentoService service;

	@GetMapping("/all")
	@Transactional
	public ResponseEntity<?> returnAll() {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
		}

	}

	@RequestMapping(method = RequestMethod.GET, path = "/enabled")
	@Transactional
	public ResponseEntity<?> returnAllEnabled() {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAllEnabled());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
		}

	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<?> getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Mi mensaje get uno\": \"" + e.getMessage() + "\"}");
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

	@RequestMapping(method = RequestMethod.POST, path = "/")
	@Transactional
	public ResponseEntity<?> save(@RequestBody Instrumento instrumentoForm) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(instrumentoForm));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Mi mensaje post \": \"" + e.getMessage() + "\"}");
		}

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	@Transactional
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Instrumento instrumentoForm) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id,instrumentoForm));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Mi mensaje put \": \"" + e.getMessage() + "\"}");
		}

	}
	
	
	/*@RequestMapping(value = "/upload",method = RequestMethod.POST, consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
	  File convertFile = new File("src\\main\\resources\\static\\images\\" + file.getOriginalFilename());
	  convertFile.createNewFile();
	  try(FileOutputStream fout = new FileOutputStream(convertFile)) {
		  fout.write(file.getBytes());
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	  }*/
	
	@PostMapping("/upload")
	@Transactional
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {
		if (file==null || file.isEmpty()){
			attributes.addFlashAttribute("message", "Por favor seleccione un archivo");
			return "redirect:status";
		}
		
		String upload_folder =".//src//main//resources//static//images//";
		byte[] filesBytes = file.getBytes();
		Path path = Paths.get(upload_folder + file.getOriginalFilename());
		Files.write(path, filesBytes);
		
		
		
		return "redirect:/status";
	}
}

