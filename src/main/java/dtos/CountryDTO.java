package dtos;

import entities.Country;

public class CountryDTO {

    private Long id;
    private String countryName;
    private Long answered;
    private Long correct;
    private Long incorrect;
    private String svg;

    public CountryDTO(String countryName, Long answered, Long correct, Long incorrect, String svg) {
        this.countryName = countryName;
        this.answered = answered;
        this.correct = correct;
        this.incorrect = incorrect;
        this.svg = svg;
    }

    public CountryDTO(Country c) {
        if (c.getId() != null) {
            this.id = c.getId();
        }
        this.countryName = c.getCountryName();
        this.answered = c.getAnswered();
        this.correct = c.getCorrect();
        this.incorrect = c.getIncorrect();
        this.svg = c.getCountrySVG();
    }

    public void setId(Long id) {this.id = id;}
    public void setCountryName(String countryName) {this.countryName = countryName;}
    public void setAnswered(Long answered) {this.answered = answered;}
    public void setCorrect(Long correct) {this.correct = correct;}
    public void setIncorrect(Long incorrect) {this.incorrect = incorrect;}
    public void setSvg(String svg) {this.svg = svg;}

    public Long getId() {return id;}
    public String getCountryName() {return countryName;}
    public Long getAnswered() {return answered;}
    public Long getCorrect() {return correct;}
    public Long getIncorrect() {return incorrect;}
    public String getSvg() {return svg;}
}
