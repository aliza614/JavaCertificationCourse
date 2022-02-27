import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                String myString="Let's split this uo into an array";
//                String[] parts=myString.split(" ");
//                for (String part:parts){
//                    System.out.println(part);
//                }
//            }
//        };

        Runnable runnable1=()->{
            String myString="Let's split this uo into an array";
            String[] parts=myString.split(" ");
            for (String part:parts){
                System.out.println(part);
            }
        };
        //CHALLENGE 2
        Function<String,String> lambdaFunction= s->{
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(lambdaFunction.apply("1234567890"));
        everySecondCharacter(lambdaFunction, "1234567890");
       // Supplier<String> iLoveJave=()->"I love Java!";
        Supplier<String> iLoveJave=()->{ return "I love Java!";};
        String supplierResult=iLoveJave.get();
        System.out.println(supplierResult);

        List<String> topNames2015= Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        List <String > firstUpperCaseList=new ArrayList<>();
        topNames2015.forEach(name-> firstUpperCaseList.add(name.substring(0,1).toUpperCase()+name.substring(1)));
        firstUpperCaseList.sort((s1,s2)->s1.compareTo(s2));
        //SAME AS THE LINE ABOVE firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(s-> System.out.println(s));
        //SAME AS THE LINE ABOVE firstUpperCaseList.forEach(System.out::println);

        //SAME AS ABOVE 4 LINES
        topNames2015
                .stream()
                .map(name->name.substring(0,1).toUpperCase()+name.substring(1))
                .peek()
                .sorted(String::compareTo)
                .forEach(System.out::println);
        long namesBeginningWithA=topNames2015
                .stream()
                .map(name->name.substring(0,1).toUpperCase()+name.substring(1))
                .filter(name->name.startsWith("A"))
                .count();
        System.out.println("number of names beginning with A is "+namesBeginningWithA);
    }


//    //CHALLENGE 2 to copy
//    public static String everySecondChar(String source) {
//        StringBuilder returnVal = new StringBuilder();
//        for (int i = 0; i < source.length(); i++) {
//            if (i % 2 == 1) {
//                returnVal.append(source.charAt(i));
//            }
//        }
//        return returnVal.toString();
//    }
    public static String everySecondCharacter(Function<String,String> func, String source){
        return func.apply(source);
    }
}
