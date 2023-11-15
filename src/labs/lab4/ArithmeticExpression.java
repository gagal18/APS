package labs.lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ArithmeticExpression {

    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char c[], int l, int r) {
        // Vasiot kod tuka
        Stack<Integer> stackNumbers = new Stack<>();
        Stack<Character> stackExpression = new Stack<>();
        for (char cExp : c) {
            if(Character.isDigit(cExp)){
                stackNumbers.push(Integer.parseInt(String.valueOf(cExp)));
            }
            if(cExp == '+' || cExp == '-'){
                stackExpression.push(cExp);
            }
            if(cExp == ')'){
                int op1 = stackNumbers.pop();
                int op2 = stackNumbers.pop();
                char type = stackExpression.pop();
                if(type == '+'){
                    stackNumbers.push(op1 + op2);
                }else{
                    stackNumbers.push(op2 - op1);
                }
            }
        }
        return stackNumbers.pop();
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);

        br.close();

    }

}
