import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Welcome page for the Panda World SDN BHD
public class Welcome extends JFrame implements ActionListener{

    private JFrame frame;
    private ImageIcon shopIcon;
    private JLabel Picture;
    private JButton startButton;


    public Welcome() {

        //set the frame default properties
        super.setTitle ( "Panda World SDN BHD");
        super.setSize ( 720, 630);
        super.setLocationRelativeTo(null);

        //register 'Exit upon closing' as a default close operation
        super.setDefaultCloseOperation( EXIT_ON_CLOSE );

        // add to content pane
        Container cp = super.getContentPane();

        // set layout
        cp.setLayout( new FlowLayout() );

        //this is for the image part
        shopIcon = new ImageIcon(this.getClass().getResource("/welc.jpg"));
        Picture = new JLabel(shopIcon);
        Picture.setSize(650,543);

        //demos of the start button
        JButton startButton = new JButton("Start");
        startButton.setBounds(300,325,75,25);
        startButton.setBackground(Color.decode("#CCE0D7"));
        startButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));


        //adding the action listener to the button
        startButton.addActionListener(this);

        Picture.add(startButton);
        cp.add(Picture);
        cp.add(startButton);

        Color originalClr = startButton.getBackground();

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setBackground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setBackground(originalClr);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

        Tents tents = new Tents();
        tents.setVisible(true);

        dispose();
    }
}