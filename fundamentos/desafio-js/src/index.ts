import https from 'https';
import { DOMAIN } from "./config";
import { IAccount } from "./i-account";
import sunOfDeposits from './questions/sun-of-deposits';
import totalHigherThan100 from './questions/total-higher-than-100';
import higherThan100OnAgency33 from './questions/higher-than-100-on-agency-33';
import highestBalanceAgency from './questions/highest-balance-agency';
import calcTotalOfHigestAccPerAgency from './questions/calc-total-of-highest-acc-per-agency';
import lowestBalanceAgency from './questions/lowest-balance-agency';
import getClientWHighestBalanceAtAg10 from './questions/get-client-w-highest-balance-at-ag-10';
import getClientWLowestBalanceAtAg47 from './questions/get-client-w-lowest-balance-at-ag-47';
import top3LowestBalanceAtAg47 from './questions/top-3-lowest-balance-at-ag-47';
import howManyAccAtAg47 from './questions/how-many-acc-at-ag-47';
import howManyAccWNameMariaAtAg47 from './questions/how-many-acc-w-name-maria-at-ag-47';
import getNextId from './questions/get-next-id';

https.get(`${DOMAIN}/api/accounts`)
  .on('error', err => console.error)
  .on('response', res => {
    let raw = '';
    res.on('data', chunk => raw += chunk);
    res.on('end', () => {
      const accounts: Array<IAccount> = JSON.parse(raw);

      sunOfDeposits(...accounts);
      totalHigherThan100(...accounts);
      higherThan100OnAgency33(...accounts);
      highestBalanceAgency(...accounts);
      lowestBalanceAgency(...accounts);
      calcTotalOfHigestAccPerAgency(...accounts);
      getClientWHighestBalanceAtAg10(...accounts);
      getClientWLowestBalanceAtAg47(...accounts);
      top3LowestBalanceAtAg47(...accounts);
      howManyAccAtAg47(...accounts);
      howManyAccWNameMariaAtAg47(...accounts);
      getNextId(...accounts);
      
    });
  });
