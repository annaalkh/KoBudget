package Services

import DataProviders.AbstractFinanceFlowsProvider
import DataProviders.FileFinanceFlowsProvider
import java.util.ArrayList
import java.util.Date

/**
 * Created by Anna on 22.10.13.
 */

public fun getTotalBasicStatistics(): CommonStatistics {
    var dataProvider: AbstractFinanceFlowsProvider = FileFinanceFlowsProvider();

    var flowList: ArrayList<FinanceFlow> = dataProvider.getAllFlows();

    var currentStatistics: CommonStatistics = getStatisticsFromFlows(flowList);

    return currentStatistics;
}

public fun getBasicStatisticsForPeriod(periodStartDate: Date, periodEndDate: Date): CommonStatistics {
    var dataProvider: AbstractFinanceFlowsProvider = FileFinanceFlowsProvider();

    var flowList: ArrayList<FinanceFlow> = dataProvider.getFlowsForPeriod(periodStartDate, periodEndDate);

    var currentStatistics: CommonStatistics = getStatisticsFromFlows(flowList);

    return currentStatistics;
}

public fun getBasicStatisticsForCurrentYear(): CommonStatistics {
    var currentYear: DatePeriod = getCurrentYear();

    var currentStatistics: CommonStatistics = getBasicStatisticsForPeriod(currentYear.dateStart, currentYear.dateEnd);

    return currentStatistics;
}

public fun getBasicStatisticsForCurrentMonth(): CommonStatistics {
    var currentMonth: DatePeriod = getCurrentMonth();

    var currentStatistics: CommonStatistics = getBasicStatisticsForPeriod(currentMonth.dateStart, currentMonth.dateEnd);

    return currentStatistics;
}

public fun getBasicStatisticsForCurrentDay(): CommonStatistics {
    var currentDay: DatePeriod = getCurrentDay();

    var currentStatistics: CommonStatistics = getBasicStatisticsForPeriod(currentDay.dateStart, currentDay.dateEnd);

    return currentStatistics;
}

fun getStatisticsFromFlows(flowList: ArrayList<FinanceFlow>): CommonStatistics {
    var currentStatistics: CommonStatistics = CommonStatistics();

    var countTotal: Int = 0;
    var countIN: Int = 0;
    var countOUT: Int = 0;

    currentStatistics.min = Integer.MAX_VALUE.toDouble();
    currentStatistics.minIN = Integer.MAX_VALUE.toDouble();
    currentStatistics.minOUT = Integer.MAX_VALUE.toDouble();

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

    if (currentStatistics.min >= Integer.MAX_VALUE.toDouble()) currentStatistics.min = 0.0;
    if (currentStatistics.minIN >= Integer.MAX_VALUE.toDouble()) currentStatistics.minIN = 0.0;
    if (currentStatistics.minOUT >= Integer.MAX_VALUE.toDouble()) currentStatistics.minOUT = 0.0;

    return currentStatistics;
}