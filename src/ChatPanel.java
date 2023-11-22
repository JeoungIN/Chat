import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class ChatPanel extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane chatScrollPane;
    private JTextPane chatTextPane;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane_1;
    private JTextPane textPane;
    private JPanel panel;
    private JPanel topPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChatPanel frame = new ChatPanel();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ChatPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 373, 675);
        contentPane = new JPanel();
        contentPane.setLayout(null);

        TopPanel();
        initChatPanel();
        TextPanel();
        sendButton();

        setContentPane(contentPane);
    }

    private void TopPanel(){
        topPanel = new JPanel();
        topPanel.setBackground(new Color(197, 216, 226));
        topPanel.setBounds(0, 0, 360, 70);
        contentPane.add(topPanel);
    }

    private void initChatPanel(){
        chatScrollPane = new JScrollPane();
        chatScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        chatScrollPane.setBounds(0, 70, 360, 437);
        chatScrollPane.setBorder(BorderFactory.createEmptyBorder());
        contentPane.add(chatScrollPane);

        chatTextPane = new JTextPane();
        chatTextPane.setFocusable(false);
        chatScrollPane.setViewportView(chatTextPane);
        chatTextPane.setBackground(new Color(204, 220, 230));
        chatTextPane.setText("Hello, this is a chat!");

        chatScrollPane.setViewportView(chatTextPane);
        contentPane.add(chatScrollPane);
    }

    private void TextPanel(){
        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 506, 360, 88);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        contentPane.add(scrollPane);

        textPane = new JTextPane();
        scrollPane.setViewportView(textPane);
        scrollPane.setBackground(new Color(255,255,255));
    }

    private void sendButton(){
        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 595, 360, 45);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("전송");
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBackground(new Color(235, 230, 133));
        btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 11));
        btnNewButton.setBounds(290, 8, 55, 25);
        panel.add(btnNewButton);
    }
}
