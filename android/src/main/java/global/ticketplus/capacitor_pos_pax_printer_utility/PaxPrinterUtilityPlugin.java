package global.ticketplus.capacitor_pos_pax_printer_utility;

import android.Manifest;
import android.content.Context;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;


@CapacitorPlugin(
        name = "PaxPrinterUtilityPlugin",
        permissions = {
                @Permission(
                      alias = "printer",
                      strings = {
                              "com.pax.permission.PRINTER"
                      }
                ),
                @Permission(
                        alias = "internet",
                        strings = {
                                Manifest.permission.INTERNET
                        }
                ),
                @Permission(
                        alias = "storage",
                        strings = {
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        }
                )
        }
)
public class PaxPrinterUtilityPlugin extends Plugin {
    private Context _context;
    private PaxPrinterUtility printerUtility;
    private static QRCodeUtil qrcodeUtility = new QRCodeUtil();

   @Override
   public void load() {
       this._context = getContext();
       printerUtility = new PaxPrinterUtility(this._context);
   }

   @PluginMethod
   public void init(PluginCall call) {
       JSObject resp = new JSObject();
       printerUtility.getDal();
       printerUtility.init();

       resp.put("ok", true);
       call.resolve(resp);
   }
   @PluginMethod
   public void start(PluginCall call) {

       JSObject resp = new JSObject();
       final int status = printerUtility.start();
       resp.put("status", status);
       call.resolve(resp);
   }

   @PluginMethod
   public void printStr(PluginCall call) {
       String text = call.getString("text");

       //Optional
       String asciiFontType = call.getString("asciiFontType");
       String cFontType = call.getString("cFontType");

       JSObject resp = new JSObject();

       //Init printer
       printerUtility.getDal();
       printerUtility.init();
       configDefault(asciiFontType, cFontType);

       //Print text
       printerUtility.printStr(text, null);
       printerUtility.printStr("", null);
       printerUtility.step(150);

       //Get Status
       final int status = printerUtility.start();
       resp.put("status", status);
       //response
       call.resolve(resp);
   }

    @PluginMethod
    public void printBase64Image(PluginCall call) {
        String image = call.getString("image");

        JSObject resp = new JSObject();

        //Init printer
        printerUtility.getDal();
        printerUtility.init();

        //Print image
        if(image != null) {
            printerUtility.printBitmap(ImageToBitmapUtil.base64ToBitmap(image));
            printerUtility.printStr("\n", null);
        }
        printerUtility.step(150);

        //Get Status
        final int status = printerUtility.start();
        resp.put("status", status);
        //response
        call.resolve(resp);
    }

   @PluginMethod
   public void printReceipt(PluginCall call) {
       String text = call.getString("text");

       //Optional
       String asciiFontType = call.getString("asciiFontType");
       String cFontType = call.getString("cFontType");

       JSObject resp = new JSObject();

       printerUtility.getDal();
       printerUtility.init();
       configDefault(asciiFontType, cFontType);
       printerUtility.printStr(text, null);
       printerUtility.printStr("", null);
       printerUtility.step(150);
       final int status = printerUtility.start();
       resp.put("status", status);
       call.resolve(resp);
   }
   @PluginMethod
   public void printReceiptWithQr(PluginCall call){
       String text = call.getString("text");
       String qrString = call.getString("qrString");

       //Optional
       String asciiFontType = call.getString("asciiFontType");
       String cFontType = call.getString("cFontType");

       JSObject resp = new JSObject();

       printerUtility.getDal();
       printerUtility.init();
       configDefault(asciiFontType, cFontType);
       printerUtility.printStr(text, null);
       printerUtility.printStr("", null);
       if(qrString != null) {
           printerUtility.printBitmap(qrcodeUtility.encodeAsBitmap(qrString, 512, 512));
           printerUtility.printStr("", null);
       }
       printerUtility.step(150);
       final int status = printerUtility.start();
       resp.put("status", status);
       call.resolve(resp);
   }

   @PluginMethod
   public  void printQR(PluginCall call){

       //Optional
       String text = call.getString("text");
       String qrString = call.getString("qrString");
       String startText = call.getString("startText");
       String endText = call.getString("endText");
       String asciiFontType = call.getString("asciiFontType");
       String cFontType = call.getString("cFontType");
       String asciiFontTypeEnd = call.getString("asciiFontTypeEnd");
       String cFontTypeEnd = call.getString("cFontTypeEnd");

       JSObject resp = new JSObject();

       printerUtility.getDal();
       printerUtility.init();

       //Print Text
       if(asciiFontTypeEnd != null) {
           configDefault(asciiFontTypeEnd, cFontTypeEnd);
       }
       if(text != null){
           printerUtility.printStr(text, null);
           printerUtility.printStr("", null);
       }

       //Print startText
       if(asciiFontType != null){
           configDefault(asciiFontType, cFontType);
       }
       if(startText != null){
           printerUtility.printStr(startText, null);
           printerUtility.printStr("\n", null);
       }

       //Print endText
       if(asciiFontTypeEnd != null) {
           configDefault(asciiFontTypeEnd, cFontTypeEnd);
       }
       if(endText != null){
           printerUtility.printStr(endText, null);
           printerUtility.printStr("", null);
       }


       //Print QR
       if(qrString != null) {
           printerUtility.printBitmap(qrcodeUtility.encodeAsBitmap(qrString, 512, 512));
           printerUtility.printStr("", null);
       }
       printerUtility.step(150);

       final int status = printerUtility.start();
       resp.put("status", status);
       call.resolve(resp);
   }

   @PluginMethod
   public  void cutPaper(PluginCall call) {
       int mode = call.getInt("mode");
       JSObject resp = new JSObject();
       printerUtility.getDal();
       printerUtility.init();
       boolean ok = printerUtility.cutPaper(mode);
       resp.put("ok", ok);
       call.resolve(resp);
   }

   @PluginMethod
   public  void getCutMode(PluginCall call) {
       JSObject resp = new JSObject();

       int mode = printerUtility.getCutMode();
       resp.put("mode", mode);
       call.resolve(resp);
   }

   @PluginMethod
   public  void getStatus(PluginCall call) {
       JSObject resp = new JSObject();

       printerUtility.getDal();
       printerUtility.init();
       int status = printerUtility.getStatus();
       resp.put("status", status);
       call.resolve(resp);
   }

   @PluginMethod
   public  void fontSet(PluginCall call) {
       String asciiFontType = call.getString("asciiFontType");
       String cFontType = call.getString("cFontType");
       printerUtility.fontSet(asciiFontType, cFontType);
       call.resolve();
   }
   @PluginMethod
   public void doubleHeight(PluginCall call) {
       boolean isAscDouble = call.getBoolean("isAscDouble");
       boolean isLocalDouble = call.getBoolean("isLocalDouble");
       printerUtility.doubleHeight(isAscDouble, isLocalDouble);
       call.resolve();
   }

   @PluginMethod
   public void doubleWidth(PluginCall call) {
       boolean isAscDouble = call.getBoolean("isAscDouble");
       boolean isLocalDouble = call.getBoolean("isLocalDouble");
       printerUtility.doubleWidth(isAscDouble, isLocalDouble);
       call.resolve();
   }

    private void configDefault(String asciiFontType, String cFontType ) {
       printerUtility.fontSet(asciiFontType,cFontType);
       printerUtility.spaceSet(Byte.parseByte("0"), Byte.parseByte("10"));
       printerUtility.setGray(1);
    }


}
