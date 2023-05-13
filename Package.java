//@author Shreyan Wankavala
//112634232
//Recitation 01

public class Package {
    private String recipient;
    private int arrivalDate;
    private double weight;


    /** A constructor which makes a new package. Takes in three paremeters.
     *
     * @param recipient = the name of the package owner
     * @param arrivalDate = the arrival date of the package.
     * @param weight = the weight of the package.
     */
    public Package(String recipient, int arrivalDate, double weight){
        this.recipient = recipient;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
    }

    /** A method which allows you to change the recipient of a package
     *
     * @param recipient = the new recipient of the package
     */
    public void setRecipient(String recipient){
        this.recipient = recipient;
    }

    /** A method which allows you to change the arrival date of the package.
     *
     * @param arrivalDate = the new arrival date of the package.
     */
    public void setArrivalDate(int arrivalDate){
        this.arrivalDate = arrivalDate;
    }

    /** A method which allows you to set the weight of a package.
     *
     * @param weight = the new weight of the package.
     */
    public void setWeight(double weight){
        this.weight = weight;
    }


    /** Returns the recipient of a given package
     *
     * @return the recipient of the package
     */
    public String getRecipient(){
        return recipient;
    }

    /** Returns the arrival date of a given package
     *
     * @return the arrival date of the package
     */
    public int getArrivalDate(){
        return arrivalDate;
    }

    /** Returns the weight of a given package
     *
     * @return the weight of the package.
     */
    public double getWeight(){
        return weight;
    }

    /** A method to return the recipient and arrival date of a package in a string.
     *
     * @return the recipient and arrival date as a string.
     */
    public String toString(){
        return recipient + " " + arrivalDate;
    }
}
