/*
Copyright 01/04/2017 Eugeni Josep Senent i Gabriel

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/


package accordion.libs.xenione.com.accordion;

import android.graphics.Camera;
import android.graphics.Matrix;

/**
 * Helper class to apply transformation into Matrix
 *
 * @author Eugeni Senent
 */
public class MatrixHelper {

    private final Camera camera = new Camera();

    public MatrixHelper() {

    }

    public Matrix mirrorY() {
        Matrix matrix = new Matrix();
        rotateY(matrix, 180);
        return matrix;
    }

    public void rotateX(Matrix matrix, int alpha) {
        camera.save();
        camera.rotateX(alpha);
        camera.getMatrix(matrix);
        camera.restore();
    }

    public void rotateY(Matrix matrix, int alpha) {
        camera.save();
        camera.rotateY(alpha);
        camera.getMatrix(matrix);
        camera.restore();
    }

    public void rotateY(Matrix matrix, float alpha, float pivotX, float pivotY) {
        camera.save();
        camera.rotateY(alpha);
        camera.getMatrix(matrix);
        matrix.preTranslate(-pivotX, -pivotY);
        matrix.postTranslate(pivotX, pivotY);
        camera.restore();
    }

    public void rotateZ(Matrix matrix, int alpha) {
        camera.save();
        camera.rotateZ(alpha);
        camera.getMatrix(matrix);
        camera.restore();
    }

    public void translate(Matrix matrix, float dx, float dy, float dz) {
        camera.save();
        camera.translate(dx, dy, dz);
        camera.getMatrix(matrix);
        camera.restore();
    }

    public void translateY(Matrix matrix, float dy) {
        camera.save();
        camera.translate(0, dy, 0);
        camera.getMatrix(matrix);
        camera.restore();
    }

    public static void setTranslate(float x, float y, Matrix matrix) {
        float[] matrixElements = new float[9];
        matrix.getValues(matrixElements);
        matrixElements[2] = x;
        matrixElements[5] = y;
        matrix.setValues(matrixElements);
    }

    public static void setTranslate(float[] translate, Matrix matrix) {
        setTranslate(translate[0], translate[1], matrix);
    }

    public static float[] getTranslate(Matrix matrix) {
        float[] matrixElements = new float[9];
        matrix.getValues(matrixElements);
        return new float[]{matrixElements[2], matrixElements[5]};
    }

    public static void setScale(float sx, float sy, Matrix matrix) {
        float[] matrixElements = new float[9];
        matrix.getValues(matrixElements);
        matrixElements[0] = sx;
        matrixElements[4] = sy;
        matrix.setValues(matrixElements);
    }

    public static float getScaleX(Matrix matrix) {
        float[] matrixElements = new float[9];
        matrix.getValues(matrixElements);
        return matrixElements[0];
    }

    public static float getScaleY(Matrix matrix) {
        float[] matrixElements = new float[9];
        matrix.getValues(matrixElements);
        return matrixElements[4];
    }

    public static float[] getScale(Matrix matrix) {
        float[] matrixElements = new float[9];
        matrix.getValues(matrixElements);
        return new float[]{matrixElements[0], matrixElements[4]};
    }
}
