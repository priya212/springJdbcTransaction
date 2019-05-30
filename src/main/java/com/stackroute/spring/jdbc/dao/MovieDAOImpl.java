package com.stackroute.spring.jdbc.dao;

import com.stackroute.spring.jdbc.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class MovieDAOImpl implements  MovieDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(Movie movie) {
        String movieQuery="insert into movies values(?,?,?,?)";
        String actorQuery="insert into actor values(?,?,?)";

        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        jdbcTemplate.update(movieQuery,new Object[] {movie.getMovieId(),movie.getMovieName(),movie.getReleaseYear(),movie.getRating()});
        System.out.println("Movie Added in movies table");

        jdbcTemplate.update(actorQuery, new Object[] {movie.getMovieId(),movie.getActor().getActorName(),movie.getActor().getActorAge()});

        System.out.println("Actor added in actor table");

    }
}
