package castle;

/**
 * @author qsy
 * @create 2022/3/8 - 9:29
 */
public class HandlerHelp extends Handler {

    public HandlerHelp(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
        System.out.println("迷路了吗？你可以做的命令有："+ game.helpprompt());
        System.out.println("如：\tgo east");
    }
}
