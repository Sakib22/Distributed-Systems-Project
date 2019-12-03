import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TradeOrder extends JFrame implements ActionListener {
    static JFrame frame;
    JLabel lblNewStock, lblName, lblBalance;
    static JTextField txtName1, txtName2, txtName3, txtName4, txtName5, txtName6, txtName7;
    static JTextField txtBalance;
    static JButton btnAdd;
    static JRadioButton rdbUptrend;
    static JRadioButton rdbDowntrend;
    static JRadioButton rdbNoTrend;

    {
        frame = new JFrame("Stock Market Simulator");
        lblNewStock = new JLabel("ADD NEW STOCK");
        lblNewStock.setFont(new Font("Times New Roman", Font.BOLD, 15));
        ImageIcon image = new ImageIcon(new ImageIcon("res/graph_1.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(image);
        ImageIcon image2 = new ImageIcon(new ImageIcon("res/graph_2.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        JLabel imageLabel2 = new JLabel(image2);
        ImageIcon image3 = new ImageIcon(new ImageIcon("res/pic_1.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        JLabel imageLabel3 = new JLabel(image3);




        lblName = new JLabel("Company Name(s):");
        lblBalance = new JLabel("Balance:");
        txtName1 = new JTextField();
        txtName2 = new JTextField();
        txtName3 = new JTextField();
        txtName4 = new JTextField();
        txtName5 = new JTextField();
        txtName6 = new JTextField();
        txtName7 = new JTextField();
        txtBalance = new JTextField();
        btnAdd = new JButton("Add");
        rdbUptrend = new JRadioButton("Uptrend");
        rdbDowntrend = new JRadioButton("Downtrend");
        rdbNoTrend = new JRadioButton("Sideways Trend");
        rdbUptrend.setSelected(true);
        ButtonGroup g = new ButtonGroup();
        g.add(rdbUptrend);
        g.add(rdbDowntrend);
        g.add(rdbNoTrend);


        lblNewStock.setBounds(75, 30, 400, 30);
        lblName.setBounds(10, 70, 200, 30);
        lblBalance.setBounds(10, 110, 200, 30);
        txtName1.setBounds(130, 70, 100, 30);
        txtName2.setBounds(255, 70, 100, 30);
        txtName3.setBounds(380, 70, 100, 30);
        txtName4.setBounds(505, 70, 100, 30);
        txtName5.setBounds(630, 70, 100, 30);
        txtName6.setBounds(755, 70, 100, 30);
        txtName7.setBounds(880, 70, 100, 30);
        txtBalance.setBounds(130, 110, 50, 30);
        btnAdd.setBounds(40, 170, 100, 30);
        imageLabel.setBounds(10, 220, 300, 300);
        imageLabel2.setBounds(670, 220, 300, 300);
        imageLabel3.setBounds(340, 220, 300, 300);

        frame.add(lblNewStock);
        frame.add(lblName);
        frame.add(txtName1);
        frame.add(txtName2);
        frame.add(txtName3);
        frame.add(txtName4);
        frame.add(txtName5);
        frame.add(txtName6);
        frame.add(txtName7);
        frame.add(lblBalance);
        frame.add(txtBalance);
        frame.add(btnAdd);
        frame.add(imageLabel);
        frame.add(imageLabel2);
        frame.add(imageLabel3);

        frame.setSize(1025, 600);
        frame.setLayout(null);
        frame.setVisible(true);

    }



    public static void main(String[] args) {
        new TradeOrder();


        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtName1.getText().contentEquals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the company name.");
                } else if (txtBalance.getText().contentEquals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter your balance.");
                } else {
                    frame.dispose();
                    TradePanel tradePanel = new TradePanel();
                }

            }
        });
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }








}