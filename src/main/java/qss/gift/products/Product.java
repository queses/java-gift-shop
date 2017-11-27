package qss.gift.products;

import java.util.Calendar;

public interface Product {
    // Наименование:
    String getTitle();
    void setTitle(String value);
    // Цена:
    Double getPrice();
    void setPrice(Double value);

    // Получить наименовании категории товара:
    String getCategoryName();

    // День недели, в который на этот товар скидка
    Double getWeekDiscount();

    // Получить дополнительное описание
    String getExtraDescription();

    default Double getMonthDiscount() {
        String[][] rules = {
                {"1", "О"}, {"2", "Е"}, {"3", "А"}, {"4", "И"}, {"5", "Н"}, {"6", "Т"}, {"7", "С"},
                {"8", "Р"}, {"9", "В"}, {"10", "Л"}, {"11", "К"}, {"12", "М"}, {"13", "Д"}, {"14", "П"},
                {"15", "У"}, {"16", "Я"}, {"17", "Г"}, {"18", "S"}, {"19", "F"}, {"20", "E"}, {"21", "A"}, {"22", "T"},
                {"23", "O"}, {"24", "N"}, {"25", "R"}, {"26", "I"}, {"27", "C"}, {"28", "H"}, {"29", "D"}, {"30", "L"}
        };
        Integer monthDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        for (String[] weekAndNumber : rules) {
            if (monthDay.equals(Integer.parseInt(weekAndNumber[0])) &&
                    getTitle().toUpperCase().startsWith(weekAndNumber[1])) {
                return .15;
            }
        }
        return .0;
    }

    // Получить процент скидки:
    default Double getDiscount() {
        return 1 - getMonthDiscount() - getWeekDiscount();
    }

    default String getDescription() {
        String descr = String.format("%s, %s\n" +
                "Цена: %.2f рублей\n" +
                "Цена со скидкой: %.2f рублей",
                getCategoryName(), getTitle(), getPrice(), getPriceWithDiscount());
        return descr + "\n" + this.getExtraDescription();
    }

    default Double getPriceWithDiscount() {
        return getPrice() * getDiscount();
    }
}
