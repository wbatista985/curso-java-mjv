package easy.job.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import easy.job.dto.ProfissionalPost;
import easy.job.dto.ProfissionalResult;
import easy.job.model.Profissional;
import easy.job.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
	@Autowired
	private ProfissionalRepository repository;
	@Autowired
	private ModelMapper converter;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Value("${file.upload.folder}")
	private String fileUploadFolder;
	public void gravar(Profissional profissional) {
		repository.save(profissional);
	}
	public void gravar(ProfissionalPost profissional) {
		try {
			File file = saveOnDisk(profissional.getImage());
			Profissional entity = converter.map(profissional, Profissional.class);
			entity.setPathCurriculo(file.getAbsolutePath());
			repository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void gravar(String json,MultipartFile webFile) {
		try {
			Profissional entity = mapper.readValue(json, Profissional.class);
			File file = saveOnDisk(webFile);
			entity.setPathCurriculo(file.getAbsolutePath());
			entity= repository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public List<Profissional> listar(){
		return repository.findAll();
	}
	public List<ProfissionalResult> listarResultado(){
		List<Profissional> cadastros = repository.findAll();
		if(cadastros.size()%2==1) {
			Profissional p = new Profissional();
			p.setBiografia("Biografia");
			p.setEmail("e-mail@email.com");
			p.setNome("Nome do Profissional");
			p.setProfissao("Profissão");
			p.setId(0);
			cadastros.add(p);
		}
		List<ProfissionalResult> resultList = new ArrayList<ProfissionalResult>();
		
		for(int x=0; x<cadastros.size();) {
			ProfissionalResult pr = new ProfissionalResult();
			pr.setCol1(cadastros.get(x++));
			pr.setCol2(cadastros.get(x++));
			resultList.add(pr);
		}
		return resultList;
	}
	public File saveOnDisk(MultipartFile webFile) throws Exception {
		Path newFilePath = Paths.get(fileUploadFolder).resolve(UUID.randomUUID().toString()+"-"+webFile.getOriginalFilename());//webFile.getOriginalFilename()
		Files.copy(webFile.getInputStream(), newFilePath, StandardCopyOption.REPLACE_EXISTING);
		return newFilePath.toFile();
	}
}
