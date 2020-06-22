import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BarcodeUtilities {

    /**
     * Take a QR code file and return the data the qr code has. This is based on
     * "callicoder.com/qr-code-reader-scanner-in-java-using-zxing/"
     * 
     * @param qrCodeimage QR code to decode
     * @return Data from QR code
     * @throws IOException
     */
    public static String decodeQRCode(File qrCodeimage) {

        /**
         * Read and process QR code for decoding
         */
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(qrCodeimage);
        } catch (IOException e1) {
            System.err.println("Could not read file");
            System.exit(-1);
        }
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        /**
         * Try to decode the QR code
         */
        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            System.out.println("Could not find a QR code in the image");
            return null;
        }
    }

    /**
     * Take a QR code file location and return the data the qr code has. This is
     * based on "callicoder.com/qr-code-reader-scanner-in-java-using-zxing/"
     * 
     * @param qrCodeimage QR code to decode
     * @return Data from QR code
     * @throws IOException
     */
    public static String decodeQRCode(String qrCodeLocation) {

        File qrCodeimage = new File(qrCodeLocation);

        /**
         * Read and process QR code for decoding
         */
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(qrCodeimage);
        } catch (IOException e1) {
            System.err.println("Could not read file");
            System.exit(-1);
        }
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        /**
         * Try to decode the QR code
         */
        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            System.out.println("Could not find a QR code in the image");
            return null;
        }
    }
}