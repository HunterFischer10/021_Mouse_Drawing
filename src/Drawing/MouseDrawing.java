/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 *
 * @author compsci
 */
public class MouseDrawing extends JFrame{
    
    JMenuBar mainMenuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem newMenuItem = new JMenuItem("New");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    JPanel drawPanel = new JPanel();
    JLabel leftColorLabel = new JLabel();
    JLabel rightColorLabel = new JLabel();
    JPanel colorPanel = new JPanel();
    JLabel[] colorLabel = new JLabel[8];
    Graphics2D g2D;
    double xPrevious, yPrevious;
    Color drawColor, leftColor, rightColor;
    
    
   

public MouseDrawing(){

setTitle("Creations by Hunter March 12 2018");
setResizable(false);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e)
    {
        exitForm(e);
    }

   
});
getContentPane().setLayout(new GridBagLayout());

newMenuItem.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {

        newMenuItemActionPerformed(e);
    }
    private void newMenuItemActionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}); 



//Build Menu
setJMenuBar(mainMenuBar);
fileMenu.setMnemonic('F');
mainMenuBar.add(fileMenu);
fileMenu.add(newMenuItem);
fileMenu.addSeparator();
fileMenu.add(exitMenuItem);
/*
newMenuItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        newMenuItemActionPerformed(e);
        
        
    }
}); 
exitMenuItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
})*/
drawPanel.setPreferredSize(new Dimension(500, 400));
drawPanel.setBackground(Color.black);
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.gridheight = 2;
gbc.insets = new Insets(10,10,10,10);
getContentPane().add(drawPanel, gbc);




leftColorLabel.setPreferredSize(new Dimension(40,40));
leftColorLabel.setOpaque(true);
gbc = new GridBagConstraints();
gbc.gridx = 1;
gbc.gridy = 0;
gbc.anchor = GridBagConstraints.NORTH;
gbc.insets = new Insets(10,5,10,10);
getContentPane().add(leftColorLabel,gbc);

rightColorLabel.setPreferredSize(new Dimension(40,40));
rightColorLabel.setOpaque(true);
gbc = new GridBagConstraints();
gbc.gridx = 2;
gbc.gridy = 0;
gbc.anchor = GridBagConstraints.NORTH;
gbc.insets = new Insets(10,5,10,10);
getContentPane().add(rightColorLabel,gbc);

colorPanel.setPreferredSize( new Dimension(80,160));
colorPanel.setBorder(BorderFactory.createTitledBorder("Colors"));
gbc = new GridBagConstraints();
gbc.gridx = 1;
gbc.gridy = 1;
gbc.gridwidth=2;
gbc.anchor = GridBagConstraints.NORTH;
gbc.insets = new Insets(10,10,10,10);
getContentPane().add(colorPanel,gbc);


colorPanel.setLayout(new GridBagLayout());
int j = 0;
for (int i = 0; i<8; i++){
colorLabel[i] = new JLabel();
colorLabel[i].setPreferredSize(new Dimension(30,30));
colorLabel[i].setOpaque(true);
gbc = new GridBagConstraints();
gbc.gridx=j;
gbc.gridy = i-j*4;
colorPanel.add(colorLabel[i], gbc);
if (i == 3)
        {
        j++;
        }

colorLabel[i].addMouseListener(new MouseAdapter()
{
    public void mousePressed(MouseEvent e)
            {
      colorMousePressed(e);
            
     } 

        
});
}
colorLabel[0].setBackground(Color.BLACK);
colorLabel[1].setBackground(Color.BLUE);
colorLabel[2].setBackground(Color.GREEN);
colorLabel[3].setBackground(Color.CYAN);
colorLabel[4].setBackground(Color.RED);
colorLabel[5].setBackground(Color.MAGENTA);
colorLabel[6].setBackground(Color.YELLOW);
colorLabel[7].setBackground(Color.WHITE);
leftColor = colorLabel[0].getBackground();
leftColorLabel.setBackground(leftColor);
rightColor = colorLabel[7].getBackground();
rightColorLabel.setBackground(rightColor);

pack();
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
setBounds((int) (0.5 * (screenSize.width-getWidth())), (int) (0.5 * (screenSize.height-getHeight())), getWidth(), getHeight());

g2D = (Graphics2D) drawPanel.getGraphics();
}

    /**
     *
     * @param args
     */
    public static void main(String ... args){
 new MouseDrawing().setVisible(true);
}

    private void setBounds(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void exitForm(WindowEvent e) {
        g2D.dispose();
        System.exit(0);
    }
    
    private void colorMousePressed(MouseEvent e)
    {
        Component clickedColor = e.getComponent();
        
        Toolkit.getDefaultToolkit().beep();
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            leftColor = clickedColor.getBackground();
            leftColorLabel.setBackground(leftColor);
        }else if (e.getButton() == MouseEvent.BUTTON3)
        {
            rightColor = clickedColor.getBackground();
            rightColorLabel.setBackground(rightColor);
        }
    }
}
 

