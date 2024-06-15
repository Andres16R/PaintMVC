package org.example.controller;

import org.example.model.DrawModel;
import org.example.view.DrawView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

public class DrawController {
    private DrawModel model;
    private DrawView view;

    public DrawController(DrawModel model, DrawView view) {
        this.model = model;
        this.view = view;

        view.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                view.setStartPoint(e.getPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point startPoint = view.getStartPoint();
                Point endPoint = e.getPoint();
                if (startPoint != null) {
                    Shape shape = new Line2D.Float(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                    model.addShape(shape);
                    view.setStartPoint(null);
                    view.setEndPoint(null);
                    view.repaint();
                }
            }
        });

        view.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                view.setEndPoint(e.getPoint());
                view.repaint();
            }
        });
    }

    public void undo() {
        model.undo();
        view.repaint();
    }

    public void redo() {
        model.redo();
        view.repaint();
    }
}
