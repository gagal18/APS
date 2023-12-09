package labs.lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Lozinki {

    public static boolean checkPassword(String username, String password, Hashtable<String, String> table){
        return table.containsKey(username) && table.get(username).equals(password);
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Hashtable<String , String> passHash = new Hashtable<>();
        for(int i=1;i<=N;i++){
            String imelozinka = br.readLine();
            String[] pom = imelozinka.split(" ");
            passHash.put(pom[0], pom[1]);
        }

        while(true){
            String line = br.readLine();
            if(line.equals("KRAJ")){
                break;
            }
            String pass = line.split(" ")[1];
            String username = line.split(" ")[0];
            if(checkPassword(username, pass, passHash)){
                System.out.println("Najaven");
                break;
            }
            System.out.println("Nenajaven");
        }

    }
}

