package castle;

/**
 * @author qsy
 * @create 2022/3/8 - 9:32
 */
public class HandlerGo extends Handler{


    public HandlerGo(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
        game.goRoom(word);
    }
}
