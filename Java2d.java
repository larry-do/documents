package java2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Java2d {

    static class Bai1 extends JPanel {

        public Bai1() {
            setPreferredSize(new Dimension(600, 600));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            /*
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g2d.drawString("Hehe", 50, 50);
        g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2d.setColor(Color.red);
        g2d.drawLine(10, 10, 500, 500);
        g2d.drawRect(40, 100, 40, 40);
        g2d.drawRoundRect(100, 40, 100, 100, 25, 25);
        g2d.drawOval(270, 130, 50, 100);
        g2d.drawArc(200, 400, 110, 100, 5, 150);
        GradientPaint gp5 = new GradientPaint(0, 0,
        Color.orange, 0, 100, Color.black, true);
        g2d.setPaint(gp5);
        g2d.fillRect(350, 500, 100, 100);
             */
            List<Shape> shapes = new ArrayList<>();
            shapes.add(new Rectangle2D.Double(10, 10, 400, 100));
            shapes.add(new Rectangle2D.Double(10, 110, 200, 400));
            shapes.add(new Rectangle2D.Double(210, 110, 200, 400));
            shapes.add(new Rectangle2D.Double(160, 120, 20, 70));
            shapes.add(new Ellipse2D.Double(160, 300, 30, 30));
            shapes.add(new Ellipse2D.Double(230, 300, 30, 30));
            shapes.add(new Ellipse2D.Double(235, 230, 30, 30));
            shapes.add(new Ellipse2D.Double(220, 220, 60, 60));
            shapes.add(new Line2D.Double(210, 480, 250, 510));
            
            g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            shapes.forEach(shape -> g2d.draw(shape));

            g2d.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g2d.drawString("Phòng 305", 120, 70);
        }
    }

    static class Bai2 extends JPanel {

        public Bai2() {
            setPreferredSize(new Dimension(600, 600));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            Polygon polygon = new Polygon(new int[]{150, 200, 100}, new int[]{100, 200, 200}, 3);
            Line2D line = new Line2D.Double(500, 50, 500, 500);

            List<Shape> boat = new ArrayList<>();
            boat.add(new Polygon(new int[]{0, 200, 150, 50}, new int[]{100, 100, 150, 150}, 4));
            boat.add(new Polygon(new int[]{60, 80, 80}, new int[]{75, 75, 15}, 3));
            boat.add(new Line2D.Double(80, 75, 80, 100));
            AffineTransform transform = new AffineTransform();
            transform.translate(100, 0);
            transform.scale(-1, 1);
            transform.translate(-100, 0);
            boat.add(transform.createTransformedShape(boat.get(1)));
            boat.add(transform.createTransformedShape(boat.get(2)));

            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));

            g2d.draw(AffineTransform.getRotateInstance(Math.PI / 24, 500, 50).createTransformedShape(line));
            g2d.draw(AffineTransform.getTranslateInstance(-100, -50).createTransformedShape(AffineTransform.getRotateInstance(Math.PI / 4, 500, 50).createTransformedShape(line)));

            g2d.fill(polygon);
            g2d.fill(AffineTransform.getTranslateInstance(-40, 40).createTransformedShape(polygon));
            g2d.fill(AffineTransform.getTranslateInstance(-80, 80).createTransformedShape(polygon));

            boat.forEach(shape -> g2d.fill(AffineTransform.getTranslateInstance(100, 300).createTransformedShape(shape)));
            g2d.setColor(Color.BLACK);
            boat.forEach(shape -> g2d.draw(AffineTransform.getTranslateInstance(100, 300).createTransformedShape(shape)));

            g2d.setColor(Color.red);
            boat.forEach(shape -> g2d.fill(AffineTransform.getTranslateInstance(300, 100).createTransformedShape(AffineTransform.getScaleInstance(0.6, 0.6).createTransformedShape(shape))));
            g2d.setColor(Color.BLACK);
            boat.forEach(shape -> g2d.draw(AffineTransform.getTranslateInstance(300, 100).createTransformedShape(AffineTransform.getScaleInstance(0.6, 0.6).createTransformedShape(shape))));
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame jFrame = new JFrame();
            jFrame.setContentPane(new Bai2());
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.pack();
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        });
    }

}
