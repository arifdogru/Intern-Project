import java.util.ArrayList;

/**
 * Created by Arif on 18.05.2017.
 */
public class Client {
    /**
     * Data fields
     */
    private String  client_ID;
    private ArrayList<String> clientSongList = new ArrayList<String>();
    private Integer distinctSong=0;

    public Client(String client_ID) {
        this.client_ID = client_ID;
    }

    public Integer getDistinctSong() {
        return distinctSong;
    }

    public String getClient_ID() {
        return client_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (client_ID != null ? !client_ID.equals(client.client_ID) : client.client_ID != null) return false;
        if (clientSongList != null ? !clientSongList.equals(client.clientSongList) : client.clientSongList != null)
            return false;
        return distinctSong != null ? distinctSong.equals(client.distinctSong) : client.distinctSong == null;

    }

    @Override
    public int hashCode() {
        return client_ID != null ? client_ID.hashCode() : 0;
    }

    public ArrayList<String> getClientSongList() {
        return clientSongList;
    }

    public void setClient_ID(String client_ID) {
        this.client_ID = client_ID;
    }

    public void setClientSongList(ArrayList<String> clientSongList) {
        this.clientSongList = clientSongList;
    }

    public void setDistinctSong(Integer distinctSong) {
        this.distinctSong = distinctSong;
    }

    /**
     * Gets only distinct song for a client
     * @param song String song id
     * @return true if success
     */
    public boolean addSongList(String song){
        for (int i=0; i<clientSongList.size();++i){
            if (clientSongList.get(i).equals(song)){
                return false;
            }
        }
        ++distinctSong;
        clientSongList.add(song);
        return true;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_ID='" + client_ID + '\'' +
                ", distinctSong=" + distinctSong +
                '}';
    }
}