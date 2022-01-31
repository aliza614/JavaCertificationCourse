import java.util.Scanner;

public class SortedArray {
    public static int[] getIntegers(int number){
        Scanner scanner=new Scanner(System.in);
        int [] array=new int[number];
        System.out.println("What are "+number+" integers that you want to input");
        for(int i=0;i<number;i++)
        {
            array[i]=scanner.nextInt();
        }
        scanner.close();
        return array;
    }

    public static void printArray(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.println("Element "+i+" contents "+array[i]);
        }
    }
    public static int[] sortIntegers(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i=0;i<array.length-1;i++)
            {
                if (array[i]<array[i+1]){
                    int temp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;
                    flag =true;
                }
            }
        }
        return array;
    }
}
