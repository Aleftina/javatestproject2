package ua.javatests;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        String[] languages = {"java", "python", "php"};
        languages[0] = "python";
        languages[1] = "php";
        languages[2] = "java";

        for (int i = 0; i<3; i++) {
            System.out.println(" language "+i+" = "+languages[i]);
        }

        List<String> languagesList = new ArrayList<String>();
        List<String> usersList = Arrays.asList("Vasya", "Petya", "Masha");

        languagesList.add("c#");
        languagesList.add("cpp");
        languagesList.add("java");

        for (String l: languagesList) {
            for (String user : usersList) {
                System.out.println(user+" learns  " + l);
            }
        }
    }
}
