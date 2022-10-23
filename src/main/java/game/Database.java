package game;

import java.io.*;

/***
 * @author Jinhua
 * @version 1.0
 * This class is for saving the current information(score+username),
 * and creating a scoreboard to display all-time high scores,
 * and saving game progress.
 */
public class Database {
    private static String playerName;
    private static int playerScore;
    //private static FileWriter fw = null;
    private static BufferedWriter bw  = null;
    private static String dataFile = "src/record.txt";

    public static int getPlayerScore() {
        return playerScore;
    }

    public static void setPlayerScore(int playerScore) {
        Database.playerScore = playerScore;
    }

    /***
     * This is to update score it remains to modify
     */
    public static void updateScore(){
        Database.playerScore++;
    }
    public static void keepScore() throws IOException {
        try{
            bw = new BufferedWriter(new FileWriter(dataFile));
            bw.write(playerScore);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bw!=null){
                bw.close();
            }
        }
    }
    void reload(){

    }
}
