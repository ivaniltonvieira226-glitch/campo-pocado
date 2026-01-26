import Game.Field.Field;
import Game.Position;

public class Main {
    static void main() {
//        JFrame frame = new JFrame("Campo Pocado");

        var field = new Field(8);
        field.generateField(8);

        var console = new GameConsoleUI(field);
        console.run();

//        frame.setSize(400, 400);
//        frame.setResizable(false);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
    }
}
