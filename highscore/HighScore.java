import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HighScore {

    public static void printHighScores(String filename) {
        BufferedReader inputStream = null;
        ArrayList<Player> playerInfo = new ArrayList<>();

        try {
            inputStream = new BufferedReader(new FileReader(filename));
            String line;
            String[] playerData;
            while ((line = inputStream.readLine()) != null) {
                playerData = line.split(",");

                String name = playerData[0];
                String country = playerData[1];
                int score = Integer.parseInt(playerData[2]);

                Player player = new Player (name, country, score);
                playerInfo.add(player);

          //    System.out.println("Player " + name + " from" + country + " scored " + score + " points");
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        printHighScores("scores.txt");
    }
}
