import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;


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

    //참가 인원, 사진 출력 수정
    private void TopPanel(){
        topPanel = new JPanel();
        topPanel.setBackground(new Color(197, 216, 226));
        topPanel.setBounds(0, 0, 360, 70);
        contentPane.add(topPanel);
    }

    //채팅 내용 출력
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
        //chatTextPane.setText("Hello, this is a chat!");

        chatScrollPane.setViewportView(chatTextPane);
        contentPane.add(chatScrollPane);
    }

    //전송할 메세지 입력 창
    private void TextPanel(){
        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 506, 360, 88);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        contentPane.add(scrollPane);

        textPane = new JTextPane();
        scrollPane.setViewportView(textPane);
        scrollPane.setBackground(new Color(255,255,255));

        //Enter 키 입력 시 메세지 전송
        textPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (isEnter(e)) {
                    pressEnter(textPane.getText().replaceAll("\n", ""));
                }
            }
        });
    }

    private void sendButton(){
        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 595, 360, 45);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton sendButton = new JButton("전송");
        sendButton.setFocusPainted(false);
        sendButton.setBorderPainted(false);
        sendButton.setBackground(new Color(235, 230, 133));
        sendButton.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 11));
        sendButton.setBounds(290, 8, 55, 25);
        panel.add(sendButton);

        //전송 버튼 클릭 시 메세지 전송
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pressEnter(textPane.getText());
            }
        });

        //이미지, 이모티콘 버튼 생성
    }

    //메세지 전송 함수
    private void pressEnter(String message) {
        if(isNullString(message)) return;
        else sendMessage(message);

        textPane.setText("");
        textPane.setCaretPosition(0);
    }

    private void sendMessage(String message) {
        //message send 수정 필요
        //client 입력 값 읽어서 출력
        //받는 메세지 왼쪽, 보내는 메세지 오른쪽 출력
        appendToChat("You: " + message);
    }

    private void appendToChat(String message) {
        chatTextPane.setText(chatTextPane.getText() + "\n" + message);
    }

    private boolean isNullString(String message) {
        return message == null || message.trim().isEmpty();
    }

    private boolean isEnter(KeyEvent e) {
        return e.getKeyCode() == KeyEvent.VK_ENTER;
    }
}
