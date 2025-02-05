package LastKviz4Prep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}

class User01 {
    String username;
    String password;
    int id;
    String email;

    public User01(String username, String password, int id, String email) {
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("tmp/userDetails.txt"));
            writer.write("Username: " + this.username + "\n");
            writer.write("Password: " + this.password + "\n");
            writer.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void validatePassword() throws PasswordException {
        if(this.password.length() < 5) {
            throw new PasswordException("NO");
        }
    }


}
