import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl;
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;
    JTextArea displayTA;
    JScrollPane scroller;
    JLabel titleLbl;
    ImageIcon icon;
    JButton quitBtn;
    JButton ReadMyFortuneBtn;
    Random rnd = new Random();
    ArrayList<String> Fortunes = new ArrayList<>();
    public FortuneTellerFrame()
    {
        Fortunes.add("See this finger, see this thumb, You better Run!!"); //0
        Fortunes.add("I see money in your future.. but it is not yours."); //1
        Fortunes.add("Three can keep a secret if you get rid of the other two"); //2
        Fortunes.add("When life gives you lemons, squirt the juice in last person's eye who did you wrong. Trust me, it burns and you will feel better than if you drank lemonade! "); //3
        Fortunes.add("If you are driving and feeling lost, just skip 3 car payments and the repo man will find you."); //4
        Fortunes.add("No fortune for you. Please try again!"); //5
        Fortunes.add("Sorry, but your looking for love in all the wrong places here."); //6
        Fortunes.add("Do you feel lucky, Punk?");//7
        Fortunes.add("If your happy and you know it click again!");//8
        Fortunes.add("The end is near, once you click quit");//9
        Fortunes.add("This fortune will self destruct in 5 seconds."); //10
        Fortunes.add("An earthquake is coming, HEAD FOR THE CHOPPA!"); //11
        Fortunes.add("Unfortunate you are, no fortune here for you");//12

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setTitle("Fortune Teller");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        titleLbl.setFont(new Font("Algerian", Font.PLAIN, 36));
        ReadMyFortuneBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        quitBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        displayTA.setFont(new Font("Berlin SANS FB", Font.PLAIN, (15)));
    }
    private void createIconPanel()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/CrystalBall.jpg");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        iconPnl.add(titleLbl);
    }
    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(12,35);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }
    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 2));
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        ReadMyFortuneBtn = new JButton("Read My Fortune");
        ReadMyFortuneBtn.addActionListener((ActionEvent ae) ->
        {
            displayTA.append(Fortunes.get(rnd.nextInt(Fortunes.size())) +"\n");
        });
        controlPnl.add(ReadMyFortuneBtn);
        controlPnl.add(quitBtn);
    }


}
