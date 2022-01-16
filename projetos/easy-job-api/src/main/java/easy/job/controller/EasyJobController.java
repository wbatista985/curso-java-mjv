package easy.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import easy.job.dto.ProfissionalPost;
import easy.job.dto.ProfissionalResult;
import easy.job.model.Profissional;
import easy.job.service.ProfissionalService;

@RestController
@RequestMapping("/cadastros")
public class EasyJobController {
	//https://stackoverflow.com/questions/49845355/spring-boot-controller-upload-multipart-and-json-to-dto
	//https://blogs.perficient.com/2020/07/27/requestbody-and-multipart-on-spring-boot/
	@Autowired
	private ProfissionalService service;
	
	@GetMapping
	public List<Profissional> listar() {
		return service.listar();
	}
	@GetMapping("/resultados")
	public List<ProfissionalResult> listarResultado() {
		return service.listarResultado();
	}
	@PostMapping()
	public void gravar(@RequestBody Profissional profissional) {
		service.gravar(profissional);
	}
	@PostMapping(value = "/anexo")
	public void gravar(@ModelAttribute ProfissionalPost profissional) {
		print(profissional, profissional.getImage());
		service.gravar(profissional);
	}
	@PostMapping(value = "/parte", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public void gravarPart(@RequestPart("obj") String profissional, @RequestPart("file") MultipartFile file) {
		print(profissional, file);
		service.gravar(profissional, file);
	}
	private void print(Object entity, MultipartFile file) {
		System.out.println(entity);
		
        System.out.println("Uploaded File: ");
        System.out.println("Name : " + file.getName());
        System.out.println("Type : " + file.getContentType());
        System.out.println("Name : " + file.getOriginalFilename());
        System.out.println("Size : " + file.getSize());
	}
	@GetMapping("/json")
	public Profissional get() {
		Profissional p = new Profissional();
		p.setBiografia("Sou estudante");
		p.setEmail("estudante@dev.com.br");
		p.setNome("MARCOS SILVA");
		return p;
	}
}
