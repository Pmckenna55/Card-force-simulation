

import java.util.Random;
import java.util.Scanner;

public class Deck implements DeckInterface {

    private Card[] deckArray = new Card[52];
    private int topIndex;


    //Constructor
    public Deck() {
        topIndex = 52;
        generateCards();

    }


    public int find(){
        boolean input = false;
        int rankNum= 0;
        int suitNum=0;
        String suit;
        String strRank;
        Integer IntegerRank;


        while (!input) {
            try {
                Scanner scanMan = new Scanner(System.in);
                System.out.println("\n\nEnter number of suit:\n1: Hearts\n2: Diamonds\n3: Clubs\n4: Spades");
                System.out.println("Enter: ");
                suitNum = scanMan.nextInt();

                System.out.println("\n\nEnter number of rank :\n2: Rank 2\n3: Rank 3\n4: Rank 4\n5: Rank 5\n6: Rank 6\n7: Rank 7\n8: Rank 8\n9: Rank 9\n10: Rank 10\n11: Rank Jack" +
                        "\n12: Rank Queen\n13: Rank King\n14: Rank Ace");
                System.out.println("Enter: ");
                rankNum = scanMan.nextInt();

                //ensure correct input
                if ((suitNum >= 1) && (suitNum <= 4) && (rankNum >=2) && (rankNum <= 14)) {
                    input = true;

                } else {
                    //if number out of bounds displayed is entered
                    throw new Exception();
                }

                //if invalid input entered
            } catch (Exception e) {
                System.out.println("Invaild input re-enter selections ");
            }
        }//while loop


        //assign suit value
        switch(suitNum){
            case 1:
                suit = "Hearts";
                break;
            case 2:
                suit = "Diamonds";
                break;
            case 3:
                suit = "Clubs";
                break;
            default:
                suit = "Spades";
                break;
        }
        //if 2-10 set value
        if(rankNum <= 10){
            IntegerRank = rankNum;

            for(int i =0; i< deckArray.length ;i++){

                if(deckArray[i].rank == IntegerRank && deckArray[i].suit.equals(suit)){
                    //return card position
                    return i+1;
                }
            }

            //if face card set value
        }else{

            switch(rankNum){
                case 11:
                    strRank = "Jack";
                    break;
                case 12:
                    strRank = "Queen";
                    break;
                case 13:
                    strRank = "King";
                    break;
                default:
                    strRank = "Ace";
                    break;
            }

            for(int i = 0; i< deckArray.length ;i++){

                if(deckArray[i].rank.equals(strRank) && deckArray[i].suit.equals(suit)){
                    //return card position
                    return i+1;
                }
            }
        }
        //if card has not been found
        return -1;
    }//find method



    public void reveal(){
        System.out.print( "  Rank: " + deckArray[0].rank);
        System.out.println("   Suit: " + deckArray[0].suit);
    }



    public void show(){

        int index = 0;
        while(index <= 51) {

            System.out.print("Position: "+ (index+1) +"  Rank: " + deckArray[index].rank);
            System.out.println("   Suit: " + deckArray[index].suit);

            index++;
        }
    }

    //method to shuffle the deck
    public void shuffle(){

        Random rand = new Random();

        for (int i = 0; i < deckArray.length; i++) {


            int randomIndex = rand.nextInt(deckArray.length);

            //swap cards at each position
            Card tempCard = deckArray[i];
            deckArray[i] = deckArray[randomIndex];
            deckArray[randomIndex] = tempCard;

        }
    }

    public void inShuffle(){

        Card topHalf[] = new Card[26];
        Card bottomHalf[] = new Card[26];
        topIndex =52;

        //split deck into two halves
        System.arraycopy(deckArray, 0, topHalf, 0,26 );
        System.arraycopy(deckArray, 26, bottomHalf, 0,26 );



        for(int i = 25; i >= 0; i--){

            push(topHalf[i]);
            push(bottomHalf[i]);

        }

    }

    public void outShuffle(){

        Card topHalf[] = new Card[26];
        Card bottomHalf[] = new Card[26];
        topIndex =52;

        //split deck into two halves
        System.arraycopy(deckArray, 0, topHalf, 0,26 );
        System.arraycopy(deckArray, 26, bottomHalf, 0,26 );


        for(int i = 25; i >= 0; i--){

            push(bottomHalf[i]);
            push(topHalf[i]);


        }

    }



    private void push(Card newCard){

        deckArray[topIndex-1] = newCard;
        topIndex--;

    }



    private void generateCards(){
        int rank;
        String faceRank;
        String suit;
        Card<Integer> tempCard;
        Card<String> tempFaceCard;

        //loop through each quarter(13 cards) of the deck
        for(int i = 0; i < 4;i++){

            //switch to assign suits of each quarter
            switch (i) {
                case 0:
                    suit = "Hearts";
                    break;
                case 1:
                    suit = "Diamonds";
                    break;
                case 2:
                    suit = "Clubs";
                    break;

                default:
                    suit = "Spades";
                    break;
            }
            //loop to set rank for each card from 2 to Ace
            for(int k = 0; k < 13; k++){
                rank = k+2;
                //If card is a number card
                if(rank <= 10){
                    //add number card
                    Integer tRank = rank;

                    tempCard = new Card<Integer>(tRank, suit);
                    push(tempCard);

                } else{

                    //switch to assign ranks of face cards
                    switch (rank) {
                        case 11:
                            faceRank = "Jack";
                            break;
                        case 12:
                            faceRank = "Queen";
                            break;
                        case 13:
                            faceRank = "King";
                            break;
                        default:
                            faceRank = "Ace";
                            break;
                    }
                    //add face card
                    tempFaceCard = new Card<String>(faceRank, suit);
                    push(tempFaceCard);
                }




            }

        }

    }//generateCards



    private class Card<T>{
        private T rank;
        private String suit;


        private Card(T rank, String suit){
            this.rank = rank;
            this.suit = suit;
        }

    }



}





