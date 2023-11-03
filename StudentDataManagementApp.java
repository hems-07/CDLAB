package javaLab;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class StudentDataManagementApp extends JFrame {

    public StudentDataManagementApp() {
        setTitle("Student Data Management");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Logo (You can replace this with your logo)
        ImageIcon logo = new ImageIcon("logo.png");
        JLabel logoLabel = new JLabel(logo);
        add(logoLabel);

        // Panel for personal information
        JPanel personalInfoPanel = new JPanel();
        personalInfoPanel.setLayout(new GridLayout(4, 2, 10, 10));

        // Name
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField(20);
        personalInfoPanel.add(nameLabel);
        personalInfoPanel.add(nameTextField);

        // Department
        JLabel deptLabel = new JLabel("Department:");
        JRadioButton deptRadio1 = new JRadioButton("Department 1");
        JRadioButton deptRadio2 = new JRadioButton("Department 2");
        ButtonGroup deptGroup = new ButtonGroup();
        deptGroup.add(deptRadio1);
        deptGroup.add(deptRadio2);
        personalInfoPanel.add(deptLabel);
        personalInfoPanel.add(deptRadio1);
        personalInfoPanel.add(deptRadio2);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton maleRadio = new JRadioButton("Male");
        JRadioButton femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        personalInfoPanel.add(genderLabel);
        personalInfoPanel.add(maleRadio);
        personalInfoPanel.add(femaleRadio);

        // Area of Interest
        JLabel interestLabel = new JLabel("Area of Interest:");
        JCheckBox interest1 = new JCheckBox("Interest 1");
        JCheckBox interest2 = new JCheckBox("Interest 2");
        JCheckBox interest3 = new JCheckBox("Interest 3");
        personalInfoPanel.add(interestLabel);
        personalInfoPanel.add(interest1);
        personalInfoPanel.add(interest2);
        personalInfoPanel.add(interest3);

        // Hobbies
        JLabel hobbiesLabel = new JLabel("Hobbies:");
        String[] hobbies = {"Reading", "Sports", "Music", "Traveling", "Gaming"};
        JComboBox<String> hobbiesComboBox = new JComboBox<>(hobbies);
        personalInfoPanel.add(hobbiesLabel);
        personalInfoPanel.add(hobbiesComboBox);

        add(personalInfoPanel);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Buttons
        JButton submitButton = new JButton("Submit");
        JButton confirmButton = new JButton("Confirm");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(submitButton);
        buttonPanel.add(confirmButton);
        buttonPanel.add(exitButton);

        add(buttonPanel);


        // Button Actions
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String department = deptRadio1.isSelected() ? "Department 1" : "Department 2";
                String gender = maleRadio.isSelected() ? "Male" : "Female";
                String interests = "";
                if (interest1.isSelected()) interests += "Interest 1 ";
                if (interest2.isSelected()) interests += "Interest 2 ";
                if (interest3.isSelected()) interests += "Interest 3 ";
                String hobbies = (String) hobbiesComboBox.getSelectedItem();

                // Display the entered data (you can modify this part)
                JOptionPane.showMessageDialog(null,
                        "Name: " + name + "\n" +
                                "Department: " + department + "\n" +
                                "Gender: " + gender + "\n" +
                                "Area of Interest: " + interests + "\n" +
                                "Hobbies: " + hobbies,
                        "Student Information",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // Implement the action you want to perform when the "Confirm" button is clicked
                // This can include saving data to a database or file, etc.
                JOptionPane.showMessageDialog(null, "Data Confirmed!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentDataManagementApp app = new StudentDataManagementApp();
            app.setVisible(true);
        });
    }
}