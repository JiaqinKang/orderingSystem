import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class orderingGui {
    static float naviPanelWidth = 0.05F;
    static float topPanelHeight = 0.025F;

    static float middlePanelWidth = 0.95F/2;

    public orderingGui() {
        JFrame frame = new JFrame("Ordering"); //create a frame
        frame.setSize(dashboardGui.width, dashboardGui.height); //set the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the close operation
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//set the frame to full screen
        frame.setUndecorated(true);//set the frame to undecorated
        frame.setLayout( new BorderLayout());

////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////create top panel for title////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
        //create a panel for the title
        JPanel topPanel = new JPanel(); //create a panel
        topPanel.setSize(dashboardGui.width, (int) (dashboardGui.height * topPanelHeight)); //set the panel size
        topPanel.setLayout(new BorderLayout()); //set the layout
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black)); //set the border
        frame.add(topPanel, BorderLayout.PAGE_START); //add and set the panel to the frame at top

        //create a label for the title
        JLabel title = new JLabel("Ordering System"); //create a label
        title.setFont(new Font("正楷", Font.BOLD, 60)); //set the font
        title.setBounds(0, 0, topPanel.getWidth(), topPanel.getHeight()); //set the position and size
        title.setHorizontalAlignment(SwingConstants.LEFT); //set the horizontal alignment
        title.setVerticalAlignment(SwingConstants.CENTER); //set the vertical alignment
        topPanel.add(title); //add the label to the panel
////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////End of top panel for title////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////create left panel for navigation//////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
        JPanel leftNaviPanel = new JPanel();
        leftNaviPanel.setSize((int) (dashboardGui.width * naviPanelWidth), dashboardGui.height); //set the panel size
        // border layout for the left panel
        leftNaviPanel.setLayout( new BorderLayout());
        leftNaviPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
        frame.add(leftNaviPanel, BorderLayout.LINE_START); //add and set the panel to the frame at left

        //// create a wrapper panel for the buttons
        JPanel naviPanelButtonWrapper = new JPanel();
        naviPanelButtonWrapper.setLayout(new GridLayout(0,1));
        //// create button home
        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("正楷", Font.PLAIN, 50));
        naviPanelButtonWrapper.add(homeButton); //add the button to the wrapper panel
        //// create button order history
        JButton orderHistoryButton = new JButton("Order History");
        orderHistoryButton.setFont(new Font("正楷", Font.PLAIN, 50));
        naviPanelButtonWrapper.add(orderHistoryButton); //add the button to the wrapper panel

        leftNaviPanel.add(naviPanelButtonWrapper, BorderLayout.PAGE_START);

        ////add button for exit at the bottom of this left panel
        JPanel exitPanelWrapper = new JPanel();
        exitPanelWrapper.setLayout(new GridLayout(0,1));
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("正楷", Font.PLAIN, 50));
        exitPanelWrapper.add(exitButton);

        leftNaviPanel.add(exitPanelWrapper, BorderLayout.PAGE_END);
////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////End of left panel for navigation//////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////
///////Middle panel for order details,food category panel, food element category////////
////////////////////////////////////////////////////////////////////////////////////////
        JPanel middlePanel = new JPanel();
        middlePanel.setSize((int) (dashboardGui.width * middlePanelWidth), dashboardGui.height);
        middlePanel.setLayout( new BorderLayout());
        frame.add(middlePanel, BorderLayout.CENTER);

        ////middle left left panel for customer details, order details and payment
        ////width = 2/3 of middle left panel
        JPanel middleLeftLeftPanel = new JPanel();
        //set the panel size half of the middle panel and 2/3 of the half panel
        middleLeftLeftPanel.setSize(middlePanel.getWidth()/3*2, middlePanel.getHeight());
        System.out.println(middleLeftLeftPanel.getWidth() + " " + middleLeftLeftPanel.getHeight());
        middleLeftLeftPanel.setLayout(new BorderLayout());
        middleLeftLeftPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
        middlePanel.add(middleLeftLeftPanel, BorderLayout.WEST); //add and set the panel to the frame at left

        ////middle left left top customer details wrapper at the page start of middle left left panel
        JPanel customerDetailsWrapper = new JPanel(); //create a panel
        customerDetailsWrapper.setSize(middleLeftLeftPanel.getWidth(), middleLeftLeftPanel.getHeight()/7);
        customerDetailsWrapper.setLayout( new GridLayout(3,4));
        middleLeftLeftPanel.add(customerDetailsWrapper, BorderLayout.NORTH);


        ////create temp buttons to fill the customer details wrapper for testing
        for (int i = 0; i < 12; i++) {
            JButton tempButton = new JButton("Button " + i);
            tempButton.setFont(new Font("正楷", Font.PLAIN, 50));
            customerDetailsWrapper.add(tempButton);
        }


        ////middle left left center for order details wrapper at the center of middle left left panel
        JPanel orderWrapper = new JPanel();
        orderWrapper.setSize(middleLeftLeftPanel.getWidth(), middleLeftLeftPanel.getHeight()/7);
        orderWrapper.setLayout( new BorderLayout());
        middleLeftLeftPanel.add(orderWrapper, BorderLayout.CENTER);


        ////create a order details scroll pane to hold the order details
        JPanel orderDetailsScrollWrapper = new JPanel();
        orderDetailsScrollWrapper.setSize(orderWrapper.getWidth(), orderWrapper.getHeight()/5);
//        layout for the order details scroll pane
        orderDetailsScrollWrapper.setLayout(new GridLayout(0,1));

        ////create temp buttons to fill the order details wrapper for testing
//        for (int i = 0; i < 20; i++) {
//            JButton tempButton = new JButton("Button " + i);
//            tempButton.setFont(new Font("正楷", Font.PLAIN, 50));
//            orderDetailsScrollWrapper.add(tempButton);
//        }


//        create a scroll panel for the order details
        JScrollPane orderDetailsScrollPanel = new JScrollPane(orderDetailsScrollWrapper);
        orderDetailsScrollPanel.setSize(orderWrapper.getWidth(), orderDetailsScrollWrapper.getHeight());
        orderWrapper.add(orderDetailsScrollPanel, BorderLayout.CENTER);





        ///////////////////////////////
        ////create a wrapper for edit and display when a button is clicked for editing
        JPanel editAndDisplayWrapper = new JPanel();
        editAndDisplayWrapper.setSize(orderWrapper.getWidth(), orderWrapper.getHeight()/5*2);
        editAndDisplayWrapper.setLayout( new GridLayout(1,2));
        orderWrapper.add(editAndDisplayWrapper, BorderLayout.SOUTH);


//        crate 2 buttons for edit and display
        JButton editButton = new JButton("Delete");
        editButton.setFont(new Font("正楷", Font.PLAIN, 50));
        editAndDisplayWrapper.add(editButton);
        JButton displayButton = new JButton("Edit Note");
        displayButton.setFont(new Font("正楷", Font.PLAIN, 50));
        editAndDisplayWrapper.add(displayButton);




////////////////////////////////////////////////////////////////////////////////////////
//////End of middle left left panel for customer details, order details and payment/////
////////////////////////////////////////////////////////////////////////////////////////
        //// middle left left create new order and payment details, check out wrapper at the page end of middle left left panel
        JPanel newOrderAndPaymentWrapper = new JPanel();
        newOrderAndPaymentWrapper.setSize(middleLeftLeftPanel.getWidth(), middleLeftLeftPanel.getHeight()/7*2);
        newOrderAndPaymentWrapper.setLayout(new BorderLayout());
        middleLeftLeftPanel.add(newOrderAndPaymentWrapper, BorderLayout.PAGE_END);



//        create a wrapper for the payment details within the new order and payment wrapper
        JPanel paymentDetailsWrapper = new JPanel();
        paymentDetailsWrapper.setSize(newOrderAndPaymentWrapper.getWidth(), newOrderAndPaymentWrapper.getHeight()/2);
        paymentDetailsWrapper.setLayout( new GridLayout(4,2));

        ////create temp buttons to fill the payment details wrapper for testing
        for (int i = 0; i < 8; i++) {
            JButton tempButton = new JButton("Button " + i);
            tempButton.setFont(new Font("正楷", Font.PLAIN, 50));
            paymentDetailsWrapper.add(tempButton);
        }
        newOrderAndPaymentWrapper.add(paymentDetailsWrapper,BorderLayout.CENTER);




//      create a wrapper for payment button on the east of the payment details wrapper
        JPanel paymentButtonWrapper = new JPanel();
        paymentButtonWrapper.setLayout( new BorderLayout());
        JButton paymentButton = new JButton("Pay");
        paymentButton.setFont(new Font("正楷", Font.PLAIN, 50));
        paymentButtonWrapper.add(paymentButton, BorderLayout.CENTER);
        newOrderAndPaymentWrapper.add(paymentButtonWrapper, BorderLayout.LINE_END);


//        create a wrapper for create new order button, print, hold,take,edit and pay later buttons
        JPanel createNewOrderAndPrintWrapper = new JPanel();
//        createNewOrderAndPrintWrapper.setSize(newOrderAndPaymentWrapper.getWidth(), newOrderAndPaymentWrapper.getHeight()/2);
        createNewOrderAndPrintWrapper.setLayout( new GridLayout(1,6));
        newOrderAndPaymentWrapper.add(createNewOrderAndPrintWrapper, BorderLayout.PAGE_END);

        ////create temp buttons to fill the create new order and print wrapper for testing
        for (int i = 0; i < 5; i++) {
            JButton tempButton = new JButton("Button " + i);
            tempButton.setFont(new Font("正楷", Font.PLAIN, 50));
            createNewOrderAndPrintWrapper.add(tempButton);
        }































//
//
        ////middle left right panel for food category
        ////width = 1/3 of middle left panel
        JPanel middleLeftRightPanel = new JPanel();
        middleLeftRightPanel.setLayout( new BorderLayout());
        middleLeftRightPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
        middlePanel.add(middleLeftRightPanel, BorderLayout.CENTER);

//        test button for food category for testing
        JButton foodCategoryButton = new JButton("Food Element");
        foodCategoryButton.setFont(new Font("正楷", Font.PLAIN, 50));
        middleLeftRightPanel.add(foodCategoryButton, BorderLayout.PAGE_START);
//
//
//
//
//////////////////////////////////////////////////////////////////////////////////////////
/////////End of middle panel for order details,food category panel, food element category///
//////////////////////////////////////////////////////////////////////////////////////////
//
//
//////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////create right panel for food element////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
//
        JPanel middleRightPanel = new JPanel();
        middleRightPanel.setSize((int) (dashboardGui.width * middlePanelWidth), dashboardGui.height);
        middleRightPanel.setLayout( new BorderLayout());
        frame.add(middleRightPanel, BorderLayout.LINE_END);


////add some test buttons for layout check

        JButton foodElementButton = new JButton("Food Category");
        foodElementButton.setFont(new Font("正楷", Font.PLAIN, 50));
        middleRightPanel.add(foodElementButton, BorderLayout.PAGE_START);

        frame.setVisible(true);





















































//        home button action listener
        homeButton.addActionListener(e -> {
            new dashboardGui();
            frame.dispose();
        });


//        exit button action listener
        exitButton.addActionListener(e -> System.exit(0));



    }


}

