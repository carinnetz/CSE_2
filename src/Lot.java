public class Lot {


    //declaring description for lotNumber
    private int lotNumber;
    private static int num;

    //declaring description variable
    private static String description;

    //declaring description for currentBid
    private static int currentBid;

    //declaring description for bidIncrement
    private static int bidIncrement;
    private boolean sold;

    public Lot() {
        lotNumber = ++num;
        num = 1000;
        description = "Unknown Item";
        currentBid = 0;
        bidIncrement = 0;
        sold = false;
    }

    //public Class-name
    public Lot(String description, int currentBid, int bidIncrement, boolean sold) {

        description = "Unknown Item";
        currentBid = 0;
        bidIncrement = 0;
        sold = false;

        this.description = description;
        this.currentBid = currentBid;
        this.bidIncrement = bidIncrement;
        this.sold = sold;

    }

    public int getLotNumber() {
        return lotNumber;
    }

    //sets sold variable to true
    public void markSold() {
        this.sold = true;
    }

    //sold getter
    public boolean getSold() {
        return sold;
    }

    //bidIncrement getter
    public double getBidIncrement() {
        return bidIncrement;
    }

    //description getter
    public String getDescription() {
        return description;
    }

    public int getCurrentBid() {
        return currentBid;
    }

    //setter for current bid
    public void setCurrentBid(int currentBid) {
        this.currentBid = currentBid;
    }

    //nextBid method
    public double nextBid() {
        double nextBid = currentBid + bidIncrement;
        return nextBid;
    }

    //override return
    @Override
    public String toString() {
        if (!sold) {
            System.out.println("Lot " + lotNumber + ". " + description + " was sold for $" + currentBid);
        } else {

            System.out.println("Lot " + lotNumber + ". " + description + " current bid $" + currentBid + " minimum bid $" + nextBid());
        }
        return super.toString();
    }


}
