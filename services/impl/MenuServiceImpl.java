package BigProject.services.impl;

import BigProject.services.CmdLineService;
import BigProject.services.MenuService;

public class MenuServiceImpl implements MenuService {

    public void goBack() {
        CmdLineService cmdLineService = new CmdLineService();
        cmdLineService.goMainMenu();
    }

    public boolean exitMenu(boolean isWork) {
        isWork = false;
        return isWork;
    }

    public void showMainMenu() {
        System.out.println("Главное Меню");
        System.out.println("1. Поработать с клиентами;");
        System.out.println("2. Заняться продуктами;");
        System.out.println("0. Выход.");
    }

    public void showClientMenu() {
        System.out.println("Клиентское меню");
        System.out.println("1. Добавить клиента;");
        System.out.println("2. Редактировать данные клиента;");
        System.out.println("3. Удалить клиента;");
        System.out.println("4. Вернуться назад;");
        System.out.println("0. Выход.");
    }

    public void showProductMenu() {
        System.out.println("Продуктовое меню");
        System.out.println("1. Добавить продукт;");
        System.out.println("2. Редактировать параметры продукта;");
        System.out.println("3. Удалить продукт;");
        System.out.println("4. Вернуться назад;");
        System.out.println("0. Выход.");
    }
}
