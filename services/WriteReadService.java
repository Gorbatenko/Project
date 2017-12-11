package BigProject.services;

import BigProject.services.model.Client;

import java.util.List;

public interface WriteReadService {

    void saveToTxt(List<Client> clientsList);
}
