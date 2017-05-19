import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Arif on 18.05.2017.
 */
public class Play {

    /**
     * Data Fields
     * */
    private HashMap<String ,Client> distinctSong = new HashMap<String, Client>();
    private HashMap<Integer ,Integer> distinctSongMap = new HashMap<Integer, Integer>();

    /**
     * This method finds all distinct play songs
     * and put the distinctSongMap field
     */
    public void findDistinctSong(){
        for(HashMap.Entry<String, Client> entry : distinctSong.entrySet()){
            String key = entry.getKey();
            Client client = entry.getValue();

            if(distinctSongMap.get(client.getDistinctSong()) != null){
                distinctSongMap.put(client.getDistinctSong(), distinctSongMap.get(client.getDistinctSong())+1);
            }
            else{
                distinctSongMap.put(client.getDistinctSong(), 1);
            }
        }
    }

    /**
     * This method find distinct played song by distinct client
     * and put the Map
     * @param clientID String client id
     * @param songName String Song song id
     */
    public void addDistinctSong(String clientID,String songName){
        Client client;

        if( distinctSong.get(clientID) == null){
            client = new Client(clientID);
            distinctSong.put(clientID,client);
        }
        else{
            client = distinctSong.get(clientID);
        }

        client.addSongList(songName);
    }

    /**
     * This method reads inputs from file
     * and parse played songs in 10 august
     * @param fileName String input .csv file name
     */
    public void initializeData(String fileName) throws IOException {

        String []arr;

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        // read file line by line
        String line ;
        while ((line = reader.readLine()) != null ){
            arr = line.split("\\s+");
            if (arr[3].contains("10/08/2016")){
                addDistinctSong(arr[2],arr[1]);
            }
        }
        reader.close();
    }

    /**
     * Create desired table end of the program
     */
    public void createTable(){
        for(HashMap.Entry<Integer, Integer> entry : distinctSongMap.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "               |          " + value);
        }
    }

    public static void main(String []args){

        Play play = new Play();

        try {
            play.initializeData("exhibitA-input.csv");
            play.findDistinctSong();
            System.out.println("----------------------------------");
            System.out.println("DISTINCT_PLAY_COUNT | " +
                    "CLIENT_COUNT");
            play.createTable();
            System.out.println("----------------------------------");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
