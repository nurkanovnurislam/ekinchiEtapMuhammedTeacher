package peaksoft.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String gender;

    public Person(String name, int age, String email, String gender) {
        if (this.name.length()<25){

            System.out.println("name 25 ten az bolboit");
        }else this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    @ManyToOne
    private Company company;

    @ManyToMany
    private List<Social> socialList;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<Car> cars;


}
