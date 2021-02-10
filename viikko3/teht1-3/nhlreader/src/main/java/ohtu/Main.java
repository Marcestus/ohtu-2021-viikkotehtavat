package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        System.out.println("Tehtävä 1:");
        System.out.println("Players from FIN:");
        System.out.println("");

        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                System.out.println(player.task1());
            }
        }
        
        System.out.println("");
        System.out.println("Tehtävä 2:");
        System.out.println("Players from FIN:");
        System.out.println("");

        ArrayList<Player> finPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                finPlayers.add(player);
            }
        }
        
        Collections.sort(finPlayers, Player.playerPoints);
        
        for (Player player : finPlayers) {
            System.out.println(player);
        }
    }
  
}