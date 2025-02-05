package Week11Lecture.Kviz.First;

import java.io.BufferedWriter;
import java.io.FileWriter;

class User {
    String username;
    String password;
    String email;
    int id;

    public User(String username,String password,String email,int id){
        this.username = username;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public int getId() {
        return id;
    }


    public void writeToFile(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(this.username);
            writer.newLine();
            writer.write(this.password);
            writer.close();
        } catch(Exception e) {
        }

    }

}

class Password extends Exception {
    public Password(String message) {
        super(message);
    }
}
// TEORETSKA PITANJA

// after-each -> tacan odgovor
// pitanje za Annotation
// sta se sve moze raditi sa fileovima u javi
// Reflection probably

// U testu radimo cisto da procitamo iz filea i stavljamo try catch -> u slucaju da nema u fileu