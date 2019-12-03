import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.rmi.Naming;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


public class TradePanel extends JFrame implements ActionListener {
    JLabel lblBuySell, lblQuantity, lblPrice, lblCompany1, lblCompany2, lblCompany3, lblCompany4, lblCompany5, lblCompany6, lblCompany7;
	JLabel lblBalance, lblBalanceText;
	JLabel lblTimer;
    JTextField txtQuantity, txtPrice;
    JTextField txtPrice1, txtPrice2, txtPrice3, txtPrice4, txtPrice5, txtPrice6, txtPrice7;
    JTextField txtDiff1, txtDiff2, txtDiff3, txtDiff4, txtDiff5, txtDiff6, txtDiff7;
    JButton btnBuy, btnSell;
    JComboBox < String > cmbStocks;
    JTable jt;
    int quantityCount1=0, quantityCount2=0,quantityCount3=0,quantityCount4=0,quantityCount5=0,quantityCount6=0,quantityCount7=0;
    double balance;
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
        lblBalance = new JLabel(TradeOrder.txtBalance.getText());
        lblBalance.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblTimer = new JLabel();
        lblTimer.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblBalanceText = new JLabel("Balance: $");
        lblBalanceText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        


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

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
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
        lblBalance.setBounds(90, 640, 400, 30);
        lblBalanceText.setBounds(20, 640, 400, 30);
        lblTimer.setBounds(25, 660, 400, 30);
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
        frame.add(lblBalance);
        frame.add(lblBalanceText);
        frame.add(lblTimer);
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


        frame.setSize(500, 750);
        frame.setLayout(null);
        frame.setVisible(true);
        
String defaultStocks[] = {"Facebook", "Apple","Microsoft","Sony","Netflix"};
        
        
        int i = new Random().nextInt(defaultStocks.length);
        int j = new Random().nextInt(defaultStocks.length);
        int k = new Random().nextInt(defaultStocks.length);
        int l = new Random().nextInt(defaultStocks.length);
        int m = new Random().nextInt(defaultStocks.length);
        int n = new Random().nextInt(defaultStocks.length);
        

        if (lblCompany2.getText().isEmpty()) {
        	lblCompany2.setText(defaultStocks[i]);
        	cmbStocks.insertItemAt(defaultStocks[i], 1);
        }
        if (lblCompany3.getText().isEmpty()) {
            lblCompany3.setText(defaultStocks[j]);
            cmbStocks.insertItemAt(defaultStocks[j], 2);
        }
        if (lblCompany4.getText().isEmpty()) {
            lblCompany4.setText(defaultStocks[k]);
            cmbStocks.insertItemAt(defaultStocks[k], 3);
        }
        if (lblCompany5.getText().isEmpty()) {
            lblCompany5.setText(defaultStocks[l]);
            cmbStocks.insertItemAt(defaultStocks[l], 4);
        }
        if (lblCompany6.getText().isEmpty()) {
            lblCompany6.setText(defaultStocks[m]);
            cmbStocks.insertItemAt(defaultStocks[m], 5);
        }
        if (lblCompany7.getText().isEmpty()) {
            lblCompany7.setText(defaultStocks[n]);
            cmbStocks.insertItemAt(defaultStocks[n], 6);
        }

        class StockInfo extends TimerTask {

            //gets random stock values and sets it to textboxes
            public void run() {
            	try {
            		  AppInterface f = (AppInterface)Naming.lookup("//localhost/App");
    				
    				
            	
            	double stockValue1, stockValue2, stockValue3, stockValue4, stockValue5, stockValue6, stockValue7;
            	
            	stockValue1 = f.generateStock(50,1);;
                stockValue1 = f.roundDecimal(stockValue1);
                stockValue2 = f.generateStock(178,168);
                stockValue2 = f.roundDecimal(stockValue2);
                stockValue3 = f.facebookStock();
                stockValue3 = f.roundDecimal(stockValue3);
                stockValue4 = f.generateStock(400,100);
                stockValue4 = f.roundDecimal(stockValue4);
                stockValue5 = f.generateStock(20,2);
                stockValue5 = f.roundDecimal(stockValue5);
                stockValue6 = f.generateStock(300,200);
                stockValue6 = f.roundDecimal(stockValue6);
                stockValue7 = f.generateStock(15,1);
                stockValue7 = f.roundDecimal(stockValue7);
                
                //get Facebook stocks if user specifies it
                if (lblCompany1.getText().equals("Facebook")) {
            		stockValue1 = f.facebookStock();
            		stockValue1 = f.roundDecimal(stockValue1);
            	}
                if (lblCompany2.getText().equals("Facebook")) {
            		stockValue2 = f.facebookStock();
            		stockValue2 = f.roundDecimal(stockValue2);
            	}
                if (lblCompany3.getText().equals("Facebook")) {
            		stockValue3 = f.facebookStock();
            		stockValue3 = f.roundDecimal(stockValue3);
            	}
                if (lblCompany4.getText().equals("Facebook")) {
            		stockValue4 = f.facebookStock();
            		stockValue4 = f.roundDecimal(stockValue4);
            	}
                if (lblCompany5.getText().equals("Facebook")) {
            		stockValue5 = f.facebookStock();
            		stockValue5 = f.roundDecimal(stockValue5);
            	}
                if (lblCompany6.getText().equals("Facebook")) {
            		stockValue6 = f.facebookStock();
            		stockValue6 = f.roundDecimal(stockValue6);
            	}
                if (lblCompany7.getText().equals("Facebook")) {
            		stockValue7 = f.facebookStock();
            		stockValue7 = f.roundDecimal(stockValue7);
            	}
                
                //get Apple stocks if user specifies it
                if (lblCompany1.getText().equals("Apple")) {
            		stockValue1 = f.appleStock();
            		stockValue1 = f.roundDecimal(stockValue1);
            	}
                if (lblCompany2.getText().equals("Apple")) {
            		stockValue2 = f.appleStock();
            		stockValue2 = f.roundDecimal(stockValue2);
            	}
                if (lblCompany3.getText().equals("Apple")) {
            		stockValue3 = f.appleStock();
            		stockValue3 = f.roundDecimal(stockValue3);
            	}
                if (lblCompany4.getText().equals("Apple")) {
            		stockValue4 = f.appleStock();
            		stockValue4 = f.roundDecimal(stockValue4);
            	}
                if (lblCompany5.getText().equals("Apple")) {
            		stockValue5 = f.appleStock();
            		stockValue5 = f.roundDecimal(stockValue5);
            	}
                if (lblCompany6.getText().equals("Apple")) {
            		stockValue6 = f.appleStock();
            		stockValue6 = f.roundDecimal(stockValue6);
            	}
                if (lblCompany7.getText().equals("Apple")) {
            		stockValue7 = f.appleStock();
            		stockValue7 = f.roundDecimal(stockValue7);
            	}
                
                //get Microsoft stocks if user specifies it
                if (lblCompany1.getText().equals("Microsoft")) {
            		stockValue1 = f.microsoftStock();
            		stockValue1 = f.roundDecimal(stockValue1);
            	}
                if (lblCompany2.getText().equals("Microsoft")) {
            		stockValue2 = f.microsoftStock();
            		stockValue2 = f.roundDecimal(stockValue2);
            	}
                if (lblCompany3.getText().equals("Microsoft")) {
            		stockValue3 = f.microsoftStock();
            		stockValue3 = f.roundDecimal(stockValue3);
            	}
                if (lblCompany4.getText().equals("Microsoft")) {
            		stockValue4 = f.microsoftStock();
            		stockValue4 = f.roundDecimal(stockValue4);
            	}
                if (lblCompany5.getText().equals("Microsoft")) {
            		stockValue5 = f.microsoftStock();
            		stockValue5 = f.roundDecimal(stockValue5);
            	}
                if (lblCompany6.getText().equals("Microsoft")) {
            		stockValue6 = f.microsoftStock();
            		stockValue6 = f.roundDecimal(stockValue6);
            	}
                if (lblCompany7.getText().equals("Microsoft")) {
            		stockValue7 = f.microsoftStock();
            		stockValue7 = f.roundDecimal(stockValue7);
            	}
                
                //get Sony stocks if user specifies it
                if (lblCompany1.getText().equals("Sony")) {
            		stockValue1 = f.sonyStock();
            		stockValue1 = f.roundDecimal(stockValue1);
            	}
                if (lblCompany2.getText().equals("Sony")) {
            		stockValue2 = f.sonyStock();
            		stockValue2 = f.roundDecimal(stockValue2);
            	}
                if (lblCompany3.getText().equals("Sony")) {
            		stockValue3 = f.sonyStock();
            		stockValue3 = f.roundDecimal(stockValue3);
            	}
                if (lblCompany4.getText().equals("Sony")) {
            		stockValue4 = f.sonyStock();
            		stockValue4 = f.roundDecimal(stockValue4);
            	}
                if (lblCompany5.getText().equals("Sony")) {
            		stockValue5 = f.sonyStock();
            		stockValue5 = f.roundDecimal(stockValue5);
            	}
                if (lblCompany6.getText().equals("Sony")) {
            		stockValue6 = f.sonyStock();
            		stockValue6 = f.roundDecimal(stockValue6);
            	}
                if (lblCompany7.getText().equals("Sony")) {
            		stockValue7 = f.sonyStock();
            		stockValue7 = f.roundDecimal(stockValue7);
            	}
                
                //get Netflix stock if user specifies it
                if (lblCompany1.getText().equals("Netflix")) {
            		stockValue1 = f.netflixStock();
            		stockValue1 = f.roundDecimal(stockValue1);
            	}
                if (lblCompany2.getText().equals("Netflix")) {
            		stockValue2 = f.netflixStock();
            		stockValue2 = f.roundDecimal(stockValue2);
            	}
                if (lblCompany3.getText().equals("Netflix")) {
            		stockValue3 = f.netflixStock();
            		stockValue3 = f.roundDecimal(stockValue3);
            	}
                if (lblCompany4.getText().equals("Netflix")) {
            		stockValue4 = f.netflixStock();
            		stockValue4 = f.roundDecimal(stockValue4);
            	}
                if (lblCompany5.getText().equals("Netflix")) {
            		stockValue5 = f.netflixStock();
            		stockValue5 = f.roundDecimal(stockValue5);
            	}
                if (lblCompany6.getText().equals("Netflix")) {
            		stockValue6 = f.netflixStock();
            		stockValue6 = f.roundDecimal(stockValue6);
            	}
                if (lblCompany7.getText().equals("Netflix")) {
            		stockValue7 = f.netflixStock();
            		stockValue7 = f.roundDecimal(stockValue7);
            	}
                
                
                
                txtPrice1.setText(String.valueOf(stockValue1));
                txtPrice2.setText(String.valueOf(stockValue2));
                txtPrice3.setText(String.valueOf(stockValue3));
                txtPrice4.setText(String.valueOf(stockValue4));
                txtPrice5.setText(String.valueOf(stockValue5));
                txtPrice6.setText(String.valueOf(stockValue6));
                txtPrice7.setText(String.valueOf(stockValue7));
                
               String file1 =String.valueOf(stockValue1) +"\n";
               String file2 =String.valueOf(stockValue2) +"\n";
               String file3 =String.valueOf(stockValue3) +"\n";
               String file4 =String.valueOf(stockValue4) +"\n";
               String file5 =String.valueOf(stockValue5) +"\n";
               String file6 =String.valueOf(stockValue6) +"\n";
               String file7 =String.valueOf(stockValue7) +"\n";
               
                f.writeToFile("Company1",file1);
                f.writeToFile("Company2",file2);
                f.writeToFile("Company3",file3);
                f.writeToFile("Company4",file4);
                f.writeToFile("Company5",file5);
                f.writeToFile("Company6",file6);
                f.writeToFile("Company7",file7);
                
               
                
                
          //      txtDiff1.setForeground();
                
                double company1 = Double.parseDouble(f.rateOfChange("src/history/Company1"));
                if (company1 > 0) {
                	txtDiff1.setForeground(Color.green);
                } else if (company1 < 0) {
                	txtDiff1.setForeground(Color.red);
                } else {
                	txtDiff1.setForeground(Color.black);
                }
                
                double company2 = Double.parseDouble(f.rateOfChange("src/history/Company2"));
                if (company2 > 0) {
                	txtDiff2.setForeground(Color.green);
                } else if (company2 < 0) {
                	txtDiff2.setForeground(Color.red);
                } else {
                	txtDiff2.setForeground(Color.black);
                }
                
                double company3 = Double.parseDouble(f.rateOfChange("src/history/Company3"));
                if (company3 > 0) {
                	txtDiff3.setForeground(Color.green);
                } else if (company3 < 0) {
                	txtDiff3.setForeground(Color.red);
                } else {
                	txtDiff3.setForeground(Color.black);
                }
                
                double company4 = Double.parseDouble(f.rateOfChange("src/history/Company4"));
                if (company4 > 0) {
                	txtDiff4.setForeground(Color.green);
                } else if (company4 < 0) {
                	txtDiff4.setForeground(Color.red);
                } else {
                	txtDiff4.setForeground(Color.black);
                }
                
                double company5 = Double.parseDouble(f.rateOfChange("src/history/Company5"));
                if (company5 > 0) {
                	txtDiff5.setForeground(Color.green);
                } else if (company5 < 0) {
                	txtDiff5.setForeground(Color.red);
                } else {
                	txtDiff5.setForeground(Color.black);
                }
                
                double company6 = Double.parseDouble(f.rateOfChange("src/history/Company6"));
                if (company6 > 0) {
                	txtDiff6.setForeground(Color.green);
                } else if (company6 < 0) {
                	txtDiff6.setForeground(Color.red);
                } else {
                	txtDiff6.setForeground(Color.black);
                }
                
                double company7 = Double.parseDouble(f.rateOfChange("src/history/Company7"));
                if (company7 > 0) {
                	txtDiff7.setForeground(Color.green);
                } else if (company6 < 0) {
                	txtDiff7.setForeground(Color.red);
                } else {
                	txtDiff7.setForeground(Color.black);
                }
                
                txtDiff1.setText(f.rateOfChange("src/history/Company1")+"%");
                txtDiff2.setText(f.rateOfChange("src/history/Company2")+"%");
                txtDiff3.setText(f.rateOfChange("src/history/Company3")+"%");
                txtDiff4.setText(f.rateOfChange("src/history/Company4")+"%");
                txtDiff5.setText(f.rateOfChange("src/history/Company5")+"%");
                txtDiff6.setText(f.rateOfChange("src/history/Company6")+"%");
                txtDiff7.setText(f.rateOfChange("src/history/Company7")+"%");
                
            	} catch(Exception e) {
					System.err.println("Remote exception: " + e.getMessage());
					e.printStackTrace();
				}
            }

            
        }
       
        //set time to 3 seconds
        Timer timer = new Timer();
        timer.schedule(new StockInfo(), 0, 3000);
        
        //button which buys stocks if there is enough balance
        btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	balance= Double.parseDouble(lblBalance.getText());
            	
                if (cmbStocks.getSelectedIndex() == 0) {
                	quantityCount1+=Integer.parseInt(txtQuantity.getText());
                    model.addRow(new Object[] {
                        lblCompany1.getText(), txtQuantity.getText(), txtPrice1.getText()
                    });
                    balance -= Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice1.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully added stock. ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 1) {
                	quantityCount2+=Integer.parseInt(txtQuantity.getText());
                	model.addRow(new Object[] {
                        lblCompany2.getText(), txtQuantity.getText(), txtPrice2.getText()
                    });
                	 balance -= Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice2.getText());
                     lblBalance.setText(String.valueOf(balance));
                     JOptionPane.showMessageDialog(null, "Successfully added stock. ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 2) {
                	quantityCount3+=Integer.parseInt(txtQuantity.getText());
                    model.addRow(new Object[] {
                        lblCompany3.getText(), txtQuantity.getText(), txtPrice3.getText()
                    });
                    balance -= Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice3.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully added stock. ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 3) {
                	quantityCount4+=Integer.parseInt(txtQuantity.getText());
                	model.addRow(new Object[] {
                        lblCompany4.getText(), txtQuantity.getText(), txtPrice4.getText()
                    });
                    balance -= Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice4.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully added stock. ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 4) {
                	quantityCount5+=Integer.parseInt(txtQuantity.getText());
                	model.addRow(new Object[] {
                        lblCompany5.getText(), txtQuantity.getText(), txtPrice5.getText()
                    });
                    balance -= Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice5.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully added stock. ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 5) {
                	quantityCount6+=Integer.parseInt(txtQuantity.getText());
                	model.addRow(new Object[] {
                        lblCompany6.getText(), txtQuantity.getText(), txtPrice6.getText()
                    });
                    balance -= Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice6.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully added stock. ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 6) {
                	quantityCount7+=Integer.parseInt(txtQuantity.getText());
                	model.addRow(new Object[] {
                        lblCompany7.getText(), txtQuantity.getText(), txtPrice7.getText()
                    });
                    balance -= Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice7.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully added stock. ","", JOptionPane.DEFAULT_OPTION);
                }

            }
        });

        //button that sells stocks that were bought
        btnSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {


                if (cmbStocks.getSelectedIndex() == 0) {
                	quantityCount1-=Integer.parseInt(txtQuantity.getText());
                	if (quantityCount1<0) {
                		JOptionPane.showMessageDialog(null, "You do not have enough stock. ", "Error", JOptionPane.WARNING_MESSAGE);
                		return;
                	}
                    model.addRow(new Object[] {
                        lblCompany1.getText(), quantityCount1, txtPrice1.getText()
                    });
                    balance += Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice1.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully sold stock! ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 1) {
                	quantityCount2-=Integer.parseInt(txtQuantity.getText());
                	if (quantityCount2<0) {
                		JOptionPane.showMessageDialog(null, "You do not have enough stock. ", "Error", JOptionPane.WARNING_MESSAGE);
                		return;
                	}
                	model.addRow(new Object[] {
                        lblCompany2.getText(), quantityCount2, txtPrice2.getText()
                    });
                	balance += Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice2.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully sold stock! ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 2) {
                	quantityCount3-=Integer.parseInt(txtQuantity.getText());
                	if (quantityCount3<0) {
                		JOptionPane.showMessageDialog(null, "You do not have enough stock. ", "Error", JOptionPane.WARNING_MESSAGE);
                		return;
                	}
                	model.addRow(new Object[] {
                        lblCompany3.getText(), quantityCount3, txtPrice3.getText()
                    });
                	balance += Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice3.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully sold stock! ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 3) {
                	quantityCount4-=Integer.parseInt(txtQuantity.getText());
                	if (quantityCount4<0) {
                		JOptionPane.showMessageDialog(null, "You do not have enough stock. ", "Error", JOptionPane.WARNING_MESSAGE);
                		return;
                	}
                	model.addRow(new Object[] {
                        lblCompany4.getText(), quantityCount4, txtPrice4.getText()
                    });
                	balance += Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice4.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully sold stock! ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 4) {
                	quantityCount5-=Integer.parseInt(txtQuantity.getText());
                	if (quantityCount5<0) {
                		JOptionPane.showMessageDialog(null, "You do not have enough stock. ", "Error", JOptionPane.WARNING_MESSAGE);
                		return;
                	}
                	model.addRow(new Object[] {
                        lblCompany5.getText(), quantityCount5, txtPrice5.getText()
                    });
                	balance += Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice5.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully sold stock! ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 5) {
                	quantityCount6-=Integer.parseInt(txtQuantity.getText());
                	
                	if (quantityCount6<0) {
                		JOptionPane.showMessageDialog(null, "You do not have enough stock. ", "Error", JOptionPane.WARNING_MESSAGE);
                		return;
                	}model.addRow(new Object[] {
                        lblCompany6.getText(), quantityCount6, txtPrice6.getText()
                    });
                	balance += Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice6.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully sold stock! ","", JOptionPane.DEFAULT_OPTION);
                }
                if (cmbStocks.getSelectedIndex() == 6) {
                	quantityCount7-=Integer.parseInt(txtQuantity.getText());
                	if (quantityCount7<0) {
                		JOptionPane.showMessageDialog(null, "You do not have enough stock. ", "Error", JOptionPane.WARNING_MESSAGE);
                		return;
                	}
                	model.addRow(new Object[] {
                        lblCompany7.getText(), quantityCount7, txtPrice7.getText()
                    });
                	balance += Double.parseDouble(txtQuantity.getText())*Double.parseDouble(txtPrice7.getText());
                    lblBalance.setText(String.valueOf(balance));
                    JOptionPane.showMessageDialog(null, "Successfully sold stock! ","", JOptionPane.DEFAULT_OPTION);
                }

            }
        });

        //game ends after 10 minutes and displays final balance
        new Timer().schedule(new TimerTask() {

            int second = 60;
            @Override
            public void run() {
                lblTimer.setText(String.valueOf("Time: " + second-- + " seconds"));
                if (second == -1) {
                    JOptionPane.showMessageDialog(null, "Thanks for playing! You finished with a balance of $" + lblBalance.getText() + " and made $" + (Double.parseDouble(lblBalance.getText()) - Double.parseDouble(TradeOrder.txtBalance.getText())));
                    System.exit(0);
                }
            }
        }, 0, 1000);
    }









    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}