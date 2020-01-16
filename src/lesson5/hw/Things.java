package lesson5.hw;

public class Things {
    String name;
    float weight;
    int price;
    float udelPrice; //удельная стоимость вещи

    public Things(String name, float weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        udelPrice = this.price/this.weight;
    }

    public float getUdelPrice() {
        return udelPrice;
    }

    public void setUdelPrice(float udelPrice) {
        this.udelPrice = udelPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ("\n name=" + name+" weight="+weight+" price="+price+" udPrice="+udelPrice);
    }
}
