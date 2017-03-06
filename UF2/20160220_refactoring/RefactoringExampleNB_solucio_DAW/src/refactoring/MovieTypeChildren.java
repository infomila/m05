package refactoring;

/**
 *
 * @author BERNAT
 */
public class MovieTypeChildren extends MovieType{

  
    @Override
    public double getPrice(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3){
                    thisAmount += (daysRented - 3) * 1.5;
        }
        return thisAmount;
     }
    
}
