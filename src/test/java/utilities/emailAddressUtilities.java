package utilities;

import java.util.Random;

public class emailAddressUtilities {

    public emailAddressUtilities(){}

    public String gerRandomEmailAddress(String name, String lastName){

        return name + lastName + getRandomNumberUsingNextInt(1, 99999) + "@mail.com";
    }

    public String getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return Integer.toString(random.nextInt(max - min) + min);
    }
}
