
package railway;


import java.util.ArrayList;
import java.util.Scanner;

class Passenger {
    private String name;
    private int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class Train {
    private String trainNum;
    private String trainName;
    private int totalSeats;
    private int availableSeats;
    private String arrivalStation;
    private String departureStation;
    private String arrivalTime;
    private String departureTime;

    public Train(String trainNum, String trainName, int totalSeats, String arrivalStation, String departureStation,
                String arrivalTime, String departureTime) {
        this.trainNum = trainNum;
        this.trainName = trainName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.arrivalStation = arrivalStation;
        this.departureStation = departureStation;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getTrainNumber() {
        return trainNum;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
    
    public String getArrivalStation() {
        return arrivalStation;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void bookSeats(int seatsToBook) {
        if (seatsToBook > 0 && seatsToBook <= availableSeats) {
            availableSeats -= seatsToBook;
            System.out.println(seatsToBook + " seat(s) booked successfully.");
        } else {
            System.out.println("Invalid number of seats to book.");
        }
    }

    public void displayTrainInfo() {
        System.out.println("Train Number: " + trainNum);
        System.out.println("Train Name: " + trainName);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
        //super.displayTrainInfo();
        System.out.println("Arrival Station: " + arrivalStation);
        System.out.println("Departure Station: " + departureStation);
        System.out.println("Arrival Time: " + arrivalTime);
        System.out.println("Departure Time: " + departureTime);
    }
}

public class Railway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get the number of tickets to be booked
        System.out.print("Enter the number of tickets to book: ");  
        int numTickets = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Create a new Train object
        Train expressTrain = new Train("57698", "VANDE BHARATH", 200, "New Delhi", "Mumbai", "8:00 AM", "2:00 PM");

        // Display train information
        expressTrain.displayTrainInfo();
        
        // ArrayList to store passenger details
        ArrayList<Passenger> passengers = new ArrayList<>();

        // Book tickets and get passenger details
        for (int i = 0; i < numTickets; i++) {
            System.out.println("\nEnter details for Passenger " + (i+1) + ":");
            System.out.print("Enter passenger name: ");
            String name = scanner.nextLine();
            System.out.print("Enter passenger age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            passengers.add(new Passenger(name, age));
            expressTrain.bookSeats(1); // Book one seat for each passenger
        }

        // Display passenger details
        System.out.println("\nPassenger Details:");
        for (int i = 0; i < passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            System.out.println("Passenger " + (i+1) + ": Name - " + passenger.getName() + ", Age - " + passenger.getAge());
        }

        // Display updated train information
        expressTrain.displayTrainInfo();
        
        scanner.close();
    }
}


