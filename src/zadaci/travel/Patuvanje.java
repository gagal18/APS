package zadaci.travel;

public abstract class Patuvanje {
    private String name_company;
    private int price;

    public Patuvanje(String name_company, int price) {
        this.name_company = name_company;
        this.price = price;
    }

    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public abstract int vratiVremeVoDenovi();
}


