package Week11Lecture.Kviz.First;

/*
class PasswordException extends Exception{
    PasswordException(String message){
        super(message);
    }
}

class SecondUser{
    String username;
    String password;

    SecondUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void saveToFile(String filename){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write("Username: " + username + "\n");
            writer.write("Password: " + password);
        } catch (IOException ioe){
            System.out.println("Error: " + ioe.getMessage());
        }
    }

    public void validatePassword() throws PasswordException{
        if(password.length() < 8){
            throw new PasswordException("Lozinka mora imati vise od 8 znakova");
        }
    }

    public void readFromFile(String filename){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}

class Main02 {
    public static void main(String[] args) {
        SecondUser user = new SecondUser("Tarik", "Tarik11111");
        try{
            user.validatePassword();
        } catch (PasswordException pe){
            System.out.println(pe.getMessage());
        }
    }
}

 */