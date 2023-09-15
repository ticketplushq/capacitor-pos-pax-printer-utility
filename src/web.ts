import { WebPlugin } from '@capacitor/core';

import type {
  CutMode,
  CutPaperMode,
  EFontTypeAscii,
  EFontTypeExtCode,
  PaxPrinterUtility,
  PrintBase64ImageArgs,
  PrintQrArgs,
  PrintReceiptArgs,
  PrintReceiptWithQrArgs,
  PrintStrArgs,
  StatusResp,
} from './definitions';

export class PaxPrinterUtilityWeb
  extends WebPlugin
  implements PaxPrinterUtility
{
  cutMode: CutMode = 0;

  async init(): Promise<{ ok: boolean }> {
    console.log('PAX PRINTER: INIT');
    return { ok: true };
  }

  async start(): Promise<StatusResp> {
    console.log('PAX PRINTER: START');
    return { status: 0 };
  }

  async printStr(args: PrintStrArgs): Promise<void> {
    console.log('PAX PRINTER: PRINT STR ', args);
  }

  async printBase64Image(args: PrintBase64ImageArgs): Promise<StatusResp> {
    console.log('PAX PRINTER: PRINT BASE64 IMAGE ', args);
    return { status: 0 };
  }

  async printReceipt(args: PrintReceiptArgs): Promise<StatusResp> {
    console.log('PAX PRINTER: PRINT RECEIPT ', args);
    return { status: 0 };
  }

  async printReceiptWithQr(args: PrintReceiptWithQrArgs): Promise<StatusResp> {
    console.log('PAX PRINTER: PRINT RECEIPT WITH QR ', args);
    return { status: 0 };
  }

  async printQR(args: PrintQrArgs): Promise<StatusResp> {
    console.log('PAX PRINTER: PRINT QR ', args);
    return { status: 0 };
  }

  async cutPaper(args: CutPaperMode): Promise<{ ok: boolean }> {
    console.log('PAX PRINTER: CUT PAPER ', args);
    this.cutMode = args.mode;
    return { ok: true };
  }

  async getCutMode(): Promise<CutPaperMode> {
    console.log('PAX PRINTER: GET CUT PAPER ', { mode: this.cutMode });
    return { mode: this.cutMode };
  }

  async getStatus(): Promise<StatusResp> {
    console.log('PAX PRINTER: GET STATUS');
    return { status: 0 };
  }

  async fontSet(
    asciiFontType: EFontTypeAscii,
    cFontType: EFontTypeExtCode,
  ): Promise<void> {
    console.log('PAX PRINTER: FONT SET', { asciiFontType, cFontType });
  }

  async doubleHeight(
    isAscDouble: boolean,
    isLocalDouble: boolean,
  ): Promise<void> {
    console.log('PAX PRINTER: DOUBLE HEIGHT', { isAscDouble, isLocalDouble });
  }

  async doubleWidth(
    isAscDouble: boolean,
    isLocalDouble: boolean,
  ): Promise<void> {
    console.log('PAX PRINTER: DOUBLE WIDTH', { isAscDouble, isLocalDouble });
  }
}
