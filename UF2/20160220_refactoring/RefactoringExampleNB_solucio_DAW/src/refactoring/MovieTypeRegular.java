package refactoring;

/**
 *
 * @author BERNAT
 */
public class MovieTypeRegular extends MovieType{


    @Override
    public double getPrice(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }
        return thisAmount;
    }
    
}
