package BigProject.services;

public interface MenuService {

    void goBack();
    boolean exitMenu(boolean isWork);

    void showMainMenu();
    void showClientMenu();
    void showProductMenu();
}
