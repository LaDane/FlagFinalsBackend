package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "continents")
@NamedQuery(name = "Continent.deleteAllRows", query = "DELETE from Continent")
public class Continent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "continent_name")
    private String continentName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="continent")
    private List<Country> countries;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="continent")
    private List<Quiz> quizzes;

    public Continent() {}

    public Continent(String continentName) {
        this.continentName = continentName;
        this.countries = new ArrayList<>();
    }

    public void setId(Long id) {this.id = id;}
    public void setContinentName(String continentName) {this.continentName = continentName;}
    public void setCountries(List<Country> countries) {this.countries = countries;}
    public void addCountry(Country country) {this.countries.add(country);}

    public Long getId() {return id;}
    public String getContinentName() {return continentName;}
    public List<Country> getCountries() {return countries;}

    @Override
    public String toString() {
        return "Continent{" +
                "id=" + id +
                ", continentName='" + continentName + '\'' +
                ", countries=" + countries +
                '}';
    }
}
