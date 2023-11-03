package javaLab;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TheatreRevenueGUI extends JFrame {

  JLabel adultPriceLabel, adultTicketsLabel, childPriceLabel, childTicketsLabel;
  JTextField adultPriceField, adultTicketsField, childPriceField, childTicketsField; 
  JButton calculateBtn, clearBtn;
  JTextArea resultArea;

  public TheatreRevenueGUI() {

    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());

    adultPriceLabel = new JLabel("Adult Ticket Price:");
    adultPriceField = new JTextField(10);

    adultTicketsLabel = new JLabel("Adult Tickets Sold:");
    adultTicketsField = new JTextField(10);

    childPriceLabel = new JLabel("Child Ticket Price:");
    childPriceField = new JTextField(10);

    childTicketsLabel = new JLabel("Child Tickets Sold:");
    childTicketsField = new JTextField(10);

    calculateBtn = new JButton("Calculate");
    calculateBtn.addActionListener(new CalculateListener());

    clearBtn = new JButton("Clear");
    clearBtn.addActionListener(new ClearListener());

    resultArea = new JTextArea(10, 30);
    resultArea.setEditable(false);

    panel.add(adultPriceLabel);
    panel.add(adultPriceField);
    panel.add(adultTicketsLabel);
    panel.add(adultTicketsField);
    panel.add(childPriceLabel);
    panel.add(childPriceField);
    panel.add(childTicketsLabel);
    panel.add(childTicketsField);
    panel.add(calculateBtn);
    panel.add(clearBtn);
    panel.add(resultArea);

    add(panel);
    setSize(400,300);
    setVisible(true);
  }

  private class CalculateListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

      double adultPrice = Double.parseDouble(adultPriceField.getText());
      int adultTickets = Integer.parseInt(adultTicketsField.getText());

      double childPrice = Double.parseDouble(childPriceField.getText());  
      int childTickets = Integer.parseInt(childTicketsField.getText());

      double adultRevenue = adultPrice * adultTickets;
      double childRevenue = childPrice * childTickets;

      double adultNetRevenue = adultRevenue * 0.75; 
      double childNetRevenue = childRevenue * 0.75;

      double totalNetRevenue = adultNetRevenue + childNetRevenue;

      resultArea.setText("Adult Net Revenue: " + adultNetRevenue + "\n");
      resultArea.append("Child Net Revenue: " + childNetRevenue + "\n");
      resultArea.append("Total Net Revenue: " + totalNetRevenue);
    }
  }

  private class ClearListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      adultPriceField.setText("");
      adultTicketsField.setText("");
      childPriceField.setText("");
      childTicketsField.setText("");
      resultArea.setText("");
    }
  }

  public static void main(String[] args) {
    new TheatreRevenueGUI();
  }
}