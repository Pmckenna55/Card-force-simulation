public interface DeckInterface {


    /**Requests user input for suit and rank of card and returns position of card in deck
     @return card position, returns -1 if not found   */
    public int find();

    /**
     * Displays the rank and suit of the top card in the deck
     */
    public void reveal();

    /**
     * Displays the positions, ranks and suits of all cards in the deck
     */
    public void show();

    /**
     * Randomly shuffles the deck
     */
    public void shuffle();

    /**
     * Performs an inShuffle on the deck
     */
    public void inShuffle();
    /**
     * Performs an outShuffle on the deck
     */
    public void outShuffle();


}
