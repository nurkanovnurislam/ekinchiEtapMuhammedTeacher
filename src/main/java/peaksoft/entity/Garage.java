package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "garages")
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isEmpty;

    @OneToOne
    private Car car;

    public Garage(String name, boolean isEmpty) {
        this.name = name;
        this.isEmpty = isEmpty;
    }
}
