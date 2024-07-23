/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.benito.myapp.test;
import com.benito.myapp.test.mylibs.Buyer;
import com.benito.myapp.test.mylibs.Lot;
import com.benito.myapp.test.mylibs.REM;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author keane
 */
public class RealEstate {

    public static void main(String[] args) {
        
        REM manager = new REM();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Search Lots");
            System.out.println("2. Reserve Lot");
            System.out.println("3. Sell Lot");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter desired size in sq. meters: ");
                    double size = scanner.nextDouble();
                    System.out.print("Enter block number: ");
                    int block = scanner.nextInt();
                    List<Lot> availableLots = manager.searchLots(size, block);
                    if (availableLots.isEmpty()) {
                        System.out.println("No lots available with the specified criteria.");
                    } else {
                        availableLots.forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("Enter block number: ");
                    block = scanner.nextInt();
                    System.out.print("Enter lot number: ");
                    int lotNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter buyer name: ");
                    String buyerName = scanner.nextLine();
                    System.out.print("Enter buyer contact info: ");
                    String contactInfo = scanner.nextLine();
                    Buyer buyer = new Buyer(buyerName, contactInfo);
                    if (manager.reserveLot(block, lotNumber, buyer)) {
                        System.out.println("Lot reserved successfully.");
                    } else {
                        System.out.println("Failed to reserve the lot.");
                    }
                    break;

                case 3:
                    System.out.print("Enter block number: ");
                    block = scanner.nextInt();
                    System.out.print("Enter lot number: ");
                    lotNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter buyer name: ");
                    buyerName = scanner.nextLine();
                    System.out.print("Enter buyer contact info: ");
                    contactInfo = scanner.nextLine();
                    buyer = new Buyer(buyerName, contactInfo);
                    if (manager.sellLot(block, lotNumber, buyer)) {
                        System.out.println("Lot sold successfully.");
                    } else {
                        System.out.println("Failed to sell the lot.");
                    }
                    break;

                case 4:
                    List<Lot> report = manager.generateReport();
                    report.forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    
        
    }
}
