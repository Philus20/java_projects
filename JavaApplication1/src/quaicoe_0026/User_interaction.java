


package quaicoe_0026;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class User_interaction extends JFrame implements ActionListener {
    JButton sizeBtn;
    JTextField Type_Size;
    JPanel Items;
    JLabel  NumbersLabel;
    JPanel panel;
     JButton sendNumbers;
     JComboBox Display_Algorithms;
     JLabel sortedLabel;
     JLabel numberSize;
      JPanel numberSizePanel;
      // JButton find;
     int intSize = 0;
      
    User_interaction(){
    
       // Set the size and location of the JFrame
        setSize(400, 300);
        setLocationRelativeTo(null);
        
         // Get the dimensions of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Set the size of the JFrame to the dimensions of the screen
        setSize(screenSize.width-100, screenSize.height-100);
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Layout Manager
        this.setLayout(null);
        
        // Create a JPanel to hold the labels
        // Create a JPanel to hold the checkboxes
         panel = new JPanel();
        panel.setBounds(40, 50, 300, 100);
        // Create the comboboxes for the sorting and searching algorithms
        String Algorithms[] = {"BinarySearch","BubbleSort","InsertionSort","LinearSearch","Merge_sort","SelectionSort"};
        Display_Algorithms = new JComboBox(Algorithms);
        Display_Algorithms.setSelectedIndex(1);
         Display_Algorithms.setPreferredSize(new Dimension(150,30));
         sendNumbers = new JButton("Sort/Search");  
     sendNumbers.addActionListener(this);
         
      panel.add(Display_Algorithms);
        panel.add(sendNumbers);
      //The size of the array
       numberSizePanel = new JPanel();
       sizeBtn = new JButton("submit");
      sizeBtn.addActionListener(this);
       numberSize = new JLabel("NumberSize");
      Type_Size = new JTextField();
      Type_Size.setPreferredSize(new Dimension(50,30));
      numberSizePanel.setBounds(200, 300, 300, 100);
      
      numberSizePanel.add(numberSize);
      numberSizePanel.add(Type_Size);
      numberSizePanel.add(sizeBtn);
      
      //The numbers in the array
       NumbersLabel = new JLabel();
       NumbersLabel.setBounds(400,430,150,100);
      Items = new JPanel();
      Items.setLayout(null);
      Items.setBounds(570, 450, 500, 250);
      
      //sorted Label
      sortedLabel = new JLabel();
      sortedLabel.setBounds(0, 500,300, 100);
      
      
        
      // Add the panels to the JFrame
      this.add( NumbersLabel);
      this.add(numberSizePanel);
      this.add(panel);
      this.add(Items);
      this.add(sortedLabel);
    
   
      
        // Make the JFrame visible
        setVisible(true); 
    
    
    }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == sizeBtn) {
        String size = Type_Size.getText();
        intSize = Integer.parseInt(size);
        System.out.println(intSize * intSize);
        NumbersLabel.setText("Enter the numbers:");
        int x = 10;
        int y = 10;
        for (int i = 0; i < intSize; i++) {
            JTextField Type_item = new JTextField();
            Type_item.setPreferredSize(new Dimension(50, 30));
            Type_item.setBounds(x, y, 50, 30);
            Items.add(Type_item);
            x += 60;
            if (x > 500) {
                x = 10;
                y += 40;
            }
        }
        validate();
        repaint();
    }

    if (e.getSource() == sendNumbers) {
        // Get the text from the dynamically created text fields
        ArrayList<Integer> inputList = new ArrayList<>();
        for (Component component : Items.getComponents()) {
            if(component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                String text = textField.getText();
                int num = Integer.parseInt(text);
                inputList.add(num);
            }
        }
        System.out.println("Input list: " + inputList);

        int[] array = inputList.stream().mapToInt(Integer::intValue).toArray();

        if (Display_Algorithms.getSelectedIndex() == 1) {
            BubbleSort bubbleSort = new BubbleSort();
            bubbleSort.sorting(array, inputList.size());
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
            String sorted = Arrays.toString(array);
            sortedLabel.setText("The Sorted array(Bubble search) : " +sorted);
            
        }
        if (Display_Algorithms.getSelectedIndex() == 2) {
            InsertionSort insertSort = new InsertionSort();
            insertSort.sorting(array, inputList.size());
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
            String sorted = Arrays.toString(array);
            sortedLabel.setText("The Sorted array(insertion) : " +sorted);
            
        }
        if (Display_Algorithms.getSelectedIndex() == 4) {
            Merge_sort merge = new Merge_sort();
            merge.sorting(array, 0,array.length-1);
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
            String sorted = Arrays.toString(array);
            sortedLabel.setText("The Sorted array(Merge_sort) : " +sorted);
            
        }
        if (Display_Algorithms.getSelectedIndex() ==5 ) {
            SelectionSort selectSort = new SelectionSort();
            selectSort.sorting(array, inputList.size());
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
            String sorted = Arrays.toString(array);
            sortedLabel.setText("The Sorted array(Selection_sort) : " +sorted);
            
        }
        
        if(Display_Algorithms.getSelectedIndex() ==3){
        
        NewWindow searches = new NewWindow();
        }
    }
}
}




