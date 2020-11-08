

public class testDeck{

    public static void main(String[] args) {

        /////////////////////////////////Deck 1 Testing////////////////////////////////////////////
        System.out.println("=======Test: create object, generateCards(), push() ============");
        Deck testDeck = new Deck();


        System.out.println("\n\n=======Test: show() ============\n");
        testDeck.show();

        System.out.println("\n\n=======Test: shuffle() ============\n");
        testDeck.shuffle();
        testDeck.show();

        System.out.println("\n\n=======Test: inShuffle() ============\n");
        testDeck.inShuffle();
        testDeck.show();

        System.out.println("\n\n=======Test: outShuffle() ============\n");
        testDeck.outShuffle();
        testDeck.show();

        System.out.println("\n\n=======Test: reveal() ============\n");
        testDeck.reveal();

        System.out.println("\n\n=======Test: find() ============\n");
        int foundLocation = testDeck.find();
        System.out.println(foundLocation);



/////////////////////////////////Deck 2 Testing////////////////////////////////////////////

       System.out.println("\n\n=======Test: create object, generateCards(), push() ============\n");
       Deck testDeck2 = new Deck();


        System.out.println("\n\n=======Test2: show() ============\n");
        testDeck2.show();

        System.out.println("\n\n=======Test2: shuffle() ============\n");
        testDeck2.shuffle();
        testDeck2.show();

        System.out.println("\n\n=======Test2: inShuffle() ============\n");
        testDeck2.inShuffle();
        testDeck2.show();

        System.out.println("\n\n=======Test2: outShuffle() ============\n");
        testDeck2.outShuffle();
        testDeck2.show();

        System.out.println("\n\n=======Test2: reveal() ============\n");
        testDeck2.reveal();

        System.out.println("\n\n=======Test2: find() ============\n");
        int foundLocation2 = testDeck2.find();
        System.out.println(foundLocation2);



/////////////////////////////////CardForceTrick Testing////////////////////////////////////////////
        testDeck.show();
        testDeck.reveal();
        CardForce.cardForceTrick(testDeck);
        testDeck.find();

    }




}
