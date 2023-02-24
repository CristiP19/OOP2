package string;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StringUsage {
    public static void main(String[] args) {
        // Citirea din fisier
        String fraza = null;
        try {
            File fisier = new File("C:\\Users\\01230\\Desktop\\Univer Anul II\\testJava.txt");
            Scanner scanner = new Scanner(fisier);
            fraza = scanner.nextLine();
            System.out.println("Fraza importata din fisier este: " + fraza);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit.");
        }
        // Task 1
        convertToUpperCase(fraza);
        // Task 2
        converToLowerCase(fraza);
        //Task 3
        int lenght = getfrazaLenght(fraza);
        System.out.println("Lungimea frazei este de : " + lenght);
        //Task 4
        countOfConsonantsAndVowels(fraza);
        //Task 5
        int numberWords = countWords(fraza);
        System.out.println("Fraza are " + numberWords + " cuvinte");
        //Task 6
        maxLenghtWord(fraza);
        //Task 7
        minLenghtWord(fraza);
        //Task 8
        String[] duplicates = findDuplicateWords(fraza);
        {
            for (String word : duplicates) {
                System.out.println("Cuvintul care se repeta este: " + word);
            }
        }
    }
    // Task 1
    public static void convertToUpperCase(String fraza) {
        System.out.println("fraza in uppercase: " + fraza.toUpperCase());
    }
    // Task 2
    public static void converToLowerCase(String fraza) {
        System.out.println("fraza in lowercase: " + fraza.toLowerCase());
    }
    // Task 3
    public static int getfrazaLenght(String fraza) {
        return fraza.length();
    }
    // Task 4
    public static void countOfConsonantsAndVowels(String fraza) {
        int vocale = 0;
        int consoane = 0;
        for (int i = 0; i < fraza.length(); i++) {
            char ch = fraza.charAt(i);
            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                        ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    vocale++;
                } else {
                    consoane++;
                }
            }
        }
        System.out.println("Numarul de vocale: " + vocale);
        System.out.println("Numarul de consoane: " + consoane);
    }
    // Task 5
    private static int countWords(String fraza){
        String[] words = fraza.split("\\s+");
        return words.length;
    }
    // Task 6
    private static void maxLenghtWord(String fraza){
        String[] cuvinte = fraza.split(" ");
        int lungimeMaxima = 0;
        String cuvantMaxim = "";

        for (String cuvant : cuvinte) {
            int lungime = cuvant.length();
            if (lungime > lungimeMaxima) {
                lungimeMaxima = lungime;
                cuvantMaxim = cuvant;
            }
        }

        System.out.println("Cuvântul cu lungimea maximă din frază este: " + cuvantMaxim + " si are lungimea de " + lungimeMaxima + " caractere.");
    }
    // Task 7
    private static void minLenghtWord(String fraza){
        String[] cuvinte = fraza.split(" ");

        String cuvantMinim = cuvinte[0];

        for (String cuvant : cuvinte) {
            if (cuvant.length() < cuvantMinim.length()) {
                cuvantMinim = cuvant;
            }
        }

        System.out.println("Cuvantul cu lungimea minima este " + cuvantMinim + " cu o lungime de " + cuvantMinim.length() + " caractere.");
    }
    // Task 8
    public static String[] findDuplicateWords(String fraza) {
        String[] words = fraza.toLowerCase().split("\\s+");
        Set<String> uniqueWords = new HashSet<>();
        List<String> duplicateWords = new ArrayList<>();

        for (String word : words) {
            if (!uniqueWords.add(word)) {
                duplicateWords.add(word);
            }
        }
        return duplicateWords.toArray(new String[duplicateWords.size()]);
    }
}
