package dtos;

import entities.Question;
import entities.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizLiteDTO {
    private List<QuestionDTO> questions = new ArrayList<>();



    public QuizLiteDTO(List<Question> questions) {
        for (Question question : questions) {
            this.questions.add(new QuestionDTO(question));
        }
    }


    public void setQuestions(List<QuestionDTO> questions) {this.questions = questions;}



    public List<QuestionDTO> getQuestions() {return questions;}

}
