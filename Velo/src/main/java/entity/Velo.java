package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Velo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVelo")
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "marque")
    private String marque;

    @Column(name = "status")
    private boolean status;


}