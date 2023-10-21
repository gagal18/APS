package zadaci.travel;

public class PraznicnoPatuvanje extends Patuvanje{
    private int start_date;
    private int start_month;
    private int end_date;
    private int end_month;

    public PraznicnoPatuvanje(String name_company, int price, int start_date, int start_month, int end_date, int end_month) {
        super(name_company, price);
        try {
            if ((start_month > end_month) || (start_month == end_month && start_date > end_date)) {
                throw new Exception("Isklucok");
            }
            this.start_date = start_date;
            this.start_month = start_month;
            this.end_date = end_date;
            this.end_month = end_month;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.start_date = end_date;
            this.start_month = end_month;
            this.end_date = start_date;
            this.end_month = start_month;
        }
    }

    @Override
    public int vratiVremeVoDenovi() {
        return (end_month - start_month) * 30 + (end_date - start_date);
    }

}
