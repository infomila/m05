package refactoring;

/**
 *
 * @author BERNAT
 */
public class MovieRegular extends Movie{

    public MovieRegular(String title) {
        super(title, Movie.REGULAR);
    }

    @Override
    double getPrice(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }
        return thisAmount;
    }
    
}
