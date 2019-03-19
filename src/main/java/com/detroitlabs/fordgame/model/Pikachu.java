package com.detroitlabs.fordgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pikachu {

    private String name;
    private String weight;
    private String base_experience;
    private PikachuSprite pikachuSprite = new PikachuSprite();

    @JsonProperty("sprites")
    public PikachuSprite getPikachuSprite() {
        return pikachuSprite;
    }

    @JsonProperty("sprites")
    public void setPikachuSprite(PikachuSprite pikachuSprite) {
        this.pikachuSprite = pikachuSprite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }
}
