package castle;

import javax.print.attribute.HashDocAttributeSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
// 游戏任务——没设置，程序任务——创建游戏场景，并依照它，选择起点开始执行
//字符串
//help ——帮助信息 bye——退出游戏 go——出房间
//四个房间 大堂 书房 卧室 小酒馆
//代码冗长，代码复制多，使用函数解决
//耦合性高（内容耦合），关于出口的代码过多，不宜维护，使用封装降低耦合
public class Game {
    private Room currentRoom;
    private HashMap<String,Handler> handlers = new HashMap<String,Handler>();
    public Game() 
    {
        handlers.put("bye",new HandlerBye(this));
        handlers.put("help",new HandlerHelp(this));
        handlers.put("go",new HandlerGo(this));
        handlers.put("direction",new HandlerHelp(this));
        createRooms();

    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        
        //	初始化房间的出口
        outside.setExits("east",lobby);
        outside.setExits("south",study);
        outside.setExits("west",pub);
        lobby.setExits("west",outside);
        pub.setExits("east",outside);
        study.setExits("north",outside);
        study.setExits("east",bedroom);
        bedroom.setExits("west",study);
        lobby.setExits("up",pub);
        pub.setExits("down",lobby);
        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showprompt();
    }

    // 以下为用户命令

//    private void printHelp()
//    {
//
//    }

    public void goRoom(String direction)
    {
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            showprompt();
        }
    }
    public void showprompt(){
        System.out.println("你在" + currentRoom);
        System.out.print("出口有: ");
        System.out.println(currentRoom.getExitDesc());
        System.out.println();
    }
    public  String helpprompt(){
        StringBuffer sb = new StringBuffer();
        for (String k :
                handlers.keySet()) {
            sb.append(k+" ");
        }
        return sb.toString();
    }
	public void play(){
        Scanner in = new Scanner(System.in);
        while ( true ) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
            String value = "";
            if(words.length>1){
                value =words[1];
            }
            if( handler != null){
                handler.doCmd(value);
                if(handler.isBye()){
                    break;
                }
            }
//            if ( words[0].equals("help") ) {
//                printHelp();
//            } else if (words[0].equals("go") ) {
//                goRoom(words[1]);
//            } else if ( words[0].equals("bye") ) {
//                break;
//            }
        }
        in.close();
    }
	public static void main(String[] args) {

		Game game = new Game();
		game.printWelcome();

        game.play();

        
        System.out.println("感谢您的光临。再见！");

	}

}
