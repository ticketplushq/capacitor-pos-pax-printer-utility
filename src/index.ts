import { registerPlugin } from '@capacitor/core';

// eslint-disable-next-line @typescript-eslint/consistent-type-imports
import type { PaxPrinterUtilityPlugin } from './definitions';

const PaxPrinterUtilityPlugin = registerPlugin<PaxPrinterUtilityPlugin>(
  'PaxPrinterUtilityPlugin',
  {
    web: () => import('./web').then(m => new m.PaxPrinterUtilityPluginWeb()),
  },
);

export * from './definitions';
export { PaxPrinterUtilityPlugin };
