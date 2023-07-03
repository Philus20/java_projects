package quaicoe_0026;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewWindow extends JFrame implements ActionListener {
    JTextField text1;
    JTextField text2;
    JTextField text3;
    JTextField text4;
    JTextField text5;
    JTextField text6;
    JTextField keyBox;
    JPanel itemsPanel = new JPanel();
    JButton keyBtn;
    JLabel keyfound;

    public NewWindow() {
        // Set the size and location of the JFrame
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Get the dimensions of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set the size of the JFrame to the dimensions of the screen
        setSize(screenSize.width - 100, screenSize.height - 100);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout Manager
        this.setLayout(null);
        this.setTitle("Searching");
        
        this.setBackground(Color.BLUE);
        JLabel keyLabel = new JLabel("Key");
        JPanel keyPanel = new JPanel();
        keyPanel.setBounds(200, 100, 300, 100);
        keyBox = new JTextField();
        keyBox.setPreferredSize(new Dimension(50, 30));
        keyBtn = new JButton("Find");
        keyPanel.add(keyLabel);
        keyPanel.add(keyBox);
        keyPanel.add(keyBtn);

        keyBtn.addActionListener(this);
        text1 = new JTextField("6");
        text2 = new JTextField("12");
        text3 = new JTextField("7");
        text4 = new JTextField("17");
        text5 = new JTextField("20");
        text6 = new JTextField("200");

        text1.setPreferredSize(new Dimension(50, 30));
        text2.setPreferredSize(new Dimension(50, 30));
        text3.setPreferredSize(new Dimension(50, 30));
        text4.setPreferredSize(new Dimension(50, 30));
        text5.setPreferredSize(new Dimension(50, 30));
        text6.setPreferredSize(new Dimension(50, 30));
        itemsPanel.setLayout(new FlowLayout());
        itemsPanel.setBounds(570, 200, 500, 250);

        itemsPanel.add(text1);
        itemsPanel.add(text2);
        itemsPanel.add(text3);
        itemsPanel.add(text4);
        itemsPanel.add(text5);
        itemsPanel.add(text6);

         keyfound = new JLabel();
        keyfound.setBounds(200, 400, 600, 200);
        keyfound.setFont(new Font("MV Boli", Font.PLAIN,50));
        keyfound.setForeground(Color.red);
        this.add(itemsPanel);
        this.add(keyPanel);
        this.add(keyfound);

        // Make the JFrame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == keyBtn) {
            // Get the key value from the keyBox JTextField
            String keyStr = keyBox.getText();
            int key = Integer.parseInt(keyStr);

            // Get the values from the JTextFields and store them in an ArrayList
            ArrayList<Integer> inputList = new ArrayList<>();
            inputList.add(Integer.parseInt(text1.getText()));
            inputList.add(Integer.parseInt(text2.getText()));
            inputList.add(Integer.parseInt(text3.getText()));
            inputList.add(Integer.parseInt(text4.getText()));
            inputList.add(Integer.parseInt(text5.getText()));
            inputList.add(Integer.parseInt(text6.getText()));

            // Convert the ArrayList to an array
            int[] array = inputList.stream().mapToInt(Integer::intValue).toArray();

            // Call the linear search algorithm to find the key in the array
            int index = LinearSearch.Searching(array, array.length, key);
            if (index == -1) {
                keyfound.setText("key not found");
            } else {
                keyfound.setText("Key found at index " + index);
            }
        }
    }
}