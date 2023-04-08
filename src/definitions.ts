export interface PaxPrinterUtilityPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
