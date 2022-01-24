public class NumberToWords {
    public static void numberToWords(int a){
        int b=reverse(a);
        String sNumber="",sDigit="";
        if (a<0){
            System.out.println("Invalid Value");
            return;
        }

        while(b>0) {
            switch (b % 10) {
                case 0:
                    sDigit = "Zero";
                    break;
                case 1:
                    sDigit = "One";
                    break;
                case 2:
                    sDigit = "Two";
                    break;
                case 3:
                    sDigit = "Three";
                    break;
                case 4:
                    sDigit = "Four";
                    break;
                case 5:
                    sDigit = "Five";
                    break;
                case 6:
                    sDigit = "Six";
                    break;
                case 7:
                    sDigit = "Seven";
                    break;
                case 8:
                    sDigit = "Eight";
                    break;
                case 9:
                    sDigit = "Nine";
                    break;
            }
            b/=10;
            if (sNumber=="") sNumber=sDigit;
            else sNumber=sNumber+" "+sDigit;
        }
        if (getDigitCount(a)!=getDigitCount(b)){
            int dif=getDigitCount(a)-getDigitCount(b);
            for (int i=0;i<dif;i++)
            {
                if (sNumber=="") sNumber="Zero";
                else sNumber=sNumber+" "+"Zero";
            }
        }
        System.out.println(sNumber);

    }

    public static int reverse(int a){
        int opp=0;
        while (a!=0){
            opp=opp*10+a%10;
            a/=10;
        }
        return opp;
    }
    public static int getDigitCount(int a){
        int answer=0;
        while (a>0) {
            answer++;
            a/=10;
        }
        return answer;
    }

}
