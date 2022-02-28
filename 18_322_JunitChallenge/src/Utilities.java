public class Utilities {
    //returns a char array containing every nth char.  When'
    // sourceArray.length<n, returns sourceArray
    public char[] everyNthChar(char[] sourceArray, int n){
        if (sourceArray==null||sourceArray.length<n)
            return sourceArray;
        int returnedLength=sourceArray.length/n;
        char[] result=new char[returnedLength];
        int index=0;

        for (int i = n-1; i < sourceArray.length ; i++) {
            result[index++]=sourceArray[i];

        }
        return result;
    }
    //"ABBCDEEF"->"ABCDEF"
    //"ABCBDEEF"->"ABCBDEF" the 2 bs aren't next to eachother so aren't removed
    public String removePairs(String source){
        if (source.length()<2) return source;
        StringBuilder sb=new StringBuilder();
        char[] string=source.toCharArray();
        for (int i = 0; i < string.length-1; i++) {
            if (string[i]==string[i+1])
                sb.append(string[i++]);
            else
                sb.append(string[i]);
        }
        if(string[string.length-1]!=string[string.length-2])
            sb.append(string[string.length-1]);
        return sb.toString();
    }
    public int converter(int a, int b){
        return a/b+(a*30)-2;
    }
    public String nullIfOddLength(String source){
        if(source.length()%2==0)
        {
            return source;
        }else{
            return null;
        }
    }
}
