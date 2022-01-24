public class EvenDigitSum {
    public static int getEvenDigitSum(int number){
        int sum=0;
        if (number<0) return -1;
        while(number>0)
        {
            if (isEven(number))
                sum+=number%10;
            number/=10;
        }
        return sum;
    }
    public static boolean isEven(int n){
        return (n%2==0);
    }

}
