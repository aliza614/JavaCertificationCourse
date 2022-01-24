public class LastDigitChecker {
    public static boolean hasSameLastDigit(int a,int b, int c)
    {
        if (!isValid(a)||!isValid(b)||!isValid(c)) return false;
        int a1=a%10, b1=b%10, c1=c%10;
        return (a1==b1||a1==c1||b1==c1);
    }
    public static boolean isValid(int a) {
        return (a >= 10 && a <= 1000);
    }
}
