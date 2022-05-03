package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "quizzes")
@NamedQuery(name = "Quiz.deleteAllRows", query = "DELETE from Quiz")
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "total_points")
    private Long totalPoints;

    @Basic(optional = false)
    @NotNull
    @Column(name = "total_correct")
    private Long totalCorrect;

    @Basic(optional = false)
    @NotNull
    @Column(name = "total_incorrect")
    private Long totalIncorrect;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="quiz")
    private List<Question> questions;

    @ManyToOne()
    @JoinColumn(name = "continent_id")
    private Continent continent;

    @ManyToOne()
    @JoinColumn(name = "username")
    private User user;

    public Quiz() {}

    public Quiz(List<Question> questions, Continent continent, User user) {
        this.totalPoints = 0L;
        this.totalCorrect = 0L;
        this.totalIncorrect = 0L;
        this.questions = questions;
        this.continent = continent;
        this.user = user;
    }

    public Quiz(Long totalPoints, Long totalCorrect, Long totalIncorrect, List<Question> questions, Continent continent, User user) {
        this.totalPoints = totalPoints;
        this.totalCorrect = totalCorrect;
        this.totalIncorrect = totalIncorrect;
        this.questions = questions;
        this.continent = continent;
        this.user = user;
    }

    public void setId(Long id) {this.id = id;}
    public void setTotalPoints(Long totalPoints) {this.totalPoints = totalPoints;}
    public void setTotalCorrect(Long totalCorrect) {this.totalCorrect = totalCorrect;}
    public void setTotalIncorrect(Long totalIncorrect) {this.totalIncorrect = totalIncorrect;}
    public void setQuestions(List<Question> questions) {this.questions = questions;}
    public void addQuestion(Question question) {this.questions.add(question);}
    public void setContinent(Continent continent) {this.continent = continent;}
    public void setUser(User user) {this.user = user;}

    public Long getId() {return id;}
    public Long getTotalPoints() {return totalPoints;}
    public Long getTotalCorrect() {return totalCorrect;}
    public Long getTotalIncorrect() {return totalIncorrect;}
    public List<Question> getQuestions() {return questions;}
    public Continent getContinent() {return continent;}
    public User getUser() {return user;}

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", totalPoints=" + totalPoints +
                ", totalCorrect=" + totalCorrect +
                ", totalIncorrect=" + totalIncorrect +
                ", questions=" + questions +
                ", continent=" + continent +
                ", user=" + user +
                '}';
    }
}
