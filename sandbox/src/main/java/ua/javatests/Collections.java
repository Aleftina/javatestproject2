package ua.javatests;

<<<<<<< HEAD

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
=======
import java.util.ArrayList;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        String[] langs = {"java", "c#", "python", "php"};

        List<String> languages = new ArrayList<String>();
        languages.add("java");
        languages.add("cpp");

        for (int i = 0; i < languages.size(); i++) {
            System.out.println("I learn " + languages.get(i) + " language");
        }

        for (String language: languages) {
            System.out.println("I know " + language + " language");
        }

        for (String lang : langs) {
            System.out.println("I learn " + lang + " language");
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
        }
    }
}
