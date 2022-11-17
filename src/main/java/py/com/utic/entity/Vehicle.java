package py.com.utic.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
@ToString
@Table(name="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle", nullable = false)
    private Long idVehicle;
    private String name;
    private Integer price;
    private Integer year;
    @Column(name="id_model")
    private Integer idModel;

}
