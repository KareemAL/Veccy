package at.fhhgb.mtd.gop.veccy.math;

// Author Kareem Al-Khalily s2110238002 16.03.2022

public class Vector3 {
    private double[] values = new double[3];

    public Vector3() {                       // Initialisiert values mit { 0.0, 0.0, 1.0 }
        this.values [0] = 0.0;
        this.values [1] = 0.0;
        this.values [2] = 1.0;
    }

    public Vector3(double[] values) {       // Initialisiert this.values mit dem Parameter values (kopieren Sie die Werte!)
        this.values = values;
    }

    public Vector3(Vector3 vector) {        // Initialisiert this.values mit den values aus dem Parameter vector (verwenden Sie this()!)
        this.values = vector.values;
    }

    public double[] getValues() {           // Returniert die Instanzvariable values
        return values;
    }
}
