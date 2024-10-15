
public class Player {

    private String player_name;
    private int player_Id;

    Player(String player_name, int player_Id) {
        this.player_name = player_name;
        this.player_Id = player_Id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public int getPlayer_Id() {
        return player_Id;
    }

    public void setPlayer_Id(int player_Id) {
        this.player_Id = player_Id;
    }
}
