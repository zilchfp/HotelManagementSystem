package entity;

public class RoomCategory {
    private String name;
    private double price;
    private int totalNumber;
    private double score;


    public RoomCategory() {
        this.name = null;
        this.price = 0;
        this.totalNumber = 0;
        this.score = 0;

    }
    //Getter And Setter

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }
}
