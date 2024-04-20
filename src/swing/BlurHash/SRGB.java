/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.BlurHash;

import swing.BlurHash.BlurHash.*;
import java.util.Arrays;

/*
    Copy trên github, blurhash4j
    Chức năng: Trong khi chờ load ảnh thì sẽ hiện trc 1 cái ảnh mờ,
               đó là hình ảnh được mã hóa bằng blurHash, chỉ tốn vài byte
 */
class SRGB {

    private static final double[] SRGB2LINEAR = new double[256];

    static {
        for (int i = 0; i < 256; i++) {
            double v = i / 255.0;
            if (v <= 0.04045) {
                SRGB2LINEAR[i] = v / 12.92;
            } else {
                SRGB2LINEAR[i] = Math.pow((v + 0.055) / 1.055, 2.4);
            }
        }
    }

    static double toLinear(int value) {
        if (value < 0) {
            return SRGB2LINEAR[0];
        } else if (value >= 256) {
            return SRGB2LINEAR[255];
        } else {
            return SRGB2LINEAR[value];
        }
    }

    static int fromLinear(double value) {
        int pos = Arrays.binarySearch(SRGB2LINEAR, value);
        if (pos < 0) {
            pos = ~pos;
        }
        if (pos < 0) {
            return 0;
        } else if (pos >= 256) {
            return 255;
        } else {
            return pos;
        }
    }
}
