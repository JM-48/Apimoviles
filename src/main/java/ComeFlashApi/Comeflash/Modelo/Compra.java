package ComeFlashApi.Comeflash.Modelo;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relación Muchos a Uno (Muchas Compras de 1 Usuario)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private double total;
    private Date fecha = new Date(); // Fecha de la compra

    // Relación Uno a Muchos con los detalles de la compra
    // Esta lista NO se mapea a la BD, solo se usa para la relación.
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCompra> detalles;
}
