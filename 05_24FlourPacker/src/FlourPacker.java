public class FlourPacker {
    //bigCount represents 5 kilo, smallCount represents 1 kil, goal=number of kilo needed
    public static boolean canPack(int bigCount, int smallCount, int goal)
    {
        while( goal>=5&&bigCount>0)
        {
            goal-=5;
            bigCount--;
        }
        while(goal>0&&smallCount>0)
        {
            goal--;
            smallCount--;
        }
        return (goal==0);
    }


}
