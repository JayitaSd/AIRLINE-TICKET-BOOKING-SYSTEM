import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main{
  public static void main(String[] args) {

    JPanel panel = new JPanel();
    panel.setBackground(Color.CYAN);
    panel.setBounds(0, 0, 700, 700);
    panel.setLayout(null);

    //welcome label
    JLabel label = new JLabel(); 
    label.setText("WELCOME"); //set text of a label
    label.setBounds(250, 20, 200, 30);
    //label.setForeground(Color.white); //set font color
    label.setFont(new Font("MV  Boli", Font.BOLD,30)); //set font style and size

    //Email label
    JLabel Email = new JLabel(); 
    Email.setText("Email:");
    Email.setFont(new Font("MV  Boli", Font.BOLD,27));
    //Email.setForeground(Color.white);
    Email.setBounds(65, 165, 100, 30);

    //textfield for email
    JTextField tfEmail =new JTextField(); 
    tfEmail.setFont(new Font("MV  Boli", Font.PLAIN,20)); 
    tfEmail.setBounds(65, 210, 450, 35); //bounds

    //Password label
    JLabel Password = new JLabel(); 
    Password.setText("Password:");
    Password.setFont(new Font("MV  Boli", Font.BOLD,25));
    //Password.setForeground(Color.white);
    Password.setBounds(65, 300, 175, 30);

    //textfield for password
    JPasswordField tfpwd = new JPasswordField();
    //tfpwd.setFont(new Font("MV  Boli", Font.PLAIN,20));
    tfpwd.setBounds(65, 345, 450, 35);

    //Login button
    JButton buttonLg = new JButton( "LOGIN"); 
    buttonLg.setBounds(100, 500, 150, 50);
    buttonLg.setFont(new Font("MVBoli", Font.BOLD, 20));
    buttonLg.setForeground(Color.black);
    buttonLg.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Check if the email and password fields are filled
        String email = tfEmail.getText();
        char[] passwordChars = tfpwd.getPassword();
        String password = new String(passwordChars);

        
        if (email.isEmpty() || password.isEmpty()) {
          // Show message if any field is empty
          JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          // Open the new frame if both fields are filled
          new NewFrame(); // Calls the new frame from NewFrame.java
        }
      }
    });

    //Clear button
    JButton buttonclr = new JButton("CLEAR"); 
    buttonclr.setFont(new Font("MVBoli", Font.BOLD, 20));
    buttonclr.setForeground(Color.black);
    buttonclr.setBounds(350, 500, 150, 50);
    // Clear the text fields when the Clear button is pressed
    buttonclr.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        tfEmail.setText("");
        tfpwd.setText("");
      }
    });


    JFrame frame = new JFrame(); //creates a frame
    frame.setLayout(null); //no layout manager
    frame.setTitle("VISTARA"); //sets title of the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of the application
    frame.setResizable(false); //prevent from being resized
    frame.setSize(700,700); //sets the height and width of the frame
    frame.setVisible(true); //displays frame
    ImageIcon image = new ImageIcon("vist2.png"); //create an image icon
    frame.setIconImage(image.getImage()); //change icon of frame
    //frame.getContentPane().setBackground(new Color(148, 80, 250)); //change color of background
    //frame.setLayout(new BorderLayout());
    frame.add(panel); //adds panel to the frame
    panel.add(label); //adds welcome label to the panel
    panel.add(Email); //adds email label to the panel
    panel.add(tfEmail); //adds email textfield to the panel
    panel.add(Password); //adds password label to the panel
    panel.add(tfpwd);    //adds password textfield to the panel
    panel.add(buttonLg);  //adds login button to the panel
    panel.add(buttonclr); //adds clear button to the panel
  }
}

