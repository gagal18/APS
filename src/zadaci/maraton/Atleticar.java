package zadaci.maraton;

public class Atleticar {
    private String name;
    private String sex;
    private String country;
    private int age;
    private double finish_time;

    public Atleticar(String name, String sex, String country, int age, double finish_time) {
        this.name = name;
        this.sex = sex;
        this.country = country;
        this.age = age;
        this.finish_time = finish_time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(double finish_time) {
        this.finish_time = finish_time;
    }

    @Override
    public String toString() {
        return "Atleticar{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", finish_time=" + finish_time +
                '}';
    }
}
