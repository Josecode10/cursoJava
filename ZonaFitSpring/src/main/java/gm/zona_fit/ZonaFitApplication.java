package gm.zona_fit;

// import java.util.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import gm.zona_fit.servicio.IClienteServicio;

@SpringBootApplication // indica que es una aplicación de Spring Boot
public class ZonaFitApplication implements CommandLineRunner{

	@Autowired
	private IClienteServicio clienteServicio; // inyecta el servicio de cliente

	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);


	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion");
		// Levantar la fábrica de Spring
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("¡Aplicacion finalizada!");
	}


	@Override
	public void run(String... args) throws Exception {
		logger.info("*** Aplicacion Zona Fit (GYM) ***");
	}

}
