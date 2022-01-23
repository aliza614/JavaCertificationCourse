public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year){
         return (year>=0)&&((year%4==0&&year%100!=0)||(year%400==0));
    }
    public static int getDaysinMonth (int month, int year){
        if (month<1||month>12||year<1||year>9999)
        {
            return -1;
        } else{
            switch (month){
                case 1:
                    return 31;
                    break;
                case 2:
                    if (isLeapYear(year))
                    {
                            return 29;
                    }else
                        return 28;
                    break;
                case 3:
                    return 31;
                    break;
                case 4:
                    return 30;
                    break;
                case 5:
                    return 31;
                    break;
                case 6:
                    return 30;
                    break;
                case 7:
                    return 31;
                    break;
                case 8:
                    return 31;
                    break;
                case 9:
                    return 30;
                    break;
                case 10:
                    return 31;
                    break;
                case 11:
                    return 30;
                    break;
                case 12:
                    return 31;
                    break;
                default:
                    return -1;
            }
        }
    }
}
