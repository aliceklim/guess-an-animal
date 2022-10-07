package animals;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        greeting(now);
        System.out.println("Enter an animal:");
        Scanner scanner = new Scanner(System.in);
        checkArticle(scanner.nextLine());
        checkReply(scanner.nextLine());
        farewell();

    }
    private static void farewell(){
        String[] farewellPhrases = new String[]{"Take care", "I’ll see you then", "See you around", "See ya", "Talk to you later", "Good seeing you!", "Bye for now", "Keep in touch", "Have fun!", "Adios", "So long", "Gotta bounce", "Smell you later!", "Cheerio!", "Nice chatting with you"};
        Random random = new Random();
        int r = random.nextInt(farewellPhrases.length);
        System.out.println(farewellPhrases[r]);
    }
    private static void checkReply(String s){
        String[] posAnswers = new String[]{"y", "yes", "yeah", "yep", "sure", "right", "affirmative", "correct", "indeed", "you bet", "exactly", "you said it"};
        String[] negAnswers = new String[]{"n", "no", "no way", "nah", "nope", "negative", "I don't think so, yeah no"};
        String[] uncAnswers = new String[] {"y..", "Y!.", "ye", "jes", "Jes", "yes...", "да", "Так", "yes, yes", "Yea", "Ja", "Jawohl!", "ja natürlich!", "so genau", "1", "+", "yepi", "Yep!!", "Yes, sure!", "Ok", "Rights", "affErmative", "n..", "N!!", "nea", "nop", "noppi", "no wa", "no way!!!", "na", "nahi", "nega", "negat", "negati", "negativ", "i don't think..", "i don't", "i", "I no", "i don't think so..."};
        ArrayList<String> positiveAnswers = new ArrayList<>(Arrays.asList(posAnswers));
        ArrayList<String> negativeAnswers = new ArrayList<>(Arrays.asList(negAnswers));
        ArrayList<String> unclearAnswers = new ArrayList<>(Arrays.asList(uncAnswers));
        String str = s.trim().replaceAll("[^a-zA-Z0-9\\s]", "");
        if (unclearAnswers.contains(s)){
            System.out.println("yes or no");
        } else if (positiveAnswers.contains(str.toLowerCase())){
            System.out.println("You answered: Yes");
        } else if (negativeAnswers.contains(str.toLowerCase())){
            System.out.println("You answered: No");
        } else {
            System.out.println("yes or no");
        }
    }
    private static void greeting(LocalTime now){
        LocalTime morning = LocalTime.of(5, 0);
        LocalTime day = LocalTime.of(12, 0);
        LocalTime evening = LocalTime.of(18, 0);
        LocalTime night = LocalTime.of(23,0 );
        if (now.isAfter(morning) && now.isBefore(day)){
            System.out.println("Good morning!");
        } else if (now.isAfter(day) && now.isBefore(evening)){
            System.out.println("Good afternoon!");
        } else if (now.isAfter(evening) && now.isBefore(night)){
            System.out.println("Good evening!");
        }  else {
            System.out.println("Hi, Night Owl!");
        }
    }
    private static boolean checkConsonant(String s){
        if (s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'o' || s.charAt(0) == 'i' || s.equals("xeme")){
            return false;
        } else {
            return true;
        }
    }
    private static void checkArticle(String s){
        String[] sWords = s.split(" ",2);
        if (sWords.length == 1){
            if (checkConsonant(sWords[0].toLowerCase())){
                System.out.println("Is it a " + sWords[0].toLowerCase() + "?");
            } else{
                System.out.println("Is it an " + sWords[0].toLowerCase() + "?");
            }
        } else if (sWords[0].toLowerCase().equals("the") || sWords[0].toLowerCase().equals("a")
                    || sWords[0].toLowerCase().equals("an")){
                if (checkConsonant(sWords[1])){
                    System.out.println("Is it a " + sWords[1].toLowerCase() + "?");
                } else{
                    System.out.println("Is it an " + sWords[1].toLowerCase() + "?");
                }
        }  else {
            if (checkConsonant(sWords[0])){
                System.out.println("Is it a " + sWords[0].toLowerCase() + " " + sWords[1].toLowerCase() + "?");
            } else{
                System.out.println("Is it an " + sWords[0].toLowerCase() + " " + sWords[1].toLowerCase() + "?");
            }

        }
    }

}
