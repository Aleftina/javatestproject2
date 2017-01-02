package ua.javatests;

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
        }
    }
}
