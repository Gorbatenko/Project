package BigProject.services.model;

public class Client {
    private int id;
    private String name;
    private String surname;
    private String email;
    private int phone;

    public Client(int id, String name, String surname, String email, int phone){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
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

    @Override
    public String toString() {
        return "[" + id + ", " + name + ", " + surname + ", " + email + ", " + phone + "]";
    }
}
