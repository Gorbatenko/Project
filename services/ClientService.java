package BigProject.services;

import BigProject.services.model.Client;

import java.io.IOException;

public interface ClientService {

    void addClient(Client client) throws IOException;

    void editClient();

    void removeClient();

}