import java.io.FileNotFoundException;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PackageSimulator sim = new PackageSimulator();

        displayMenu();
        int choice = Integer.parseInt(s.nextLine());
        while (choice != 4){
            if (choice == 1){
                System.out.println("Enter the zip code of the origin package: ");
                String oZip = s.nextLine();
                System.out.println("Enter the zip code of the destination package: ");
                String dZip = s.nextLine();
                System.out.println("Enter the weight of the weight of the package: ");
                double weight = checkInput(Double.parseDouble(s.nextLine()), 0.1, s);
                System.out.println("Enter the height of the package: ");
                double height = checkInput(Double.parseDouble(s.nextLine()), 2, s);
                System.out.println("Enter the length of the package: ");
                double length = checkInput(Double.parseDouble(s.nextLine()), 2, s);
                System.out.println("Enter the width of the package: ");
                double width = checkInput(Double.parseDouble(s.nextLine()), 2, s);
                Address o = new Address("", "", "", "", oZip);
                Address d = new Address("", "", "", "", dZip);
                Package p = new Package(o, d, weight, height, length, width);
                System.out.println("Cost: " + PostageCalculator.calculatePostage(p));
            }
            else if (choice == 2){
                System.out.println("How many packages would you like to simulate?: ");
                int num = Integer.parseInt(s.nextLine());
                try{
                    sim.generatePackages(num);
                } catch (FileNotFoundException e){
                    System.exit(1);
                }
                System.out.println(sim.getSimulationInfo());
                sim.resetSimulation();
            }
            else if (choice == 3){
                displayPricing();
            }
            displayMenu();
            choice = Integer.parseInt(s.nextLine());
        }
    }

    public static void displayMenu(){
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1. Calculate cost of one package\n2. Simulate packages\n3. How package costs are calculated \n4. Exit\n");
    }

    public static void displayPricing(){
        System.out.println("The prices of packages are calculated based on three main factors: \nSize, Weight, and the County Codes of the origin and destination addresses.");
        System.out.println("GENERAL PRICING ---------------------------------------------------------------");
        System.out.println("The base cost of all packages is $3.75. For every tenth of a pound, 5 cents are added.");
        System.out.println("The County Code of the origin and destination addresses are the first 3 digits of their zip codes. The difference between their county codes\ndivided by 100 is added to the cost.");
        System.out.println("OVERSIZED PACKAGES ------------------------------------------------------------");
        System.out.println("If the packages dimensions exceed a total of 36 inches combined, it is considered an oversized package. Each additional inch costs another 10 cents.");
        System.out.println("If the package is more than 40 pounds, it is also considered oversized. For each tenth of a pound after 40 pounds, 10 cents will be added to the cost.");
    }

    public static double checkInput(double input, double min, Scanner s){
        while (input < min){
            System.out.println("Please enter a number greater than or equal to " + min);
            input = Double.parseDouble(s.nextLine());
        }
        return input;
    }
}
