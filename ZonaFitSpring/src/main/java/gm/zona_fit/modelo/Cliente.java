package gm.zona_fit.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity // indica que es una entidad de la base de datos
@Data // genera getters y setters
@NoArgsConstructor // genera constructor sin argumentos
@AllArgsConstructor // genera constructor con todos los argumentos
@ToString // genera el método toString
@EqualsAndHashCode // genera los métodos equals y hashCode
public class Cliente {
    @Id // clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremental
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer membresia;
}
