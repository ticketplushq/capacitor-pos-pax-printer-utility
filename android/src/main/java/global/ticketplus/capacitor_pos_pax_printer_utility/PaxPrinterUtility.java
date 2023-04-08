package global.ticketplus.capacitor_pos_pax_printer_utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.pax.dal.IDAL;
import com.pax.dal.IPrinter;
import com.pax.dal.entity.EFontTypeAscii;
import com.pax.dal.entity.EFontTypeExtCode;
import com.pax.dal.exceptions.PrinterDevException;
import com.pax.neptunelite.api.NeptuneLiteUser;

public class PaxPrinterUtility {
    private Context _context;
    private static IDAL dal;
    private static IPrinter printer;

    public PaxPrinterUtility(Context context) {
        this._context = context;
    }

    public IDAL getDal() {
        if (dal == null) {
            try {
                dal = NeptuneLiteUser.getInstance().getDal(this._context);
                logPrint("GET DAL", "GET DAL");
            } catch (Exception e) {
                e.printStackTrace();
                logPrint("GET DAL", e);
            }
        }
        return dal;
    }

    public void init() {
        try {
            printer = getDal().getPrinter();
            printer.init();
            logPrint("INIT", "INIT");
        } catch (Exception e) {
            e.printStackTrace();
            logPrint("INIT", e);
        }
    }

    public int start() {
        int resp;
        try {
            resp = printer.start();
            logPrint("START", resp);
        } catch (PrinterDevException e) {
            e.printStackTrace();
            logPrint("START", e);
            //Native error plugin;
            resp = 404;
        }
        return resp;
    }

    public void printStr(String str, String charset) {
        try {
            printer.printStr(str, charset);
            logPrint("PRINT STR", "PRINT STR");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            logPrint("PRINT STR", e);
        }
    }

    public void printBitmap(Bitmap bitmap) {
        try {
            printer.printBitmap(bitmap);
            Log.i("PRINT BITMAP",  "PRINT BITMAP");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            logPrint("PRINT BITMAP", e);
        }
    }

    public void printBitmapFromString(String text, int width, int height) {
        try {
            QRCodeUtil qrcodeUtility = new QRCodeUtil();
            printer.printBitmap(qrcodeUtility.encodeAsBitmap(text, width, height ));
            Log.i("PRINT BITMAP STRING",  "PRINT BITMAP STRING");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            logPrint("PRINT BITMAP STRING", e);
        }
    }

    public void setGray(int level) {
        try {
            printer.setGray(level);
            logPrint("GRAY", level);
        } catch (PrinterDevException e) {
            e.printStackTrace();
            logPrint("PRINT STR", e);
        }
    }

    public void fontSet(String asciiFontTypeString, String cFontTypeString) {
        EFontTypeAscii asciiFontType = getGrayTypeAscii(asciiFontTypeString);
        EFontTypeExtCode cFontType = getGrayTypeExtCode(cFontTypeString);
        try {
            printer.fontSet(asciiFontType, cFontType);
            logPrint("SET FONT",  "SET FONT");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            logPrint("FONT", e);
        }

    }

    public void spaceSet(byte wordSpace, byte lineSpace) {
        try {
            printer.spaceSet(wordSpace, lineSpace);
            logPrint("SPACE SET",  "SPACE SET");
        } catch (PrinterDevException e) {
            e.printStackTrace();
            logPrint("SPACE SET", e);
        }
    }

    public void step(int b) {
        try {
            printer.step(b);
            logPrint("STEP",  "STEP: " + b);
        } catch (PrinterDevException e) {
            e.printStackTrace();
            logPrint("STEP", e);
        }
    }

    public boolean cutPaper(int mode) {
        try {
            printer.cutPaper(mode);
            logPrint("CUT PAPER",  "CUT PAPER");
            return true;
        } catch (PrinterDevException e) {
            e.printStackTrace();
            logPrint("CUT PAPER", e);
            return false;
        }
    }

    public int getStatus() {
        try {
            int status = printer.getStatus();
            logPrint("GET STATUS",  status);
            return status;
        } catch (PrinterDevException e) {
            e.printStackTrace();
            logPrint("GET STATUS", e);
            return 404;
        }
    }

    private EFontTypeAscii  getGrayTypeAscii(String asciiFontTypeString) {
        if (asciiFontTypeString.equals("FONT_8_16")) {
            return EFontTypeAscii.FONT_8_16;
        }else if (asciiFontTypeString.equals("FONT_12_24")) {
            return EFontTypeAscii.FONT_12_24;
        }else if (asciiFontTypeString.equals("FONT_8_32")) {
            return EFontTypeAscii.FONT_8_32;
        }else if (asciiFontTypeString.equals("FONT_12_48")) {
            return EFontTypeAscii.FONT_12_48;
        }else if (asciiFontTypeString.equals("FONT_16_16")) {
            return EFontTypeAscii.FONT_16_16;
        }else if (asciiFontTypeString.equals("FONT_24_24")) {
            return EFontTypeAscii.FONT_24_24;
        }else if (asciiFontTypeString.equals("FONT_16_32")) {
            return EFontTypeAscii.FONT_16_32;
        }else if (asciiFontTypeString.equals("FONT_24_48")) {
            return EFontTypeAscii.FONT_24_48;
        } else {
            return EFontTypeAscii.FONT_8_16;
        }
    }

    private EFontTypeExtCode getGrayTypeExtCode(String cFontTypeString) {
        if (cFontTypeString.equals("FONT_16_16")) {
            return EFontTypeExtCode.FONT_16_16;
        } else if (cFontTypeString.equals("FONT_24_24")) {
            return EFontTypeExtCode.FONT_24_24;
        }else if (cFontTypeString.equals("FONT_16_32")) {
            return EFontTypeExtCode.FONT_16_32;
        }else if (cFontTypeString.equals("FONT_24_48")) {
            return EFontTypeExtCode.FONT_24_48;
        }else if (cFontTypeString.equals("FONT_48_24")) {
            return EFontTypeExtCode.FONT_48_24;
        }else if (cFontTypeString.equals("FONT_32_32")) {
            return EFontTypeExtCode.FONT_32_32;
        }else if (cFontTypeString.equals("FONT_48_48")) {
            return EFontTypeExtCode.FONT_48_48;
        } else {
            return EFontTypeExtCode.FONT_16_16;
        }
    }

    private static <T> void logPrint(String tag, T msg) {
        Log.i(tag, String.valueOf(msg));
    }

}
