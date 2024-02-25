public class PostageCalculator {
    public static double calculatePostage(String zip1, String zip2, double weight, double l, double w, double h) {
        double cost = 3.75;
        if (weight <= 40){
            cost += (0.05) * (weight * 10);
        }
        else {
            double extra = weight - 40;
            cost += (0.05) * (weight * 10);
            cost += (.1) * (extra * 10);
        }
        double combined = l + w + h;
        if (combined > 36){
            double extra = combined - 36;
            cost += (.1) * extra;
        }
        int z1 = Integer.parseInt(zip1.substring(0, 3));
        int z2 = Integer.parseInt(zip2.substring(0, 3));
        double difference = Math.abs(z2 - z1);
        cost += difference / 100;
        cost = Math.round(cost * 100.0) / 100.0;
        return cost;
    }

    public static double calculatePostage(Address ad1, Address ad2, double weight, double l, double w, double h){
        double cost = 3.75;
        if (weight <= 40){
            cost += (0.05) * (weight * 10);
        }
        else {
            double extra = weight - 40;
            cost += (0.05) * (weight * 10);
            cost += (.1) * (extra * 10);
        }
        double combined = l + w + h;
        if (combined > 36){
            double extra = combined - 36;
            cost += (.1) * extra;
        }
        int z1 = Integer.parseInt(ad1.getZipCode().substring(0, 3));
        int z2 = Integer.parseInt(ad2.getZipCode().substring(0, 3));
        double difference = Math.abs(z2 - z1);
        cost += difference / 100;
        cost = Math.round(cost * 100.0) / 100.0;
        return cost;
    }

    public static double calculatePostage(Package p){
        double cost = 3.75;
        double weight = p.getWeight();
        double l = p.getLength();
        double h = p.getHeight();
        double w = p.getWeight();
        if (weight <= 40){
            cost += (0.05) * (weight * 10);
        }
        else {
            double extra = weight - 40;
            cost += (0.05) * (weight * 10);
            cost += (.1) * (extra * 10);
        }
        double combined = l + w + h;
        if (combined > 36){
            double extra = combined - 36;
            cost += (.1) * extra;
        }
        int z1 = Integer.parseInt(p.getOrigin().getZipCode().substring(0, 3));
        int z2 = Integer.parseInt(p.getDestination().getZipCode().substring(0, 3));
        double difference = Math.abs(z2 - z1);
        cost += difference / 100;
        cost = Math.round(cost * 100.0) / 100.0;
        return cost;

    }
}
