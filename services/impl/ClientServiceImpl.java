package BigProject.services.impl;

import BigProject.services.ClientService;
import BigProject.services.CmdLineService;
import BigProject.services.model.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ClientServiceImpl implements ClientService {

    private final BufferedReader reader;
    private List<Client> clients = new ArrayList<>();

    public ClientServiceImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void addClient(Client client) throws IOException {
        System.out.println("Введите имя:");
        String name = reader.readLine();

        System.out.println("Введите фамилию:");
        String surname = reader.readLine();

        System.out.println("Введите почту:");
        String email = reader.readLine();

        System.out.println("Введите телефон (без \"+38\"):");
        boolean phoneInputErr = true;
        int phone = 0;
        while (phoneInputErr) {
            try {
                phone = new Integer(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите телефон цифрами!");
            }
            if (phone != 0) {
                System.out.println(phone);
                break;
            }
        }
//        addClient(new Client(name, surname, email, phone));
        System.out.println("Клиент успешно добавлен!");
        clients.add(client);
        System.out.println(client);
    }

    public void editClient() {
        System.out.println("Пик-Пик. Клиент отредактирован.\n");
    }

    public void removeClient() {
        System.out.println("Ой-Вэй. Клиент удалён.\n");
    }
}