package gm.zona_fit;

import java.util.Scanner;

// import java.util.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import gm.zona_fit.servicio.IClienteServicio;
import lombok.var;

@SpringBootApplication // indica que es una aplicación de Spring Boot
public class ZonaFitApplication implements CommandLineRunner{

	@Autowired
	private IClienteServicio clienteServicio; // inyecta el servicio de cliente

	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion");
		// Levantar la fábrica de Spring
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("Aplicacion finalizada!");
	}

	@Override
	public void run(String... args) throws Exception {
		zonaFitApp();
	}
	
	private void zonaFitApp(){
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir) {
			var opcion = mostrarMenu(consola);
			// salir = ejecutarOpciones(consola, opcion);
			logger.info(nl);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info(nl + """
			*** Aplicacion Zona Fit (GYM) ***
			1. Listar clientes
			2. Buscar cliente
			3. Agregar cliente
			4. Modificar cliente
			5. Eliminar cliente
			6. Salir
			Elige una opcion:\s""");
		return Integer.parseInt(consola.nextLine());
	}
}