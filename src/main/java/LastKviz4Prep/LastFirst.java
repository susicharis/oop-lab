package LastKviz4Prep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class ValidatePass extends Exception {
    public ValidatePass(String message) {
        super(message);
    }
}

class User04 {
    String username;
    String password;
    int id;
    String email;

    public User04(String username, String password, int id, String email) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public int getId() {
        return this.id;
    }
    public String getEmail() {
        return this.email;
    }

    public void writeToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"));
            writer.write("Username: " + this.username);
            writer.write("Password: " + this.password);
            writer.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void validatePassword() throws ValidatePass {
        if(this.password.length() < 5) {
            throw new ValidatePass("Notgood");
        }
    }

}
