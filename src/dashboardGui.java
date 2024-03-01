import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
    public Image panelImage;

    public static int width;
    public static int height;

    //get current screen size method
    public void getScreenSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//get screen size
        width = screenSize.width;//get screen width
        height = screenSize.height;//get screen height
    }

    private void changeLanguage(String language){
        if (language.equals("中文")){
            startOrderButton.setText("开始点单");
            checkOrderHistoryButton.setText("查询记录");
            menuEditButton.setText("修改菜单");
            systemSettingButton.setText("系统设置");
            exitProgramButton.setText("退出");
        }
    }

    public void setPanelImage(){
        try {
            panelImage = new ImageIcon("images/panelImage.jpeg").getImage();
            // Check if the image has valid dimensions
            if (panelImage.getWidth(null) > 0 && panelImage.getHeight(null) > 0) {
                // Scale and display the image
                Image scaledImage = panelImage.getScaledInstance(width / 2, height, Image.SCALE_SMOOTH);
                img.setIcon(new ImageIcon(scaledImage));
            } else {
                String errorMessage = "The panel image file is empty, corrupted, or has invalid dimensions";
                System.out.println(errorMessage);
                throw new Exception(errorMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Panel Image Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }


    public dashboardGui() {
        getScreenSize();//get screen size
        changeLanguage(configs.language);

        JFrame frame = new JFrame("Welcome to the system");//create a frame
        frame.setContentPane(main);//set main panel as the content pane
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the close operation
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//set the frame to full screen
        frame.setUndecorated(true);//set the frame to undecorated
        frame.setVisible(true);//make the window visible
        frame.setSize(width, height);//set the frame size

        //left panel setting
        left.setSize(width / 2, height);//set the panel size
        setPanelImage();

        //right panel setting
        right.setSize(width/2, height);//set the panel size
        startPanel.setSize(width/2, height/3);//set the panel size
        startOrderButton.setFont(new Font("正楷", Font.BOLD, startPanel.getHeight()/10));//set the button font size to fill the panel

        orderHistoryPanel.setSize(width/2, height/3);//set the panel size
        checkOrderHistoryButton.setFont(new Font("正楷", Font.BOLD, orderHistoryPanel.getHeight()/10));

        menuEditPanel.setSize(width/2, height/3);//set the panel size
        menuEditButton.setFont(new Font("正楷", Font.BOLD, menuEditPanel.getHeight() / 10));

        systemConfigPanel.setSize(width/2, height/3);//set the panel size
        systemSettingButton.setFont(new Font("正楷", Font.BOLD, systemConfigPanel.getHeight()/10));

        exitPanel.setSize(width/2, height/3);//set the panel size
        exitProgramButton.setFont(new Font("正楷", Font.BOLD, exitPanel.getHeight()/10));
        exitProgramButton.addActionListener(e -> System.exit(0));
        startOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new orderingGui();
            }
        });
    }
}
