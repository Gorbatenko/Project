package BigProject.services;

import BigProject.services.impl.MenuServiceImpl;
import BigProject.services.impl.ProductServiceDb;
import BigProject.services.impl.ClientServiceImpl;
import BigProject.services.model.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CmdLineService {

    private MenuService menuService;
    private ClientService clientService;
    private ProductService productService;
    private BufferedReader reader;

    private boolean isWork = true;

    public CmdLineService(ClientServiceImpl clientService, ProductServiceDb productService, MenuServiceImpl menuService) {
        this.menuService = menuService;
        this.clientService = clientService;
        this.productService = productService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
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

    private void goClientMenu() throws IOException {
        do {
            menuService.showClientMenu();
            String s = reader.readLine();
            switch (s) {
                case "1":
                    clientService.addClient();
                    break;
                case "2":
                    String index = viewingClientList();
                    if (!index.equals("Null")) {
                        int indexId = Integer.valueOf(index);
                        System.out.println(indexId);
                        goEditClientMenu(indexId);
                    }
                    break;
                case "3":
                    index = viewingClientList();
                    if (!index.equals("Null")) {
                        int indexId = Integer.valueOf(index);
                        clientService.removeClient(indexId);
                    }
                    break;
                case "4":
                    clientService.showClientsList();
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
            String editParam;
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

    private void goProductMenu() throws IOException {
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
                    productService.showProducts();
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

    private String viewingClientList() throws IOException {
        String index = "Null";
        List<Client> clientsList = clientService.getClients();
        if (clientsList.size() > 0) {
            System.out.println("Введите Id клиента:");
            int id = clientService.getReadId();
            for (int indexId = 0; indexId < clientsList.size(); indexId++) {
                Client client = clientsList.get(indexId);
                if (client.getId() == id) {
                    index = Integer.toString(indexId);
                    return index;
                } else {
                    if (indexId == clientsList.size()-1) {
                        System.out.println("В базе нет клиента с таким Id.\n");
                    }
                }
            }
        } else {
            System.out.println("База клиентов пуста.\n");
        }
        return index;
    }
}