package pe.edu.upeu.sysalmacenfx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;
import pe.edu.upeu.sysalmacenfx.repositorio.Mainx;

@SpringBootApplication
public class SysAlmacenFxApplication {


	public static void main(String[] args) {SpringApplication.run(SysAlmacenFxApplication.class);}
	@Bean
		public CommandLineRunner run(ApplicationContext context) { return args -> {
		Mainx mx = context.getBean(Mainx.class);
		mx.registro();
	};

	}

}
