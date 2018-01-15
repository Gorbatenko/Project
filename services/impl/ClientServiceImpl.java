package BigProject.services.impl;

import BigProject.services.ClientService;
import BigProject.services.model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ClientServiceImpl implements ClientService {

    private final BufferedReader reader;
    private List<Client> clients = new ArrayList<>();
    private String name;
    private String surname;
    private String email;
    private int phone;
    private int id;

    public ClientServiceImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        clients = new ArrayList<>();
        readTxt();
    }

    public void addClient() throws IOException {
        System.out.println("Введите Id клиента");
        id = readId();
        System.out.println("Введите имя:");
        name = reader.readLine();
        System.out.println("Введите фамилию:");
        surname = reader.readLine();
        System.out.println("Введите почту:");
        email = reader.readLine();
        System.out.println("Введите телефон, без кода страны:");
        phone = readId();

        if (clients.size() > 0) {
            for (int i = 0; i < clients.size(); i++) {
                Client client = clients.get(i);
                if (Objects.equals(client.getId(), id)) {
                    client.setName(name);
                    client.setSurname(surname);
                    client.setEmail(email);
                    client.setPhone(phone);
                    break;
                } else {
                    if (i == clients.size()-1) {
                        clients.add(new Client(id, name, surname, email, phone));
                    }
                }
            }
        } else {
            clients.add(new Client(id, name, surname, email, phone));
        }
        writeTxt();
        System.out.println("Клиент Id=" + id + " успешно добавлен!\n");
    }

    @Override
    public void showClientsList() {
        List<Client> clientsList = getClients();
        if (clientsList.size() > 0) {
            System.out.println("Список всех клиентов:");
            for (Client aClientsList : clientsList) {
                System.out.println(aClientsList);
            }
            System.out.println();
        } else {
            System.out.println("База клиентов пуста.\n");
        }
    }

    public void editClient(int indexId, String editParam) throws IOException{
        Client client = clients.get(indexId);

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
        writeTxt();
        System.out.println("Клиент отредактирован.\n");
    }

    public void removeClient(int indexId) {
        Client client = clients.get(indexId);
        clients.remove(client);
        writeTxt();
        System.out.println("Клиент удалён.\n");
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

    private void writeTxt() {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("Clients.txt"))))) {
            for (Client aClientsList : clients) {
                printWriter.println(String.valueOf(aClientsList));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void readTxt() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("Clients.txt")))) {
            String line = reader.readLine();
            while (line != null) {
                ArrayList<String> arr = new ArrayList<String>();
                for(;line.contains(";");) {
                    arr.add(line.substring(1, line.indexOf(";")));
                    line = line.substring(line.indexOf(";") + 1, line.length());
                }
                arr.add(line.substring(1, line.length()-1));

                id = Integer.valueOf(arr.get(0));
                name = arr.get(1);
                surname = arr.get(2);
                email = arr.get(3);
                phone = Integer.valueOf(arr.get(4));

                clients.add(new Client(id, name, surname, email, phone));
                line = reader.readLine();
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("В файле Clients.txt нет клиентов.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getReadId() throws IOException {
        return readId();
    }

    public List<Client> getClients(){
        return clients;
    }

}