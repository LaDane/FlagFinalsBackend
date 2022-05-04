package dtos;

import entities.Continent;
import entities.Country;

import java.util.ArrayList;
import java.util.List;

public class ContinentDTO {

    private Long id;
    private String continentName;
    private List<CountryDTO> countries = new ArrayList<>();

    public ContinentDTO(String continentName) {
        this.continentName = continentName;
    }

    public ContinentDTO(String continentName, List<CountryDTO> countries) {
        this.continentName = continentName;
        this.countries = countries;
    }

    public ContinentDTO(Continent c) {
        if (c.getId() != null) {
            this.id = c.getId();
        }
        this.continentName = c.getContinentName();
        for (Country country : c.getCountries()) {
            this.countries.add(new CountryDTO(country));
        }
    }

    public void setId(Long id) {this.id = id;}
    public void setContinentName(String continentName) {this.continentName = continentName;}
    public void setCountries(List<CountryDTO> countries) {this.countries = countries;}
    public void addCountry(CountryDTO c) {this.countries.add(c);}

    public Long getId() {return id;}
    public String getContinentName() {return continentName;}
    public List<CountryDTO> getCountries() {return countries;}
}
