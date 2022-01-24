public class SumOddRange {
    public static boolean isOdd (int i){
        if (i<=0) return false;
        return (i%2==1);
    }
    public static int sumOdd (int start, int end){
        if (end<start) return -1;
        int answer=0;
        for (int i =start; i<=end; i++)
            if (isOdd(i)){
                answer+=i;
            }
        return answer;
    }
}
