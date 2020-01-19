package lesson5.hw;

import java.util.ArrayList;

public class Ruckzack {
    float max_waight;
    float current_weight;
    int current_price;
    ArrayList<Things> things;


    public Ruckzack(float max_waight) {
        this.max_waight = max_waight;
        this.current_price = 0;
        this.current_weight = 0;
        things = new ArrayList<>();
    }

    public void addThing(Things thing){
        things.add(thing);
        current_weight +=thing.getWeight();
        current_price += thing.getPrice();
    }

    public ArrayList<Things> getThings() {
        return things;
    }

    public void setThings(ArrayList<Things> things) {
        this.things = things;
    }

    public float getMax_waight() {
        return max_waight;
    }

    public void setMax_waight(float max_waight) {
        this.max_waight = max_waight;
    }

    public int getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(int current_price) {
        this.current_price = current_price;
    }

    public float getCurrent_weight() {
        return current_weight;
    }

    public void setCurrent_weight(float current_weight) {
        this.current_weight = current_weight;
    }
}
