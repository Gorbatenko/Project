package BigProject.services.impl;

import BigProject.services.CmdLineService;
import BigProject.services.MenuService;

public class MenuServiceImpl implements MenuService {

    public void comeBack() {
        CmdLineService.showMenuMain();
    }

    public boolean exitMenu() {
        return false;
    }
}
