import java.util.Scanner;

public class MinimumElement {

    private static int readInteger(){
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        scanner.nextLine();
        scanner.close();
        return number;
    }
    private static int[] readElements(int count){
        int[] array=new int[count];
        Scanner scanner=new Scanner(System.in);
        for (int i=0;i<array.length;i++)
        {
            array[i]=scanner.nextInt();
            scanner.nextLine();
        }
        scanner.close();
        return  array;
    }
    private static int findMin(int [] array){
        //System.out.println("How many ints do you want to process?");
        //int count=readInteger();
        //System.out.println("enter your numbers");
        //int [] array=readElements(count);
        int min=Integer.MAX_VALUE;
        for (int i=0;i<array.length;i++)
            if (min>array[i]) min=array[i];
        return min;
    }
}
