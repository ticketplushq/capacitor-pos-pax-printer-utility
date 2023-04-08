# @ticketplushq/capacitor-pos-pax-printer-utility

Integration to POS pax printer

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
* [`printReceipt(...)`](#printreceipt)
* [`printReceiptWithQr(...)`](#printreceiptwithqr)
* [`printQR(...)`](#printqr)
* [`cutPaper(...)`](#cutpaper)
* [`getStatus()`](#getstatus)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

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
printStr({ text, charset }: PrintStrArgs) => Promise<void>
```

Print text string, remember that to use this method you must before started the printer instance,
after run started method.

| Param     | Type                                                  | Description                             |
| --------- | ----------------------------------------------------- | --------------------------------------- |
| **`__0`** | <code><a href="#printstrargs">PrintStrArgs</a></code> | &lt;{text: string, charset: string}&gt; |

--------------------


### printReceipt(...)

```typescript
printReceipt({ text }: PrintReceiptArgs) => Promise<StatusResp>
```

Print receipt only

| Param     | Type                                                          | Description            |
| --------- | ------------------------------------------------------------- | ---------------------- |
| **`__0`** | <code><a href="#printreceiptargs">PrintReceiptArgs</a></code> | &lt;{text: string}&gt; |

**Returns:** <code>Promise&lt;<a href="#statusresp">StatusResp</a>&gt;</code>

--------------------


### printReceiptWithQr(...)

```typescript
printReceiptWithQr({ text, qrString, }: PrintReceiptWithQrArgs) => Promise<StatusResp>
```

Print receipt and QR code content

| Param     | Type                                                                      | Description                              |
| --------- | ------------------------------------------------------------------------- | ---------------------------------------- |
| **`__0`** | <code><a href="#printreceiptwithqrargs">PrintReceiptWithQrArgs</a></code> | &lt;{text: string, qrString: string}&gt; |

**Returns:** <code>Promise&lt;<a href="#statusresp">StatusResp</a>&gt;</code>

--------------------


### printQR(...)

```typescript
printQR({ qrString, startText, endText }: PrintQrArgs) => Promise<StatusResp>
```

Print QR code content,
optionally you can pass a text to print before and after QR code

| Param     | Type                                                | Description                                                     |
| --------- | --------------------------------------------------- | --------------------------------------------------------------- |
| **`__0`** | <code><a href="#printqrargs">PrintQrArgs</a></code> | &lt;{qrString: string, startText?:string, endText?: string}&gt; |

**Returns:** <code>Promise&lt;<a href="#statusresp">StatusResp</a>&gt;</code>

--------------------


### cutPaper(...)

```typescript
cutPaper({ mode }: CutPaperArgs) => Promise<{ ok: boolean; }>
```

Set printer cut mode,
remember that to use this method you must before started the printer instance,

| Param     | Type                                                  | Description            |
| --------- | ----------------------------------------------------- | ---------------------- |
| **`__0`** | <code><a href="#cutpaperargs">CutPaperArgs</a></code> | &lt;{mode: number}&gt; |

**Returns:** <code>Promise&lt;{ ok: boolean; }&gt;</code>

--------------------


### getStatus()

```typescript
getStatus() => Promise<StatusResp>
```

Get printer status,
remember that to use this method you must before started the printer instance,

**Returns:** <code>Promise&lt;<a href="#statusresp">StatusResp</a>&gt;</code>

--------------------


### Interfaces


#### StatusResp

| Prop         | Type                                                |
| ------------ | --------------------------------------------------- |
| **`status`** | <code><a href="#statuscodes">StatusCodes</a></code> |


#### PrintStrArgs

| Prop          | Type                |
| ------------- | ------------------- |
| **`text`**    | <code>string</code> |
| **`charset`** | <code>string</code> |


#### PrintReceiptArgs

| Prop       | Type                |
| ---------- | ------------------- |
| **`text`** | <code>string</code> |


#### PrintReceiptWithQrArgs

| Prop           | Type                |
| -------------- | ------------------- |
| **`text`**     | <code>string</code> |
| **`qrString`** | <code>string</code> |


#### PrintQrArgs

| Prop            | Type                |
| --------------- | ------------------- |
| **`qrString`**  | <code>string</code> |
| **`startText`** | <code>string</code> |
| **`endText`**   | <code>string</code> |


#### CutPaperArgs

| Prop       | Type                                        |
| ---------- | ------------------------------------------- |
| **`mode`** | <code><a href="#cutmode">CutMode</a></code> |


### Type Aliases


#### StatusCodes

<code>0 | 1 | 2 | 3 | 4 | 8 | 9 | -16 | -6 | -5 | -4 | -2</code>


#### CutMode

<code>0 | 1 | 2 | -1</code>

</docgen-api>
