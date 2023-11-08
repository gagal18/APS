package labs.lab3;

import java.util.*;

public class CountWordPairs {

    //TODO: implement function
    public static int countWordPairs(String [] words) {
        ArrayList<Character> firstChars = new ArrayList<>();
        int matches = 0;
        for (String word: words) {
            firstChars.add(word.charAt(0));
        }
        for (int i = 0; i < firstChars.size(); i++) {
            for (int j = i+1; j < firstChars.size(); j++) {
                if(firstChars.get(i).equals(firstChars.get(j)))
                    matches++;
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        String words[] = new String[N];

        for(int i=0;i<N;i++) {
            words[i] = input.next();
        }

        System.out.println(countWordPairs(words));

    }
}