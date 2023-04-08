import { WebPlugin } from '@capacitor/core';

import type {
  CutPaperArgs,
  PaxPrinterUtilityPlugin,
  PrintQrArgs,
  PrintReceiptArgs,
  PrintReceiptWithQrArgs,
  PrintStrArgs,
  StatusResp,
} from './definitions';

export class PaxPrinterUtilityPluginWeb
  extends WebPlugin
  implements PaxPrinterUtilityPlugin
{
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

  async cutPaper(args: CutPaperArgs): Promise<{ ok: boolean }> {
    console.log('PAX PRINTER: CUT PAPER ', args);
    return { ok: true };
  }

  async getStatus(): Promise<StatusResp> {
    console.log('PAX PRINTER: GET STATUS');
    return { status: 0 };
  }
}
