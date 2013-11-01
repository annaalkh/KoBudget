package DataProviders

import java.util.Date
import java.util.ArrayList

/**
 * Created by Anna on 21.10.13.
 */

trait AbstractFinanceFlowsProvider {
    fun getAllFlows(): ArrayList<FinanceFlow>;
    fun getFlowsForPeriod(periodStartDate: Date, periodEndDate: Date): ArrayList<FinanceFlow>;

    fun getAllFlowsByTitle(title: String): ArrayList<FinanceFlow>;
    fun getFlowsForPeriodByTitle(title: String, periodStartDate: Date, periodEndDate: Date): ArrayList<FinanceFlow>;
}