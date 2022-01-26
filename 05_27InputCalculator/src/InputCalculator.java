import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage(){
        Scanner scanner=new Scanner(System.in);
        int sum=0,count=0;
        while (true){
            boolean hasInt=scanner.hasNextInt();
            if(!hasInt) break;
            int i=scanner.nextInt();
            sum+=i;
            count++;
            scanner.nextLine();
        }
        System.out.println("SUM = "+sum+" AVG = "+Math.round(( (double)sum/count));

        scanner.close();
    }
}
