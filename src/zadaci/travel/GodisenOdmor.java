package zadaci.travel;

public class GodisenOdmor extends Patuvanje {
    private int trip_length;

    public GodisenOdmor(String name_company, int price, int trip_length) {
        super(name_company, price - 1000);
        this.trip_length = trip_length;
    }

    @Override
    public int vratiVremeVoDenovi() {
        return 0;
    }
}
