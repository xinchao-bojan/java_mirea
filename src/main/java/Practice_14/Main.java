package Practice_14;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N= Integer.parseInt(in.nextLine());
        String[] simpleArray=new String[N];
        for (int i = 0; i < N; i++) {
            simpleArray[i]=in.nextLine();
        }
        String line = in.nextLine();
      // Handler handler=new Handler(simpleArray,line);
       // handler.firstMethod();
       // handler.secondMethod();



        String str ="";
        for (int i = 0; i < simpleArray.length; i++) {
            str+=simpleArray[i].split(" ")[0];
            if (i != simpleArray.length - 1)
                str+="|";
        }
        HashMap<String, String> replaceMap = new HashMap<>();
        for (String t : simpleArray) {
            replaceMap.put(t.split(" ")[0], t.split(" ")[1]);
        }

        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(line);
        System.out.println(/*"Second method result | " + */matcher.replaceAll(mchr -> replaceMap.get(mchr.group())));

    }
}
