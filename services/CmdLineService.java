package BigProject.services;

import BigProject.services.impl.MenuServiceImpl;
import BigProject.services.impl.ProductServiceImpl;
import BigProject.services.impl.ClientServiceImpl;
import BigProject.services.model.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CmdLineService {

    MenuService menuService = (MenuService) new MenuServiceImpl();
    ClientService clientService = (ClientService) new ClientServiceImpl();
    ProductService productService = (ProductService) new ProductServiceImpl();

    boolean isWork = true;
    private BufferedReader reader;

    public CmdLineService(ClientServiceImpl clientService, ProductServiceImpl productService, MenuServiceImpl menuService) {
        this.productService = productService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.clientService = clientService;
    }

    public void goMainMenu() throws IOException {
        do {
            menuService.showMainMenu();
            String s = reader.readLine();
            switch (s) {
                case "1":
                    goClientMenu();
                    break;
                case "2":
                    goProductMenu();
                    break;
                case "0":
                    isWork = false;
                    break;
                default:
                    System.out.println("Неправильный ввод. \nПожалуйста, выберите один из пунктов меню.\n");
                    break;
            }
        } while (isWork);
    }

    public void goClientMenu() throws IOException {
        do {
            menuService.showClientMenu();
            String s = reader.readLine();
            switch (s) {
                case "1":
                    clientService.addClient();
                    break;
                case "2":
                    System.out.println("Введите ID:");
                    int indexId = -1;
                    int id = clientService.getReadId();
                    List<Client> clientsList = clientService.getClientsList();
                    for (int i = 0; i < clientsList.size(); i++) {
                        Client client = clientsList.get(i);
                        if (client.getId() == id) {
                            indexId = i;
                            goEditClientMenu(indexId);
                            break;
                        }
                        System.out.println("В базе нет клиента с таким Id\n");
                    }
                    break;
                case "3":
                    clientService.removeClient();
                    break;
                case "4":
                    clientService.showClientLists();
                    break;
                case "9":
                    goMainMenu();
                    break;
                case "0":
                    isWork = false;
                    break;
                default:
                    System.out.println("Неправильный ввод. \nПожалуйста, выберите один из пунктов меню.\n");
                    break;
            }
        } while (isWork);
    }

    private void goEditClientMenu(int indexId) throws IOException {
        do {
            menuService.showEditClientMenu();
            String s = reader.readLine();
            String editParam = "";
            switch (s) {
                case "1":
                    editParam = "новое имя";
                    clientService.editClient(indexId, editParam);
                    break;
                case "2":
                    editParam= "новую фамилию";
                    clientService.editClient(indexId, editParam);
                    break;
                case "3":
                    editParam = "новую почту";
                    clientService.editClient(indexId, editParam);
                    break;
                case "4":
                    editParam = "новый телефон";
                    clientService.editClient(indexId, editParam);
                    break;
                case "9":
                    goClientMenu();
                    break;
                case "0":
                    isWork = false;
                    break;
                default:
                    System.out.println("Неправильный ввод. \nПожалуйста, выберите один из пунктов меню.\n");
                    break;
            }
        } while (isWork);
    }


    public void goProductMenu() throws IOException {
        do {
            menuService.showProductMenu();
            String s = reader.readLine();
            switch (s) {
                case "1":
                    productService.addProduct();
                    break;
                case "2":
                    productService.editProduct();
                    break;
                case "3":
                    productService.removeProduct();
                    break;
                case "4":
                    goMainMenu();
                    break;
                case "0":
                    isWork = false;
                    break;
                default:
                    System.out.println("Неправильный ввод. \nПожалуйста, выберите один из пунктов меню.\n");
                    break;
            }
        } while (isWork);
    }
}
