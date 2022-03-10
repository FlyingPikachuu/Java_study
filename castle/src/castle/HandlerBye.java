package castle;

/**
 * @author qsy
 * @create 2022/3/8 - 9:19
 */
public class HandlerBye extends Handler {
    public  HandlerBye(Game game){
        super(game);
    }
    @Override
    public boolean isBye() {
        return true;
    }
}
