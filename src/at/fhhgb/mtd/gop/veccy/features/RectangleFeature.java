package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.NamedFeature;

public class RectangleFeature implements NamedFeature {
    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public void onSelect() {
        System.out.println("Selected Rectangle");
    }

    @Override
    public void onDeselect() {
        System.out.println("Deselected Rectangle");
    }

    @Override
    public void onMouseClick(int i, int i1) {
        System.out.println(i);
        System.out.println(i1);
    }

    @Override
    public void onMouseDrag(int i, int i1) {
        System.out.println(i);
        System.out.println(i1);
    }
}
