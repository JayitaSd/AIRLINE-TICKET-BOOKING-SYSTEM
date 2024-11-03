import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MD extends JFrame {
  private static String[] seats = {"1A", "1B", "2A", "2B", "3A", "3B", "4A", "4B", "5A", "5B" };
  private static int seatCount = seats.length;
  private Booking[] bookings = new Booking[10]; // Initialize with 10 slots
  private int bookingCount = 0;

  public MD(){
    //setting up new frame 
    setTitle("Mumbai--->Delhi");
    setSize(700, 700);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setResizable(false);
    ImageIcon image2 = new ImageIcon("vist2.png");
    setIconImage(image2.getImage());

    //label for details
    JLabel details = new JLabel("DETAILS: ");
    details.setFont(new Font("MVBoli", Font.BOLD, 25));
    details.setBounds(10, 10, 300, 40);

    //label for name
    JLabel name = new JLabel("Enter your name: ");
    name.setFont(new Font("MVBoli", Font.BOLD, 20));
    name.setBounds(10, 50, 250, 40);

    //textfield for name
    JTextField name1 = new JTextField();
    name1.setFont(new Font("MVBoli", Font.PLAIN, 18));
    name1.setBounds(270, 50, 325, 40);

    //label for date of birth
    JLabel dob = new JLabel("Enter date of birth: ");
    dob.setFont(new Font("MVBoli", Font.BOLD, 20));
    dob.setBounds(10, 110, 250, 40);

    //textfield for date of birth
    JTextField dob1 = new JTextField();
    dob1.setFont(new Font("MVBoli", Font.PLAIN, 18));
    dob1.setBounds(270, 110, 325, 40);

    //label for age
    JLabel age = new JLabel("Enter age: ");
    age.setFont(new Font("MVBoli", Font.BOLD, 20));
    age.setBounds(10, 170, 250, 40);
    
    //textfield for age
    JTextField age1 = new JTextField();
    age1.setFont(new Font("MVBoli", Font.PLAIN, 18));
    age1.setBounds(270, 170, 325, 40);
    
    //label for gender
    JLabel gender = new JLabel("Enter gender: ");
    gender.setFont(new Font("MVBoli", Font.BOLD, 20));
    gender.setBounds(10, 230, 250, 40);

    //textfield for gender
    JTextField gender1 = new JTextField();
    gender1.setFont(new Font("MVBoli", Font.PLAIN, 18));
    gender1.setBounds(270, 230, 325, 40);

    //label for aadhar
    JLabel adh = new JLabel("Enter aadhar card no.: ");
    adh.setFont(new Font("MVBoli", Font.BOLD, 20));
    adh.setBounds(10, 290, 250, 40);

    //textfield for aadhar
    JTextField adh1 = new JTextField();
    adh1.setFont(new Font("MVBoli", Font.PLAIN, 18));
    adh1.setBounds(270, 290, 325, 40);

    //label for passport
    JLabel pp = new JLabel("Enter passport no.: ");
    pp.setFont(new Font("MVBoli", Font.BOLD, 20));
    pp.setBounds(10, 350, 250, 40);

    //textfield for passport
    JTextField pp1 = new JTextField();
    pp1.setFont(new Font("MVBoli", Font.PLAIN, 18));
    pp1.setBounds(270, 350, 325, 40);

    //button for submit
    JButton book = new JButton("BOOK");
    book.setBounds(275, 500, 150, 50 );
    book.setFont(new Font("MVBoli", Font.BOLD, 20));
    book.setForeground(Color.BLACK);
    book.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          String name = name1.getText();
          String dob = dob1.getText();
          String age = age1.getText();
          String gender = gender1.getText();
          String adh = adh1.getText();
          String pp = pp1.getText();
  
          if (name.isEmpty() || dob.isEmpty() || age.isEmpty() || gender.isEmpty() || adh.isEmpty() || pp.isEmpty()) {
              // Show message if any field is empty
              JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
              return;
          }
  
          try {
              int ageInt = Integer.parseInt(age);
              long ppInt = Long.parseLong(pp);
              long adhInt = Long.parseLong(adh);
  
              // Proceed with booking if validation passes
              String seat = bookSeat();
              if (seat != null) {
                  JOptionPane.showMessageDialog(null, "Seat " + seat + " booked successfully.");
                  // Store the data in an array of objects
                  storeData(name, dob, ageInt, gender, adhInt, ppInt, seat);
                  // Redirect to the home page (MAIN.java)
                  dispose(); // Dispose of the current frame
                  new Main(); // Create a new instance of the Main frame
              } 
              else {
                  JOptionPane.showMessageDialog(null, "No seats available. Exiting application.");
                  System.exit(0); // Exit the application if no seats are available
              }
          } 
          catch (NumberFormatException ex) {
              // Show error if non-integer values are entered in age, pp, or adh
              JOptionPane.showMessageDialog(null, "Age, Passport, and Aadhar must be integers.");
          }
      }
  });


    //panel to contain everything
    JPanel panel3 = new JPanel();
    panel3.setLayout(null);
    panel3.setBackground(Color.CYAN);
    add(panel3);
    panel3.add(details);
    panel3.add(name);
    panel3.add(name1);
    panel3.add(dob);
    panel3.add(dob1);
    panel3.add(age);
    panel3.add(age1);
    panel3.add(gender);
    panel3.add(gender1);
    panel3.add(adh);
    panel3.add(adh1);
    panel3.add(pp);
    panel3.add(pp1);
    panel3.add(book);
  }
  // Method to book a seat
  private String bookSeat() {
    if (seatCount > 0) {
      String seat = seats[seats.length - seatCount];
      seatCount--;
      return seat;
    }
    return null;
  }

  // Method to store data in an array of objects
  private void storeData(String name, String dob, int age, String gender, long adh, long pp, String seat) {
    Booking booking = new Booking(name, dob, age, gender, adh, pp, seat);
    bookings[bookingCount] = booking;
    bookingCount++;
  }

}

