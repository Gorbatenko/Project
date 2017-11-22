package BigProject.services.impl;

import BigProject.services.ProductService;

public class ProductServiceImpl implements ProductService {

    public void addProduct() {
        System.out.println("Туц-Туц. Продукт добавлен.\n");
    }

    public void editProduct() {
        System.out.println("Так-Сяк. Продукт отредактирован.\n");
    }

    public void removeProduct() {
        System.out.println("Ай-Ой. Продукт удалён.\n");
    }
}
