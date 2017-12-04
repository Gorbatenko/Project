package BigProject.services.impl;

import BigProject.services.ProductService;
import BigProject.services.model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductServiceImpl implements ProductService {

    private final BufferedReader reader;
    private List<Product> products = new ArrayList<>();

    public ProductServiceImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.products = new ArrayList<>();
    }

    public void addProduct() throws IOException {
        System.out.println("Введите Id товара");
        Integer id = readId();
        System.out.println("Введите название товара:");
        String name = reader.readLine();
        System.out.println("Введите количество:");
        int amount = readId();
        System.out.println("Введите цену:");
        int price = readId();
        System.out.println("Введите склад:");
        Integer stock = readId();

        if (products.size() > 0) {
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                if (Objects.equals(product.getId(), id)) {
                    product.setName(name);
                    product.setAmount(amount);
                    product.setPrice(price);
                    product.setStock(stock);
                    break;
                } else {
                    if (i == products.size()-1) {
                        products.add(new Product(id, name, amount, price, stock));
                    }
                }
            }
        } else {
            products.add(new Product(id, name, amount, price, stock));
        }
        System.out.println("Туц-Туц. Продукт Id=" + id + " добавлен.\n");
    }

    public void editProduct() {
        System.out.println("Так-Сяк. Продукт отредактирован.\n");
    }

    public void removeProduct() {
        System.out.println("Ай-Ой. Продукт удалён.\n");
    }

    public void showProducts(){
        List<Product> products = getProducts();
        if (products.size() > 0) {
            System.out.println("Полный список продуктов:");
            for (Product aClientsList : products) {
                System.out.println(aClientsList);
            }
        } else {
            System.out.println("База продуктов пуста.\n");
        }
    };

    private int readId() throws IOException {
        Integer id;
        while (true) {
            try {
                id = new Integer(reader.readLine());
                if (id != 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Вводите только цифры, пожалуйста.");
            }
        }
        return id;
    }

    private List<Product> getProducts(){
        return products;
    }
}
