package castle;

/**
 * @author qsy
 * @create 2022/3/8 - 9:09
 */
public interface Handler {
    public void doCmd(String word);
    public default boolean isBye(){
        return false;
    }
}
