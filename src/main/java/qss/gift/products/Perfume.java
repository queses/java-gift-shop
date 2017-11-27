package qss.gift.products;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

public class Perfume implements Product {
    // Запах:
    @Getter @Setter
    private String flavour;
    // Объем:
    @Getter @Setter
    private Double volume;

    public Perfume(String title, Double price, String flavour, Double volume) {
        this.title = title;
        this.price = price;
        this.flavour = flavour;
        this.volume = volume;
    }

    @Override
    public String getCategoryName() {
        return "Духи";
    }

    @Override
    public Double getWeekDiscount() {
        Integer weekDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (weekDay.equals(2)) return .1;
        else return .0;
    }

    @Override
    public String getExtraDescription() {
        return String.format("Запах: %s\n" +
                "Объем: %.0f мл\n", flavour, volume);
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
