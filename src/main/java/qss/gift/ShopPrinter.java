package qss.gift;

import qss.gift.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopPrinter {
    private Shop shop;
    private Scanner scanner;

    ShopPrinter(Shop shop) {
        this.shop = shop;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        Integer category, product;
        while (true) {
            category = selectCategory();
            if (category < 0) { stop(); return; }
            product = selectProduct(category);
            if (product < 0) { continue; }
            showProduct(category, product);
        }
    }

    public void stop() {
        System.out.println("Будем рады видеть Вас ещё!");
    }

    private Integer selectCategory() {
        Integer selection;
        while (true) {
            printCategories();
            System.out.print("> ");
            try {
                selection = Integer.parseInt(scanner.next());
            } catch (Exception err) {
                System.out.println("Неправильный ввод.");
                continue;
            }
            if (selection.equals(shop.getCatalog().size() + 1)) {
                showSpecial();
                continue;
            }
            if (shop.getCatalog().size() < selection) {
                System.out.println("Нет такой категории");
                continue;
            }
            return selection - 1;
        }
    }

    private Integer selectProduct(Integer categoryNum) {
        Integer selection;
        while (true) {
            printProducts(categoryNum);
            System.out.print("> ");
            try {
                selection = Integer.parseInt(scanner.next());
            } catch (Exception err) {
                System.out.println("Неправильный ввод.");
                continue;
            }
            if (shop.getProducts(categoryNum).size() < selection) {
                System.out.println("Нет такой категории");
                continue;
            }
            return selection - 1;
        }
    }

    private void showProduct(Integer categoryNum, Integer productNum) {
        Product product = shop.getProducts(categoryNum).get(productNum);
        System.out.println(product.getDescription());
        System.out.println("Введите 0, чтобы вернуться в главное меню");
        scanner.next();
    }

    private void printCategories() {
        Integer i = 1;
        for (String catName : shop.getCatalog().keySet()) {
            System.out.printf("%d: %s\n", i++, catName);
        }
        System.out.printf("%d: %s\n", i, "Специальное джентельменское предложение");
    }

    private void printProducts(Integer categoryNum) {
        Integer i = 1;
        for (Product product : shop.getProducts(categoryNum)) {
            System.out.printf("%d: %s\n", i++, product.getTitle());
        }
    }

    private void showSpecial() {
        List<Product> products = new ArrayList<>();
        products.add(shop.getProducts("Конфеты").get(2));
        products.add(shop.getProducts("Печенье").get(2));
        products.add(shop.getProducts("Шампанское").get(2));
        products.add(shop.getProducts("Шоколад").get(2));
        products.add(shop.getProducts("Духи").get(2));

        System.out.println("Выбирая подарок для Вашей возлюбленной, выберите:\n");
        Double sum = .0;
        for (Product product : products) {
            System.out.println(product.getDescription());
            sum += product.getPriceWithDiscount();
        }

        System.out.printf("Итоговая сумма подарка: %.2f\n", sum);
        System.out.println("Введите 0, чтобы вернуться в главное меню");
        scanner.next();
    }
}
