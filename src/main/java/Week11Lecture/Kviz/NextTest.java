package Week11Lecture.Kviz;


import java.io.*;

class ValidatePassword extends Exception {
    public ValidatePassword(String message) {
        super(message);
    }
}

class User01 {
    String username;
    String password;

    public User01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }


    public void validatePassword() throws ValidatePassword {
            if (this.password.length() < 8)
                throw new RuntimeException("Jedi mi jaja");
    }

    public void saveToFile(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write("Username: " + this.username);
            writer.newLine();
            writer.write("Password: " + this.password);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        User01 user = new User01("Haris","harke99");
        try {
            user.validatePassword();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}



