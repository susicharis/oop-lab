package Week11Lecture.Kviz.First;

import java.io.BufferedWriter;
import java.io.FileWriter;

class PasswordValidation extends Exception {
    public PasswordValidation(String message) {
        super(message);
    }
}

class User03 {
    String username;
    String password;
    String id;
    String email;

    public User03(String username, String password, String id, String email) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    public void writeToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/tmp/userDetails.txt"));
            writer.write("Username: " + this.username);
            writer.write("Password: " + this.password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void validatePassword() throws PasswordValidation {
        if(this.password.length() < 5)
            throw new PasswordValidation("Not good nigga");
    }
}