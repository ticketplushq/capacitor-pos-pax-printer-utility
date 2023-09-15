export interface PaxPrinterUtility {
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
   * Print text string
   * @param Object<{text: string, charset: string}>
   * @returns Promise<void>
   */
  printStr({ text }: PrintStrArgs): Promise<void>;
  /**
   * Print base64 image (jpg) (in development)
   * @param Object<{image: string}>
   * @returns Primise<{status: number}>
   */
  printBase64Image({ image }: PrintBase64ImageArgs): Promise<StatusResp>;
  /**
   * Print receipt only
   * @param Object<{text: string, asciiFontType?:EFontTypeAscii, cFontType?: EFontTypeExtCode}>
   * @returns Primise<{status: number}>
   */
  printReceipt({ text }: PrintReceiptArgs): Promise<StatusResp>;
  /**
   * Print receipt and QR code content
   * @param Object<{text: string, qrString: string, asciiFontType?:EFontTypeAscii, cFontType?: EFontTypeExtCode}>
   * @returns Primise<{status: number}>
   */
  printReceiptWithQr({
    text,
    qrString,
  }: PrintReceiptWithQrArgs): Promise<StatusResp>;
  /**
   * Print QR code content,
   * optionally you can pass a text to print before and after QR code
   * @param Object<{qrString: string, startText?:string, endText?: string, asciiFontType?:EFontTypeAscii, cFontType?: EFontTypeExtCode}>
   * @returns Primise<{status: number}>
   */
  printQR({ qrString, startText, endText }: PrintQrArgs): Promise<StatusResp>;
  /**
   * Set printer cut mode,
   * remember that to use this method you must before started the printer instance,
   * @param Object<{mode: number}>
   * @returns Promise<{ok: boolean}>
   */
  cutPaper({ mode }: CutPaperMode): Promise<{ ok: boolean }>;
  /**
   * Get printer cut mode,
   * remember that to use this method you must before started the printer instance,
   * @returns Promise<{mode: number}>
   */
  getCutMode(): Promise<CutPaperMode>;
  /**
   * Get printer status,
   * remember that to use this method you must before started the printer instance,
   * @returns Promise<{status: number}>
   */
  getStatus(): Promise<StatusResp>;
  /**
   * Set print font
   * @param asciiFontType EFontTypeAscii
   * @param cFontType EFontTypeExtCode
   * @returns Promise<void>
   */
  fontSet(
    asciiFontType: EFontTypeAscii,
    cFontType: EFontTypeExtCode,
  ): Promise<void>;
  /**
   * Set printing font which is based on base font to double height.
   * @param isAscDouble If the single coding font is double height or not.
   * @param isLocalDouble If the multi coding font is double height or not.
   */
  doubleHeight(isAscDouble: boolean, isLocalDouble: boolean): Promise<void>;
  /**
   * Set printing font which is based on base font to double width.
   * @param isAscDouble If the single coding font is double width or not.
   * @param isLocalDouble If the multi coding font is double width or not.
   */
  doubleWidth(isAscDouble: boolean, isLocalDouble: boolean): Promise<void>;
}

/**
| Value       | Description                                        |
| ---------- | ------------------------------------------- |
| **`0`** | Success |
| **`1`** | Printer is busy |
| **`2`** | Out of paper |
| **`3`** | The format of print data packet error |
| **`4`** | Printer malfunctions |
| **`8`** | Printer over heats |
| **`9`** | Printer voltage is too low |
| **`-16`** | Printing is unfinished |
| **`-6`** | cut jam error(only support:E500,E800) |
| **`-5`** | cover open error(only support:E500,E800,SK600,SK800) |
| **`-4`** | The printer has not installed font library |
| **`-2`** | Data package is too long |
 */
export type StatusCodes = 0 | 1 | 2 | 3 | 4 | 8 | 9 | -16 | -6 | -5 | -4 | -2;

export interface StatusResp {
  status: StatusCodes;
}

export interface PrintStrArgs {
  text: string;
}

export interface PrintBase64ImageArgs {
  image: string;
}

export interface PrintReceiptArgs extends PrintOptionalArgs {
  text: string;
}

export interface PrintReceiptWithQrArgs extends PrintOptionalArgs {
  text: string;
  qrString: string | null;
}

export interface PrintQrArgs extends PrintOptionalArgs {
  qrString: string | null;
  startText: string | null;
  endText: string | null;
  asciiFontTypeEnd: EFontTypeAscii | null;
  cFontTypeEnd: EFontTypeExtCode | null;
}

export interface PrintOptionalArgs {
  asciiFontType: EFontTypeAscii | null;
  cFontType: EFontTypeExtCode | null;
}

export interface CutPaperMode {
  mode: CutMode;
}

/**
| Value       | Description                                        |
| ---------- | ------------------------------------------- |
| **`0`** | FULL_PAPER_CUTTING |
| **`1`** | PARTIAL_PAPER_CUTTING |
| **`2`** | FULL_AND_PARTIAL_PAPER_CUTTING |
| **`-1`** | NO_CUTTING_KNIFE_NOT_SUPPORTED |
 */
export type CutMode = 0 | 1 | 2 | -1;

export enum EFontTypeAscii {
  /**
   * 8x16 font (Basic)
   */
  FONT_8_16 = 'FONT_8_16',
  /**
   * 12x24 font (Basic)
   */
  FONT_12_24 = 'FONT_12_24',
  /**
   * 8x16 font (enlarge vertically)
   */
  FONT_8_32 = 'FONT_8_32',
  /**
   * 12x24 font (enlarge vertically)
   */
  FONT_12_48 = 'FONT_12_48',
  /**
   * 8x16 font (enlarge horizontally)
   */
  FONT_16_16 = 'FONT_16_16',
  /**
   * 12x24 font (enlarge horizontally)
   */
  FONT_24_24 = 'FONT_24_24',
  /**
   * 8x16 font (enlarge on both levels)
   */
  FONT_16_32 = 'FONT_16_32',
  /**
   * 12x24 font (enlarge on both levels)
   */
  FONT_24_48 = 'FONT_24_48',
}

export enum EFontTypeExtCode {
  /**
   * 16x16 font (Basic)
   */
  FONT_16_16 = 'FONT_16_16',
  /**
   * 24x24 font (Basic)
   */
  FONT_24_24 = 'FONT_24_24',
  /**
   * 16x16 font (enlarge vertically)
   */
  FONT_16_32 = 'FONT_16_32',
  /**
   * 24x24 font (enlarge vertically)
   */
  FONT_24_48 = 'FONT_24_48',
  /**
   * 16x16 font (enlarge horizontally)
   */
  FONT_32_16 = 'FONT_32_16',
  /**
   * 24x24 font (enlarge horizontally)
   */
  FONT_48_24 = 'FONT_48_24',
  /**
   * 16x16 font (enlarge on both levels)
   */
  FONT_32_32 = 'FONT_32_32',
  /**
   * 24x24 font (enlarge on both levels)
   */
  FONT_48_48 = 'FONT_48_48',
}
