package BigProject.services.impl;

import BigProject.services.WriteReadService;
import BigProject.services.model.Client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteReadServiceImpl implements WriteReadService {

    public WriteReadServiceImpl() {

    }

    public void saveToTxt(List<Client> clientsList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("Clients.txt")))) {
            for (Client aClientsList : clientsList) {
                bufferedWriter.write(String.valueOf(aClientsList));
            }
            System.out.println("Клиенты успешно записаны в файл Clients.txt\n");
        } catch (IOException ex) {
            System.out.println("Что-то пошло не так.");
        }
    }
}
