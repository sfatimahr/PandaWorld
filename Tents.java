import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;

/*
 GUI App for user details
*/

public class Tents extends JFrame implements ActionListener {

    // buttons
    private JButton btnClear, btnDone;
    // labels
    private JLabel lblName, lblIC, lblAdd, lblPhone, lblEmail, lblpackages, lblpackages2,
            lblprice, lblitems, lblunitprice, lbladdon, lblCustomer;
    // text fields
    private JTextField txtName, txtIC, txtAdd, txtPhone, txtEmail, qtyE, qtyS, qtyP, qty1, qty2, qty3, qty4, qty5;;

    //checkboxes
    private JCheckBox ecoBox, stdBox, ptnBox, item1Box, item2Box, item3Box, item4Box, item5Box;

    public Tents() {

        //set the frame default properties
        super.setTitle ( "Tents Package");
        super.setSize ( 750, 1050);
        super.setLocationRelativeTo(null);

        //register 'Exit upon closing' as a default close operation
        super.setDefaultCloseOperation( EXIT_ON_CLOSE );

        /////////////--- SOUTH -----//////////////////////////////

        // create button object
        btnClear = new JButton("Clear");
        btnDone = new JButton("Done");

        btnClear.setBackground(Color.decode("#CCE0D7"));
        btnDone.setBackground(Color.decode("#CCE0D7"));

        // register button to event listener
        btnClear.addActionListener( this );
        btnDone.addActionListener(this);

        // add to content pane
        Container cp = super.getContentPane();

        // set layout
        cp.setLayout( new BorderLayout() );

        // prepare south panel
        JPanel pnlSouth = new JPanel();
        pnlSouth.setLayout(new FlowLayout());
        pnlSouth.add(btnClear);
        pnlSouth.add(btnDone);

        // prepare east and west panel
        JPanel pnlEast = new JPanel();
        JPanel pnlWest = new JPanel();

        // place pnlSouth on the south region of the content pane
        cp.add(pnlSouth, BorderLayout.SOUTH);

        /////////////--- CENTER -----//////////////////////////////
        // prepare center panel
        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(10,1));

        //first row of choices panel
        JPanel pnlOne = new JPanel();
        pnlOne.setLayout(new GridLayout(1, 2));
        pnlOne.setBackground(Color.decode("#A6C9B8"));
        lblpackages = new JLabel("Packages", SwingConstants.CENTER);
        lblpackages.setFont(new Font("Stencil", Font.PLAIN, 14));
        lblprice = new JLabel("Price", SwingConstants.CENTER);
        lblprice.setFont(new Font("Stencil", Font.PLAIN, 14));
        pnlOne.add(lblpackages);
        pnlOne.add(lblprice);
        pnlCenter.add(pnlOne);

        //second row of choices panel
        JPanel pnlTwo = new JPanel();
        pnlTwo.setLayout(new GridLayout(1, 2));
        JTextArea descE = new JTextArea(
                "Economy: \n" +
                        "✓ 1 Pyramid Canopy (20 x 20)\n" +
                        "✓ 40 plastic chair\n" +
                        "✓ 4 round table + tablecloth\n" +
                        "✓ Fan");
        descE.setEditable(false);
        JTextArea priceE = new JTextArea("RM300");
        descE.setBackground(Color.decode("#E5E5E5"));
        priceE.setBackground(Color.decode("#E5E5E5"));
        priceE.setEditable(false);
        pnlTwo.add(descE);
        pnlTwo.add(priceE);
        pnlCenter.add(pnlTwo);

        //third row of choices panel
        JPanel pnlThree = new JPanel();
        pnlThree.setLayout(new GridLayout(1, 2));
        JTextArea descS = new JTextArea(
                "Standard : \n" +
                        "✓ 1 Arabian Canopy (20 x 20) + scallops\n" +
                        "✓ 40 plastic chair\n" +
                        "✓ 4 round table + tablecloth\n" +
                        "✓ Fan + light");
        descS.setEditable(false);
        JTextArea priceS = new JTextArea("RM450");
        descS.setBackground(Color.decode("#F5F5F5"));
        priceS.setBackground(Color.decode("#F5F5F5"));
        priceS.setEditable(false);
        pnlThree.add(descS);
        pnlThree.add(priceS);
        pnlCenter.add(pnlThree);

        //fourth row of choices panel
        JPanel pnlFour = new JPanel();
        pnlFour.setLayout(new GridLayout(1, 2));
        JTextArea descP = new JTextArea(
                "Platinum : \n" +
                        "✓ 1 Arabian Canopy (20 x 20) + scallops\n" +
                        "✓ 40 plastic chair with fabric and ribbon\n" +
                        "✓ 4 round table + tablecloth\n" +
                        "✓ Fan + light");
        descP.setEditable(false);
        JTextArea priceP = new JTextArea("RM600");
        descP.setBackground(Color.decode("#E5E5E5"));
        priceP.setBackground(Color.decode("#E5E5E5"));
        priceP.setEditable(false);
        pnlFour.add(descP);
        pnlFour.add(priceP);
        pnlCenter.add(pnlFour);

        //fifth row of choices panel
        JPanel pnlFive = new JPanel();
        pnlFive.setLayout(new GridLayout(1, 2));
        pnlFive.setBackground(Color.decode("#9AC1AE"));
        lblitems = new JLabel("Item", SwingConstants.CENTER);
        lblitems.setFont(new Font("Stencil", Font.PLAIN, 14));
        lblunitprice = new JLabel("Price per unit", SwingConstants.CENTER);
        lblunitprice.setFont(new Font("Stencil", Font.PLAIN, 14));
        pnlFive.add(lblitems);
        pnlFive.add(lblunitprice);
        pnlCenter.add(pnlFive);

        //sixth row of choices panel
        JPanel pnlSix = new JPanel();
        pnlSix.setLayout(new GridLayout(5, 2));

        JTextArea item1 = new JTextArea("Canopy Arabian (20 x 20)");
        item1.setEditable(false);
        JTextArea unitPrice1 = new JTextArea("RM200");
        unitPrice1.setEditable(false);
        item1.setBackground(Color.decode("#F5F5F5"));
        unitPrice1.setBackground(Color.decode("#F5F5F5"));

        JTextArea item2 = new JTextArea("Stand fan");
        item2.setEditable(false);
        JTextArea unitPrice2 = new JTextArea("RM25");
        unitPrice2.setEditable(false);
        item2.setBackground(Color.decode("#E5E5E5"));
        unitPrice2.setBackground(Color.decode("#E5E5E5"));

        JTextArea item3 = new JTextArea("Bride Groom table");
        item3.setEditable(false);
        JTextArea unitPrice3 = new JTextArea("RM200");
        unitPrice3.setEditable(false);
        item3.setBackground(Color.decode("#F5F5F5"));
        unitPrice3.setBackground(Color.decode("#F5F5F5"));

        JTextArea item4 = new JTextArea("Plastic chair");
        item4.setEditable(false);
        JTextArea unitPrice4 = new JTextArea("RM1");
        unitPrice4.setEditable(false);
        item4.setBackground(Color.decode("#E5E5E5"));
        unitPrice4.setBackground(Color.decode("#E5E5E5"));

        JTextArea item5 = new JTextArea("Round table");
        item5.setEditable(false);
        JTextArea unitPrice5 = new JTextArea("RM15");
        unitPrice5.setEditable(false);
        item5.setBackground(Color.decode("#F5F5F5"));
        unitPrice5.setBackground(Color.decode("#F5F5F5"));

        //adding the description onto the sixth row of choices panel
        pnlSix.add(item1);
        pnlSix.add(unitPrice1);
        pnlSix.add(item2);
        pnlSix.add(unitPrice2);
        pnlSix.add(item3);
        pnlSix.add(unitPrice3);
        pnlSix.add(item4);
        pnlSix.add(unitPrice4);
        pnlSix.add(item5);
        pnlSix.add(unitPrice5);
        pnlCenter.add(pnlSix);

        //seventh row of choices panel
        JPanel pnlSeven = new JPanel();
        pnlSeven.setLayout(new GridLayout(1, 2));
        pnlSeven.setBackground(Color.decode("#8DB9A4"));
        lblpackages2 = new JLabel("Packages", SwingConstants.CENTER);
        lblpackages2.setFont(new Font("Stencil", Font.PLAIN, 14));
        lbladdon = new JLabel("Add-ons", SwingConstants.CENTER);
        lbladdon.setFont(new Font("Stencil", Font.PLAIN, 14));
        pnlSeven.add(lblpackages2);
        pnlSeven.add(lbladdon);
        pnlCenter.add(pnlSeven);

        //eighth row of choices panel
        JPanel pnlEight = new JPanel();
        pnlEight.setLayout(new GridLayout(1, 2));

        //
        JPanel pnlPackage = new JPanel();
        pnlPackage.setLayout(new GridLayout(3, 2));
        ecoBox = new JCheckBox("Economy");
        stdBox = new JCheckBox("Standard");
        ptnBox = new JCheckBox("Platinum");
        qtyE = new JTextField();
        qtyS = new JTextField();
        qtyP = new JTextField();
        pnlPackage.add(ecoBox);
        pnlPackage.add(qtyE);
        pnlPackage.add(stdBox);
        pnlPackage.add(qtyS);
        pnlPackage.add(ptnBox);
        pnlPackage.add(qtyP);

        JPanel pnlAddons = new JPanel();
        pnlAddons.setLayout(new GridLayout(5, 2));
        item1Box = new JCheckBox("Canopy Arabian (20 x 20)");
        item2Box = new JCheckBox("Stand fan");
        item3Box = new JCheckBox("Bride Groom table");
        item4Box = new JCheckBox("Plastic chair");
        item5Box = new JCheckBox("Round table");
        qty1 = new JTextField();
        qty2 = new JTextField();
        qty3 = new JTextField();
        qty4 = new JTextField();
        qty5 = new JTextField();
        pnlAddons.add(item1Box);
        pnlAddons.add(qty1);
        pnlAddons.add(item2Box);
        pnlAddons.add(qty2);
        pnlAddons.add(item3Box);
        pnlAddons.add(qty3);
        pnlAddons.add(item4Box);
        pnlAddons.add(qty4);
        pnlAddons.add(item5Box);
        pnlAddons.add(qty5);

        pnlEight.add(pnlPackage);
        pnlEight.add(pnlAddons);
        pnlCenter.add(pnlEight);

        //nineth row of choices panel
        JPanel pnlNine = new JPanel();
        pnlNine.setLayout(new GridLayout(1,1));
        pnlNine.setBackground(Color.decode("#8DB9A4"));
        lblCustomer = new JLabel("Customer Details", SwingConstants.CENTER);
        lblCustomer.setFont(new Font("Stencil", Font.PLAIN, 15));
        pnlNine.add(lblCustomer);
        pnlCenter.add(pnlNine);

        //prepare customer panel
        JPanel pnlCustomer = new JPanel();
        pnlCustomer.setLayout(new GridLayout(5,2));

        // first row of customer panel
        lblName = new JLabel("Name :", SwingConstants.CENTER);
        txtName = new JTextField();
        txtName.setBackground(Color.decode("#C0D8CD"));
        pnlCustomer.add(lblName);
        pnlCustomer.add(txtName);

        // second row of customer panel
        lblIC = new JLabel("NRIC :", SwingConstants.CENTER);
        txtIC = new JTextField();
        txtIC.setBackground(Color.decode("#D9E8E1"));
        pnlCustomer.add(lblIC);
        pnlCustomer.add(txtIC);

        // third row of customer panel
        lblAdd = new JLabel("Address :", SwingConstants.CENTER);
        txtAdd = new JTextField();
        txtAdd.setBackground(Color.decode("#C0D8CD"));
        pnlCustomer.add(lblAdd);
        pnlCustomer.add(txtAdd);

        // fourth row of customer panel
        lblPhone = new JLabel("Phone number :", SwingConstants.CENTER);
        txtPhone = new JTextField();
        txtPhone.setBackground(Color.decode("#D9E8E1"));
        pnlCustomer.add(lblPhone);
        pnlCustomer.add(txtPhone);

        // fifth row of customer panel
        lblEmail = new JLabel("Email :", SwingConstants.CENTER);
        txtEmail = new JTextField();
        txtEmail.setBackground(Color.decode("#C0D8CD"));
        pnlCustomer.add(lblEmail);
        pnlCustomer.add(txtEmail);

        //add customer panel to center panel
        pnlCenter.add(pnlCustomer);

        // add center panel to content pane
        cp.add(pnlCenter, BorderLayout.CENTER);
        cp.add(pnlWest, BorderLayout.WEST);
        cp.add(pnlEast, BorderLayout.EAST);

    }

    @Override

    public void actionPerformed(ActionEvent e) {

        // check the event source
        if (e.getSource() == btnClear) {

            // clear text fields
            txtName.setText("");
            txtIC.setText("");
            txtAdd.setText("");
            txtPhone.setText("");
            txtEmail.setText("");

            // clear checkboxes
            ecoBox.setSelected(false);
            stdBox.setSelected(false);
            ptnBox.setSelected(false);
            item1Box.setSelected(false);
            item2Box.setSelected(false);
            item3Box.setSelected(false);
            item4Box.setSelected(false);
            item5Box.setSelected(false);

            //clear text fields
            qtyE.setText("");
            qtyS.setText("");
            qtyP.setText("");
            qty1.setText("");
            qty2.setText("");
            qty3.setText("");
            qty4.setText("");
            qty5.setText("");

        }

        //the actions when button done is clicked
        if (e.getSource() == btnDone) {

            //
            if (txtName.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Please fill in your name");
            else if (txtIC.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Please fill in your IC number");
            else if (txtAdd.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Please fill in your address");
            else if (txtPhone.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Please fill in your phone number");
            else if (txtEmail.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Please fill in your email");
            else {

                //get customer details from form
                String name = txtName.getText();
                String icNum = txtIC.getText();
                String add = txtAdd.getText();
                String phoneNum = txtPhone.getText();
                String email = txtEmail.getText();

                //declare variables
                double sum = 0;
                double sumItem = 0;
                double qtyPackage = 0;
                double qtyTable = 0;
                double qtyChair = 0;
                String checked = "";

                //check if at least one package is selected
                if (!ecoBox.isSelected() && !stdBox.isSelected() && !ptnBox.isSelected() && !item1Box.isSelected() &&
                        !item2Box.isSelected() && !item3Box.isSelected() && !item4Box.isSelected() && !item5Box.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Please select at least 1 package!");
                }
                else {
                    //check which item and packages are selected
                    if (ecoBox.isSelected()) {
                        if (qtyE.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Please enter quantity");
                        }
                        int economy = Integer.parseInt(qtyE.getText());
                        qtyPackage += economy;
                        sum += economy * 300;
                        checked = "Economy package : " + economy + "\n";
                    }

                    if (stdBox.isSelected()) {
                        if (qtyS.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Please enter quantity");
                        }
                        int standard = Integer.parseInt(qtyS.getText());
                        qtyPackage += standard;
                        sum += standard * 450;
                        checked = checked + "Standard package : " + standard + "\n";
                    }

                    if (ptnBox.isSelected()) {
                        if (qtyP.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Please enter quantity");
                        }
                        int platinum = Integer.parseInt(qtyP.getText());
                        qtyPackage += platinum;
                        sum += platinum * 600;
                        checked = checked + "Platinum package : " + platinum + "\n\n";
                    }

                    if (item1Box.isSelected()) {
                        if (qty1.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this,  "Please enter quantity");
                        }
                        int canopy = Integer.parseInt(qty1.getText());
                        sumItem += canopy * 200;
                        checked = checked + "Additional canopy arabian : " + canopy + "\n";
                    }

                    if (item2Box.isSelected()) {
                        if (qty2.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Please enter quantity");
                        }
                        int fan = Integer.parseInt(qty2.getText());
                        sumItem += fan * 25;
                        checked = checked + "Additional stand fan : " + fan + "\n";
                    }

                    if (item3Box.isSelected()) {
                        if (qty3.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Please enter quantity");
                        }
                        int bgTable = Integer.parseInt(qty3.getText());
                        sumItem += bgTable * 200;
                        checked = checked + "Additional bride groom table : " + bgTable + "\n";
                    }

                    if (item4Box.isSelected()) {
                        if (qty4.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Please enter quantity");
                        }
                        int chair = Integer.parseInt(qty4.getText());
                        qtyChair += chair;
                        sumItem += chair;
                        checked = checked + "Additional plastic chair : " + chair + "\n";
                    }

                    if (item5Box.isSelected()) {
                        if (qty5.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Please enter quantity");
                        }
                        int table = Integer.parseInt(qty5.getText());
                        qtyTable += table;
                        sumItem += table * 15;
                        checked = checked + "Additional round table : " + table;
                    }

                    //calculation for if
                    if (qtyChair > 49 || qtyTable > 2) {
                        sumItem = sumItem * 0.95;
                    }

                    //calculation for if the selected packages is 5 or more
                    if (qtyPackage >= 5) {
                        sum = (sum + sumItem) * 0.9;
                    } else {
                        sum = sum + sumItem;
                    }

                    //calculation for SST
                    sum = sum * 0.94;

                    //sending the data onto the bill frame
                    Bill receipt = new Bill(sum, name, icNum, add, phoneNum, email, checked);
                    receipt.setVisible(true);

                    try {
                        PrintWriter outCustomer = new PrintWriter("customerDetails.txt");
                        outCustomer.write("Customer Details\n" + "-------------------------------\n");
                        outCustomer.write("Name :" + name + "\n");
                        outCustomer.write("IC Number :" + icNum + "\n");
                        outCustomer.write("Home Address :" + add + "\n");
                        outCustomer.write("Phone Number :" + phoneNum + "\n");
                        outCustomer.write("Email :" + email + "\n");
                        outCustomer.write("\n" + checked);
                        outCustomer.write("Total : RM" + sum);

                        outCustomer.close();

                    }
                    catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    dispose();

                }
            }
        }
    }
}
