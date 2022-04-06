package at.fhhgb.mtd.gop.veccy.math;

public class Matrix3 {


    private double[][] values = new double[3][3];

    public Matrix3() {                       //Initialisiert values als Einheitsmatrix // 1.0 0.0 0.0 , 0.0 1.0 0.0 , 0.0 0.0 1.0
        this.values = new double[][] {{1.0, 0.0,0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0}};
    }

    public Matrix3(double[][] values) {     // Initialisiert this.values mit dem Parameter values (kopieren Sie die Werte!)
        this.values = values;
    }

    public Matrix3(Matrix3 matrix) {        // Initialisiert this.values mit den values aus dem Parameter matrix // (verwenden Sie this()!)
        this.values = matrix.getValues();
    }

    public Matrix3 mult(Matrix3 matrix) {   // Implementieren Sie eine Matrixmultiplikation und geben Sie eine neue Matrix3 // Instanz mit dem Ergebnis zurück
        double[][] other = matrix.getValues();
        double[][] result = new double[3][3];

        for(int i=0;i<3;i++) {

            for (int j = 0; j < 3; j++) {
                result[i][j] = 0;

                for (int k = 0; k < 3; k++) {
                    result[i][j] += this.values[i][k] * other[k][j];
                }                                       //end of k loop
            }
        }
        return new Matrix3(result);
    }

    public Vector3 mult(Vector3 vector) {   // Implementieren Sie eine Multiplikation Matrix3 * Vector3 und geben Sie eine // neue Vector3 Instanz mit dem Ergebnis zurück
        double [] vec = vector.getValues();
        double [] result = new double[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i] += this.values[i][j] * vec[j];
            }
        }
        return new Vector3(result);
    }

    public double[][] getValues() {         // Returniert die Instanzvariable values
        return this.values;
    }
}
