package org.example;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder

@Entity
@Table(name = "Factura")

public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private int numero;
    private int total;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "fk_cliente")
   private Cliente cliente;

    //Al eliminar una instancia de Factura se eliminan todos los detalles por la composición

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    @Builder.Default
    private Set<DetalleFactura> detallesFacturas = new HashSet<>();
}
