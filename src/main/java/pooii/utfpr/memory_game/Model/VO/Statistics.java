package pooii.utfpr.memory_game.Model.VO;

public class Statistics {

    private Player player;

    private Modality mod;

    private int time;

    private int biggerSequence;

    private int beginTime;

    private int endTime;

    public Statistics() {
    }

    void rankTen() {
    }

    void histPlayer() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Modality getMod() {
        return mod;
    }

    public void setMod(Modality mod) {
        this.mod = mod;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getBiggerSequence() {
        return biggerSequence;
    }

    public void setBiggerSequence(int biggerSequence) {
        this.biggerSequence = biggerSequence;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    void histPlayer(Player player) {
    }
}
