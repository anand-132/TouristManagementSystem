import java.util.*;
class Tourist {
    protected String name;
    protected int age;
    protected String destination;

    public Tourist(String name, int age, String destination) {
        this.name = name;
        this.age = age;
        this.destination = destination;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Destination: " + destination);
    }
}


class DomesticTourist extends Tourist {
    private String state;

    public DomesticTourist(String name, int age, String destination, String state) {
        super(name, age, destination);
        this.state = state;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("State: " + state);
    }
}


class InternationalTourist extends Tourist {
    private String country;

    public InternationalTourist(String name, int age, String destination, String country) {
        super(name, age, destination);
        this.country = country;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Country: " + country);
    }
}

public class TouristManagementSystem {
    private static List<Tourist> touristList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Tourist Management System ---");
            System.out.println("1. Add Domestic Tourist");
            System.out.println("2. Add International Tourist");
            System.out.println("3. Display All Tourists");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addDomesticTourist(scanner);
                    break;
                case 2:
                    addInternationalTourist(scanner);
                    break;
                case 3:
                    displayAllTourists();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    
    private static void addDomesticTourist(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter State: ");
        String state = scanner.nextLine();

        DomesticTourist domesticTourist = new DomesticTourist(name, age, destination, state);
        touristList.add(domesticTourist);
        System.out.println("Domestic Tourist added successfully!");
    }

    
    private static void addInternationalTourist(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Country: ");
        String country = scanner.nextLine();

        InternationalTourist internationalTourist = new InternationalTourist(name, age, destination, country);
        touristList.add(internationalTourist);
        System.out.println("International Tourist added successfully!");
    }

    
    private static void displayAllTourists() {
        if (touristList.isEmpty()) {
            System.out.println("No tourists available.");
        } else {
            for (Tourist tourist : touristList) {
                tourist.displayDetails();
                System.out.println("------------------------");
            }
        }
    }
}
