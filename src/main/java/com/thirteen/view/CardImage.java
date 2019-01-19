package com.thirteen.view;

import com.thirteen.model.CardID;
import com.thirteen.model.Rank;
import com.thirteen.model.Suit;
import javafx.scene.image.Image;

import java.io.File;
import java.util.HashMap;

/**
 * Enum representing card image assets. Contains all possible
 * types of cards.
 *
 * @author Michael Kha
 */
public enum CardImage {
    CARD_BACK(Rank.BACK, Suit.BACK, "card_back.png"),
    THREE_OF_SPADES(Rank.THREE, Suit.SPADES, "3_of_spades.png"),
    THREE_OF_CLUBS(Rank.THREE, Suit.CLUBS, "3_of_clubs.png"),
    THREE_OF_DIAMONDS(Rank.THREE, Suit.DIAMONDS, "3_of_diamonds.png"),
    THREE_OF_HEARTS(Rank.THREE, Suit.HEARTS, "3_of_hearts.png"),
    FOUR_OF_SPADES(Rank.FOUR, Suit.SPADES, "4_of_spades.png"),
    FOUR_OF_CLUBS(Rank.FOUR, Suit.CLUBS, "4_of_clubs.png"),
    FOUR_OF_DIAMONDS(Rank.FOUR, Suit.DIAMONDS, "4_of_diamonds.png"),
    FOUR_OF_HEARTS(Rank.FOUR, Suit.HEARTS, "4_of_hearts.png"),
    FIVE_OF_SPADES(Rank.FIVE, Suit.SPADES, "5_of_spades.png"),
    FIVE_OF_CLUBS(Rank.FIVE, Suit.CLUBS, "5_of_clubs.png"),
    FIVE_OF_DIAMONDS(Rank.FIVE, Suit.DIAMONDS, "5_of_diamonds.png"),
    FIVE_OF_HEARTS(Rank.FIVE, Suit.HEARTS, "5_of_hearts.png"),
    SIX_OF_SPADES(Rank.SIX, Suit.SPADES, "6_of_spades.png"),
    SIX_OF_CLUBS(Rank.SIX, Suit.CLUBS, "6_of_clubs.png"),
    SIX_OF_DIAMONDS(Rank.SIX, Suit.DIAMONDS, "6_of_diamonds.png"),
    SIX_OF_HEARTS(Rank.SIX, Suit.HEARTS, "6_of_hearts.png"),
    SEVEN_OF_SPADES(Rank.SEVEN, Suit.SPADES, "7_of_spades.png"),
    SEVEN_OF_CLUBS(Rank.SEVEN, Suit.CLUBS, "7_of_clubs.png"),
    SEVEN_OF_DIAMONDS(Rank.SEVEN, Suit.DIAMONDS, "7_of_diamonds.png"),
    SEVEN_OF_HEARTS(Rank.SEVEN, Suit.HEARTS, "7_of_hearts.png"),
    EIGHT_OF_SPADES(Rank.EIGHT, Suit.SPADES, "8_of_spades.png"),
    EIGHT_OF_CLUBS(Rank.EIGHT, Suit.CLUBS, "8_of_clubs.png"),
    EIGHT_OF_DIAMONDS(Rank.EIGHT, Suit.DIAMONDS, "8_of_diamonds.png"),
    EIGHT_OF_HEARTS(Rank.EIGHT, Suit.HEARTS, "8_of_hearts.png"),
    NINE_OF_SPADES(Rank.NINE, Suit.SPADES, "9_of_spades.png"),
    NINE_OF_CLUBS(Rank.NINE, Suit.CLUBS, "9_of_clubs.png"),
    NINE_OF_DIAMONDS(Rank.NINE, Suit.DIAMONDS, "9_of_diamonds.png"),
    NINE_OF_HEARTS(Rank.NINE, Suit.HEARTS, "9_of_hearts.png"),
    TEN_OF_SPADES(Rank.TEN, Suit.SPADES, "10_of_spades.png"),
    TEN_OF_CLUBS(Rank.TEN, Suit.CLUBS, "10_of_clubs.png"),
    TEN_OF_DIAMONDS(Rank.TEN, Suit.DIAMONDS, "10_of_diamonds.png"),
    TEN_OF_HEARTS(Rank.TEN, Suit.HEARTS, "10_of_hearts.png"),
    JACK_OF_SPADES(Rank.JACK, Suit.SPADES, "jack_of_spades.png"),
    JACK_OF_CLUBS(Rank.JACK, Suit.CLUBS, "jack_of_clubs.png"),
    JACK_OF_DIAMONDS(Rank.JACK, Suit.DIAMONDS, "jack_of_diamonds.png"),
    JACK_OF_HEARTS(Rank.JACK, Suit.HEARTS, "jack_of_hearts.png"),
    QUEEN_OF_SPADES(Rank.QUEEN, Suit.SPADES, "queen_of_spades.png"),
    QUEEN_OF_CLUBS(Rank.QUEEN, Suit.CLUBS, "queen_of_clubs.png"),
    QUEEN_OF_DIAMONDS(Rank.QUEEN, Suit.DIAMONDS, "queen_of_diamonds.png"),
    QUEEN_OF_HEARTS(Rank.QUEEN, Suit.HEARTS, "queen_of_hearts.png"),
    KING_OF_SPADES(Rank.KING, Suit.SPADES, "king_of_spades.png"),
    KING_OF_CLUBS(Rank.KING, Suit.CLUBS, "king_of_clubs.png"),
    KING_OF_DIAMONDS(Rank.KING, Suit.DIAMONDS, "king_of_diamonds.png"),
    KING_OF_HEARTS(Rank.KING, Suit.HEARTS, "king_of_hearts.png"),
    ACE_OF_SPADES(Rank.ACE, Suit.SPADES, "ace_of_spades.png"),
    ACE_OF_CLUBS(Rank.ACE, Suit.CLUBS, "ace_of_clubs.png"),
    ACE_OF_DIAMONDS(Rank.ACE, Suit.DIAMONDS, "ace_of_diamonds.png"),
    ACE_OF_HEARTS(Rank.ACE, Suit.HEARTS, "ace_of_hearts.png"),
    TWO_OF_SPADES(Rank.TWO, Suit.SPADES, "2_of_spades.png"),
    TWO_OF_CLUBS(Rank.TWO, Suit.CLUBS, "2_of_clubs.png"),
    TWO_OF_DIAMONDS(Rank.TWO, Suit.DIAMONDS, "2_of_diamonds.png"),
    TWO_OF_HEARTS(Rank.TWO, Suit.HEARTS, "2_of_hearts.png");

    /**
     * Path name where the images are located
     */
    private static final String PATH_NAME = "file:src/main/resources/img/card/";

    /**
     * Map used to access the associated image
     */
    public static final HashMap<CardID, CardImage> CARD_IMAGES = new HashMap<>();
    static {
        /*
        CARD_IMAGES.put(new Enum[]{Rank.BACK, Suit.BACK}, CARD_BACK);
        CARD_IMAGES.put(new Enum[]{Rank.THREE, Suit.SPADES}, THREE_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.THREE, Suit.CLUBS}, THREE_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.THREE, Suit.DIAMONDS}, THREE_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.THREE, Suit.HEARTS}, THREE_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.FOUR, Suit.SPADES}, FOUR_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.FOUR, Suit.CLUBS}, FOUR_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.FOUR, Suit.DIAMONDS}, FOUR_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.FOUR, Suit.HEARTS}, FOUR_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.FIVE, Suit.SPADES}, FIVE_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.FIVE, Suit.CLUBS}, FIVE_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.FIVE, Suit.DIAMONDS}, FIVE_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.FIVE, Suit.HEARTS}, FIVE_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.SIX, Suit.SPADES}, SIX_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.SIX, Suit.CLUBS}, SIX_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.SIX, Suit.DIAMONDS}, SIX_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.SIX, Suit.HEARTS}, SIX_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.SEVEN, Suit.SPADES}, SEVEN_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.SEVEN, Suit.CLUBS}, SEVEN_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.SEVEN, Suit.DIAMONDS}, SEVEN_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.SEVEN, Suit.HEARTS}, SEVEN_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.EIGHT, Suit.SPADES}, EIGHT_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.EIGHT, Suit.CLUBS}, EIGHT_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.EIGHT, Suit.DIAMONDS}, EIGHT_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.EIGHT, Suit.HEARTS}, EIGHT_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.NINE, Suit.SPADES}, NINE_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.NINE, Suit.CLUBS}, NINE_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.NINE, Suit.DIAMONDS}, NINE_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.NINE, Suit.HEARTS}, NINE_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.TEN, Suit.SPADES}, TEN_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.TEN, Suit.CLUBS}, TEN_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.TEN, Suit.DIAMONDS}, TEN_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.TEN, Suit.HEARTS}, TEN_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.JACK, Suit.SPADES}, JACK_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.JACK, Suit.CLUBS}, JACK_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.JACK, Suit.DIAMONDS}, JACK_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.JACK, Suit.HEARTS}, JACK_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.QUEEN, Suit.SPADES}, QUEEN_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.QUEEN, Suit.CLUBS}, QUEEN_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.QUEEN, Suit.DIAMONDS}, QUEEN_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.QUEEN, Suit.HEARTS}, QUEEN_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.KING, Suit.SPADES}, KING_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.KING, Suit.CLUBS}, KING_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.KING, Suit.DIAMONDS}, KING_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.KING, Suit.HEARTS}, KING_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.ACE, Suit.SPADES}, ACE_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.ACE, Suit.CLUBS}, ACE_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.ACE, Suit.DIAMONDS}, ACE_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.ACE, Suit.HEARTS}, ACE_OF_HEARTS);
        CARD_IMAGES.put(new Enum[]{Rank.TWO, Suit.SPADES}, TWO_OF_SPADES);
        CARD_IMAGES.put(new Enum[]{Rank.TWO, Suit.CLUBS}, TWO_OF_CLUBS);
        CARD_IMAGES.put(new Enum[]{Rank.TWO, Suit.DIAMONDS}, TWO_OF_DIAMONDS);
        CARD_IMAGES.put(new Enum[]{Rank.TWO, Suit.HEARTS}, TWO_OF_HEARTS);
        */
        CARD_IMAGES.put(new CardID(Rank.BACK, Suit.BACK), CARD_BACK);
        CARD_IMAGES.put(new CardID(Rank.THREE, Suit.SPADES), THREE_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.THREE, Suit.CLUBS), THREE_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.THREE, Suit.DIAMONDS), THREE_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.THREE, Suit.HEARTS), THREE_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.FOUR, Suit.SPADES), FOUR_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.FOUR, Suit.CLUBS), FOUR_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.FOUR, Suit.DIAMONDS), FOUR_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.FOUR, Suit.HEARTS), FOUR_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.FIVE, Suit.SPADES), FIVE_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.FIVE, Suit.CLUBS), FIVE_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.FIVE, Suit.DIAMONDS), FIVE_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.FIVE, Suit.HEARTS), FIVE_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.SIX, Suit.SPADES), SIX_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.SIX, Suit.CLUBS), SIX_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.SIX, Suit.DIAMONDS), SIX_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.SIX, Suit.HEARTS), SIX_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.SEVEN, Suit.SPADES), SEVEN_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.SEVEN, Suit.CLUBS), SEVEN_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.SEVEN, Suit.DIAMONDS), SEVEN_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.SEVEN, Suit.HEARTS), SEVEN_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.EIGHT, Suit.SPADES), EIGHT_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.EIGHT, Suit.CLUBS), EIGHT_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.EIGHT, Suit.DIAMONDS), EIGHT_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.EIGHT, Suit.HEARTS), EIGHT_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.NINE, Suit.SPADES), NINE_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.NINE, Suit.CLUBS), NINE_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.NINE, Suit.DIAMONDS), NINE_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.NINE, Suit.HEARTS), NINE_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.TEN, Suit.SPADES), TEN_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.TEN, Suit.CLUBS), TEN_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.TEN, Suit.DIAMONDS), TEN_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.TEN, Suit.HEARTS), TEN_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.JACK, Suit.SPADES), JACK_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.JACK, Suit.CLUBS), JACK_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.JACK, Suit.DIAMONDS), JACK_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.JACK, Suit.HEARTS), JACK_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.QUEEN, Suit.SPADES), QUEEN_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.QUEEN, Suit.CLUBS), QUEEN_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.QUEEN, Suit.DIAMONDS), QUEEN_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.QUEEN, Suit.HEARTS), QUEEN_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.KING, Suit.SPADES), KING_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.KING, Suit.CLUBS), KING_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.KING, Suit.DIAMONDS), KING_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.KING, Suit.HEARTS), KING_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.ACE, Suit.SPADES), ACE_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.ACE, Suit.CLUBS), ACE_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.ACE, Suit.DIAMONDS), ACE_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.ACE, Suit.HEARTS), ACE_OF_HEARTS);
        CARD_IMAGES.put(new CardID(Rank.TWO, Suit.SPADES), TWO_OF_SPADES);
        CARD_IMAGES.put(new CardID(Rank.TWO, Suit.CLUBS), TWO_OF_CLUBS);
        CARD_IMAGES.put(new CardID(Rank.TWO, Suit.DIAMONDS), TWO_OF_DIAMONDS);
        CARD_IMAGES.put(new CardID(Rank.TWO, Suit.HEARTS), TWO_OF_HEARTS);
    }

    private static final double WIDTH = 500.0;

    private static final double HEIGHT = 726.0;

    /**
     * Rank of the image
     */
    private final Rank rank;

    /**
     * Suit of the image
     */
    private final Suit suit;

    /**
     * The actual image used to display the card
     */
    private final Image image;

    /**
     * Creates a card image given a rank and suit as well as the image name.
     * @param rank      Rank of card
     * @param suit      Suit of card
     * @param imageName Image nam
     */
    CardImage(Rank rank, Suit suit, String imageName) {
        this.rank = rank;
        this.suit = suit;
        image = new Image(PATH_NAME + imageName, WIDTH, HEIGHT, false, false);
    }

    /**
     * Get the image contained in the map.
     * @return  The image associated with the enum
     */
    public Image getImage() {
        return image;
    }

}
