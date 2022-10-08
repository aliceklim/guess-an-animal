package animals;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String firstAnimal;
    static String secondAnimal;
    static String distinguishingFeature;
    static Scanner scanner;
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        scanner = new Scanner(System.in);
        greeting(now);
        System.out.println("What's your favorite animal?");
        firstAnimal = checkArticle(scanner.nextLine());
        System.out.println("Enter the second animal:");
        secondAnimal = checkArticle(scanner.nextLine());
        System.out.println("Specify a fact that distinguishes " + firstAnimal + " from " + secondAnimal + ".");
        distinguishingFeature = scanner.nextLine().toLowerCase();
        checkDistinguishingFeature(firstAnimal, secondAnimal, distinguishingFeature);
        farewell();

    }

    private static void checkDistinguishingFeature(String firstAnimal, String secondAnimal, String distinguishingFeature){
        String s = distinguishingFeature.replaceAll("\\p{Punct}", "");
        Pattern pattern = Pattern.compile("^it\\s(can|has|is).*");
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            System.out.println("Is it correct for " + secondAnimal + "?");
            String reply = scanner.nextLine().toLowerCase();
            printDistFeatReply(reply.toLowerCase(), firstAnimal, secondAnimal, s); // yes/no, wolf, hair, it's a mammal
        } else {
            System.out.println("examples of a statement");
        }
    }
    private static void printDistFeatReply(String s, String firstAnimal, String secondAnimal, String r){
        // yes/no, wolf, hair, it can mammal
        if (s.equals("yes")) {
            System.out.println("The " + firstAnimal.replaceFirst("(a|an)\\s", "") + " " + convertToNegation(r)+ ".");
            System.out.println("The " + secondAnimal.replaceFirst("(a|an)\\s", "") + " " + r.replaceFirst("it\\s", "")+ ".");
            System.out.println(convertToQuestion(distinguishingFeature));

        } else if (s.equals("no")) {
            System.out.println("The " + secondAnimal.replaceFirst("(a|an)\\s", "") + " " + convertToNegation(r)+ ".");
            System.out.println("The " + firstAnimal.replaceFirst("(a|an)\\s", "") + " " + r.replaceFirst("it\\s", "") + ".");
            System.out.println(convertToQuestion(distinguishingFeature));
        } else {
            System.out.println("yes or no");
            String reply = scanner.nextLine();
            printDistFeatReply(reply, firstAnimal, secondAnimal, r);
        }
    }
    private static String convertToQuestion(String s){
        if(s.contains("has")){
            return s.replace("it has", "Does it have")+ "?";
        } else if (s.contains("it is")){
            return s.replace("it is", "Is it")+ "?";
        } else {
            return s.replace("it can","Can it") + "?";
        }
    }
    private static String convertToNegation(String s){
        String reply = s.replaceFirst("it ", "");
        if (reply.contains("has")) {
            return reply.replace("has", "doesn't have");
        } else if (reply.contains("can")){
            return reply.replace("can", "can't");
        } else {
            return reply.replace("is", "isn't");
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
        if (s.charAt(0) == 'a' || s.charAt(0) == 'u'|| s.charAt(0) == 'e' || s.charAt(0) == 'o' || s.charAt(0) == 'i' || s.equals("xeme")){
            return false;
        } else {
            return true;
        }
    }
    private static String checkArticle(String s){
        String r = s.toLowerCase();
        String[] sWords = r.split(" ",2);
        if (sWords.length == 1){
            if (checkConsonant(sWords[0])){
                return "a " + sWords[0];
            } else{
                return "an " + sWords[0];
            }
        } else if (sWords[0].equals("the") || sWords[0].equals("a")
                    || sWords[0].equals("an")){
                if (checkConsonant(sWords[1])){
                    return "a " + sWords[1];
                } else{
                    return "an " + sWords[1];
                }
        }  else {
            if (checkConsonant(sWords[0])){
                return "a " + sWords[0];
            } else{
                return "an " + sWords[0];
            }
        }
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

}

