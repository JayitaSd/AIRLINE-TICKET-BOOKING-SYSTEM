import javax.swing.*;
import java.awt.*;

public class NewFrame extends JFrame {
  
    public NewFrame() {

      // Set up the new frame
      setTitle("BOOK");
      setSize(700, 700);
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setResizable(false);
      ImageIcon image1= new ImageIcon("vist2.png");
      setIconImage(image1.getImage());

      // Create a label to display the success message
      JLabel welcomeMessage = new JLabel("Login Successful!!!");
      welcomeMessage.setFont(new Font("MV  Boli", Font.BOLD,27));
      welcomeMessage.setBounds(225, 20, 300, 100);

      //Label for choosing
      JLabel choose = new JLabel("Which flight do you want to book?");
      choose.setFont(new Font("MV  Boli", Font.BOLD,25));
      choose.setBounds(30, 150, 500, 80);

      //mumbai to delhi rbutton
      JRadioButton md = new JRadioButton("Mumbai ---> Delhi");
      md.setFont(new Font("MV  Boli", Font.BOLD,25));
      md.setBounds(30, 235, 400, 50);
      md.setOpaque(false);

      //delhi to mumbai rbutton
      JRadioButton dm = new JRadioButton("Delhi ---> Mumbai");
      dm.setFont(new Font("MV  Boli", Font.BOLD,25));
      dm.setBounds(30, 305, 400, 50);
      dm.setOpaque(false);

      //Grouping the radio buttons so that only one button can be selected at a time
      ButtonGroup group = new ButtonGroup();
      group.add(md);
      group.add(dm);

      //Button for submitting and opening a new panel
      JButton submit = new JButton("SUBMIT");
      submit.setFont(new Font("MV  Boli", Font.BOLD,25));
      submit.setForeground(Color.black);
      submit.setBounds(275, 450, 150, 50);

      submit.addActionListener(e -> {
        String selectedOption = "None";
        if (md.isSelected()) {
          selectedOption = "Mumbai ---> Delhi";
          JOptionPane.showMessageDialog(this, "You selected: " + selectedOption);
          new MD();
        } 
        else if (dm.isSelected()) {
          selectedOption = "Delhi ---> Mumbai"; 
          JOptionPane.showMessageDialog(this, "You selected: " + selectedOption);
          new DM();
        }
    });

      // Panel to hold everything
      JPanel panel2 = new JPanel(); //new panel
      panel2.setLayout(null); //no layout maneger for the panel
      panel2.setBackground(Color.CYAN); //sets background color of the panel
      panel2.add(welcomeMessage); //add login successfull label to the panel
      panel2.add(choose); //add label to choose to the panel
      panel2.add(md); //add radio button to the panel
      panel2.add(dm); //add radio button to the panel
      panel2.add(submit); //Add submit button to the panel
      add(panel2); // Add the panel to the frame
    }
}



