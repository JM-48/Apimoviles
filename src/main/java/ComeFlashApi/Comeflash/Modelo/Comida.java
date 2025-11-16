package ComeFlashApi.Comeflash.Modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Usamos 'id' para ser consistentes con tu modelo de Android

    private String nombre;
    private String descripcion; // Añadido desde tu ViewModel de Android
    private double precio; // Cambiado a double para mejor manejo de precios

    private String tipoComida; // Para tu filtro de "Hamburguesa", "Pizza", etc.
    private boolean oferta; // Para tu filtro de "Ofertas"
    private String imagenUrl;

    // Si necesitas campos de relación (Sucursal, Proveedor, etc.), añádelos aquí
}