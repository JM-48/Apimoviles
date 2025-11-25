package CatalogoAPI.ApiAppMoviles.Modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relación Muchos a Uno (Muchos detalles pertenecen a 1 Compra)
    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    // Relación Muchos a Uno (El detalle apunta a la comida comprada)
    @ManyToOne
    @JoinColumn(name = "comida_id")
    private Productos comida;

    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
}
