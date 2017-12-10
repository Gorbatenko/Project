package BigProject.services.impl;

import BigProject.services.WriteReadService;
import BigProject.services.model.Client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteReadServiceImpl implements WriteReadService {

    private List<Client> clientsList = new ArrayList<>();
    int noOfLines = 10000;
    public WriteReadServiceImpl() {

    }

    @Override
    public void saveToTxt() {
        File file = new File("Clients.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine = clientsList + System.getProperty("line.separator");
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(int i = noOfLines; i>0; i--){
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
