package BigProject.services.impl;

import BigProject.services.ClientService;
import BigProject.services.model.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ClientServiceImpl implements ClientService {

    private final BufferedReader reader;
    private List<Client> clientsList = new ArrayList<>();

    public ClientServiceImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.clientsList = new ArrayList<>();
    }

    public void addClient() throws IOException {
        System.out.println("Введите Id клиента");
        Integer id = readId();
        System.out.println("Введите имя:");
        String name = reader.readLine();
        System.out.println("Введите фамилию:");
        String surname = reader.readLine();
        System.out.println("Введите почту:");
        String email = reader.readLine();
        System.out.println("Введите телефон, без кода страны:");
        Integer phone = readId();

        /*"этот кусок работает не правильно. Он таки редактирует существующий Ид, но всё равно добавляет еще в конце такой же (столько же, сколько отредактировал)*/
//        if (clientsList.size() > 0) {
//            for (int i = 0; i < clientsList.size(); i++) {
//                Client client = clientsList.get(i);
//                if (client.getId() == id) {
//                    client.setName(name);
//                    client.setSurname(surname);
//                    client.setEmail(email);
//                    client.setPhone(phone);
//                    System.out.println("Клиент добавлен внутри!\n");
//                } else {
//                    clientsList.add(new Client(id, name, surname, email, phone));
//                    System.out.println("Клиент добавлен в серединке!\n");
//                }
//            }
//        } else {
//            clientsList.add(new Client(id, name, surname, email, phone));
//            System.out.println("Клиент добавлен снаружи!\n");
//        }
        clientsList.add(new Client(id, name, surname, email, phone));
        System.out.println("Клиент Id=" + id + " успешно добавлен!\n");
    }

    @Override
    public void showClientsList() {
        List<Client> clientsList = getClientsList();
        if (clientsList.size() > 0) {
            System.out.println("Список всех клиентов:");
            for (int i = 0; i < clientsList.size(); i++) {
                System.out.println(clientsList.get(i));
            }
        } else {
            System.out.println("База клиентов пуста.\n");
        }
    }

    public void editClient(int indexId, String editParam) throws IOException{
        Client client = clientsList.get(indexId);
        String name, surname, email;
        int phone;

        System.out.println("Введите " + editParam + ":");

        switch (editParam) {
            case "новое имя":
                name = reader.readLine();
                client.setName(name);
                break;
            case "новую фамилию":
                surname = reader.readLine();
                client.setSurname(surname);
                break;
            case "новую почту":
                email = reader.readLine();
                client.setEmail(email);
                break;
            case "новый телефон":
                phone = readId();
                client.setPhone(phone);
                break;
            default:
                System.out.println("Что-то новое прилетело в этот метод.\n");
                break;
        }
        System.out.println("Пик-Пик. Клиент отредактирован.\n");
    }

    public void removeClient(int indexId) {
        Client client = clientsList.get(indexId);
        clientsList.remove(client);
        System.out.println("Ой-Вэй. Клиент удалён.\n");
    }

    private int readId() throws IOException {
        Integer id;
        while (true) {
            try {
                id = new Integer(reader.readLine());
                if (id != 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Вводите только цифры, пожалуйста.");
            }
        }
        return id;
    }

    public int getReadId() throws IOException {
        return readId();
    }

    public List<Client> getClientsList(){
        return clientsList;
    }

//    public List<Client> showClientList() {
//        return clientsList;
//    }
}