package ir.logicbase.circularbitmapshader;

import android.graphics.*;
import android.widget.ImageView;

public class CircularBitmapShader {
    private Bitmap srcBitmap;
    private int shadowSize = 36;
    private int shadowColor = RandomColor.generateBrightColor();
    private boolean autoGenerateColor = true;

    public CircularBitmapShader(Bitmap srcBitmap) {
        this.srcBitmap = srcBitmap;
    }

    /**
     * @param shadowSize default is 36
     */
    public CircularBitmapShader setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        return this;
    }

    /**
     * @param shadowColor argb color eg. Color.argb(alpha, red, green, blue);
     */
    public CircularBitmapShader setShadowColor(int shadowColor) {
        this.shadowColor = shadowColor;
        return this;
    }

    /**
     * @param autoGenerateColor true if you want to automatically generate new color for next into() method call
     */
    public CircularBitmapShader setAutoGenerateColor(boolean autoGenerateColor) {
        this.autoGenerateColor = autoGenerateColor;
        return this;
    }

    public CircularBitmapShader regenerateShadowColor() {
        this.shadowColor = RandomColor.generateBrightColor();
        return this;
    }

    public CircularBitmapShader into(ImageView imageView) {
        imageView.setImageBitmap(generateBitmap());
        if (autoGenerateColor) {
            regenerateShadowColor();
        }
        return this;
    }

    public Bitmap generateBitmap() {
        // Calculate the circular bitmap width with shadow
        int dstBitmapWidth = srcBitmap.getWidth() + shadowSize * 2;
        Bitmap dstBitmap = Bitmap.createBitmap(dstBitmapWidth, dstBitmapWidth, Bitmap.Config.ARGB_8888);

        // Initialize a new Canvas instance
        Canvas canvas = new Canvas(dstBitmap);
        float canvasCenterX = canvas.getWidth() / 2f;
        float canvasCenterY = canvas.getHeight() / 2f;
        float radius = (dstBitmapWidth / 2f) - (shadowSize / 2f);

        // Gradient from circle inside to circle edge
        RadialGradient gradient = new RadialGradient(canvasCenterX, canvasCenterY, radius, shadowColor,
                Color.TRANSPARENT, Shader.TileMode.CLAMP);

        // Paint to draw circular bitmap shadow
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(gradient);

        // Draw the shadow around circular bitmap
        canvas.drawCircle(canvasCenterX, canvasCenterY, radius, paint);

        // Draw destination bitmap
        canvas.drawBitmap(srcBitmap, shadowSize, shadowSize, null);

        // Return the circular bitmap with shadow
        return dstBitmap;
    }

    public void recycleSrcBitmap() {
        this.srcBitmap.recycle();
    }
}