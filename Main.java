package BigProject;

import BigProject.services.ClientService;
import BigProject.services.CmdLineService;

public class Main {
    public static void main(String[] args) {

        CmdLineService cmdLineService = new CmdLineService();

        cmdLineService.showMenuMain();
    }
}