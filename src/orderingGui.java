import javax.swing.*;
import java.awt.*;

public class orderingGui {
    static float naviPanelWidth = 0.05F;
    static float topPanelHeight = 0.025F;

    public orderingGui() {
        JFrame frame = new JFrame("Ordering"); //create a frame
        frame.setSize(dashboardGui.width, dashboardGui.height); //set the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the close operation
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//set the frame to full screen
        frame.setUndecorated(true);//set the frame to undecorated
//        set layout to border layout
        frame.setLayout( new BorderLayout());
        frame.setSize(dashboardGui.width,dashboardGui.width);//set the frame size



//        create top panel for title
        JPanel topPanel = new JPanel();
        topPanel.setSize(dashboardGui.width, (int) (dashboardGui.height * topPanelHeight));
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        frame.add(topPanel, BorderLayout.NORTH);

        JLabel title = new JLabel("Ordering");
//        font and size
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(0, 0, topPanel.getWidth(), topPanel.getHeight());
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        topPanel.add(title);


//        create left panel for navigation 3 buttons, 1 for home ordering, 2 for order history and 3 at the button for exit
//        the panel size should be 20% of the width and full height
        JPanel leftNaviPanel = new JPanel();
        leftNaviPanel.setSize((int) (dashboardGui.width * naviPanelWidth), dashboardGui.height);
        leftNaviPanel.setLayout( new BorderLayout());
        leftNaviPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
        frame.add(leftNaviPanel, BorderLayout.WEST);


//      navigation panel wrapper
        int buttonSize = leftNaviPanel.getWidth();
        JPanel naviPanelWrapper = new JPanel();
        naviPanelWrapper.setLayout(new BoxLayout(naviPanelWrapper, BoxLayout.Y_AXIS));

        JButton homeButton = new JButton("Home");
        homeButton.setMaximumSize(new Dimension(buttonSize, buttonSize));
        naviPanelWrapper.add(homeButton);

        JButton orderHistoryButton = new JButton("Order History");
        orderHistoryButton.setMaximumSize(new Dimension(buttonSize, buttonSize));
        naviPanelWrapper.add(orderHistoryButton);

        leftNaviPanel.add(naviPanelWrapper, BorderLayout.NORTH);

//        add button for exit at the bottom of this left panel
        JPanel exitPanelWrapper = new JPanel();
        JButton exitButton = new JButton("Exit");
        exitPanelWrapper.setLayout(new BoxLayout(exitPanelWrapper, BoxLayout.Y_AXIS));
        exitButton.setMaximumSize(new Dimension(buttonSize, buttonSize));
        exitPanelWrapper.add(exitButton);
        leftNaviPanel.add(exitPanelWrapper, BorderLayout.SOUTH);


//        create middle left panel for customer information and order details
//        the panel size should be 30% of the width and full height
        JPanel middleLeftPanel = new JPanel();
        middleLeftPanel.setSize((int) (dashboardGui.width * naviPanelWidth), dashboardGui.height);
        middleLeftPanel.setLayout( new BorderLayout());
        middleLeftPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
        frame.add(middleLeftPanel, BorderLayout.CENTER);







        frame.setVisible(true);

























































//        exit button action listener
        exitButton.addActionListener(e -> System.exit(0));

    }

}

