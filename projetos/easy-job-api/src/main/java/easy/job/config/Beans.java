package easy.job.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class Beans {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}
}
