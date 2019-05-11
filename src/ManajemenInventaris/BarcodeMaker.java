package ManajemenInventaris;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import net.sourceforge.barbecue.*;
import net.sourceforge.barbecue.linear.code128.Code128Barcode;
import net.sourceforge.barbecue.output.OutputException;
import org.krysalis.barcode4j.*;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 *
 * @author Hafizh
 */
public class BarcodeMaker {

    static {
        System.out.println("Hello");
    }

    public static BufferedImage create128BBarcode(String msg) throws FileNotFoundException, IOException {
        Code128Bean code128Barcode = new Code128Bean();
        code128Barcode.setHeight(11d);
        final int dpi = 200;
//        code128Barcode.setModuleWidth(UnitConv.in2mm(1.0f / dpi));
//        code128Barcode.doQuietZone(false);
        OutputStream out = new FileOutputStream(new File("output.barcode"));
        BitmapCanvasProvider provider
                = new BitmapCanvasProvider(out, "image/x-png", dpi,
                        BufferedImage.TYPE_BYTE_GRAY,
                         false,
                        0);
        code128Barcode.generateBarcode(provider, msg);

        provider.finish();

        BufferedImage bufferedImage = provider.getBufferedImage();
        out.close();
        return bufferedImage;

    }

    public static Image createBarcodeImage(String string) throws net.sourceforge.barbecue.BarcodeException, OutputException {
        Barcode barcode = BarcodeFactory.createGlobalTradeItemNumber(string);
        BufferedImage bi = BarcodeImageHandler.getImage(barcode);
        Image imageBarcode = bi.getScaledInstance(barcode.getWidth(), barcode.getHeight(), Image.SCALE_SMOOTH);
        return imageBarcode;
    }
}
