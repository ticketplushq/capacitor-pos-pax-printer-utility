import { registerPlugin } from '@capacitor/core';

import type { PaxPrinterUtilityPluginPlugin } from './definitions';

const PaxPrinterUtilityPlugin = registerPlugin<PaxPrinterUtilityPluginPlugin>(
  'PaxPrinterUtilityPlugin',
  {
    web: () => import('./web').then(m => new m.PaxPrinterUtilityPluginWeb()),
  },
);

export * from './definitions';
export { PaxPrinterUtilityPlugin };
