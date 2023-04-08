package global.ticketplus.capacitor_pos_pax_printer_utility;

import android.content.Context;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;


@CapacitorPlugin(name = "PaxPrinterUtilityPlugin")
public class PaxPrinterUtilityPlugin extends Plugin {
    private Context _context;
    private PaxPrinterUtility printerUtility;
    private static QRCodeUtil qrcodeUtility = new QRCodeUtil();
   public  PaxPrinterUtilityPlugin() {
       super();
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
       String charset = call.getString("charset");
       JSObject ret = new JSObject();
       printerUtility.printStr(text, charset);
       call.resolve();
   }

   @PluginMethod
   public void printReceipt(PluginCall call) {
       String text = call.getString("text");
       JSObject resp = new JSObject();

       printerUtility.getDal();
       printerUtility.init();
       configDefault();
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
       JSObject resp = new JSObject();

       printerUtility.getDal();
       printerUtility.init();
       configDefault();
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
   public  void cutPaper(PluginCall call) {
       int mode = call.getInt("mode");
       JSObject resp = new JSObject();

       boolean ok = printerUtility.cutPaper(mode);
       resp.put("ok", ok);
       call.resolve(resp);
   }

    private void configDefault() {
       printerUtility.fontSet("FONT_8_16","FONT_16_16");
       printerUtility.spaceSet(Byte.parseByte("0"), Byte.parseByte("10"));
       printerUtility.setGray(1);
    }


}
