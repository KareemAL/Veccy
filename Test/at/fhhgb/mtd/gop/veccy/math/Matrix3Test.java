package at.fhhgb.mtd.gop.veccy.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Matrix3Test {

    @Test
    void Matrix_Mult_test (){
        double [][] values = new double [][] {{1, 1, 2}, {1, 1, 1}, {1, 1, 1}};
        double [][] result = new double [][] {{4, 4, 5}, {3, 3, 4}, {3, 3, 4}};

        Matrix3 matrix1 = new Matrix3(values);
        Matrix3 matrix2 = new Matrix3(values);

        Matrix3 matrix_result = matrix1.mult(matrix2);

        assertTrue(Arrays.deepEquals(matrix_result.getValues(), result));

    }

    @Test
    void Vector_Mult_test () {
        double [][] values = new double [][] {{1, 1, 2}, {1, 1, 1}, {1, 1, 1}};
        double [] vector = new double[] {1, 2, 3};
        double [] result = new double [] {9, 6, 6};

        Matrix3 matrix1 = new Matrix3(values);
        Vector3 vector1 = new Vector3(vector);

        Vector3 vector_result = matrix1.mult(vector1);

        assertArrayEquals(vector_result.getValues(), result);
    }

}