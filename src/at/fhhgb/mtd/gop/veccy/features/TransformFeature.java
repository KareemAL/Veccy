package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.data.DoubleLinkedList;
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

    TransformConfig config = BlockingTransformInputDialog.requestConfigInput();

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
            Shape translShape = shapes.get(model.getCurrentlySelectedShapeIndex());
            translShape.setTransform(TransformFactory.createRotation(config.getRotation()));
            translShape.setTransform(TransformFactory.createScaling(config.getScaleX(), config.getScaleY()));
            if (config.isMirrorX()) {
                translShape.setTransform(TransformFactory.createHorizontalMirroring());
            }
            if (config.isMirrorY()) {
                translShape.setTransform(TransformFactory.createVerticalMirroring());
            }
        }
        selected = false;
    }

    @Override
    public void onMouseDrag(int x, int y) {
    }
}