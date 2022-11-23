package py.com.utic.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@ToString
@Table(name="model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_model", nullable = false)
    private Long idModel;
    private String name;
    @Column(name="id_brand")
    private Integer idBrand;
    private String description;
    private String image;
}
