package UI;

import Game.Cell.Cell;
import Game.Cell.CellState;
import Game.Field.Field;
import Game.Field.GameState;
import Game.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameGUI extends JFrame {
    private final int rows;
    private final int cols;
    private final JButton[][] buttons;
    private final Field field; // Your logical board

    public GameGUI(int side, int mines) {
        this.rows = side;
        this.cols = side;
        this.field = new Field(side, mines);
        this.buttons = new JButton[side][side];

        initializeUI();
    }

    private void initializeUI() {
        setTitle("Campo POCADO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(50, 50));

                final int r = i;
                final int c = j;

                // MouseListener captures both Left (Reveal) and Right (Flag) clicks
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            handleLeftClick(r, c);
                        } else if (SwingUtilities.isRightMouseButton(e)) {
                            handleRightClick(r, c);
                        }
                    }
                });

                add(buttons[i][j]);
            }
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleLeftClick(int x, int y) {
            var pos = new Position(x, y);
            field.revealCell(pos);
            updateBoardUI();

            if (field.gameState == GameState.GameOver) {
                JOptionPane.showMessageDialog(this, "Boom! Game Over.");
            } else if (field.gameState == GameState.Win) {
                JOptionPane.showMessageDialog(this, "Parabéns, você venceu!");
            }
    }

    private void handleRightClick(int x, int y) {
        var pos = new Position(x, y);
        field.flagCell(pos);
        updateBoardUI();
    }

    private void updateBoardUI() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                var cell = field.cells[i][j];
                var cellState = cell.getState();

                if (cellState == CellState.Revealed) {
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setText(cell.symbol);
                } else if (cellState == CellState.Flagged) {
                    buttons[i][j].setText("🚩");
                } else {
                    buttons[i][j].setText("");
                }
            }
        }
    }
}