package project_java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class NumberGuessGame { // Chương trình đoán số ngẫu nhiên

    private int randomNumber; // Lưu số ngẫu nhiên được tạo ra để người chơi đoán
    private int attempts; // Đếm số lần người chơi đã đoán
    private JFrame frame; // Khung chính của giao diện
    private JTextField inputField; // Ô nhập liệu để người chơi nhập số đoán
    private JLabel messageLabel; // Nhãn để hiển thị thông báo cho người chơi
    private JButton guessButton; // Nút để xác nhận dự đoán
    private JButton resetButton; // Nút để đặt lại trò chơi

    

    private void initializeGame() {
        Random random = new Random();
        randomNumber = random.nextInt(101); // Tạo số ngẫu nhiên trong khoảng từ 0 đến 100
        attempts = 0; // Đặt lại số lần đoán
    }

    private void prepareGUI() {
        // Cấu hình khung giao diện
        frame = new JFrame("Number Guessing Game");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addComponents() {
        // Nhãn hướng dẫn
        JLabel instructionLabel = new JLabel("Guess a number between 0 and 100:");
        instructionLabel.setBounds(10, 10, 380, 30);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(instructionLabel);

        // Ô nhập liệu
        inputField = new JTextField();
        inputField.setBounds(10, 50, 180, 30);
        inputField.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(inputField);

        // Nhãn thông báo
        messageLabel = new JLabel("Enter your guess and click 'Guess'", SwingConstants.CENTER);
        messageLabel.setBounds(10, 90, 380, 30);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 12));
        frame.add(messageLabel);

        // Nút đoán số
        guessButton = new JButton("Guess");
        guessButton.setBounds(200, 50, 80, 30);
        guessButton.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(guessButton);

        // Nút đặt lại trò chơi
        resetButton = new JButton("Reset");
        resetButton.setBounds(290, 50, 100, 30);
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(resetButton);
    }

    private void addActionEvent() {
        // Thêm sự kiện cho nút đoán
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess(); // Xử lý khi nhấn nút đoán
            }
        });

        // Thêm sự kiện cho nút đặt lại
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeGame(); // Đặt lại trò chơi
                inputField.setText(""); // Xóa ô nhập liệu
                messageLabel.setText("Enter your guess and click 'Guess'"); // Đặt lại thông báo
                guessButton.setEnabled(true); // Bật lại nút đoán
            }
        });
    }

    private void handleGuess() {
        try {
            int guess = Integer.parseInt(inputField.getText()); // Lấy số người chơi nhập
            attempts++; // Tăng số lần đoán

            if (guess < 0 || guess > 100) {
                messageLabel.setText("Please enter a number between 0 and 100."); // Nhắc nhập số đúng phạm vi
            } else if (guess == randomNumber) {
                messageLabel.setText("Correct! You guessed it in " + attempts + " attempts."); // Thông báo đoán đúng
                guessButton.setEnabled(false); // Vô hiệu hóa nút đoán
            } else if (guess < randomNumber) {
                messageLabel.setText("Too low! Try again."); // Gợi ý số nhỏ hơn
            } else {
                messageLabel.setText("Too high! Try again."); // Gợi ý số lớn hơn
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid number."); // Nhắc người chơi nhập đúng định dạng số
        }
    }
    
    public NumberGuessGame() {
        prepareGUI(); // Chuẩn bị giao diện
        addComponents(); // Thêm các thành phần vào giao diện
        addActionEvent(); // Thêm sự kiện cho các nút
        initializeGame(); // Khởi tạo trò chơi ban đầu
    }
}
