package BigProject.services.impl;

import BigProject.services.ClientService;
import BigProject.services.model.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


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
        int phone;
        while (true) {
            try {
                phone = new Integer(reader.readLine());
                if (phone != 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите телефон цифрами.");
            }
        }
        clientsList.add(new Client(id, name, surname, email, phone));
        Client client = clientsList.get(clientsList.size() - 1);
        System.out.println("Клиент Id=" + client.getId() + " успешно добавлен!\n");
    }

    public List<Client> showClientList() {
        return clientsList;
    }

    @Override
    public void showClientLists() {
        System.out.println("Список всех клиентов:");
        for (int i = 0; i < clientsList.size(); i++) {
            System.out.println(clientsList.get(i));
        }
        System.out.println();
    }

    public void editClient(int indexId, String editParam) throws IOException{
        Client client = clientsList.get(indexId);
        String editParamNew = "";
        int editParamNewInt = 0;

        Integer id = client.getId();
        String name = client.getName();
        String surname = client.getSurname();
        String email = client.getEmail();
        int phone = client.getPhone();

        System.out.println("Введите " + editParam + ":");

        switch (editParam) {
            case "новое имя":
                editParamNew = reader.readLine();
                name = editParamNew;
                break;
            case "новую фамилию":
                editParamNew = reader.readLine();
                surname = editParamNew;
                break;
            case "новую почту":
                editParamNew = reader.readLine();
                email = editParamNew;
                break;
            case "новый телефон":
                editParamNewInt = readId();
                phone = editParamNewInt;
                break;
            default:
                System.out.println("Что-то новое прилетело в этот метод.\n");
                break;
        }
        clientsList.set(indexId, new Client(id, name, surname, email, phone));
        System.out.println("Пик-Пик. Клиент отредактирован.\n");
    }

    public void removeClient() throws IOException {
        System.out.println("Введите ID:");
        Integer id = readId();
        for (int i = 0; i < clientsList.size(); i++) {
            Client client = clientsList.get(i);
            if (client.getId() == id) {
                clientsList.remove(client);
                System.out.println("Ой-Вэй. Клиент удалён.\n");
                break;
            }
            System.out.println("В базе нет клиента с таким Id\n");
        }
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
}