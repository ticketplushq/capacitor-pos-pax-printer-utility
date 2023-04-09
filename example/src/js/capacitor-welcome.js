import { PaxPrinterUtilityPlugin } from '@ticketplushq/capacitor-pos-pax-printer-utility';

const form = document.querySelector('#form');

form.addEventListener('submit', event => {
  event.preventDefault();
  handleSubmit();
});

async function handleSubmit() {
  const text = document.getElementById('textElement').value;
  const qrString = document.getElementById('qrCodeElement').value;

  try {
    const resp = await PaxPrinterUtilityPlugin.printReceiptWithQr({
      text,
      qrString,
    });
    console.log({ resp });
  } catch (error) {
    console.error(error);
  }
}
