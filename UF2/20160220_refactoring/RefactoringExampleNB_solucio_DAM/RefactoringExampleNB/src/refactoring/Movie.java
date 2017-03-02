package refactoring;

// From book: 'Refactoring' by Martin Fowler

import java.util.logging.Level;
import java.util.logging.Logger;

// This is the original code before refactoring begins
public class Movie {


    private String _title;
    private MovieTypeEnum _movieTypeCode;
    private MovieType _movieType;

    public Movie(String title, MovieTypeEnum movieTypeCode) {
        _title = title;
        _movieTypeCode = movieTypeCode;
        updateMovieType(movieTypeCode);
    }

    public void updateMovieType(MovieTypeEnum movieTypeCode) {
        try {
            
                         
            _movieType = (MovieType) movieTypeCode.getC().newInstance();
            
            /*Class [] movie_types_classes = new Class[] {
                MovieType_Children.class,
                MovieType_NewRelease.class,
                MovieType_Regular.class
            };
            _movieType = (MovieType) movie_types_classes[movieTypeCode.ordinal()].newInstance();
            */
            /*
            switch (movieTypeCode) {
            case REGULAR:
            _movieType = new MovieType_Regular();
            break;
            case NEW_RELEASE:
            _movieType = new MovieType_NewRelease();
            break;
            case CHILDRENS:
            _movieType = new MovieType_Children();
            break;
            }*/
        } catch (InstantiationException ex) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MovieTypeEnum getMovieTypeCode() {
        return _movieTypeCode;
    }

    public void setMovieTypeCode(MovieTypeEnum arg) {
        _movieTypeCode = arg;
        updateMovieType(_movieTypeCode);
    }

    public String getTitle() {
        return _title;
    }

    double getPrice(int daysRented){
        return _movieType.getPrice(daysRented);
    }
 
}
