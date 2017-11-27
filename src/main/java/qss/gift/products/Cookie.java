package qss.gift.products;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

public class Cookie implements Product {
    // Вкус:
    @Getter @Setter
    private String taste;
    // Вес:
    @Getter @Setter
    private Double weight;

    public Cookie(String title, Double price, String taste, Double weight) {
        this.title = title;
        this.price = price;
        this.taste = taste;
        this.weight = weight;
    }

    @Override
    public String getCategoryName() {
        return "Печенье";
    }

    @Override
    public Double getWeekDiscount() {
        Integer weekDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (weekDay.equals(3)) return .1;
        else return .0;
    }

    @Override
    public String getExtraDescription() {
        return String.format("Вкус: %s\n" +
               "Вес: %.2f гр\n", taste, weight);
    }

    // ------
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }

    private Double price;
}
