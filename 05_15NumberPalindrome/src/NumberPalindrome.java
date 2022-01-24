public class NumberPalindrome {
    public static void main(String[] args) {
        isPalindrome(-222);
    }
    public static boolean isPalindrome(int num){
        int numCopy=num;
        int newNum=0;
        int sign =1;
        if (num<0) {
            sign=-1;
            System.out.println("sign negative");
        }
        while (numCopy!=0) {
            newNum = newNum * 10 + numCopy % 10;
            System.out.println("new num" + newNum);
            numCopy /= 10;
        }
        newNum*=sign;
        return (newNum==num);
    }
}
