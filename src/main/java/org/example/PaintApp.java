package org.example;

import org.example.controller.DrawController;
import org.example.model.DrawModel;
import org.example.view.DrawView;

import javax.swing.*;
import java.awt.*;

public class PaintApp extends JFrame {
    private DrawModel model;
    private DrawView view;
    private DrawController controller;

    public PaintApp() {
        setTitle("Paint App MVC");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el modelo, la vista y el controlador
        model = new DrawModel();
        view = new DrawView(model);
        controller = new DrawController(model, view);

        // Agregar la vista al JFrame
        add(view, BorderLayout.CENTER);

        // Crear el panel de botones para deshacer y rehacer
        JPanel buttonPanel = new JPanel();
        JButton undoButton = new JButton("Undo");
        JButton redoButton = new JButton("Redo");

        // Configurar acciones para los botones
        undoButton.addActionListener(e -> controller.undo());
        redoButton.addActionListener(e -> controller.redo());

        // Agregar los botones al panel
        buttonPanel.add(undoButton);
        buttonPanel.add(redoButton);

        // Agregar el panel de botones al JFrame
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
