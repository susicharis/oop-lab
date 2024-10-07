package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // First Task
    public static void main(String[] args) {
        String correctPassword = "java123";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Unesite lozinku: ");
        String enteredPassword = scanner.nextLine();

        if (enteredPassword.equals(correctPassword)) {
            System.out.println("Tačna lozinka! Evo tajne poruke:");
            System.out.println("Tajna poruka: Dobrodošli u svijet programiranja u Javi!");
        } else {
            System.out.println("Pogrešna lozinka. Try Again! ");
        }

        scanner.close();
    }


    // Second Task



}
