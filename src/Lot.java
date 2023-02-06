public class Lot {

    //boolean for lot when 2 has been pressed
    private boolean isBidding;

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
        isBidding = false;
    }

    //public Class-name
    public Lot(String description, int currentBid, int bidIncrement) {

       lotNumber = 1000;
       num = 1;
       lotNumber = lotNumber + num;
       num++;
       isBidding = false;
       this.description = description;
        this.currentBid = currentBid;
        this.bidIncrement = bidIncrement;
        this.sold = false;
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

    //isBidding getter
    public boolean getIsBidding() {
        return isBidding;
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

    //setter isBidding
    public void setBidding(boolean bidding) {
        isBidding = bidding;
    }

    //nextBid method
    public int nextBid() {
        return currentBid + bidIncrement;
    }

    //override return
    @Override
    public String toString() {
        String lot;
        if (sold) {
            lot = "Lot " + lotNumber + ". " + description + " was sold for $" + currentBid;
        } else {
            lot = "Lot " + lotNumber + ". " + description + " current bid $" + currentBid + " minimum bid $" + nextBid();
        }
        return lot;
    }
}
