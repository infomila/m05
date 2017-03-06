package refactoring;

/**
 *
 * @author BERNAT
 */
public class MovieTypeNewRelease extends MovieType{

 

    @Override
    public double getPrice(int daysRented) {
        return daysRented * 3;
    }
    
    
}
