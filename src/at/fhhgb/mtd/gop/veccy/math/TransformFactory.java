package at.fhhgb.mtd.gop.veccy.math;

public class TransformFactory {

    public static Matrix3 createTranslation(int deltaX, int deltaY) {
        Matrix3 matrix3 = new Matrix3(new double[][]{{1, 0, deltaX}, {0, 1, deltaY}, {0, 0, 1}});
        return matrix3;
    }

    public static Matrix3 createRotation(double radians) {
        Matrix3 matrix3 = new Matrix3(new double[][]{{Math.cos(radians), -Math.sin(radians),0}, {Math.sin(radians), Math.cos(radians), 0}, {0, 0, 1}});
        return matrix3;
    }

    public static Matrix3 createHorizontalMirroring() {
        Matrix3 matrix3 = new Matrix3(new double[][]{{-1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
        return matrix3;
    }

    public static Matrix3 createVerticalMirroring() {
        Matrix3 matrix3 = new Matrix3(new double[][]{{1, 0, 0}, {0, -1, 0}, {0, 0, 1}});
        return matrix3;
    }

    public static Matrix3 createScaling(double factorX, double factorY) {
        Matrix3 matrix3 = new Matrix3(new double[][]{{factorX, 0, 0}, {0, factorY, 0}, {0, 0, 1}});
        return matrix3;
    }
}