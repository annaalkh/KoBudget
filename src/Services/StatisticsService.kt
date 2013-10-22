package Services

import DataProviders.AbstractFinanceFlowsProvider
import DataProviders.FileFinanceFlowsProvider
import java.util.ArrayList

/**
 * Created by Anna on 22.10.13.
 */

public fun getTotalBasicStatistics(): CommonStatistics {
    var dataProvider: AbstractFinanceFlowsProvider = FileFinanceFlowsProvider();

    var flowList: ArrayList<FinanceFlow> = dataProvider.getAllFlows();

    var currentStatistics: CommonStatistics = CommonStatistics();

    var countTotal: Int = 0;
    var countIN: Int = 0;
    var countOUT: Int = 0;

    for (financeFlow in flowList) {
        var currentSum = financeFlow.sum;
        var flowType = financeFlow.flowType;

        countTotal++;
        currentStatistics.sum += currentSum;
        if (currentSum < currentStatistics.min) currentStatistics.min = currentSum;
        if (currentSum > currentStatistics.max) currentStatistics.max = currentSum;

        if (flowType == "IN") {
            countIN++;
            currentStatistics.sumIN += currentSum;
            if (currentSum < currentStatistics.minIN) currentStatistics.minIN = currentSum;
            if (currentSum > currentStatistics.maxIN) currentStatistics.maxIN = currentSum;
        } else {
            countOUT++;
            currentStatistics.sumOUT += currentSum;
            if (currentSum < currentStatistics.minOUT) currentStatistics.minOUT = currentSum;
            if (currentSum > currentStatistics.maxOUT) currentStatistics.maxOUT = currentSum;
        }
    }

    currentStatistics.mean = currentStatistics.sum / countTotal;
    currentStatistics.meanIN = currentStatistics.sumIN / countIN;
    currentStatistics.meanOUT = currentStatistics.sumOUT / countOUT;

    return currentStatistics;
}