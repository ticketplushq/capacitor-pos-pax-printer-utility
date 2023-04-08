export interface PaxPrinterUtilityPlugin {
  /**
   * Get printer and init instance
   * @returns Promise<{ok: boolean}>
   */
  init(): Promise<{ ok: boolean }>;
  /**
   * Run printer commands
   * @returns Promise<{status: number}>
   */
  start(): Promise<StatusResp>;
  /**
   * Print text string, remember that to use this method you must before started the printer instance,
   * after run started method.
   * @param Object<{text: string, charset: string}>
   * @returns Promise<void>
   */
  printStr({ text, charset }: PrintStrArgs): Promise<void>;
  /**
   * Print receipt only
   * @param Object<{text: string}>
   * @returns Primise<{status: number}>
   */
  printReceipt({ text }: PrintReceiptArgs): Promise<StatusResp>;
  /**
   * Print receipt and QR code content
   * @param Object<{text: string, qrString: string}>
   * @returns Primise<{status: number}>
   */
  printReceiptWithQr({
    text,
    qrString,
  }: PrintReceiptWithQrArgs): Promise<StatusResp>;
  /**
   * Print QR code content,
   * optionally you can pass a text to print before and after QR code
   * @param Object<{qrString: string, startText?:string, endText?: string}>
   * @returns Primise<{status: number}>
   */
  printQR({ qrString, startText, endText }: PrintQrArgs): Promise<StatusResp>;
  /**
   * Set printer cut mode,
   * remember that to use this method you must before started the printer instance,
   * @param Object<{mode: number}>
   * @returns Promise<{ok: boolean}>
   */
  cutPaper({ mode }: CutPaperArgs): Promise<{ ok: boolean }>;
  /**
   * Get printer status,
   * remember that to use this method you must before started the printer instance,
   * @returns Promise<{status: number}>
   */
  getStatus(): Promise<StatusResp>;
}

export type StatusCodes = 0 | 1 | 2 | 3 | 4 | 8 | 9 | -16 | -6 | -5 | -4 | -2;

export interface StatusResp {
  status: StatusCodes;
}

export interface PrintStrArgs {
  text: string;
  charset: string;
}

export interface PrintReceiptArgs {
  text: string;
}

export interface PrintReceiptWithQrArgs {
  text: string;
  qrString?: string;
}

export interface PrintQrArgs {
  qrString: string;
  startText?: string;
  endText?: string;
}

export type CutMode = 0 | 1 | 2 | -1;

export interface CutPaperArgs {
  mode: CutMode;
}
