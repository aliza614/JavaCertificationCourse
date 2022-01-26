public class DiagonalStar {
    public static void printSquareStar(int number) {
        if (number<5){
            System.out.println("Invalid Value");
            return;
        }
        //make a double for loop that prints a square with a diagonal
        for (int r=0;r<number;r++) {
            String row = "";
            for (int c = 0; c < number; c++) {
                if(c==0||c==number-1||c==r||c==number-1-r||r==0||r==number-1)
                    row+="*";
                else row+=" ";

            }
            System.out.println(row);
        }
    }
}