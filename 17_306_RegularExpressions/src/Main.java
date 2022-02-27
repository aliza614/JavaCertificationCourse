import javafx.css.Match;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String string="I am a string.  Yes I am";
        System.out.println(string);
        String yourString=string.replaceAll("I","You");
        System.out.println(yourString);

        String alphanumeric="ahfdkhakdsj297430keasdhfkj8932yh";
        System.out.println(alphanumeric.replaceAll(".","Y"));
        System.out.println(alphanumeric.replaceAll("ahf","YYY"));
        String secondString="ahfdkhakdsj2974ahf30keasdhfkj8932yh";
        System.out.println(alphanumeric.replaceAll("^ahf","YYY"));
        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^ahf"));//false
        System.out.println(alphanumeric.matches("ahfdkhakdsj2974ahf30keasdhfkj8932yh"));//returns true if the whole string matches
        System.out.println(alphanumeric.replaceAll("2yh$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]","X"));//will replace any a, e, or i with the X
        System.out.println(alphanumeric.replaceAll("[aei][Fj]","X"));
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
        String newAlphanumeric="ahfdkhakdsj2974ahf30keasdhfkj8932yh";
        //replace everything except e and j
        System.out.println(newAlphanumeric.replaceAll("[^ej]","X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]","X"));
        //DOES THE SAME AS ABOVE LINE
        System.out.println(newAlphanumeric.replaceAll("[a-f3-8]","X"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]","X"));
        //DOES THE SAME AS ABOVE LINE
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]","X"));

        System.out.println(newAlphanumeric.replaceAll("[0-9]","X"));
        //DOES THE SAME AS ABOVE LINE
        System.out.println(newAlphanumeric.replaceAll("\\d","X"));

        //replaces all non digits with x
        System.out.println(newAlphanumeric.replaceAll("\\D","X"));

        String hasWhiteSpace="I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhiteSpace);
        //replaces all whitespaces
        System.out.println(hasWhiteSpace.replaceAll("\\s",""));

        //replace all tabs
        System.out.println(hasWhiteSpace.replaceAll("\t","X"));

        //replace all non whitespace
        System.out.println(hasWhiteSpace.replaceAll("\\S",""));
        //a-z 0-9 and _
        System.out.println(hasWhiteSpace.replaceAll("\\w","X"));
        //START AND END OF EACH WORD HAS X
        System.out.println(hasWhiteSpace.replaceAll("\\B","X"));

        String thirdAlphanumericString= "ahfffdkhakdsj2974ahf30keasdhfkj8932yh";
        System.out.println(thirdAlphanumericString.replaceAll("^ahf{3}","X"));
        //searches with an unspeficied numebr of fs at the end of the string
        System.out.println(thirdAlphanumericString.replaceAll("^ahf+","YYY"));
        //searches with or without an unspeficied numebr of fs at the end of the string
        System.out.println(thirdAlphanumericString.replaceAll("^ahf*","YYY"));
        //searches with 2-5 numebr of fs at the end of the string
        System.out.println(thirdAlphanumericString.replaceAll("^ahf{2,5}","YYY"));
        //searches with or without an unspeficied numebr of as 0 or more hs and an fat the end of the string
        System.out.println(thirdAlphanumericString.replaceAll("a+h*f","YYY"));

        StringBuilder htmlText=new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2> Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something</p>");
        htmlText.append("<p>This is another paragraph about something else </p>");
        htmlText.append("<h2> Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");
        String h2Pattern =".*<h2>.*";
        Pattern pattern= Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE |Pattern.UNICODE_CASE);
        Matcher matcher= pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        // something having to do with groups
        // h2Pattern ="(<h2>)";
        h2Pattern ="<h2>";
        pattern= Pattern.compile(h2Pattern);
        matcher= pattern.matcher(htmlText);
        int count =0;
        while (matcher.find()){
            count++;
            System.out.println("Occurence "+count+" : "+matcher.start()+" to "+matcher.end());
        }

        String h2GroupPattern="(<h2>.*?</h2>)";
        Pattern groupPattern=Pattern.compile(h2GroupPattern);
        Matcher groupMatcher=groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find())
        {
            System.out.println("Occurrence: "+groupMatcher.group(1));
        }

        String h2TextGroups="(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern=Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher=h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()){
            System.out.println("Occurence: "+h2TextMatcher.group(2));
            //gives 2nd group which is the stuff between the tags
        }
        System.out.println("harry".replaceAll("[H|h]arry","Larry" ));

        String phone1="1234567890";//shouldn't match
        String phone2="(123) 456-7890";//match
        String phone3="123 456-7890";//shouldn't match
        String phone4="(123)456-7890";//shouldn't match

        System.out.println("phone1 = "+phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone2 = "+phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone3 = "+phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone4 = "+phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-][0-9]{4})$"));

        String challenge1="I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));
        String challenge2="I want a ball.";
        System.out.println(challenge1.matches("I want a \\w+."));
        System.out.println(challenge2.matches("I want a (bike|Ball)."));

        //CHALLENGE 3
        String regExExpression="I want a (bike|Ball).";
        Pattern regExPattern=Pattern.compile(regExExpression);
        Matcher regExMatcher=regExPattern.matcher(challenge1);
        System.out.println(regExMatcher.matches());
        regExMatcher=regExPattern.matcher(challenge2);
        System.out.println(regExMatcher.matches());

        //CHALLENGE 4
        String challenge4="Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll(" ","_"));
        System.out.println( challenge4.replaceAll("\\s","_"));

        //CHALLENGE 5
        String challenge5="aaabccccccccdddefffg";
        String regEx2="[abcdefg]+";
        //String regEx2="[a-g]+";
        System.out.println( challenge5.matches(regEx2));
        //CHALLENGE 6
        String regEx3="^a{3}bc{8}d{3}ef{3}g$";
        //CHALLENGE 7
        String challenge7="abcd.135";
        String regEx4="^\\D+\\.\\d+$";
        //String regEx4="^\\[A-Z[a-z]+\\.\\d$";

        String challenge8="abcd.135uvqz.7tzik.999";
        Pattern pattern8=Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher8= pattern8.matcher(challenge8);
        while (matcher8.find()){
            System.out.println("Occurrence: "+matcher8.group(1));
        }

        //CHALLENGE 9
        String challenge9="abcd.135\tuvqz.7\ttzik.999\n";
        String regEx9="[A-Za-z]+\\.(\\d+)\\s";
        Pattern pattern9=Pattern.compile(regEx9);
        Matcher matcher9=pattern9.matcher(challenge9);
        while(matcher9.find())
        {
            System.out.println("Occurence : "+matcher9.group(1));
        }

        //CHALLENGE 10
        String challenge10="abcd.135\tuvqz.7\ttzik.999\n";
        String regEx10="[A-Za-z]+\\.(\\d+)\\s";
        Pattern pattern10=Pattern.compile(regEx10);
        Matcher matcher10=pattern10.matcher(challenge10);
        while(matcher10.find())
        {
            System.out.println("Occurence : start="+matcher10.start(1)+" end="+(matcher10.end(1)-1));
        }
        //CHALLENGE 11
        String challenge11="{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        String regEx11="[^\\{\\}]*" ;
        challenge11.replaceAll(regEx11,"");

        //CHALLENGE 12
        String challenge12="11111";
        String regEx12="^\\d{5}$";
        System.out.println(challenge12.matches(regEx12));

        //CHALLENGE 13
        String challenge13="11111-1111";
        String regEx13="^\\d{5}-\\d{4}$";
        System.out.println(challenge13.matches(regEx13));


        //CHALLENGE 14
        String challenge14="11111-1111";
        String regEx14="^\\d{5}-\\d{4}$|^\\d{5}$";
        String regEx14a="^\\d{5}(-\\d{4})?$";
        System.out.println(challenge14.matches(regEx14));

    }


}
