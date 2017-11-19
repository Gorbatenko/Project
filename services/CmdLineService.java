package BigProject.services;

import BigProject.services.impl.MenuServiceImpl;
import java.util.Scanner;

public class CmdLineService {

    private static Scanner command = new Scanner(System.in);
    static MenuService menuService = (MenuService) new MenuServiceImpl();

    public static void showMenuMain(String back){
        System.out.println("Меню Главное");
        System.out.println("1. Перейти в MenuA");
        System.out.println("2. Перейти в MenuВ");
        System.out.println("3. Выход");

        back  = "MenuMain";

        int s = readCommand();
        switch (s) {
            case 1:
                showMenuA(back);
                break;
            case 2:
                showMenuB(back);
                break;
            case 3:
                menuService.exitMenu();
                break;
            default:
                System.out.println("Неправильный ввод \n");
                showMenuMain(back);
                break;
        }
    }

    public static void showMenuA(String back){
        System.out.println("Меню А");
        System.out.println("1. Вернуться в MenuMain");
        System.out.println("2. Сделать что-то в меню А");
        System.out.println("3. Перейти в MenuВ");
        System.out.println("4. Выход");

        back = back + "/MenuA";

        int s = readCommand();
        switch (s) {
            case 1:
                menuService.comeBack(back);
                break;
            case 2:
                System.out.println("Что-то сделано в Меню-А \n");
                showMenuA(back);
                break;
            case 3:
                showMenuB(back);
                break;
            case 4:
                menuService.exitMenu();
                break;
            default:
                System.out.println("Неправильный ввод \n");
                showMenuA(back);
                break;
        }
    }

    public static void showMenuB(String back){
        System.out.println("Меню Б");
        System.out.println("1. Вернуться в MenuMain ");
        System.out.println("2. Сделать что-то в Меню-B");
        System.out.println("3. Перейти в MenuА");
        System.out.println("4. Выход");

        back = back + "/MenuB";

        int s = readCommand();
        switch (s) {
            case 1:
                menuService.comeBack(back);
                break;
            case 2:
                System.out.println("Что-то сделано в Меню-B \n");
                showMenuB(back);
                break;
            case 3:
                showMenuA(back);
                break;
            case 4:
                menuService.exitMenu();
                break;
            default:
                System.out.println("Неправильный ввод \n");
                showMenuB(back);
                break;
        }
    }

    public static int readCommand(){
        return command.nextInt();
    }


}