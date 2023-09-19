import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyDrawPanel extends JPanel {

//    public void paintComponent(Graphics graphics){
//        graphics.setColor(Color.orange);
//        graphics.fillRect(20, 50, 100, 100);
//    }

//    public void paintComponent(Graphics graphics){
////        Image image = new ImageIcon(getClass().getResource("benugo.jpg")).getImage();
//        Image image = new ImageIcon("E:\\javaWorkspace\\javaSwing\\GuiGraphics\\src\\resources\\benugo.jpg").getImage();
//        graphics.drawImage(image, 3, 4, this);
//    }

//    public void paintComponent(Graphics graphics){
//        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
//
//        Random random = new Random();
//        int red = random.nextInt(256);
//        int blue = random.nextInt(256);
//        int green = random.nextInt(256);
//
//        Color randomColor = new Color(red, green, blue);
//        graphics.setColor(randomColor);
//        graphics.fillOval(70, 70 , 100, 100);
//    }

//    public void paintComponent(Graphics graphics){
//        Graphics2D g2d = (Graphics2D) graphics;
//        GradientPaint gradientpaint = new GradientPaint(70, 70, Color.CYAN, 150, 150, Color.orange);
//        g2d.setPaint(gradientpaint);
//        g2d.fillOval(70, 70, 100, 100);
//    }

    public void paintComponent(Graphics graphics){
        Graphics2D g2d = (Graphics2D) graphics;
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

        Random random = new Random();
        int red = random.nextInt(256);
        int blue = random.nextInt(256);
        int green = random.nextInt(256);
        Color startColor  = new Color(red, blue, green);

        red = random.nextInt(256);
        blue = random.nextInt(256);
        green = random.nextInt(256);
        Color endColor = new Color(red, blue, green);

       GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 100, endColor);
        g2d.setPaint(gradient);
       g2d.fillOval(70, 70 , 100, 100);
    }

}
