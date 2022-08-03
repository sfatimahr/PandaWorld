import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bill extends JFrame{

    private Popup popup;

    public Bill(double sum, String name, String icNum, String add, String phoneNum, String email, String checked) {
        super.setTitle("Receipt");
        super.setSize(350, 450);
        super.setLocationRelativeTo(null);

        //register 'Exit upon closing' as a default close operation
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        ////////////////CENTER////////////////
        Container cp = super.getContentPane();

        //set layout
        cp.setLayout(new GridLayout(3,1));

        //prepare customer details panel
        JPanel pnlCust = new JPanel();
        pnlCust.setLayout(new GridLayout(6,1));
        pnlCust.setBackground(Color.decode("#D9E8E1"));
        JLabel tajuk = new JLabel("     Receipt");
        JLabel lblName = new JLabel("     Name : " + name);
        JLabel lblIc = new JLabel("     IC Number : " + icNum);
        JLabel lblAdd = new JLabel("     Home Address : " + add);
        JLabel lblPhone = new JLabel("     Phone Number : " + phoneNum);
        JLabel lblEmail = new JLabel("     Email Address : " + email);
        pnlCust.add(tajuk);
        pnlCust.add(lblName);
        pnlCust.add(lblIc);
        pnlCust.add(lblAdd);
        pnlCust.add(lblPhone);
        pnlCust.add(lblEmail);

        //prepare the selected item panel
        JPanel  pnlSelected = new JPanel();
        pnlSelected.setLayout(new FlowLayout());
        pnlSelected.setBackground(Color.decode("#D9E8E1"));
        JTextArea selected = new JTextArea(" \n---------------------\n" + "Order details" + "\n---------------------\n" + checked);
        selected.setEditable(false);
        selected.setBackground(Color.decode("#D9E8E1"));
        pnlSelected.add(selected);

        //prepare total sum panel
        JPanel pnlResult = new JPanel();
        pnlResult.setLayout(new GridLayout(2,1));
        JLabel lblTotal = new JLabel("Total = RM" + sum, SwingConstants.CENTER);
        lblTotal.setOpaque(true);
        lblTotal.setBackground(Color.decode("#D9E8E1"));
        pnlResult.setBackground(Color.decode("#D9E8E1"));
        pnlResult.add(lblTotal);

        //confirm button
        JButton btnConfirmed = new JButton("Confirm");
        btnConfirmed.setBackground(Color.decode("#9AC1AE"));
        btnConfirmed.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                // change text of button after click
                if (btnConfirmed.getText() == "Confirm"){
                    JLabel text = new JLabel("Your order has been made!" );
                    popup = PopupFactory.getSharedInstance().getPopup(me.getComponent(), text, me.getXOnScreen(), me.getYOnScreen());
                    popup.show();
                }
            }
        });

        //adding the confirm button onto result panel
        pnlResult.add(btnConfirmed);


        //adding panels to container
        cp.add(pnlCust);
        cp.add(pnlSelected);
        cp.add(pnlResult);
    }
}
