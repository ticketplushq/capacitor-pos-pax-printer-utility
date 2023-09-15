# @ticketplushq/capacitor-pos-pax-printer-utility

Printer integration for PAX payment POS, Android support.

In web context it behaves like a mock that returns successful execution results.

When executed in the emulator or on a device other than the POS, it will generate an error that will stop the application. This is due to the lack of installation of the [NeptuneService](https://docs.hips.com/docs/pax-a920) app. At the moment, it has not been possible to install [NeptuneService](https://docs.hips.com/docs/pax-a920) on a device other than POS but work is being done to achieve it.

## Permissions

Adding permissions in the AndroidManifest.xml file

```xml
<uses-permission android:name="com.pax.permission.PRINTER"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```

## Install

```bash
npm install @ticketplushq/capacitor-pos-pax-printer-utility
npx cap sync
```

## API

<docgen-index>

* [`init()`](#init)
* [`start()`](#start)
* [`printStr(...)`](#printstr)
* [`printBase64Image(...)`](#printbase64image)
* [`printReceipt(...)`](#printreceipt)
* [`printReceiptWithQr(...)`](#printreceiptwithqr)
* [`printQR(...)`](#printqr)
* [`cutPaper(...)`](#cutpaper)
* [`getCutMode()`](#getcutmode)
* [`getStatus()`](#getstatus)
* [`fontSet(...)`](#fontset)
* [`doubleHeight(...)`](#doubleheight)
* [`doubleWidth(...)`](#doublewidth)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)
* [Enums](#enums)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### init()

```typescript
init() => Promise<{ ok: boolean; }>
```

Get printer and init instance

**Returns:** <code>Promise&lt;{ ok: boolean; }&gt;</code>

--------------------


### start()

```typescript
start() => Promise<StatusResp>
```

Run printer commands

**Returns:** <code>Promise&lt;<a href="#statusresp">StatusResp</a>&gt;</code>

--------------------


### printStr(...)

```typescript
printStr({ text }: PrintStrArgs) => Promise<void>
```

Print text string

| Param     | Type                                                  | Description                             |
| --------- | ----------------------------------------------------- | --------------------------------------- |
| **`__0`** | <code><a href="#printstrargs">PrintStrArgs</a></code> | &lt;{text: string, charset: string}&gt; |

--------------------


### printBase64Image(...)

```typescript
printBase64Image({ image }: PrintBase64ImageArgs) => Promise<StatusResp>
```

Print base64 image (jpg) (in development)

| Param     | Type                                                                  | Description             |
| --------- | --------------------------------------------------------------------- | ----------------------- |
| **`__0`** | <code><a href="#printbase64imageargs">PrintBase64ImageArgs</a></code> | &lt;{image: string}&gt; |

**Returns:** <code>Promise&lt;<a href="#statusresp">StatusResp</a>&gt;</code>

--------------------


### printReceipt(...)

```typescript
printReceipt({ text }: PrintReceiptArgs) => Promise<StatusResp>
```

Print receipt only

| Param     | Type                                                          | Description                                                                                                                                       |
| --------- | ------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`__0`** | <code><a href="#printreceiptargs">PrintReceiptArgs</a></code> | &lt;{text: string, asciiFontType?:<a href="#efonttypeascii">EFontTypeAscii</a>, cFontType?: <a href="#efonttypeextcode">EFontTypeExtCode</a>}&gt; |

**Returns:** <code>Promise&lt;<a href="#statusresp">StatusResp</a>&gt;</code>

--------------------


### printReceiptWithQr(...)

```typescript
printReceiptWithQr({ text, qrString, }: PrintReceiptWithQrArgs) => Promise<StatusResp>
```

Print receipt and QR code content

| Param     | Type                                                                      | Description                                                                                                                                                         |
| --------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`__0`** | <code><a href="#printreceiptwithqrargs">PrintReceiptWithQrArgs</a></code> | &lt;{text: string, qrString: string, asciiFontType?:<a href="#efonttypeascii">EFontTypeAscii</a>, cFontType?: <a href="#efonttypeextcode">EFontTypeExtCode</a>}&gt; |

**Returns:** <code>Promise&lt;<a href="#statusresp">StatusResp</a>&gt;</code>

--------------------


### printQR(...)

```typescript
printQR({ qrString, startText, endText }: PrintQrArgs) => Promise<StatusResp>
```

Print QR code content,
optionally you can pass a text to print before and after QR code

| Param     | Type                                                | Description                                                                                                                                                                                |
| --------- | --------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **`__0`** | <code><a href="#printqrargs">PrintQrArgs</a></code> | &lt;{qrString: string, startText?:string, endText?: string, asciiFontType?:<a href="#efonttypeascii">EFontTypeAscii</a>, cFontType?: <a href="#efonttypeextcode">EFontTypeExtCode</a>}&gt; |

**Returns:** <code>Promise&lt;<a href="#statusresp">StatusResp</a>&gt;</code>

--------------------


### cutPaper(...)

```typescript
cutPaper({ mode }: CutPaperMode) => Promise<{ ok: boolean; }>
```

Set printer cut mode,
remember that to use this method you must before started the printer instance,

| Param     | Type                                                  | Description            |
| --------- | ----------------------------------------------------- | ---------------------- |
| **`__0`** | <code><a href="#cutpapermode">CutPaperMode</a></code> | &lt;{mode: number}&gt; |

**Returns:** <code>Promise&lt;{ ok: boolean; }&gt;</code>

--------------------


### getCutMode()

```typescript
getCutMode() => Promise<CutPaperMode>
```

Get printer cut mode,
remember that to use this method you must before started the printer instance,

**Returns:** <code>Promise&lt;<a href="#cutpapermode">CutPaperMode</a>&gt;</code>

--------------------


### getStatus()

```typescript
getStatus() => Promise<StatusResp>
```

Get printer status,
remember that to use this method you must before started the printer instance,

**Returns:** <code>Promise&lt;<a href="#statusresp">StatusResp</a>&gt;</code>

--------------------


### fontSet(...)

```typescript
fontSet(asciiFontType: EFontTypeAscii, cFontType: EFontTypeExtCode) => Promise<void>
```

Set print font

| Param               | Type                                                          | Description                                      |
| ------------------- | ------------------------------------------------------------- | ------------------------------------------------ |
| **`asciiFontType`** | <code><a href="#efonttypeascii">EFontTypeAscii</a></code>     | <a href="#efonttypeascii">EFontTypeAscii</a>     |
| **`cFontType`**     | <code><a href="#efonttypeextcode">EFontTypeExtCode</a></code> | <a href="#efonttypeextcode">EFontTypeExtCode</a> |

--------------------


### doubleHeight(...)

```typescript
doubleHeight(isAscDouble: boolean, isLocalDouble: boolean) => Promise<void>
```

Set printing font which is based on base font to double height.

| Param               | Type                 | Description                                        |
| ------------------- | -------------------- | -------------------------------------------------- |
| **`isAscDouble`**   | <code>boolean</code> | If the single coding font is double height or not. |
| **`isLocalDouble`** | <code>boolean</code> | If the multi coding font is double height or not.  |

--------------------


### doubleWidth(...)

```typescript
doubleWidth(isAscDouble: boolean, isLocalDouble: boolean) => Promise<void>
```

Set printing font which is based on base font to double width.

| Param               | Type                 | Description                                       |
| ------------------- | -------------------- | ------------------------------------------------- |
| **`isAscDouble`**   | <code>boolean</code> | If the single coding font is double width or not. |
| **`isLocalDouble`** | <code>boolean</code> | If the multi coding font is double width or not.  |

--------------------


### Interfaces


#### StatusResp

| Prop         | Type                                                |
| ------------ | --------------------------------------------------- |
| **`status`** | <code><a href="#statuscodes">StatusCodes</a></code> |


#### PrintStrArgs

| Prop       | Type                |
| ---------- | ------------------- |
| **`text`** | <code>string</code> |


#### PrintBase64ImageArgs

| Prop        | Type                |
| ----------- | ------------------- |
| **`image`** | <code>string</code> |


#### PrintReceiptArgs

| Prop       | Type                |
| ---------- | ------------------- |
| **`text`** | <code>string</code> |


#### PrintReceiptWithQrArgs

| Prop           | Type                        |
| -------------- | --------------------------- |
| **`text`**     | <code>string</code>         |
| **`qrString`** | <code>string \| null</code> |


#### PrintQrArgs

| Prop                   | Type                                                                  |
| ---------------------- | --------------------------------------------------------------------- |
| **`qrString`**         | <code>string \| null</code>                                           |
| **`startText`**        | <code>string \| null</code>                                           |
| **`endText`**          | <code>string \| null</code>                                           |
| **`asciiFontTypeEnd`** | <code><a href="#efonttypeascii">EFontTypeAscii</a> \| null</code>     |
| **`cFontTypeEnd`**     | <code><a href="#efonttypeextcode">EFontTypeExtCode</a> \| null</code> |


#### CutPaperMode

| Prop       | Type                                        |
| ---------- | ------------------------------------------- |
| **`mode`** | <code><a href="#cutmode">CutMode</a></code> |


### Type Aliases


#### StatusCodes

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

<code>0 | 1 | 2 | 3 | 4 | 8 | 9 | -16 | -6 | -5 | -4 | -2</code>


#### CutMode

| Value       | Description                                        |
| ---------- | ------------------------------------------- |
| **`0`** | FULL_PAPER_CUTTING |
| **`1`** | PARTIAL_PAPER_CUTTING |
| **`2`** | FULL_AND_PARTIAL_PAPER_CUTTING |
| **`-1`** | NO_CUTTING_KNIFE_NOT_SUPPORTED |

<code>0 | 1 | 2 | -1</code>


### Enums


#### EFontTypeAscii

| Members          | Value                     | Description                         |
| ---------------- | ------------------------- | ----------------------------------- |
| **`FONT_8_16`**  | <code>'FONT_8_16'</code>  | 8x16 font (Basic)                   |
| **`FONT_12_24`** | <code>'FONT_12_24'</code> | 12x24 font (Basic)                  |
| **`FONT_8_32`**  | <code>'FONT_8_32'</code>  | 8x16 font (enlarge vertically)      |
| **`FONT_12_48`** | <code>'FONT_12_48'</code> | 12x24 font (enlarge vertically)     |
| **`FONT_16_16`** | <code>'FONT_16_16'</code> | 8x16 font (enlarge horizontally)    |
| **`FONT_24_24`** | <code>'FONT_24_24'</code> | 12x24 font (enlarge horizontally)   |
| **`FONT_16_32`** | <code>'FONT_16_32'</code> | 8x16 font (enlarge on both levels)  |
| **`FONT_24_48`** | <code>'FONT_24_48'</code> | 12x24 font (enlarge on both levels) |


#### EFontTypeExtCode

| Members          | Value                     | Description                         |
| ---------------- | ------------------------- | ----------------------------------- |
| **`FONT_16_16`** | <code>'FONT_16_16'</code> | 16x16 font (Basic)                  |
| **`FONT_24_24`** | <code>'FONT_24_24'</code> | 24x24 font (Basic)                  |
| **`FONT_16_32`** | <code>'FONT_16_32'</code> | 16x16 font (enlarge vertically)     |
| **`FONT_24_48`** | <code>'FONT_24_48'</code> | 24x24 font (enlarge vertically)     |
| **`FONT_32_16`** | <code>'FONT_32_16'</code> | 16x16 font (enlarge horizontally)   |
| **`FONT_48_24`** | <code>'FONT_48_24'</code> | 24x24 font (enlarge horizontally)   |
| **`FONT_32_32`** | <code>'FONT_32_32'</code> | 16x16 font (enlarge on both levels) |
| **`FONT_48_48`** | <code>'FONT_48_48'</code> | 24x24 font (enlarge on both levels) |

</docgen-api>
