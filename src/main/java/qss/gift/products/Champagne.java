package qss.gift.products;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

public class Champagne implements Product {
    // Цвет:
    @Getter @Setter
    private String color;
    // Объем:
    @Getter @Setter
    private Double volume;

    public Champagne(String title, Double price, String color, Double volume) {
        this.title = title;
        this.price = price;
        this.color = color;
        this.volume = volume;
    }

    @Override
    public String getCategoryName() {
        return "Шампанское";
    }

    @Override
    public Double getWeekDiscount() {
        Integer weekDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (weekDay.equals(1)) return .1;
        else return .0;
    }

    @Override
    public String getExtraDescription() {
        return String.format("Цвет: %s\n" +
                "Объем: %.2f л\n", color, volume);
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
