import Game.Field.Field;

import javax.swing.*;

public class Main {
    static void main() {
        JFrame frame = new JFrame("Campo Pocado");

        var field = new Field(8);
        field.generateField(12);
        field.showFieldOnConsole();

        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
