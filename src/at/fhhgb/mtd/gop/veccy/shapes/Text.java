package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Text extends Shape{

    private String currentText;

    public Text(int x, int y) {
        super(x, y);
    }

    public void SetText (String Text){
        if (Text != null)
        this.currentText = Text;
    }

    public String GetText () {
        return currentText;
    }

    @Override
    public double[][] getCoordinates() {
        return new double[][] {{getX(), getX() + currentText.length() * 6},
                {getY(), getY() - 12}};
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Text @ ");
        sb.append(position.getValues()[0]);
        sb.append("/");
        sb.append(position.getValues()[1]);
        sb.append(" | ");
        sb.append(currentText);
        return sb.toString();
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.fillText(this.currentText, super.getX(), super.getY());
        graphicsContext.strokeText(this.currentText, super.getX(), super.getY());
    }
}