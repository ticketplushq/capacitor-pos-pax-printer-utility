import { PaxPrinterUtilityPlugin } from '@ticketplushq/capacitor-pos-pax-printer-utility';
import '../css/style.css';

const form = document.querySelector('#form');

form.addEventListener('submit', event => {
  event.preventDefault();
  handleSubmit();
});

async function handleSubmit() {
  const text = document.getElementById('textElement').value;
  const qrString = document.getElementById('qrCodeElement').value;
  const asciiFontType = document.getElementById('asciiFontType').value;
  const cFontType = document.getElementById('cFontType').value;
  const cutModeString = document.getElementById('cutMode').value;
  const cutMode = Number.parseInt(cutModeString);

  let payload = {
    text,
    asciiFontType,
    cFontType,
  };

  if (qrString?.length > 0) {
    payload.qrString = qrString;
  }

  try {
    const resp = await PaxPrinterUtilityPlugin.printReceiptWithQr(payload);
    const cutPaper = await PaxPrinterUtilityPlugin.cutPaper({ mode: cutMode });
    console.log({ resp, cutPaper });
  } catch (error) {
    console.error(error);
  }
}
