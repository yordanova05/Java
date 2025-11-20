package week7.exercise5;

import java.util.Scanner;

public class Main {

    private static Room findRoomByNumber(int number) {
        for (SingleRoom r : RoomBookingSystem.singleRooms) {
            if (r.roomNumber == number) return r;
        }
        for (SuiteRoom r : RoomBookingSystem.suiteRooms) {
            if (r.roomNumber == number) return r;
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("=== Loading rooms from file... ===");
        RoomBookingSystem.processRoomReservations();
        System.out.println("=== Rooms loaded successfully ===\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== ROOM BOOKING MENU ===");
            System.out.println("1. View single rooms");
            System.out.println("2. View suite rooms");
            System.out.println("3. Reserve a room");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- SINGLE ROOMS ---");
                    for (SingleRoom r : RoomBookingSystem.singleRooms) {
                        System.out.println(r);
                    }
                    break;

                case 2:
                    System.out.println("\n--- SUITE ROOMS ---");
                    for (SuiteRoom r : RoomBookingSystem.suiteRooms) {
                        System.out.println(r);
                    }
                    break;

                case 3:
                    System.out.print("Enter room number to reserve: ");
                    int roomNumber = scanner.nextInt();

                    System.out.print("Enter nights: ");
                    int nights = scanner.nextInt();

                    Room room = findRoomByNumber(roomNumber);

                    if (room == null) {
                        System.out.println("No room with this number found!");
                        break;
                    }

                    try {
                        room.reserveRoom(nights);
                        System.out.println("Reservation successful!");
                    } catch (NotAvailableNightsException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case 4:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

