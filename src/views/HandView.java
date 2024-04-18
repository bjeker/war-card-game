//package views;
//
//import main.Card;
//
//import java.util.ArrayList;
//
//public class HandView {
//
//    public static void display(ArrayList<Card> cards) {
//        System.out.println("╔════════════╗");
//        for (Card card : cards) {
//            System.out.print("║ ");
//            System.out.print(formatCardRank(card.getRank()));
//            System.out.print(" ");
//            System.out.print(formatCardSuit(card.getSuit()));
//            System.out.println(" ║");
//        }
//        System.out.println("╚════════════╝");
//    }
//
//    private static String formatCardRank(String rank) {
//        if (rank.length() == 2) {
//            return rank.substring(0, 1);
//        } else {
//            return rank;
//        }
//    }
//
//    private static String formatCardSuit(String suit) {
//        switch (suit) {
//            case "Hearts":
//                return "\u2665";
//            case "Diamonds":
//                return "\u2666";
//            case "Clubs":
//                return "\u2663";
//            case "Spades":
//                return "\u2660";
//            default:
//                return "";
//        }
//    }
//}
