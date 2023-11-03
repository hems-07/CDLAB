package javaLab;

import javax.swing.*;
import java.awt.event.*;

public class LengthConverterGUI {

  private JFrame frame;
  private JTextField meterField; 
  private JTextField cmField;

  public LengthConverterGUI() {

    frame = new JFrame("Length Converter");

    JPanel panel = new JPanel();
    meterField = new JTextField(10);
    cmField = new JTextField(10);

    panel.add(new JLabel("Meters: "));
    panel.add(meterField);
    panel.add(new JLabel("Centimeters: ")); 
    panel.add(cmField);

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);

    meterField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        double meters = Double.parseDouble(meterField.getText());
        double centimeters = meters * 100;
        cmField.setText(String.valueOf(centimeters));
      }
    });

    cmField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        double centimeters = Double.parseDouble(cmField.getText());
        double meters = centimeters / 100; 
        meterField.setText(String.valueOf(meters));
      }
    });
  }

  public static void main(String[] args) {
    new LengthConverterGUI();
  }
}