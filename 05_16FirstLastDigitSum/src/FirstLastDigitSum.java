public class FirstLastDigitSum {
    // write your code here
    public static int sumFirstAndLastDigit(int num) {
        if (num<0) return -1;

        int first = 0,sum=0, numCopy=num,  last=numCopy%10;
        for (;numCopy!=0;numCopy=numCopy/10) {
            if (numCopy<10)
            {	first=numCopy;
                break;
            }
        }
        return first+last;
    }
}