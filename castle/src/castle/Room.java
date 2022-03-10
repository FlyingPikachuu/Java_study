package castle;

import javax.print.DocFlavor;
import java.awt.event.FocusEvent;
import java.util.HashMap;
import java.util.HashSet;

public class Room {
    private String description;
    private HashMap<String,Room> exits = new HashMap<String,Room>();

    public Room(String description) 
    {
        this.description = description;
    }

    public void setExits(String dir,Room room) {
        exits.put(dir, room);
    }


    @Override
    public String toString()
    {
        return description;
    }
    //表达出口
    public String getExitDesc(){
        StringBuffer sb = new StringBuffer();
        for (String dir :
                exits.keySet()) {
            sb.append(dir);
            sb.append(' ');
        }
        return sb.toString();
    }
    //建立出口方向的字符串和它出口方向上对应房间的关系
    public Room getExit(String direction){
        return exits.get(direction);
    }
}
