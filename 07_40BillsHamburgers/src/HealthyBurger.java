public class HealthyBurger extends Hamburger {
    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("healthy", meat, price, "brown rye");
    }


    public void addHealthyAddition1(String name, double price) {
        this.healthyExtra1Name=name;
        this.healthyExtra1Price=price;
    }
    public void addHealthyAddition2(String name, double price) {
        this.healthyExtra2Name=name;
        this.healthyExtra2Price=price;
    }
    public double itemizeHamburger() {
        System.out.println( "Healthy hamburger on a Brown rye roll with "+super.getMeat()+", price is "+super.getPrice());
        if(healthyExtra1Name!=null)
            System.out.println( "Added "+healthyExtra1Name+" for an extra "+healthyExtra1Price);
        if(healthyExtra2Name!=null)
            System.out.println( "Added "+healthyExtra2Name+" for an extra "+healthyExtra2Price);
        System.out.println( "Total Healthy Burger price is  "+super.getPrice());
        return super.getPrice() +healthyExtra1Price+healthyExtra2Price;

    }
}
