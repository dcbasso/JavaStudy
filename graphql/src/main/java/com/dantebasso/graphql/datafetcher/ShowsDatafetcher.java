package com.dantebasso.graphql.datafetcher;

import com.dantebasso.graphql.model.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dante Basso <dantebasso@rezolve.com>
 * @since 07-06-2022
 */
@DgsComponent
public class ShowsDatafetcher {

    private final List<Show> shows = List.of(
            new Show("Stranger Things", 2016),
            new Show("Ozark", 2017),
            new Show("The Crown", 2016),
            new Show("Dead to Me", 2019),
            new Show("Orange is the New Black", 2013)
    );

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        if(titleFilter == null) {
            return shows;
        }

        return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }

    @DgsQuery
    public List<Show> showsFilterByYear(@InputArgument Integer releaseYearFilter) {
        if(releaseYearFilter == null) {
            return shows;
        }

        return shows.stream().filter(s -> s.getReleaseYear().equals(releaseYearFilter)).collect(Collectors.toList());
    }

}
