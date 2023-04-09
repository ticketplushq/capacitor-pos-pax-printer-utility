import { registerPlugin } from '@capacitor/core';

import type { PaxPrinterUtility } from './definitions';

const PaxPrinterUtilityPlugin = registerPlugin<PaxPrinterUtility>(
  'PaxPrinterUtilityPlugin',
  {
    web: () => import('./web').then(m => new m.PaxPrinterUtilityWeb()),
  },
);

export * from './definitions';
export { PaxPrinterUtilityPlugin };
