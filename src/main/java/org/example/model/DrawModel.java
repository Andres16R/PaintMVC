package org.example.model;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DrawModel {
    private List<Shape> shapes = new ArrayList<>();
    private Stack<Shape> undoStack = new Stack<>();
    private Stack<Shape> redoStack = new Stack<>();

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        redoStack.clear(); // Clear redo stack on new action
    }

    public void undo() {
        if (!shapes.isEmpty()) {
            Shape shape = shapes.remove(shapes.size() - 1);
            undoStack.push(shape);
        }
    }

    public void redo() {
        if (!undoStack.isEmpty()) {
            Shape shape = undoStack.pop();
            shapes.add(shape);
        }
    }
}
