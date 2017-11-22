package BigProject.services;

import BigProject.services.impl.MenuServiceImpl;
import BigProject.services.impl.ProductServiceImpl;
import BigProject.services.impl.ClientServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CmdLineService {

    private Scanner command = new Scanner(System.in);
    MenuService menuService = (MenuService) new MenuServiceImpl();
    ClientService clientService = (ClientService) new ClientServiceImpl();
    ProductService productService = (ProductService) new ProductServiceImpl();

    boolean isWork = true;

    public void goMainMenu() {
        do {
            menuService.showMainMenu();
            try{
                int s = command.nextInt();
                switch (s) {
                    case 1:
                        goClientMenu();
                        break;
                    case 2:
                        goProductMenu();
                        break;
                    case 0:
                        isWork = false;
                        break;
                    default:
                        System.out.println("Неправильный ввод \n");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Эээх, чтобы не зацикливаться - программа закрывается. \n");
                break;
            }
        }while(isWork);
    }

    public void goClientMenu() {
//        boolean isWork = true;
        do {
            menuService.showClientMenu();
            try{
            int s = command.nextInt();
            switch (s) {
                case 1:
                    clientService.addClient();
                    break;
                case 2:
                    clientService.editClient();
                    break;
                case 3:
                    clientService.removeClient();
                    break;
                case 4:
                    goMainMenu();
//                    menuService.goBack();
                    break;
                case 0:
                    isWork = false;
                    break;
                default:
                    System.out.println("Неправильный ввод \n");
                    break;
            }
            }catch(InputMismatchException e){
                System.out.println("Эээх, чтобы не зацикливаться - программа закрывается. \n");
                break;
            }
        }while(isWork);
    }

    public void goProductMenu() {
//        boolean isWork = true;
        do {
            menuService.showProductMenu();
            try{
            int s = command.nextInt();
            switch (s) {
                case 1:
                    productService.addProduct();
                    break;
                case 2:
                    productService.editProduct();
                    break;
                case 3:
                    productService.removeProduct();
                    break;
                case 4:
                    goMainMenu();
//                    menuService.goBack();
                    break;
                case 0:
                    isWork = false;
                    break;
                default:
                    System.out.println("Неправильный ввод \n");
                    break;
            }
        }catch(InputMismatchException e){
            System.out.println("Эээх, чтобы не зацикливаться - программа закрывается. \n");
            break;
        }
        }while(isWork);
    }
}
