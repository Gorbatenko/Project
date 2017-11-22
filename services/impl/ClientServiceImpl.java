package BigProject.services.impl;

import BigProject.services.ClientService;
import BigProject.services.CmdLineService;


public class ClientServiceImpl implements ClientService{

    public void addClient() {
        System.out.println("Чик-Чик. Клиент добавлен.\n");
    }

    public void editClient() {
        System.out.println("Пик-Пик. Клиент отредактирован.\n");
    }

    public void removeClient() {
        System.out.println("Ой-Вэй. Клиент удалён.\n");
    }
}