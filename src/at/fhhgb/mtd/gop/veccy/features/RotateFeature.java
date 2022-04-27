package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.data.DoubleLinkedList;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Shape;

public class RotateFeature implements NamedFeature {
    private CanvasModel model;
    private boolean selected = false;
    private DoubleLinkedList shapes;

    public RotateFeature(CanvasModel model, DoubleLinkedList shapes) {
        this.model = model;
        this.shapes = shapes;
    }

    @Override
    public String getName() {
        return "Rotate";
    }

    @Override
    public void onSelect() {
        System.out.println("Selected Rotate");
        selected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Deselected Rotate");
        selected = false;
    }

    @Override
    public void onMouseClick(int i, int i1) {

    }

    @Override
    public void onMouseDrag(int x, int y) {
        if (selected && shapes.get(model.getCurrentlySelectedShapeIndex()) != null) {
            Shape translShape = shapes.get(model.getCurrentlySelectedShapeIndex());
            double angle = Math.atan2(y - translShape.getY(), x - translShape.getX());
            translShape.setTransform(TransformFactory.createRotation(angle));
        }
    }
}
