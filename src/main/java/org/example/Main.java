package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static int hunger = 0;
    private static int happiness = 0;
    private static String name;
    private static boolean adopted = false;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while(flag){

            if(adopted&&(hunger == 0 || happiness == 0)){
                System.out.println("Game over. your pet's '" + name + "' has reached a critical level.");
                endGame();
                break;
            }

            System.out.println("\nPet Adoption game menu :");
            System.out.println("1. Adopt a pet");
            System.out.println("2. Feed the pet");
            System.out.println("3. Play with the pet");
            System.out.println("4. Check Status");
            System.out.println("5. End the game");
            System.out.println("Choose the option :");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1:
                    adoptPet();
                    break;
                case 2:
                    feed();
                    break;
                case 3:
                    play();
                    break;
                case 4:
                    checkStatus();
                    break;
                case 5:
                    flag = false;
                    endGame();
                    break;
                default:
                    System.out.println("Invalid choice please choose again.");
            }
        }
    }

    private static void adoptPet(){
        if(!adopted){
            System.out.println("Please Enter the name of your pet : ");
            name = input.nextLine();
            happiness = 50;
            hunger = 50;
            adopted = true;
            System.out.println("You have adopted " + name + " successfully");
        }
        else {
            System.out.println("You have already adopted your pet");
        }
    }

    private static void checkStatus(){
        if (adopted) {
            System.out.println(name + "'s Hunger level : " + hunger);
            System.out.println(name + "'s Happiness leve : " + happiness);
        }
        else{
            System.out.println("You need to adopt a pet first.");
        }
    }

    private static void feed(){
        if (adopted){
            if(hunger < 90){
                hunger += 10;
                happiness -= 10;
                System.out.println("Pet has been fed.");
            }
            else if(hunger > 90){
                System.out.println(name + " is alraedy full.");
            }
        }
        else{
            System.out.println("You need to adopt a pet first.");
        }
    }

    private static void play(){
        if (adopted){
            if (happiness < 90){
                happiness += 10;
                hunger -= 20;
                System.out.println("Pet played and is heppier now. ");
            }
            else if(hunger > 90){
                System.out.println(name + " is too happy already.");
            }
        }
        else{
            System.out.println("You need to adopt a pet first.");
        }
    }

    private static void endGame(){
        if (adopted){
            System.out.println("Final status of " + name + " is :");
            checkStatus();
            System.out.println("*******************************************");
            System.out.println("\t Thanks for playing this game");
            System.out.println("*******************************************");
            name = null;
            adopted = false;
            hunger = 0;
            happiness = 0;
        }
        else {
            System.out.println("You need to adopt a pet first.");
        }
    }

}