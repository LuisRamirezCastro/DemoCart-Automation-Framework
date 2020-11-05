package pojo;

public class productPriceData {

    private String name;
    private String dollars;
    private String euros;
    private String pounds;

    public productPriceData(String _name, String _dollars, String _euros, String _pounds) {
        this.name = _name;
        this.dollars = _dollars;
        this.euros = _euros;
        this.pounds = _pounds;
    }

    public String getName() {
        return this.name;
    }
    public String getDollars() {
        return this.dollars;
    }
    public String getEuros() {
        return this.euros;
    }
    public String getPounds() {
        return this.pounds;
    }

}