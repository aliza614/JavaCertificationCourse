public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays (long minutes)
    {
        if (minutes<0) {
            System.out.println("Invalid Value");
        }else{
            long daysTotal=minutes/60/24;
            long years=(daysTotal/365);
            long days=(daysTotal%365);
            System.out.println(minutes+" min = "+years+" y and "+days+" d");
        }
    }
}
