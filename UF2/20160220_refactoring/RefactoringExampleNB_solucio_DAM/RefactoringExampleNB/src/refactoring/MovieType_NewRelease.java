package refactoring;

/**
 *
 * @author BERNAT
 */
public class MovieType_NewRelease extends MovieType{

    @Override
    public double getPrice(int daysRented) {
        return daysRented * 3;
    }
    
    
}
