package labs.lab11.roads;

import java.util.Objects;

class Road {
    String name;
    int id;

    public Road(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}