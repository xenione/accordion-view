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

package com.xenione.accordion;

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
}
