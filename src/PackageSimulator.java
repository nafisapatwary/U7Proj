import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PackageSimulator {
    private ArrayList<Package> packages = new ArrayList<Package>();

    public void generatePackages(int num) throws FileNotFoundException {
        File zipCodes = new File("Data/zipCodes");
        for (int i = 0; i < num; i++) {
            Scanner s1 = null;
            Scanner s2 = null;
            try {
                s1 = new Scanner(zipCodes);
                s2 = new Scanner(zipCodes);
            } catch (FileNotFoundException e) {
                System.exit(1);
            }

            String zip1 = "";
            int zip1idx = (int) (Math.random() * 42735);
            for (int j = 0; j < zip1idx + 1; j++) {
                zip1 = s1.nextLine();
            }

            String zip2 = "";
            int zip2idx = (int) (Math.random() * 42735);
            for (int n = 0; n < zip2idx; n++) {
                zip2 = s2.nextLine();
            }

            Address ad1 = new Address("123", "Not A Real Street", "1A", "City", "State", zip1);
            Address ad2 = new Address("123", "Not A Real Street", "1A", "City", "State", zip2);
            //randomize weight
            double weight = 0;
            boolean overweight = ((int)(Math.random() * 4)) < 1; //20% chance
            if (overweight) {
                //USPS max weight is 70 pounds
                weight = (Math.random() * 30) + 40;
            } else {
                weight = (Math.random() * 39.9) + 0.1;
            }

            //online it says the standard box measures 17 inch by 12 inch by 12 inch
            //so lets say the average box measures between 2 inches on each side to 20 inches on each side
            //and there's a smaller chance that a side would be greater than 20, but not more than 27 inches
            boolean longL = ((int)(Math.random() * 4)) < 1;
            boolean longH = ((int)(Math.random() * 4)) < 1;
            boolean longW = ((int)(Math.random() * 4)) < 1;
            double l = 0;
            double h = 0;
            double w = 0;

            //randomizing dimensions
            if (longL) {
                l = (Math.random() * 8) + 20;
            } else {
                l = (Math.random() * 19) + 2;
            }

            if (longH) {
                h = (Math.random() * 8) + 20;
            } else {
                h = (Math.random() * 19) + 2;
            }

            if (longW) {
                w = (Math.random() * 8) + 20;
            } else {
                w = (Math.random() * 19) + 2;
            }

            Package p = new Package(ad1, ad2, weight, l, h, w);
            packages.add(p);
        }
    }

    public double generateCost(Package p){
        return PostageCalculator.calculatePostage(p);
    }

    public double generateTotalCost(){
        double cost = 0;
        for (Package p: packages){
            cost += PostageCalculator.calculatePostage(p);
        }
        cost = Math.round(cost * 100.0) / 100.0;
        return cost;
    }

    public String getSimulationInfo() {
        String info = "\nRandomly Generated Packages info:";
        for (int i = 0; i < packages.size(); i++) {
            info += "\nPackage " + (i + 1) + ":__________________________________________" +
                    "\nOrigin address: " + packages.get(i).getOrigin() +
                    "\nDestination address: 123 " + packages.get(i).getDestination() +
                    "\nWeight: " + packages.get(i).getWeight() + " pounds" +
                    "\nHeight: " + packages.get(i).getHeight() + " inches" +
                    "\nLength: " + packages.get(i).getLength() + " inches" +
                    "\nWidth: " + packages.get(i).getWidth() + " inches" +
                    "\nCost: " + generateCost(packages.get(i)) + "\n";
        }
        info += "\nTotal Cost: " + generateTotalCost();
        return info;
    }

    public void resetSimulation(){
        packages = new ArrayList<Package>();
    }



}
