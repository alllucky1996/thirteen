package com.thirteen.view;

import com.thirteen.model.Rank;
import com.thirteen.model.Suit;
import javafx.scene.image.Image;

import java.io.File;
import java.util.HashMap;

public enum CardImage {
    CARD_BACK(null, null, "card_back.png"),
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

    private static final String PATH_NAME = "src/main/resources/img/card/";

    private final HashMap<Enum[], Image> CARD_IMAGES = new HashMap<>();

    private Enum[] rankAndSuit;
    private Rank rank;
    private Suit suit;

    CardImage(Rank rank, Suit suit, String imageName) {
        this.rank = rank;
        this.suit = suit;
        rankAndSuit = new Enum[]{rank, suit};
        Image image = new Image(new File(PATH_NAME + imageName).toURI().toString());
        CARD_IMAGES.put(rankAndSuit, image);
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Image getImage() {
        return CARD_IMAGES.get(rankAndSuit);
    }

}
