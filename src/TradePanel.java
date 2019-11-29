import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.FocusManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class TradePanel extends JFrame implements ActionListener {
    JLabel lblBuySell, lblQuantity, lblPrice, lblCompany1, lblCompany2, lblCompany3, lblCompany4, lblCompany5, lblCompany6, lblCompany7;
    JTextField txtQuantity, txtPrice;
    JTextField txtPrice1, txtPrice2, txtPrice3, txtPrice4, txtPrice5, txtPrice6, txtPrice7;
    JTextField txtDiff1, txtDiff2, txtDiff3, txtDiff4, txtDiff5, txtDiff6, txtDiff7;
    JButton btnBuy, btnSell;
    JComboBox < String > cmbStocks;
    JTable jt;

    {

        JFrame frame = new JFrame("Stock Market Simulator");
        lblBuySell = new JLabel("Buy/Sell Stock");
        lblBuySell.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblQuantity = new JLabel("Quantity");
        lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblCompany1 = new JLabel();
        lblCompany1.setText(TradeOrder.txtName1.getText());
        lblCompany1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblCompany2 = new JLabel("Apple");
        lblCompany2.setText(TradeOrder.txtName2.getText());
        lblCompany2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblCompany3 = new JLabel("Twitter");
        lblCompany3.setText(TradeOrder.txtName3.getText());
        lblCompany3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblCompany4 = new JLabel("Instagram");
        lblCompany4.setText(TradeOrder.txtName4.getText());
        lblCompany4.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblCompany5 = new JLabel("Android");
        lblCompany5.setText(TradeOrder.txtName5.getText());
        lblCompany5.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblCompany6 = new JLabel("Whatsapp");
        lblCompany6.setText(TradeOrder.txtName6.getText());
        lblCompany6.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblCompany7 = new JLabel("Snapchat");
        lblCompany7.setText(TradeOrder.txtName7.getText());
        lblCompany7.setFont(new Font("Times New Roman", Font.BOLD, 15));

        if (lblCompany2.getText().isEmpty()) {
            lblCompany2.setText("N/A");
        }
        if (lblCompany3.getText().isEmpty()) {
            lblCompany3.setText("N/A");
        }
        if (lblCompany4.getText().isEmpty()) {
            lblCompany4.setText("N/A");
        }
        if (lblCompany5.getText().isEmpty()) {
            lblCompany5.setText("N/A");
        }
        if (lblCompany6.getText().isEmpty()) {
            lblCompany6.setText("N/A");
        }
        if (lblCompany7.getText().isEmpty()) {
            lblCompany7.setText("N/A");
        }


        txtQuantity = new JTextField();
        txtPrice = new JTextField();
        txtPrice1 = new JTextField();
        txtDiff1 = new JTextField();
        txtPrice2 = new JTextField();
        txtDiff2 = new JTextField();
        txtPrice3 = new JTextField();
        txtDiff3 = new JTextField();
        txtPrice4 = new JTextField();
        txtDiff4 = new JTextField();
        txtPrice5 = new JTextField();
        txtDiff5 = new JTextField();
        txtPrice6 = new JTextField();
        txtDiff6 = new JTextField();
        txtPrice7 = new JTextField();
        txtDiff7 = new JTextField();
        btnBuy = new JButton("Buy");
        btnSell = new JButton("Sell");
        cmbStocks = new JComboBox();
        cmbStocks.addItem(TradeOrder.txtName1.getText());
        cmbStocks.addItem(TradeOrder.txtName2.getText());
        cmbStocks.addItem(TradeOrder.txtName3.getText());
        cmbStocks.addItem(TradeOrder.txtName4.getText());
        cmbStocks.addItem(TradeOrder.txtName5.getText());
        cmbStocks.addItem(TradeOrder.txtName6.getText());
        cmbStocks.addItem(TradeOrder.txtName7.getText());
        JPanel companyPanel = new JPanel();
        Border graphViewBorder = BorderFactory.createEtchedBorder();
        Border border = BorderFactory.createTitledBorder("Company Stock");
        companyPanel.setBorder(graphViewBorder);
        companyPanel.setBorder(border);


        String[] columns = {
            "Stock Name",
            "Quantity",
            "Price"
        };

        Object[][] data = {};

        JTable table = new JTable(data, columns);
        getContentPane().add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(36, 480, 407, 150);
        getContentPane().add(scrollPane);


        lblBuySell.setBounds(20, 30, 400, 30);
        lblQuantity.setBounds(240, 40, 400, 30);
        lblCompany1.setBounds(100, 180, 400, 30);
        lblCompany2.setBounds(100, 220, 400, 30);
        lblCompany3.setBounds(100, 260, 400, 30);
        lblCompany4.setBounds(100, 300, 400, 30);
        lblCompany5.setBounds(100, 340, 400, 30);
        lblCompany6.setBounds(100, 380, 400, 30);
        lblCompany7.setBounds(100, 420, 400, 30);
        txtQuantity.setBounds(230, 70, 70, 30);
        txtPrice1.setBounds(180, 180, 90, 30);
        txtDiff1.setBounds(290, 180, 90, 30);
        txtPrice2.setBounds(180, 220, 90, 30);
        txtDiff2.setBounds(290, 220, 90, 30);
        txtPrice3.setBounds(180, 260, 90, 30);
        txtDiff3.setBounds(290, 260, 90, 30);
        txtPrice4.setBounds(180, 300, 90, 30);
        txtDiff4.setBounds(290, 300, 90, 30);
        txtPrice5.setBounds(180, 340, 90, 30);
        txtDiff5.setBounds(290, 340, 90, 30);
        txtPrice6.setBounds(180, 380, 90, 30);
        txtDiff6.setBounds(290, 380, 90, 30);
        txtPrice7.setBounds(180, 420, 90, 30);
        txtDiff7.setBounds(290, 420, 90, 30);
        btnBuy.setBounds(380, 50, 70, 20);
        btnSell.setBounds(380, 110, 70, 20);
        cmbStocks.setBounds(20, 70, 100, 20);
        companyPanel.setBounds(85, 150, 320, 320);


        frame.add(lblBuySell);
        frame.add(lblQuantity);
        frame.add(lblPrice);
        frame.add(lblCompany1);
        frame.add(lblCompany2);
        frame.add(lblCompany3);
        frame.add(lblCompany4);
        frame.add(lblCompany5);
        frame.add(lblCompany6);
        frame.add(lblCompany7);
        frame.add(txtQuantity);
        frame.add(txtPrice);
        frame.add(txtPrice1);
        frame.add(txtDiff1);
        frame.add(txtPrice2);
        frame.add(txtDiff2);
        frame.add(txtPrice3);
        frame.add(txtDiff3);
        frame.add(txtPrice4);
        frame.add(txtDiff4);
        frame.add(txtPrice5);
        frame.add(txtDiff5);
        frame.add(txtPrice6);
        frame.add(txtDiff6);
        frame.add(txtPrice7);
        frame.add(txtDiff7);
        frame.add(btnBuy);
        frame.add(btnSell);
        frame.add(cmbStocks);
        frame.add(scrollPane);
        frame.add(companyPanel);




        frame.setSize(500, 700);
        frame.setLayout(null);
        frame.setVisible(true);
    }






    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}