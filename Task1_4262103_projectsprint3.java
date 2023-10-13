import java.util.ArrayList;
import java.util.Scanner;

class SignUp{
    private String name;
    private String surname;
    private String email;
    private int cell;
    private int password;

    public SignUp(String name, String surname, String email, int cell, int password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cell = cell;
        this.password = password;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public int getCell(){
        return cell;
    }
    public void setCell(int cell){
        this.cell = cell;
    }
    public int getPassword() {
        return password;
    }
    public void setPassword(int password){
        this.password = password;
    }
    public String getInfo(){
        String info = "Information of user: " + "\n" + getName() + " " + getSurname() + "\n" + getEmail() + "\n" + getCell() + "\n" + getPassword();
        return info;
    }
    public String toString() {
        return name + ", " + surname + ", " + email + ", " + cell + ", " + password;
    }
}

public class Main {
    public static void main(String[] args){
        ArrayList<SignUp> login = new ArrayList<>();
        Scanner person = new Scanner(System.in);
        System.out.println("Name: ");
        String name = person.nextLine();
        System.out.println("Surname: ");
        String surname = person.nextLine();
        System.out.println("Email: ");
        String email = person.nextLine();
        System.out.println("Cell number: ");
        int cell = person.nextInt();
        System.out.println("Password (digits only): ");
        int password = person.nextInt();

        SignUp signUp = new SignUp(name, surname, email, cell, password);
        login.add(signUp);

        System.out.println(login.get(0).getInfo());

        //login.forEach(System.out::println);
    }
}