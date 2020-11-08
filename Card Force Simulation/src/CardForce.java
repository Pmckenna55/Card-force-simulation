

import java.util.Scanner;
public class CardForce {


    public static void main(String[] args) {

        //1
        System.out.println("====1. Create an instance of the deck of cards====");
        Deck deck = new Deck();

        //2
        System.out.println("\n\n====2. Display the current state of the deck using the show operation ====\n");
        deck.show();

        //3
        System.out.println("\n\n\n=======3. Randomly shuffle the deck using the shuffle operation, then display the\n" +
                "current state of the deck using the show operation======\n");
        deck.shuffle();
        deck.show();

        //4
        System.out.println("\n\n\n====4. Show the card at the top of the deck using the reveal operation ====\n");
        deck.reveal();

        //5
        System.out.println("\n\n\n======5. Perform the card force trick (ask the user for the specified position in the\n" +
                "deck), then display the current state of the deck afterwards using the\n" +
                "show operation======\n");

        cardForceTrick(deck);
        deck.show();

        System.out.println("\n\n\n======6. Verify the top card has been moved to the specified position in the deck\n" +
                "using the find operation======\n");

        System.out.println(deck.find());



    }


    public static void cardForceTrick(Deck theDeck){

        int num =-1;
        boolean isError = true;
        while(isError) {
            try {

                System.out.println("Enter position(Number between 1- 52) to move top card to:");
                Scanner scanMan = new Scanner(System.in);
                num = scanMan.nextInt();


                if (num < 1 || num > 52) {
                    throw new Exception();
                }
                isError= false;
            } catch (Exception err) {
                System.out.println("Invaild input!");
            }


        }
        //decrement value
        num--;
        //convert to binary string
        String binaryNum = Integer.toBinaryString(num);

        for (int i = 0; i < binaryNum.length(); i++){
            char digit = binaryNum.charAt(i);
            if(digit == '1'){
                theDeck.inShuffle();
            }else{

                theDeck.outShuffle();
            }
        }

    }

}
