package BigProject.services.impl;

import BigProject.services.CmdLineService;
import BigProject.services.MenuService;

public class MenuServiceImpl implements MenuService {

    public void comeBack(String back) {
        System.out.println(back);
        CmdLineService.showMenuMain(back);
    }

    public boolean exitMenu() {
        return false;
    }
}
