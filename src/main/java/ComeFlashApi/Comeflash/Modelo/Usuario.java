package ComeFlashApi.Comeflash.Modelo;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String correo;
    private String contrasena; // NOTA: Nunca almacenar contraseñas sin hashear.

    // Relación Muchos a Uno (Muchos Usuarios tienen 1 Rol)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")
    private Rol rol;

    // El campo logoUri no es esencial para la lógica del backend, se mantiene si es necesario.
    private String logoUri;







}
