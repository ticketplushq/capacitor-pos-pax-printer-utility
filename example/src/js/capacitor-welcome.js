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

  try {
    const resp = await PaxPrinterUtilityPlugin.printReceiptWithQr({
      text,
      qrString,
      asciiFontType,
      cFontType,
    });
    console.log({ resp });
  } catch (error) {
    console.error(error);
  }
}
