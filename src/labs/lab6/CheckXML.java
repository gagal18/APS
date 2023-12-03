//package labs.lab6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CheckXML {
    static int isValidXML(String[] rows) {
        Stack<String> stack = new Stack<>();
        for (String row : rows) {
            if (row.startsWith("[/")) {
                String tagName = row.substring(2, row.length() - 1);
                if (stack.isEmpty() || !stack.pop().equals(tagName)) {
                    return 0;
                }
            } else if (row.startsWith("[")) {
                String tagName = row.substring(1, row.length() - 1);
                stack.push(tagName);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();

        int valid;
        valid = isValidXML(redovi);
        // Vasiot kod tuka
        // Moze da koristite dopolnitelni funkcii ako vi se potrebni

        System.out.println(valid);

        br.close();
    }
}