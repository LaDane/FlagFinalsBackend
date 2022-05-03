package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
@NamedQuery(name = "Country.deleteAllRows", query = "DELETE from Country")
public class Country implements Serializable {

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
    @Column(name = "country_name")
    private String countryName;

    @ManyToOne()
    @JoinColumn(name = "continent_id")
    private Continent continent;

    @Basic(optional = false)
    @NotNull
    @Column(name = "answered")
    private Long answered;              // times answered

    @Basic(optional = false)
    @NotNull
    @Column(name = "correct")
    private Long correct;               // times answered correctly

    @Basic(optional = false)
    @NotNull
    @Column(name = "incorrect")
    private Long incorrect;             // times answered incorrectly

    @Basic(optional = false)
    @NotNull
    @Column(name = "country_svg", columnDefinition="LONGTEXT")
    private String countrySVG;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="country")
    private List<User> users;

    public Country() {}

    public Country(String countryName, Continent continent, String countrySVG) {
        this.countryName = countryName;
        this.continent = continent;
        this.answered = 0L;
        this.correct = 0L;
        this.incorrect = 0L;
        this.countrySVG = countrySVG;
        this.users = new ArrayList<>();
    }

    public Country(String countryName, Continent continent, Long answered, Long correct, Long incorrect, String countrySVG) {
        this.countryName = countryName;
        this.continent = continent;
        this.answered = answered;
        this.correct = correct;
        this.incorrect = incorrect;
        this.countrySVG = countrySVG;
        this.users = new ArrayList<>();
    }

    public void setId(Long id) {this.id = id;}
    public void setCountryName(String countryName) {this.countryName = countryName;}
    public void setContinent(Continent continent) {this.continent = continent;}
    public void setAnswered(Long answered) {this.answered = answered;}
    public void setCorrect(Long correct) {this.correct = correct;}
    public void setIncorrect(Long incorrect) {this.incorrect = incorrect;}
    public void setCountrySVG(String countrySVG) {this.countrySVG = countrySVG;}
    public void setUsers(List<User> users) {this.users = users;}
    public void addUser(User user) {this.users.add(user);}

    public Long getId() {return id;}
    public String getCountryName() {return countryName;}
    public Continent getContinent() {return continent;}
    public Long getAnswered() {return answered;}
    public Long getCorrect() {return correct;}
    public Long getIncorrect() {return incorrect;}
    public String getCountrySVG() {return countrySVG;}
    public List<User> getUsers() {return users;}

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", continent=" + continent +
                ", answered=" + answered +
                ", correct=" + correct +
                ", incorrect=" + incorrect +
                ", countrySVG='" + countrySVG + '\'' +
                ", users=" + users +
                '}';
    }
}
