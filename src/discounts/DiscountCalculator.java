package discounts;

import com.hz.Customer;
import products.Product;

public class DiscountCalculator {

    private Customer customer;




    public DiscountCalculator(Customer customer) {
        this.customer = customer;
    }

    public double getDiscount(Product product, int index) {

        double discount = 0.0;

        boolean isFirstProduct = index == 0;

        // on Christmas Eve, 1st product 20%, the next 12.5% discount
        if(ChristmasEve.isChristmasEve) {

            if(isFirstProduct) {
                discount = .20;
            } else {
                discount = .125;
            }

        }

        // Default situation: new customers full price, regular 15% off
        else if(customer.isRegular()) {
            discount = .15;
        }

        return 1 - discount;
    }
}
