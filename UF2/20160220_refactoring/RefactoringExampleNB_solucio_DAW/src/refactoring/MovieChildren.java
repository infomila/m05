package refactoring;

/**
 *
 * @author BERNAT
 */
public class MovieChildren extends Movie{

    public MovieChildren(String title) {
        super(title, Movie.CHILDRENS);
    }

    @Override
    double getPrice(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3){
                    thisAmount += (daysRented - 3) * 1.5;
        }
        return thisAmount;
     }
    
}
