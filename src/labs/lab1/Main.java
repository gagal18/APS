package labs.lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

class QuarterlySales {

    private int numOfSales;
    private int [] revenues;
    private int quarterNo;

    public int getNumOfSales() {
        return numOfSales;
    }

    public void setNumOfSales(int numOfSales) {
        this.numOfSales = numOfSales;
    }

    public int[] getRevenues() {
        return revenues;
    }

    public void setRevenues(int[] revenues) {
        this.revenues = revenues;
    }

    public int getQuarterNo() {
        return quarterNo;
    }

    public void setQuarterNo(int quarterNo) {
        this.quarterNo = quarterNo;
    }

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }
    @Override
    public String toString() {
        return "   "+Arrays.stream(this.revenues).sum();
    }

}

class SalesPerson {

    private String name;
    private QuarterlySales [] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }
    int sumSales(SalesPerson sp){
        QuarterlySales[] QSs = sp.quarters;
        int sum = 0;
        for (QuarterlySales qs: QSs ) {
            sum += Arrays.stream(qs.getRevenues()).sum();
        }
        return sum;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.name);
        int sum = 0;
        QuarterlySales[] QSs = this.quarters;
        for (QuarterlySales qs : QSs) {
            str.append(qs.toString());
            sum += Arrays.stream(qs.getRevenues()).sum();
        }
        str.append("   "+sum);
        return str.toString();
    }

    public String getName() {
        return name;
    }
}



public class Main {

    public static SalesPerson salesChampion(SalesPerson [] arr) {
        SalesPerson theChamp = arr[0];
        for (SalesPerson sp: arr) {
            if(sp.sumSales(sp) > theChamp.sumSales(theChamp)){
                theChamp = sp;
            }
        }
        return theChamp;
    }
    public static void table(SalesPerson [] arr) {
        StringBuilder str = new StringBuilder();
        str.append("SP   1   2   3   4   Total");
        str.append("\n");
        for (SalesPerson sp: arr) {
            str.append(sp.toString());
            str.append("\n");
        }
        System.out.println(str);
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        input.nextLine();
        SalesPerson [] arr = new SalesPerson[n];
        for (int i = 0; i < n; i++) {
            String name = input.nextLine();
            QuarterlySales[] qs = new QuarterlySales[4];
            for (int j = 0; j < 4; j++) {
                int num_sales = input.nextInt();
                int[] revs = new int[num_sales];
                for (int k = 0; k < num_sales; k++) {
                    int revenue = input.nextInt();
                    revs[k] = revenue;
                }
                QuarterlySales singQs = new QuarterlySales(num_sales, revs,j);
                qs[j] = singQs;
            }
            SalesPerson singSp = new SalesPerson(name, qs);
            arr[i] = singSp;
            input.nextLine();
        }
        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

    }
}