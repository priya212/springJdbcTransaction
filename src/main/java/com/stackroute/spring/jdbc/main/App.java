package com.stackroute.spring.jdbc.main;

import com.stackroute.spring.jdbc.model.Actor;
import com.stackroute.spring.jdbc.model.Movie;
import com.stackroute.spring.jdbc.service.MovieManager;
import com.stackroute.spring.jdbc.service.MovieManagerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main(String[] args )
    {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        MovieManager movieManager=(MovieManagerImpl)context.getBean("movieManager");

        Movie movie=createNewMovie();
        movieManager.createMovie(movie);
        context.close();
    }

    private static Movie createNewMovie()
    {
        Movie movie=new Movie();
        movie.setMovieId(1);
        movie.setMovieName("Veer Zaara");
        movie.setReleaseYear(2013);
        movie.setRating(5);
        Actor actor=new Actor();
        actor.setMovieId(movie.getMovieId());
        actor.setActorName("Pretty");
        actor.setActorAge(49);
        movie.setActor(actor);
        return  movie;
    }
}
