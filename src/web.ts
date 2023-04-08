import { WebPlugin } from '@capacitor/core';

import type { PaxPrinterUtilityPluginPlugin } from './definitions';

export class PaxPrinterUtilityPluginWeb
  extends WebPlugin
  implements PaxPrinterUtilityPluginPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
