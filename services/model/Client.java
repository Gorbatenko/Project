package BigProject.services.model;

public class Client {
    private String name;
    private String surname;
    private String email;
    private int phone;

    public Client(){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }
}
