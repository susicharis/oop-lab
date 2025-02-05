package Week11Lecture.Kviz;

import java.io.*;

class PasswordException extends Exception{
    PasswordException(String message){
        super(message);
    }
}

class TUser {
    String username;
    String password;

    public TUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }



    public void saveToFile(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write("Username: " + this.username);
            writer.newLine();
            writer.write("Password: " + this.password);
            writer.close();
        } catch (IOException ioe){
            System.out.println("Error: " + ioe.getMessage());
        }
    }

    public void readFromFile(String filename) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException ioe){
            System.out.println("Error: " + ioe.getMessage());
        }
    }

    public void validatePassword() throws PasswordException {
        if (password.length() < 8){
            throw new PasswordException("Meni je ovo jako ruzno");
        }
    }

    public static void main(String[] args) {
        TUser user = new TUser("Haris","harke99");
        try {
            user.validatePassword();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
