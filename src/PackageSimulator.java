import java.util.ArrayList;
public class PackageSimulator {
    private ArrayList<Package> packages = new ArrayList<Package>();

    public void generatePackages(int num){
       for (int i = 0; i < num; i++){
           //ZIP 1
           String zip1 = "";
           for (int j = 0; j < 5; j++) {
               zip1 += (int) (Math.random() * 10);
           }
           while (!checkValidity(zip1)) {
               zip1 = "";
               for (int n = 0; n < 5; n++) {
                   zip1 += (int) (Math.random() * 10);
               }
           }
           //ZIP 2
           String zip2 = "";
           for (int j = 0; j < 5; j++) {
               zip2 += (int) (Math.random() * 10);
           }
           while (!checkValidity(zip2)) {
               zip2 = "";
               for (int n = 0; n < 5; n++) {
                   zip2 += (int) (Math.random() * 10);
               }
           }

           double w = 0;
           boolean overweight = ((int)(Math.random() * 5)) < 2; //25% chance
           //fed ex max weight is 150 pounds
           if (overweight){
               w = (Math.random() * 111 + 40);
           }
           else{
               w = (Math.random() * 40);
           }

           //online it says the standard box measures 17 inch by 12 inch by 12 inch
           //USPS will only ship packages that are at least 6 inches in length, 3 inches in height, and 0.25 inches in width

           double l = (Math.random() * 24 + 6);
           double h = (Math.random() * 27 + 3);
           double wi = (Math.random() * 29 + 1);

           Address ad1 = new Address("123", "Random Street", "3C", "City", "State", zip1);
           Address ad2 = new Address("123", "Random Street", "3C", "City", "State", zip2);
           Package p = new Package(ad1, ad2, w, l, h, wi);
           packages.add(p);
        }
    }

    public boolean checkValidity(String z){
         //zip codes cannot be entirely made up of only 1 unique digit (?)
        for (int i = 0; i < z.length() - 1; i++) {
            if (z.charAt(i) != z.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    public double generateCost(Package p){
        return PostageCalculator.calculatePostage(p);
    }

    public double generateTotalCost(){
        double cost = 0;
        for (Package p: packages){
            cost += PostageCalculator.calculatePostage(p);
        }
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
