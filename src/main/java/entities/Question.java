package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "questions")
@NamedQuery(name = "Question.deleteAllRows", query = "DELETE from Question")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "correct_country_id")
    private Long correctCountryId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "country_svg", columnDefinition="LONGTEXT")
    private String countrySVG;

    @Basic(optional = false)
    @NotNull
    @Column(name = "answer1")
    private String answer1;

    @Basic(optional = false)
    @NotNull
    @Column(name = "answer2")
    private String answer2;

    @Basic(optional = false)
    @NotNull
    @Column(name = "answer3")
    private String answer3;

    @Basic(optional = false)
    @NotNull
    @Column(name = "answer4")
    private String answer4;

    @Basic(optional = false)
    @NotNull
    @Column(name = "points")
    private Long points;

    @ManyToOne()
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Question() {}

    public Question(Long correctCountryId, String countrySVG, String answer1, String answer2, String answer3, String answer4, Long points) {
        this.correctCountryId = correctCountryId;
        this.countrySVG = countrySVG;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.points = points;
    }

    public void setId(Long id) {this.id = id;}
    public void setCorrectCountryId(Long correctCountryId) {this.correctCountryId = correctCountryId;}
    public void setCountrySVG(String countrySVG) {this.countrySVG = countrySVG;}
    public void setAnswer1(String answer1) {this.answer1 = answer1;}
    public void setAnswer2(String answer2) {this.answer2 = answer2;}
    public void setAnswer3(String answer3) {this.answer3 = answer3;}
    public void setAnswer4(String answer4) {this.answer4 = answer4;}
    public void setPoints(Long points) {this.points = points;}
    public void setQuiz(Quiz quiz) {this.quiz = quiz;}

    public Long getId() {return id;}
    public Long getCorrectCountryId() {return correctCountryId;}
    public String getCountrySVG() {return countrySVG;}
    public String getAnswer1() {return answer1;}
    public String getAnswer2() {return answer2;}
    public String getAnswer3() {return answer3;}
    public String getAnswer4() {return answer4;}
    public Long getPoints() {return points;}
    public Quiz getQuiz() {return quiz;}

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", correctCountryId=" + correctCountryId +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                '}';
    }
}
