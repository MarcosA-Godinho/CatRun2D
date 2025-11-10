package Main;

import Util.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    private JTextField nameField;
    private JButton startButton;
    private GameWindow gameWindow; // Referência à janela principal

    public LoginPanel(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        // Define o layout deste painel
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.PINK); // Segue o padrão do jogo

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento

        // 1. Rótulo "Digite seu nome:"
        JLabel nameLabel = new JLabel("Digite seu nome:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(nameLabel, gbc);

        // 2. Campo de texto para o nome
        nameField = new JTextField(20); // 20 colunas de largura
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(nameField, gbc);

        // 3. Botão "Iniciar Jogo"
        startButton = new JButton("Iniciar Jogo");
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(startButton, gbc);

        // 4. Ação do botão
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pega o nome digitado
                String playerName = nameField.getText();

                // Validação simples
                if (playerName == null || playerName.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(LoginPanel.this,
                            "Por favor, digite um nome.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Salva no banco e pega o ID
                int playerID = DatabaseConnection.findOrCreatePlayer(playerName.trim());

                if (playerID != -1) {
                    // Se deu certo, avisa a GameWindow para começar o jogo
                    gameWindow.startGame(playerID);
                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this,
                            "Erro ao salvar jogador no banco de dados.", "Erro de DB", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Sobrescrevemos para definir o tamanho preferido (o mesmo do GamePanel)
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GamePanel.LARGURA_TELA, GamePanel.ALTURA_TELA);
    }
}