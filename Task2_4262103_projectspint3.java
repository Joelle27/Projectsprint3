import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Task2 extends JFrame {
    private JTextField name;
    private JTextField surname;
    private JTextField email;
    private JTextField cell;
    private JTextField password;
    private JButton enterButton;

    public Task2() throws IOException {
        setTitle("Sign up page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,400);
        setLayout(new GridLayout(10,2));

        add(new JLabel("Name: "));
        name = new JTextField(20);
        add(name);

        add(new JLabel("Surname: "));
        surname = new JTextField(20);
        add(surname);

        add(new JLabel("Email: "));
        email = new JTextField(20);
        add(email);

        add(new JLabel("Cell number: "));
        cell = new JTextField(20);
        add(cell);

        add(new JLabel("Password (digits only): "));
        password = new JTextField(20);
        add(password);

        enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonListener());
        add(enterButton);
    }

    public Task2(JTextField name, JTextField surname, JTextField email, JTextField cell, JTextField password) throws IOException {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cell = cell;
        this.password = password;
    }

    private class EnterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String name1 = name.getText();
            String surname1 = surname.getText();
            String email1 = email.getText();
            String cell1 = cell.getText();
            String password1 = password.getText();
            try {
                Task2 signup = new Task2(name, surname, email, cell, password);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try{
                BufferedWriter file = new BufferedWriter(new FileWriter("volunteers.txt"));
                file.write("INFORMATION OF VOLUNTEER");
                file.write("\n" + "Name: " + name1);
                file.write("\n" + "Surname: " + surname1);
                file.write("\n" + "Email: " + email1);
                file.write("\n" + "Cell Number: " + cell1);
                file.write("\n" + "Password: " + password1);
                file.close();
                JOptionPane.showMessageDialog(null, "Successfully stored.");
            }  catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            Task2 gui = null;
            try {
                gui = new Task2();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            gui.setVisible(true);
        });
    }
}
