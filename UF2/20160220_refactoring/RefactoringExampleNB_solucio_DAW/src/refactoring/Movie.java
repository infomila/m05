package refactoring;

// From book: 'Refactoring' by Martin Fowler

import java.util.logging.Level;
import java.util.logging.Logger;

// This is the original code before refactoring begins
public class Movie {

 
    private String _title;
    private MovieTypeEnum _priceCode;
    private MovieType _type;

    public Movie(String title, MovieTypeEnum priceCode) {
        _title = title;
        _priceCode = priceCode;
        updateMovieType(priceCode);
    }

    public void updateMovieType(MovieTypeEnum priceCode) {        
        try {
            _type = (MovieType)priceCode.getC().newInstance();
            
           /* Class [] mtc = new Class[]{                
                MovieTypeRegular.class,
                MovieTypeNewRelease.class,
                MovieTypeChildren.class
            };
            _type = (MovieType) mtc[priceCode.ordinal()].newInstance();
            */
            /*
            switch (priceCode) {
            case REGULAR: {
            _type = new MovieTypeRegular();
            }
            break;
            case NEW_RELEASE: {
            _type = new MovieTypeNewRelease();
            }
            break;
            case CHILDRENS: {
            _type = new MovieTypeChildren();
            }
            break;
            }*/
        } catch (InstantiationException ex) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MovieTypeEnum getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(MovieTypeEnum priceCode) {
        _priceCode = priceCode;
        updateMovieType(priceCode);
    }

    public String getTitle() {
        return _title;
    }

    double getPrice(int daysRented) {
        return _type.getPrice(daysRented);
    }

}
