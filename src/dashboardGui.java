import javax.swing.*;
import java.awt.*;
import java.awt.Image;


public class dashboardGui {

    private JPanel main;
    private JPanel left;
    private JPanel right;
    private JLabel img;
    private JPanel startPanel;
    private JPanel orderHistoryPanel;
    private JPanel menuEditPanel;
    private JPanel exitPanel;
    private JPanel systemConfigPanel;
    private JButton startOrderButton;
    private JButton checkOrderHistoryButton;
    private JButton menuEditButton;
    private JButton systemSettingButton;
    private JButton exitProgramButton;

    public int width, height;

    //get current screen size method
    public void getScreenSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//get screen size
        width = screenSize.width;//get screen width
        height = screenSize.height;//get screen height
    }


    public dashboardGui() {

        getScreenSize();//get screen size

        JFrame frame = new JFrame("Welcome to the system");//create a frame
        frame.setContentPane(main);//set main panel as the content pane
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the close operation
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//set the frame to full screen
        frame.setUndecorated(true);//set the frame to undecorated
        frame.setVisible(true);//make the window visible
        frame.setSize(width, height);//set the frame size


        //left panel setting
        left.setSize(width / 2, height);//set the panel size
        Image originalImage;//create an image
        originalImage = new ImageIcon("src/images/display.jpeg").getImage();//load image
        Image scaledImage = originalImage.getScaledInstance(frame.getWidth()/2,frame.getHeight(),Image.SCALE_SMOOTH);//scale image
        img.setIcon(new ImageIcon(scaledImage));//set image to label


        //right panel setting
        right.setSize(width/2, height);//set the panel size
        startPanel.setSize(width/2, height/3);//set the panel size
        startOrderButton.setFont(new Font("Arial", Font.BOLD, startPanel.getHeight()/10));//set the button font size to fill the panel

        orderHistoryPanel.setSize(width/2, height/3);//set the panel size
        checkOrderHistoryButton.setFont(new Font("Arial", Font.BOLD, orderHistoryPanel.getHeight()/10));

        menuEditPanel.setSize(width/2, height/3);//set the panel size
        menuEditButton.setFont(new Font("Arial", Font.BOLD, menuEditPanel.getHeight()/10));

        systemConfigPanel.setSize(width/2, height/3);//set the panel size
        systemSettingButton.setFont(new Font("Arial", Font.BOLD, systemConfigPanel.getHeight()/10));

        exitPanel.setSize(width/2, height/3);//set the panel size
        exitProgramButton.setFont(new Font("Arial", Font.BOLD, exitPanel.getHeight()/10));
        exitProgramButton.addActionListener(e -> System.exit(0));

    }
}
