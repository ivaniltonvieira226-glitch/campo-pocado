package UI.GUI;

import javax.swing.*;
import java.awt.*;

public class MenuGUI extends JFrame {

    public MenuGUI() {
        initializeMenu();
    }

    private void initializeMenu() {
        setTitle("Campo POCADO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Painel de título
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("CAMPO POCADO", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        titlePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Botões de dificuldade
        JButton easyBtn = createDifficultyButton("Fácil (9x9, 10 Mines)", 9, 10);
        JButton mediumBtn = createDifficultyButton("Médio (16x16, 40 Mines)", 16, 40);
        JButton hardBtn = createDifficultyButton("Difícil (30x30, 99 Mines)", 30, 99);

        buttonPanel.add(easyBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(mediumBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(hardBtn);

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createDifficultyButton(String label, int size, int mines) {
        JButton button = new JButton(label);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addActionListener(e -> {
            // Instanciar o jogo
            new GameGUI(size, mines);

            // Fechar o menu
            this.dispose();
        });

        return button;
    }
}