package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> groceryList = new ArrayList<>();

    public void startGrocery(){

        int choice;

        do {
            System.out.println("0: Çıkış\n1: Ekleme\n2: Silme");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;

                case 2:
                    System.out.print("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
            }

        } while (choice != 0);
            scanner.close();
    }


    public static void addItems(String itemsToAdd){
        String[] splitItems = itemsToAdd.split(",");
        for (String item : splitItems) {
            if (checkItemIsInList(item)) {
                System.out.println("'" + item + "' zaten listede var, eklenmedi.");
            }
            else {
                groceryList.add(item);
                System.out.println("'" + item + "' eklendi.");
            }
            sortItems();
        }
    }

    public static boolean checkItemIsInList(String item) {
        return Grocery.groceryList.contains(item);
    }

    public static void removeItems(String itemsToRemove){
        String[] splitItems = itemsToRemove.split(",");
        for (String item : splitItems) {

            if (checkItemIsInList(item)) {
            System.out.println("'" + item + "' silindi.");
            groceryList.remove(item);
            }
            else {
            System.out.println("'" + item + "' listede bulunamadı.");
            }
        }
    }

    public static void printSorted() {
        sortItems();
        System.out.println("Mevcut Liste:");

        for (String item : groceryList) {
            System.out.println(item);
        }
    }

    public static void sortItems(){
        Collections.sort(groceryList);
    }
}
