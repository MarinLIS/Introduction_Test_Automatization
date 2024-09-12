package ru.gb.seminars.seminar_03.spoonacular;

import ru.gb.seminars.seminar_03.spoonacular.recipers.OrgMaxLesson3Seminar;


import java.util.List;

public class RandomRecipesDto {

    List<OrgMaxLesson3Seminar> recipes;

    public List<OrgMaxLesson3Seminar> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<OrgMaxLesson3Seminar> recipes) {
        this.recipes = recipes;
    }
}
