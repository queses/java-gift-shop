package qss.gift;

import qss.gift.products.*;

public class Main {
    Shop shop;

    Main() {
        shop = new Shop();
    }

    public static void main(String[] args) {
        (new Main()).start();
    }

    public void start() {
        fillShop();
        ShopPrinter printer = new ShopPrinter(shop);
        printer.start();
    }

    public void fillShop() {
        shop.addProduct(new Champagne("Cinzanno Rose", 790.9, "Розовое", .75));
        shop.addProduct(new Champagne("Lambrusco Mirabello", 590.9, "Красное", .75));
        shop.addProduct(new Champagne("ЛевЪ Голицкий", 290.9, "Белое", .75));

        shop.addProduct(new Perfume("Black Dress", 1299.9, "Цветочный", 50.));
        shop.addProduct(new Perfume("Demeter 'Свекла'", 999.9, "Овощной", 30.));
        shop.addProduct(new Perfume("Одеколон 'Шипр'", 73.9, "Ореховый", 100.));

        shop.addProduct(new Chocolate("Milka", 79.9, 35, 90.));
        shop.addProduct(new Chocolate("Alpen Gold", 69.9, 30, 90.));
        shop.addProduct(new Chocolate("Кондитерская плитка 'То что надо!'", 19.9, 20, 120.));

        shop.addProduct(new Candie("Merci", 249.9, "Различная", 250.));
        shop.addProduct(new Candie("Коркунов", 389.9, "Пралине", 300.));
        shop.addProduct(new Candie("Коровка Сливочная", 49.9, "Сливочная", 900.));

        shop.addProduct(new Cookie("Mulino Bianko", 89.9, "Клубничный", .4));
        shop.addProduct(new Cookie("Oreo", 119.9, "Шоколадный", .3));
        shop.addProduct(new Cookie("Галеты 'Поход'", 39.9, "Пшеничный", .9));
    }
}
