package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.data.DoubleLinkedList;
import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.model.TransformConfig;
import at.fhhgb.mtd.gop.veccy.shapes.Shape;
import at.fhhgb.mtd.gop.veccy.view.BlockingTransformInputDialog;

public class TransformFeature implements NamedFeature {
    private CanvasModel model;
    private boolean selected = false;
    private DoubleLinkedList shapes;

    public TransformFeature(CanvasModel model, DoubleLinkedList shapes) {
        this.model = model;
        this.shapes = shapes;
    }

    @Override
    public String getName() {
        return "Transform";
    }

    @Override
    public void onSelect() {
        System.out.println("Selected Transform");
        selected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Deselected Transform");
        selected = false;
    }

    @Override
    public void onMouseClick(int i, int i1) {
        if (selected && shapes.get(model.getCurrentlySelectedShapeIndex()) != null) {
            Matrix3 transform = new Matrix3();
            TransformConfig config = BlockingTransformInputDialog.requestConfigInput();
            Shape translShape = shapes.get(model.getCurrentlySelectedShapeIndex());
            transform = (TransformFactory.createScaling(config.getScaleX(), config.getScaleY())).mult(transform);
            transform = (TransformFactory.createRotation(config.getRotation())).mult(transform);
            if (config.isMirrorX()) {
                transform = (TransformFactory.createHorizontalMirroring()).mult(transform);
            }
            if (config.isMirrorY()) {
                transform = (TransformFactory.createVerticalMirroring()).mult(transform);
            }
            translShape.setTransform(transform);
        }
    }

    @Override
    public void onMouseDrag(int x, int y) {
    }
}