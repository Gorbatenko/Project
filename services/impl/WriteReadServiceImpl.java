package BigProject.services.impl;

import BigProject.services.WriteReadService;
import BigProject.services.model.Client;

import java.io.*;
import java.util.List;

public class WriteReadServiceImpl implements WriteReadService {

    public WriteReadServiceImpl() {

    }

    public void saveToTxt(List<Client> clientsList) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("Clients.txt"))))) {
            for (Client aClientsList : clientsList) {
                printWriter.println(String.valueOf(aClientsList));
            }
            System.out.println("Клиенты успешно записаны в файл Clients.txt\n");
        } catch (IOException ex) {
            System.out.println("Что-то пошло не так.");
        }
    }

}
