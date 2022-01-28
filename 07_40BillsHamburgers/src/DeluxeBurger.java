public class DeluxeBurger extends Hamburger{
    public DeluxeBurger() {
        super("Deluxe", "sausage", 19.10, "white");
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("No additional items can ba added to a deluze burger.");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("No additional items can ba added to a deluze burger.");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }



    public double itemizeHamburger() {
        System.out.println( "Deluxe hamburger on a "+getBreadRollType()+" roll with "+super.getMeat()+", price is "+(super.getPrice()-2.75-1.81));
        System.out.println( "Added Chips for an extra 2.75\n" +
                "    Added Drink for an extra 1.81");

        System.out.println( "Total Deluxe Burger price is  "+super.getPrice());
        return super.getPrice();
    }
}
