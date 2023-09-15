package global.ticketplus.capacitor_pos_pax_printer_utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;


public class ImageToBitmapUtil {

    public  static Bitmap base64ToBitmap(String base64String) {

        byte[] decodeString = Base64.decode(base64String, Base64.DEFAULT);

        Bitmap imageJPG = BitmapFactory.decodeByteArray(decodeString,0, decodeString.length);
        Bitmap imageBN = Bitmap.createBitmap(imageJPG.getWidth(), imageJPG.getHeight(), Bitmap.Config.ARGB_8888);

        for (int i = 0; i < imageJPG.getWidth(); i++) {
            for (int j = 0; j < imageJPG.getHeight(); j++) {
                int pixel = imageJPG.getPixel(i, j);
                int alpha = Color.alpha(pixel);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);

                if (red == 255 && green == 255 && blue == 255) {
                    imageBN.setPixel(i, j, Color.WHITE);
                } else if (red == 0 && green == 0 && blue == 0) {
                    imageBN.setPixel(i, j, Color.BLACK);
                } else if (alpha == 0) {
                    imageBN.setPixel(i, j, Color.WHITE);
                } else {
                    imageBN.setPixel(i, j, Color.BLACK);
                }
            }
        }

        return imageBN;
    }
}
