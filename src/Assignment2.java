import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        ArrayList<Lot> lot = new ArrayList<>();
        mainMenu(lot);


    }

    public static Lot getNextLot(ArrayList<Lot> arrayList) {
        if (!arrayList.isEmpty()) {
            //create cell 0 as variable
            Lot item = arrayList.get(0);
            //then remove cell 0
            arrayList.remove(0);
            //will return the "first" cell 0
            return item;
        } else {
            Lot currentLot = new Lot();
            return currentLot;
        }

    }

    //adding an item to the lot
    public static void addItem(ArrayList<Lot> arrayList) {
        Scanner sc = new Scanner(System.in);
        int startingBid, bidIncrement;
        System.out.print("Give a description?\n");
        String description = sc.nextLine().trim();
        System.out.print("What is the starting bid?\n");
        startingBid = sc.nextInt();
        System.out.print("What is the bid increment?\n");
        bidIncrement = sc.nextInt();
        //creating a lot for the user to use
        Lot item = new Lot(description, startingBid, bidIncrement);
        arrayList.add(item);
    }

    public static void methodBid(Lot chosenLot) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much would you like to bid? Minimum must be " + chosenLot.getCurrentBid());
        int userBid = sc.nextInt();
        if (userBid < chosenLot.getCurrentBid()) {
            System.out.println("You are below the minimum bid.");
        } else {
            chosenLot.setCurrentBid(userBid);
        }
    }

    //marking and printing the lot as sold
    public static void markSold(Lot chosenLot) {
        chosenLot.markSold();
        System.out.println(chosenLot);
    }

    public static void mainMenu(ArrayList<Lot> lot) {
        Scanner sc = new Scanner(System.in);
        Lot currentLot = getNextLot(lot);
        int answer = 1;
        while (answer < 5) {
            if (!currentLot.getIsBidding()){
                System.out.println("We are not currently bidding\n");
            }

            System.out.println("""
                    1. Add Lot to Auction
                    2. Start bidding on next Lot
                    3. Bid on current Lot
                    4. Mark current Lot Sold
                    5. Quit""");

            answer = sc.nextInt();

                switch (answer) {
                    case 1:
                        addItem(lot);
                        break;
                    case 2:
                        if (currentLot == null) {
                            System.out.println("There is nothing to bid on, add an item first");
                        } else if ((currentLot != null) && (!currentLot.getSold())) {
                            System.out.println("You must mark the current lot as sold before bringing up the next Lot");
                        } else {
                            currentLot.setBidding(true);
                            System.out.println("Current Lot: \n" + currentLot);
                        }
                        break;
                    case 3:
                        if (!currentLot.getIsBidding()) {
                            System.out.println("You must first bring a Lot up for bidding");
                        } else {
                            methodBid(currentLot);
                            System.out.println("Lot " + currentLot.getLotNumber() + ". " + currentLot.getDescription() + " current bid: $" + currentLot.getCurrentBid() + " minimum bid: $" + currentLot.nextBid());
                        }
                        break;
                    case 4:
                        if (currentLot == null || Objects.equals(currentLot.getDescription(), "Unknown Item") || !currentLot.getSold()) {
                            System.out.println("You must first bring a Lot up for bidding");
                        }
                        else
                        currentLot.markSold();
                        currentLot.setBidding(false);
                        currentLot = getNextLot(lot);
                        break;
                }
        }

    }
}