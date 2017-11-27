package qss.gift.products;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

public class Chocolate implements Product {
    // Процент содержания какао:
    @Getter @Setter
    private Integer cocoa;
    // Объем:
    @Getter @Setter
    private Double weight;

    public Chocolate(String title, Double price, Integer cocoa, Double weight) {
        this.title = title;
        this.price = price;
        this.cocoa = cocoa;
        this.weight = weight;
    }

    @Override
    public String getCategoryName() {
        return "Шоколад";
    }

    @Override
    public Double getWeekDiscount() {
        Integer weekDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (weekDay.equals(4)) return .1;
        else return .0;
    }

    @Override
    public String getExtraDescription() {
        return String.format("Содержание какао: %d\n" +
                "Вес: %.0f гр\n", cocoa, weight);
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

