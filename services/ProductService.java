package BigProject.services;

import java.io.IOException;

public interface ProductService {

    void addProduct() throws IOException;

    void editProduct();

    void removeProduct();

    void showProducts();
}