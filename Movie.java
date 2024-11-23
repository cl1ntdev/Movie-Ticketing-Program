import java.util.*;

public class Movie {
    public static void clrScreen() {
        for (int i = 0; i < 8; i++) {
            System.out.println(" ");
        }
    }

    public static void tradeMark() {
        System.out.println(
                "                                        ==========================================================================================");
        System.out.println(
                "                                        <>* <>*                W H I T E       S T E L L A R       F I L M S               *<> *<>");
        System.out.println(
                "                                        ==========================================================================================");
    }

    public static String invalid() {
        return "                                        =============INVALID INPUT================";
    }

    public static void recieptShow(String movie, String movieType, int ticketAmount, int totalAmountPay,
            int clientInputBalance, int change) { // showing of reciepts
        boolean next = false;
        Scanner scan = new Scanner(System.in);
        do {
            clrScreen();
            clrScreen();
            System.out.println(
                    "                                        ================================================================");
            System.out.println(
                    "                                        <>* <>*     W H I T E     S T E L L A R     F I L M S    *<> *<>");
            System.out.println(
                    "                                        ================================================================");
            System.out.println(" ");
            System.out.println("                                        Movie: " + movie + " Movie Type: " + movieType);
            System.out.println(" ");
            System.out.println("                                        Number of Tickets: " + ticketAmount);
            System.out.println(" ");
            System.out.println("                                        Total Amount: " + totalAmountPay);
            System.out.println(" ");
            System.out.println("                                        Amount Paid: PHP" + clientInputBalance);
            System.out.println(" ");
            System.out.println("                                        Change: PHP" + change);
            System.out.println(
                    "                                        =================================================================");
            System.out.println(
                    "                                        <>* <>*     W H I T E     S T E L L A R     F I L M S    *<> *<>");
            System.out.println(
                    "                                        ================================================================");

            System.out.print("                                        ENTER ANY CHARACTER TO BUY NEW TICKET: ");
            String proc = scan.nextLine();
            if (proc.length() > 0) {
                next = true;
            }
        } while (!next);
    }

    public static void buyTicket(String[] movies, String[] movieTypes, int movieChoice, int movieTypeChoice,
            int moviePriceBase) {
        String movieName = movies[movieChoice]; // movies in the movies array using the choice int
        // System.out.println(movieName); //debuggin purposes
        boolean isValid = false;

        do {
            String movieTypeBase = movieTypes[movieTypeChoice]; // used in comparing
            int price = 0;
            if (movieTypeBase.equals("IMAX")) {
                price = 100;
            } else if (movieTypeBase.equals("3D")) {
                price = 200;
            } else {
                price = 250;
            }
            clrScreen();
            tradeMark();
            System.out.println("                                                                    Movie: "
                    + movies[movieChoice] + " -> " + moviePriceBase + " || Type: " + movieTypeBase
                    + " -> " + price);
            Scanner scan = new Scanner(System.in);
            clrScreen();
            tradeMark();
            System.out.print(
                    "                                                                         No. Tickets: ");
            int noTicket = scan.nextInt(); // number of ticket the user want
            tradeMark();
            int totAmPay = 0; // declarations
            int change = 0;
            switch (movieTypeBase) {
                case "IMAX":
                    totAmPay = 100 + moviePriceBase; // declare first the variable and multiply it by how many tickets
                                                     // the user wants
                    totAmPay *= noTicket;
                    break;
                case "3D":
                    totAmPay = 200 + moviePriceBase;
                    totAmPay *= noTicket;
                    break;
                case "IMAX 3D":
                    totAmPay = 250 + moviePriceBase;
                    totAmPay *= noTicket;
                    break;
                default:
                    break;
            }
            clrScreen();
            tradeMark();
            clrScreen();
            System.out.println(
                    "                                                                         Your total amount to pay is: "
                            + totAmPay);
            clrScreen();
            tradeMark();
            System.out.print(
                    "                                                                         Please Input Amount: ");
            int clientInputBalance = scan.nextInt();
            change = clientInputBalance - totAmPay; // the clients money subtracted by the total amount to pay
            if (change >= 0) { // if change is greater or equal to 0, meaning it is a valid transaction, no
                               // ones in dept, cash is according
                isValid = true; // boolean value set to true to stop the while loop
                // proceed to next showing receipt
                recieptShow(movies[movieChoice], movieTypes[movieTypeChoice], noTicket, totAmPay,
                        clientInputBalance, change);
            } else if (change < 0) { // if change is less than 0, meaning the clients cash does not match the total
                                     // amount to be payed
                clrScreen();
                System.out.println(invalid()); // invalid show in the function
            }
        } while (!isValid);
    }

    public static void selectMovieTypes(String[] movies, String[] movieTypes, int movieChoice, int moviePriceBase) { // !!!!!reused
                                                                                                                     // code
        // block in selecting
        // movie types
        boolean select = false;
        int choice = 0;
        int iterationCount = 0;
        // int moviePrice = moviePriceBase;
        do {
            clrScreen();
            Scanner scan = new Scanner(System.in);
            tradeMark();

            System.out.println(
                    "                                        ---------Enter (U/u) to go up || Enter (D/d) to go down || Enter (C/c) to confirm---------");
            clrScreen();
            for (String m : movieTypes) { // show movietypes
                // System.out.println(iterationCount + " ?? " + choice); // debuggin for choice
                if (choice == iterationCount) {
                    switch (m) { // adding arrow logic
                        case "IMAX":
                            System.out.println(
                                    "                                                                         > "
                                            + m + ".........PHP100");
                            break;
                        case "3D":
                            System.out.println(
                                    "                                                                         > "
                                            + m + ".........PHP200");
                            break;
                        case "IMAX 3D":
                            System.out.println(
                                    "                                                                         > "
                                            + m + ".........PHP250");
                        default:
                            break;
                    }
                } else {
                    switch (m) {
                        case "IMAX":
                            System.out.println(
                                    "                                                                         "
                                            + m + ".......PHP100");
                            break;
                        case "3D":
                            System.out.println(
                                    "                                                                         "
                                            + m + "........PHP200");
                            break;
                        case "IMAX 3D":
                            System.out.println(
                                    "                                                                         "
                                            + m + "........PHP250");
                        default:
                            break;
                    }

                }
                iterationCount++;
            }
            clrScreen();
            tradeMark();
            System.out.print(
                    "                                        W/w -> up || D/d -> down || C/c -> confirm            Choice: ");
            String baseCh = scan.nextLine();
            clrScreen();
            switch (baseCh) {
                case "w":
                    if (choice <= 0) { // the same logic as the selecting movies function
                        iterationCount = 0;
                        // choice = 0;
                        // return;
                    } else {
                        choice--;
                        iterationCount = 0;
                    }
                    break;
                case "d":
                    if (choice >= movieTypes.length - 1) {
                        iterationCount = 0;
                        choice = 0;
                        // return;
                    } else {
                        choice++;
                        iterationCount = 0;
                    }
                    break;
                case "c":
                    select = true;// after everything is done, proceed to buying ticket
                    buyTicket(movies, movieTypes, movieChoice, choice, moviePriceBase); // movie array, movie type
                                                                                        // arraw,
                    // movieChoice(int value will be used in
                    // identifying the element in the movie array),
                    // current choice of types
                    break;
                default:
                    choice = 0;
                    iterationCount = 0;
                    System.out.println(invalid());
                    break;
            }
        } while (!select);
    }

    public static void selectMovie(String[] movies, String[] movieTypes) {
        int[] moviePrice = { 100, 200, 300, 400, 500 };
        boolean select = false;
        int choice = 0; // used in increment and decrement to change arrow position
        int iterationCount = 0; // used in foreach to track what iteration is being based in choices
        int moviePriceBase = 0;
        do {
            clrScreen();
            Scanner scan = new Scanner(System.in);
            tradeMark();
            clrScreen();
            for (String m : movies) {
                // System.out.println(iterationCount + " ?? " + choice); // debuggin for choice
                if (choice == iterationCount) { // if the choice is equal to the number interation it will show arrow
                    System.out.println(
                            "                                                                         > " + m
                                    + " .......... " + moviePrice[iterationCount]);
                } else {
                    System.out.println(
                            "                                                                          " + m
                                    + " .......... " + moviePrice[iterationCount]);
                }
                iterationCount++;
            }
            clrScreen();
            tradeMark();
            System.out.print(
                    "                                        W/w -> up || D/d -> down || C/c -> confirm            Choice: ");
            String baseCh = scan.nextLine();
            clrScreen();
            switch (baseCh) {
                case "w":
                    if (choice <= 0) { // the first index of the list is 0, if value is 0 or less than(highly unlikely)
                                       // it will reset the choice so the arrow will not represent -1 index
                        iterationCount = 0;
                        choice = 0;
                        // return;
                    } else {
                        choice--; // decrement for the arrow to go up
                        iterationCount = 0; // reset iteration count in displaying the movies
                    }
                    break;
                case "d":
                    if (choice >= movies.length - 1) { // comparing the choice and the last element of the movie
                        iterationCount = 0; // if choice is greater than the length, that represent the last on the list
                                            // everything will reset, so the arrow will go up
                        choice = 0;
                        // return;
                    } else {
                        choice++;
                        iterationCount = 0;
                    }
                    break;
                case "c":
                    moviePriceBase = moviePrice[choice];
                    select = true;// after everything is done the select boolean will be true, stopping the loop
                                  // and proceeding to the next function of slecting types
                    selectMovieTypes(movies, movieTypes, choice, moviePriceBase);
                    break;
                default: // reset if anything invalid happens
                    choice = 0;
                    iterationCount = 0;
                    System.out.println(invalid());
                    break;
            }
        } while (!select);
    }

    public static void main(String[] args) { // start the file here
        String[] movies = { "Gotham", "Squid Game", "Lacasa de Papel", "Candle Cobe", "On my Block" };
        String[] movieTypes = { "IMAX", "3D", "IMAX 3D" };

        do { // for the process to continue using while loop true without conditions
            selectMovie(movies, movieTypes); // to select movie

        } while (true);// true in order for the program to infinitely
    }
}
