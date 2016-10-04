package slave;

/**
 * Created by Ekaterina on 03.10.2016.
 */
public abstract class Human {

    private String name;
    private int minimalCost;


    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getMinimalCost() {
        return minimalCost;
    }

    protected void setMinimalCost(int minimalCost) {
        this.minimalCost = minimalCost;
    }
}
