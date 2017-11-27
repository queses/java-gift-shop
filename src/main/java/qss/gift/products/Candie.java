package qss.gift.products;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

public class Candie implements Product {
    // Начинка:
    @Getter @Setter
    private String filling;
    // Вес:
    @Getter @Setter
    private Double weight;

    public Candie(String title, Double price, String filling, Double weight) {
        this.title = title;
        this.price = price;
        this.filling = filling;
        this.weight = weight;
    }

    @Override
    public String getCategoryName() {
        return "Конфеты";
    }

    @Override
    public Double getWeekDiscount() {
        Integer weekDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (weekDay.equals(5)) return .1;
        else return .0;
    }

    @Override
    public String getExtraDescription() {
        return String.format("Начинка: %s\n" +
                "Вес: %.0f гр\n", filling, weight);
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

