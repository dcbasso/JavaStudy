package com.dantebasso.graphql.model;

/**
 * @author Dante Basso <dantebasso@rezolve.com>
 * @since 07-06-2022
 */
public class Show {

    private final String title;
    private final Integer releaseYear;

    public Show(String title, Integer releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

}
