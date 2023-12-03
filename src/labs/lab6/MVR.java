package labs.lab6;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Gragjanin {
    String name_surname;
    int id_card;
    int passport;
    int driver_card;

    public String getNameSurname() {
        return name_surname;
    }

    public int getIdCard() {
        return id_card;
    }

    public int getPassport() {
        return passport;
    }

    public int getDriverCard() {
        return driver_card;
    }

    public Gragjanin(String name_surname, int id_card, int passport, int driver_card) {
        this.name_surname = name_surname;
        this.id_card = id_card;
        this.passport = passport;
        this.driver_card = driver_card;
    }

    @Override
    public String toString() {
        return name_surname ;
    }
}

public class MVR {

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);
        Queue<Gragjanin> id_card_list = new LinkedList<>();
        Queue<Gragjanin> passport_list = new LinkedList<>();
        Queue<Gragjanin> driver_card_list = new LinkedList<>();
        int N = Integer.parseInt(br.nextLine());
        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);
            if (covek.id_card == 1) {
                id_card_list.offer(covek);
            } else if (covek.passport == 1) {
                passport_list.offer(covek);
            }else if (covek.driver_card == 1) {
                driver_card_list.offer(covek);
            }
        }
        while (!id_card_list.isEmpty()) {
            Gragjanin currentServed = id_card_list.peek();
            if(currentServed.getPassport() == 1) {
                passport_list.add(id_card_list.poll());
            } else if(currentServed.getDriverCard() == 1) {
                driver_card_list.add(id_card_list.poll());
            } else {
                System.out.println(id_card_list.poll());
            }
        }
        while (!passport_list.isEmpty()) {
            Gragjanin currentServed = passport_list.peek();
            if(currentServed.getDriverCard() == 1) {
                driver_card_list.add(passport_list.poll());
            } else {
                System.out.println(passport_list.poll());
            }
        }
        while (!driver_card_list.isEmpty()) {
            System.out.println(driver_card_list.poll());
        }
    }
}
