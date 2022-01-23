public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double a, double b)
    {
        long aRounded=((long)(a*10000))/10;
        long bRounded=((long)(b*10000))/10;
        return (aRounded==bRounded);
    }
}
