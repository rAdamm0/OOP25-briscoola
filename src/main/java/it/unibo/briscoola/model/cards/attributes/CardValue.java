package it.unibo.briscoola.model.cards.attributes;

/*
 * in Briscola the cards are going from 1 to 7
 * after there are jack, horse, king
 * the value level are 2,4,5,6,7,jack,horse,king,tree,ace
 */

public enum CardValue {

    /*card(valuePoints,valueHierarchy) */
    
    /*
     *Card with 1, with value of Points, and Grade of importance
     */
    TWO(0,1),

    /*
     *Card with 1, with value of Points, and Grade of importance
     */
    FOUR(0,2),

    /*
     *Card with 1, with value of Points, and Grade of importance
     */
    FIVE(0,3),

    /*
     *Card with 1, with value of Points, and Grade of importance
     */
    SIX(0,4),

    /*
     *Card with 1, with value of Points, and Grade of importance
     */
    SEVEN(0,5),

    /*
     *Card with 1, with value of Points, and Grade of importance
     */
    JACK(2,6),

    /*
     *Card with 1, with value of Points, and Grade of importance
     */
    HORSE(3,7),

    /*
     *Card with 1, with value of Points, and Grade of importance
     */
    KING(4,8),

    /*
     *Card with 1, with value of Points, and Grade of importance
     */
    THREE(10,9),

    /*
     *Card with 1, with value of Points, and Grade of importance
     */
    ACE(11,10);


    private final int pointCard;
    private final int powerCard;

    /*
    * Constructor for Cards
    */
    CardValue(final int pointCard, final int powerCard){
        this.pointCard=pointCard;
        this.powerCard=powerCard;
    }

    /* @retutn the points of the card */
    public int getPointCard(){
        return this.pointCard;
    }

    /* @return the Power opr valueHierarchy of the card */
    public int getPowerCard(){
        return this.powerCard;
    }
}
