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
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String location;

    @OneToMany(mappedBy = "company")
    private List<Person> persons;

    public Company(String companyName, String location) {
        if (this.companyName.length()<30){
            System.out.println("company name 30 dan az bolboit");
        }else this.companyName = companyName;

        this.location = location;
    }
}
