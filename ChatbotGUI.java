import java.awt.*;
import javax.swing.*;

public class ChatbotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private Chatbot chatbot;

    public ChatbotGUI() {

        chatbot = new Chatbot();

        setTitle("Java NLP Chatbot");
        setSize(600, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        // Chat area
        chatArea = new JTextArea();

        chatArea.setEditable(false);

        chatArea.setFont(
            new Font("Arial", Font.PLAIN, 16)
        );

        chatArea.setLineWrap(true);

        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane =
            new JScrollPane(chatArea);

        // Input field
        inputField = new JTextField();

        inputField.setFont(
            new Font("Arial", Font.PLAIN, 16)
        );

        // Send button
        sendButton = new JButton("Send");

        sendButton.setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        // Bottom panel
        JPanel bottomPanel =
            new JPanel(new BorderLayout());

        bottomPanel.add(
            inputField,
            BorderLayout.CENTER
        );

        bottomPanel.add(
            sendButton,
            BorderLayout.EAST
        );

        // Add components
        add(
            scrollPane,
            BorderLayout.CENTER
        );

        add(
            bottomPanel,
            BorderLayout.SOUTH
        );

        // Welcome message
        chatArea.append(
            "JavaBot: Hello! Welcome to JavaBot.\n"
        );

        chatArea.append(
            "JavaBot: Ask me something!\n\n"
        );

        // Button event
        sendButton.addActionListener(
            e -> sendMessage()
        );

        // Enter key event
        inputField.addActionListener(
            e -> sendMessage()
        );
    }

    private void sendMessage() {

        String userMessage =
            inputField.getText().trim();

        if (userMessage.isEmpty()) {
            return;
        }

        // Display user message
        chatArea.append(
            "You: " + userMessage + "\n"
        );

        // Get chatbot response
        String response =
            chatbot.getResponse(userMessage);

        // Display response
        chatArea.append(
            "JavaBot: " + response + "\n\n"
        );

        // Clear input
        inputField.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ChatbotGUI gui =
                new ChatbotGUI();

            gui.setVisible(true);
        });
    }
} 