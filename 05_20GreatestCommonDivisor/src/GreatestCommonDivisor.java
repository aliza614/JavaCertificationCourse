public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int a, int b){
        if(a<10||b<10) return -1;
        int maxNumber,maxCD=1;
        if (a>b) {
            maxNumber=b
        }else maxNumber=a;
        for (int i=1;i<=maxNumber;i++)
        {
            if (a%i==0&&b%i==0)
                maxCD=i;
        }
        return maxCD;
    }
}
