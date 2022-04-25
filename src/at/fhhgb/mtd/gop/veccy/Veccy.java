package at.fhhgb.mtd.gop.veccy;

// Author Kareem Al-Khalily s2110238002 15.03.2022

import at.fhhgb.mtd.gop.veccy.features.*;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Polygon;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Veccy extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        VeccyGUI veccyGUI = new VeccyGUI(stage);
        CanvasModel model = veccyGUI.getModel();

        // Create Shapes here!
        // Add Shapes via model.addShape(someShape);

        model.addFeature(new RectangleFeature(model));
        model.addFeature(new CircleFeature(model));
        model.addFeature(new LineFeature(model));
        model.addFeature(new PointFeature(model));
        model.addFeature(new PolygonFeature(model));
        model.addFeature(new TextFeature(model));
        model.addFeature(new PathFeature(model));

        /*

        Rectangle rectangle = new Rectangle(50, 50, 20, 20);
        rectangle.setTransform(TransformFactory.createRotation(Math.PI/4));
        model.addShape(rectangle);

        Circle circle = new Circle(100, 100, 100);
        circle.setFillColor(Color.BROWN);
        circle.setTransform(TransformFactory.createScaling(2, 1).mult(TransformFactory.createTranslation(200, 100)));
        model.addShape(circle);

         */ //Polygon Showoff


//        Rectangle rectangle = new Rectangle(50, 50, 20, 20);
//        model.addShape(rectangle);
//
//        Circle circle = new Circle(100, 100, 10);
//        model.addShape(circle);


        /*
        for(int j = 0; j < 38; j++) {
            for(int i = 0; i < 29; i++) {
                Rectangle IteratedRectangle = new Rectangle(21 * j, 21 * i, 20, 20, Color.rgb(70+(2*i), 60, 40));
                model.addShape(IteratedRectangle);
            }
        }

        int iterations = 27;

        for(int i = 0; i < iterations; i++) {
            Rectangle IteratedRectangle = new Rectangle(30 * i, 10, 20, 2);
            model.addShape(IteratedRectangle);
        }

        for(int i = 0; i < iterations; i++) {
            Rectangle IteratedRectangle = new Rectangle(30 * i, 585, 20, 2);
            model.addShape(IteratedRectangle);
        }

        int iterations2 = 20;

        for(int i = 0; i < iterations2; i++) {
            if(i % 2 == 0){
                Circle IteratedCircle = new Circle(1 + (i*10), 100 + (i*10), 200 - (i*10), Color.rgb(150, 150, 0));
                model.addShape(IteratedCircle);
            }
            else {
                Circle IteratedCircle = new Circle(1 + (i*10), 100 + (i*10), 200 - (i*10));
                model.addShape(IteratedCircle);
            }
        }

        int iterations3 = 20;

        for(int f = 0; f < iterations3; f++) {

            int red = 10 + (f*15);
            if(red>255) {
                red = 255;
            }

            if(f % 2 == 0){
                Circle IteratedCircle = new Circle(400 + (f*10), 100 + (f*10), 200 - (f*10), Color.rgb(red, 150, 0));
                model.addShape(IteratedCircle);
            }
            else {
                Circle IteratedCircle = new Circle(400 + (f*10), 100 + (f*10), 200 - (f*10), Color.rgb(red, 150, 255));
                model.addShape(IteratedCircle);
            }
        }
        */ //Big artistic Test

    }
}