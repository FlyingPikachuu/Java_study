package castle;

/**
 * @author qsy
 * @create 2022/3/8 - 9:09
 */
public class Handler {
    protected Game game;
    public  Handler(Game game){
        this.game =game;
    }
    public void doCmd(String word){

    }
    public boolean isBye(){
        return false;
    }
}
