import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("E:\\temp\\cards.txt"));
        String linha = br.readLine();

        int nCardsAlice = 0;
        String cardsAlice[] = new String[]{};
        int nCardsBetty = 0;
        String cardsBetty[] = new String[]{};

        int i = 1;

        while(!linha.equals("0 0")){


            if(i == 1){
                String aEbCards[] = linha.split(" ");
                nCardsAlice = Integer.parseInt(aEbCards[0]);
                nCardsBetty = Integer.parseInt(aEbCards[1]);
            }
            if(i == 2){
                cardsAlice =  linha.split(" ");
            }
            if(i == 3){
                cardsBetty = linha.split(" ");

                Map<String, Integer> aliceMapCards = new HashMap<String, Integer>();
                for (String cards: cardsAlice) {
                    aliceMapCards.put(cards, Collections.frequency(Arrays.asList(cardsAlice), cards));
                }

                Map<String, Integer> bettyMapCards = new HashMap<String, Integer>();
                for (String cards: cardsBetty) {
                    bettyMapCards.put(cards, Collections.frequency(Arrays.asList(cardsBetty), cards));
                }

                int aliceTrades = 0;
                int bettyTrades = 0;

                for(Map.Entry<String, Integer> card : aliceMapCards.entrySet()){
                    if(card.getValue() > 1 && !bettyMapCards.containsKey(card)){
                        aliceTrades += 1;
                    }
                }

                for(Map.Entry<String, Integer> card : bettyMapCards.entrySet()){
                    if(card.getValue() > 1 && !aliceMapCards.containsKey(card.getKey())){
                        bettyTrades += 1;
                    }
                }

                if(aliceTrades >= bettyTrades){
                    System.out.println(bettyTrades*2);
                }
                else{
                    System.out.println(aliceTrades*2);
                }

                nCardsAlice = 0;
                Arrays.fill(cardsAlice, "");
                nCardsBetty = 0;
                Arrays.fill(cardsBetty, "");

                i = 0;
            }

            linha = br.readLine();
            i++;
        }

        br.close();

    }
}
