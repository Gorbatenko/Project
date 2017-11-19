package BigProject.services;

import BigProject.services.impl.MenuServiceImpl;

import java.util.Scanner;

public class CmdLineService {

    private static Scanner command = new Scanner(System.in);
    static MenuService menuService = (MenuService) new MenuServiceImpl();

    String Back;

    public static void showMenuMain(){
        System.out.println("1. Перейти в MenuA");
        System.out.println("2. Перейти в MenuВ");
        System.out.println("3. Выход");

        String Back = "showMenuMain";
        int s = readCommand();
        switch (s) {
            case 1:
                showMenuA();
                break;
            case 2:
                showMenuB();
                break;
            case 3:
                menuService.exitMenu();
                break;
            default:
                System.out.println("Неправильный ввод \n");
                showMenuMain();
                break;
        }
    }

    public static void showMenuA(){
        System.out.println("1. Вернуться в MenuMain");
        System.out.println("2. Сделать что-то в меню А");
        System.out.println("3. Выход");

        int s = readCommand();
        switch (s) {
            case 1:
                menuService.comeBack();
                break;
            case 2:
                System.out.println("Что-то сделано в Меню-А \n");
                showMenuA();
                break;
            case 3:
                menuService.exitMenu();
                break;
            default:
                System.out.println("Неправильный ввод \n");
                showMenuA();
                break;
        }
    }

    public static void showMenuB(){
        System.out.println("1. Вернуться в MenuMain ");
        System.out.println("2. Сделать что-то в Меню-B");
        System.out.println("3. Выход");

        int s = readCommand();
        switch (s) {
            case 1:
                menuService.comeBack();
                break;
            case 2:
                System.out.println("Что-то сделано в Меню-B \n");
                showMenuB();
                break;
            case 3:
                menuService.exitMenu();
                break;
            default:
                System.out.println("Неправильный ввод \n");
                showMenuB();
                break;
        }
    }

    public static int readCommand(){
        return command.nextInt();
    }


}