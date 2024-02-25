public class Address {
    private String houseNumber;
    private String stName;
    private String aptNumber;
    private String city;
    private String state;
    private String zipCode;


    /**
     * Constructor for the Address Class when an apartment number is given.
     * @param h String h representing house number
     * @param s String s representing street name
     * @param a String a representing apartment number
     * @param c String c representing city name
     * @param st String st representing state
     * @param z String z representing zip code
     */
    public Address(String h, String s, String a, String c, String st, String z) {
        this.houseNumber = h;
        this.stName = s;
        this.aptNumber = a;
        this.city = c;
        this.state = st;
        this.zipCode = z;
    }

    /**
     * Constructor for the Address Class when an apartment number is not given.
     * @param h String h representing house number
     * @param s String s representing street name
     * @param c String c representing city name
     * @param st String st representing state
     * @param z String z representing zip code
     */
    public Address(String h, String s, String c, String st, String z) {
        this.houseNumber = h;
        this.stName = s;
        this.city = c;
        this.state = st;
        this.zipCode = z;
    }

    /**
     * Constructor for the Address Class
     * @param address an Address object
     */
    public Address(Address address) {
        this.houseNumber = address.getHouseNumber();
        this.stName = address.getStName();
        this.city = address.getCity();
        this.state = address.getState();
        this.zipCode = address.getZipCode();
        if (address.getAptNumber() != null) {
            this.aptNumber = address.getAptNumber();
        }
    }

    /**
     * Constructor for the Address class
     * @param address a String representing an Address
     */
    public Address(String address) {
        this.zipCode = address.substring(address.length() - 5);
        this.state = address.substring(address.length() - 8, address.length() - 6);
        address = address.substring(0, address.length() - 10);
        this.city = address.substring(address.indexOf(",") + 2);
        address = address.substring(0, address.indexOf(","));
        this.houseNumber = address.substring(0, address.indexOf(" "));
        address = address.substring(address.indexOf(" ") + 1);
        if (address.indexOf("Apt") == -1) {
            this.stName = address;
        }
        else {
            this.stName = address.substring(0, address.indexOf("Apt "));
            this.aptNumber = address.substring(address.indexOf("Apt ") + 4);
        }
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString() {
        if (aptNumber != null) {
            return (houseNumber + " " + stName + " APT " + aptNumber + ", " + city + ", " + state + " " + zipCode);
        } else {
            return (houseNumber + " " + stName + ", " + city + ", " + state + " " + zipCode);
        }
    }
}
