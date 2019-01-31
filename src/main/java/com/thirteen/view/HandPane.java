package com.thirteen.view;

import com.thirteen.model.Card;
import com.thirteen.model.Hand;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An HBox holding instances of card buttons to be clicked on.
 *
 * @author Michael Kha
 */
public class HandPane extends HBox implements ThirteenView {

    /**
     * Holds the cards and their visual representation as buttons
     */
    private Map<Card, CardButton> cards;

    /**
     * Create a hand pane consisting of the cards in hand as
     * selectable buttons.
     * @param hand  The hand to use
     */
    HandPane(Hand hand) {
        cards = new HashMap<>();
        ObservableList<Node> children = getChildren();
        for (Card card : hand.getCards()) {
            // FIXME: Java 11 runtime exception :( using Java 9 for now
            CardButton cardButton = new CardButton(CardImage.CARD_IMAGES.get(card.getID()));
            cards.put(card, cardButton);
            children.add(cardButton);
        }
        setPadding(DEFAULT_INSETS);
    }

    /**
     * Removes all card buttons in hand that are toggled.
     * @return  List of card objects that were removed
     */
    public List<Card> removeToggled() {
        List<Card> removedCards = new ArrayList<>();
        for (Card card : cards.keySet()) {
            CardButton cardButton = cards.get(card);
            if (cardButton.isSelected()) {
                cards.remove(card);
                removedCards.add(card);
            }
        }
        return removedCards;
    }

}
