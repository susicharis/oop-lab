package LastKviz4Prep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Password02 extends Exception {
    public Password02(String message) {
        super(message);
    }
}
class User02 {
    String username;
    String password;
    int id;
    String email;

    public User02(String username, String password, int id, String email) {
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
            writer.write("Username: " + this.username + "\n");
            writer.write("Password: " + this.password + "\n");
            writer.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void validatePassword() throws Password02 {
        if(this.password.length() < 5)
            throw new Password02("Not good!");
    }


}