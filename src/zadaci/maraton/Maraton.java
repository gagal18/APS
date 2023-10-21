package zadaci.maraton;

import zadaci.maraton.Atleticar;
import zadaci.maraton.IMaraton;

import java.util.Arrays;

public class Maraton implements IMaraton {

    private String country_held;
    private int year_held;

    private Atleticar[] marathon_runners;
    @Override
    public Atleticar najdobroVreme() {
        double best_time = marathon_runners[0].getFinish_time();
        Atleticar a = marathon_runners[0];
        for (Atleticar runner: marathon_runners) {
            if(runner.getFinish_time() < best_time){
                best_time = runner.getFinish_time();
                a = runner;
            }
        }
        return a;
    }

    @Override
    public int atleticariOd(String s) {
        int fromCountry = 0;
        for (Atleticar a: marathon_runners) {
            if(a.getCountry().equals(s))
                fromCountry++;
        }

        return fromCountry;
    }
    public Maraton(){}
    public Maraton(String country_held, int year_held, Atleticar[] marathon_runners) {
        this.country_held = country_held;
        this.year_held = year_held;
        this.marathon_runners = marathon_runners;
    }

    public String getCountry_held() {
        return country_held;
    }

    public void setCountry_held(String country_held) {
        this.country_held = country_held;
    }

    public int getYear_held() {
        return year_held;
    }

    public void setYear_held(int year_held) {
        this.year_held = year_held;
    }

    public Atleticar[] getMarathon_runners() {
        return marathon_runners;
    }

    public void setMarathon_runners(Atleticar[] marathon_runners) {
        this.marathon_runners = marathon_runners;
    }

    @Override
    public String toString() {
        return "Maraton{" +
                "country_held='" + country_held + '\'' +
                ", year_held=" + year_held +
                ", marathon_runners=" + Arrays.toString(marathon_runners) +
                '}';
    }
}
