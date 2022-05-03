package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_name", length = 25)
    private String userName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_pass")
    private String userPass;

    @Basic(optional = false)
    @NotNull
    @Column(name = "points")
    private Long points;

    @Basic(optional = false)
    @NotNull
    @Column(name = "answered")
    private Long answered;              // questions answered

    @Basic(optional = false)
    @NotNull
    @Column(name = "correct")
    private Long correct;               // questions answered correctly

    @Basic(optional = false)
    @NotNull
    @Column(name = "incorrect")
    private Long incorrect;             // questions answered incorrectly

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;

    @JoinTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "user_name", referencedColumnName = "user_name")}, inverseJoinColumns = {
            @JoinColumn(name = "role_name", referencedColumnName = "role_name")})
    @ManyToMany
    private List<Role> roleList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Quiz> quizzes;

    public List<String> getRolesAsStrings() {
        if (roleList.isEmpty()) {
            return null;
        }
        List<String> rolesAsStrings = new ArrayList<>();
        roleList.forEach((role) -> {
            rolesAsStrings.add(role.getRoleName());
        });
        return rolesAsStrings;
    }

    public User() {}

    public User(String userName, String userPass, Country country) {
        this.userName = userName;
        this.userPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
        this.points = 0L;
        this.answered = 0L;
        this.correct = 0L;
        this.incorrect = 0L;
        this.country = country;
    }

    public User(String userName, String userPass, Long points, Long answered, Long correct, Long incorrect, Country country) {
        this.userName = userName;
        this.userPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
        this.points = points;
        this.answered = answered;
        this.correct = correct;
        this.incorrect = incorrect;
        this.country = country;
    }

    public void setUserName(String userName) {this.userName = userName;}
    public void setUserPass(String userPass) {this.userPass = userPass;}
    public void setPoints(Long points) {this.points = points;}
    public void setAnswered(Long answered) {this.answered = answered;}
    public void setCorrect(Long correct) {this.correct = correct;}
    public void setIncorrect(Long incorrect) {this.incorrect = incorrect;}
    public void setCountry(Country country) {this.country = country;}
    public void setRoleList(List<Role> roleList) {this.roleList = roleList;}
    public void addRole(Role role) {this.roleList.add(role);}

    public String getUserName() {return userName;}
    public String getUserPass() {return userPass;}
    public Long getPoints() {return points;}
    public Long getAnswered() {return answered;}
    public Long getCorrect() {return correct;}
    public Long getIncorrect() {return incorrect;}
    public Country getCountry() {return country;}
    public List<Role> getRoleList() {return roleList;}

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", points=" + points +
                ", answered=" + answered +
                ", correct=" + correct +
                ", incorrect=" + incorrect +
                ", country=" + country +
                ", roleList=" + roleList +
                '}';
    }

    public boolean verifyPassword(String pw) {
        return (BCrypt.checkpw(pw, userPass));
    }
}
