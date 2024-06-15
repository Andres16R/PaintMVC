package org.example.view;

import org.example.model.DrawModel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class DrawView extends JPanel {
    private DrawModel model;
    private Point startPoint, endPoint;

    public DrawView(DrawModel model) {
        this.model = model;
        setBackground(Color.WHITE);
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Shape shape : model.getShapes()) {
            g2d.draw(shape);
        }
        if (startPoint != null && endPoint != null) {
            g2d.draw(new Line2D.Float(startPoint.x, startPoint.y, endPoint.x, endPoint.y));
        }
    }
}
