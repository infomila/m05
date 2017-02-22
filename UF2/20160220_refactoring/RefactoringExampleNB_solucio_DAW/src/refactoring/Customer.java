package refactoring;

import java.util.Iterator;
import java.util.LinkedList;

//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins
public class Customer {

    private String _name;
    private LinkedList<Rental> _rentals = new LinkedList<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int points = 0;
        String result = "Rental Record for " + getName() + "\n";

        for(Rental curRental: _rentals) {
            
            double thisAmount = curRental.getPrice();

            // add frequent renter points
            points++;
            // add bonus for a two day new release rental
            if ((curRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && 
                    curRental.getDaysRented() > 1) {
                points++;
            }

            // show figures for this rental
            result += "\t" + curRental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(points) + " frequent renter points";

        return result;
    }

}
