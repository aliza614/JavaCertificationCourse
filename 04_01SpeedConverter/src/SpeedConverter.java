public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour)
    {
        if (kilometersPerHour<0) return -1L;
        return Math.round(kilometersPerHour/1.609);
    }
    public static void printConversion (double kilometersPerHour) {
        if (kilometersPerHour < 0.0) {
            System.out.println("Invalid Value");
        } else {
            String kilo = "" + kilometersPerHour;
            if (kilometersPerHour < 10.0) kilo = "0" + kilo;
            long milesPerHour = toMilesPerHour(kilometersPerHour);
            String miles = "" + milesPerHour;
            if (milesPerHour < 10) miles = "0" + miles;
            System.out.println(kilo+" km/h = "+miles+" mi/h");
        }
    }
}
