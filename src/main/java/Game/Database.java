package Game;

import java.io.*;
import java.util.Vector;

/***
 * @author Jinhua
 * @version 1.0  This class is for saving the current information(score+username), and creating a scoreboard to display all-time high scores, and saving game progress.
 */
public class Database {
    private static String playerName;
    private static int playerScore;
    //private static FileWriter fw = null;
    private static BufferedWriter bw  = null;
    private static BufferedReader br = null;
    private static String dataFile = "src/record.txt";
    private static Vector<Node> nodes = new Vector<>();

    /**
     * Gets player score.
     *
     * @return the player score
     */
    public static int getPlayerScore() {
        return playerScore;
    }

    /**
     * Sets player score.
     *
     * @param playerScore the player score
     */
    public static void setPlayerScore(int playerScore) {
        Database.playerScore = playerScore;
    }

    /***
     * This is to update score it remains to modify
     */
    public static void updateScore(){
        Database.playerScore++;
    }

    /**
     * Save player's score and position and NPC's position when exits.
     *
     * @throws IOException the io exception
     */
    public static void saveData() throws IOException {
        try{
            bw = new BufferedWriter(new FileWriter(dataFile));
            bw.write(playerScore+"\r\n");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bw!=null){
                bw.close();
            }
        }
    }

    /**
     * Reload enemy information when game starts.
     *
     * @return vector
     * @throws IOException the io exception
     */
    public static Vector<Node> reload() throws IOException {
        try {
            br = new BufferedReader(new FileReader(dataFile));
            String line = "";
            while((line = br.readLine())!=null){
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]),Integer.parseInt(xyd[1]),Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                br.close();
            }
        }
        return nodes;
    }
}
