/**
 * Created by Anna on 20.10.13.
 */

import java.util.Scanner
import java.util.Date
import java.io.File
import Services.getTotalBasicStatistics
import Services.getBasicStatisticsForCurrentMonth
import Services.getBasicStatisticsForCurrentDay
import Services.getBasicStatisticsForCurrentYear

public fun inputFlow(flowType: String): FinanceFlow {
    var theIn:Scanner=Scanner(System.`in`);
    var currentFlow: FinanceFlow;

    if (flowType=="OUT") {
        currentFlow = Outgoing();
    } else {
        currentFlow = Incoming();
    }


    var title: String;
    var sum: Double;
    var currentDate: Date;

    currentDate = Date();
    println(currentFlow.inputTitleMessage);
    title = theIn.next();
    println("Input sum");
    sum = theIn.nextDouble();

    currentFlow.title = title;
    currentFlow.sum = sum;
    currentFlow.date = currentDate;
    currentFlow.comment = "";

    return currentFlow;
}

public fun printConsoleMenu() {
    println("KoBudget");
    println("Chose operation:");
    println("1. Input outgoing");
    println("2. Input incoming");
    println("3. Show data");
    println("4. Common statistics");
    println("5. Exit");
}

public fun selectNextOperation(): String {
    var theIn:Scanner=Scanner(System.`in`);
    printConsoleMenu();
    var userInput: String = theIn.next();
    if (userInput.equals("1")) return "addOUT";
    if (userInput.equals("2")) return "addIN";
    if (userInput.equals("3")) return "show";
    if (userInput.equals("4")) return "commonStatistics";
    if (userInput.equals("5")) return "exit";
    return "exit";
}

public fun printAllData() {
    var theIn:Scanner=Scanner(File("outgoings"));
    while (theIn.hasNext()) {
        println(theIn.nextLine());
    }
    println();
}

public fun printCommonStatistics() {
    var currentPeriod: String = selectPeriod();

    var commonStatistics: CommonStatistics;

    when (currentPeriod) {
        "all" -> {
            commonStatistics = getTotalBasicStatistics();
        };
        "day" -> {
            commonStatistics = getBasicStatisticsForCurrentDay();
        };
        "month" -> {
            commonStatistics = getBasicStatisticsForCurrentMonth();
        };
        "year" -> {
            commonStatistics = getBasicStatisticsForCurrentYear();
        };
        else -> return;
    }

    var statisticsString = commonStatistics.toString();
    println(statisticsString);
}

public fun selectPeriod(): String {
    var theIn:Scanner=Scanner(System.`in`);
    printSelectPeriodMenu();
    var userInput: String = theIn.next();
    if (userInput.equals("1")) return "all";
    if (userInput.equals("2")) return "day";
    if (userInput.equals("3")) return "month";
    if (userInput.equals("4")) return "year";
    return "exit";
}

fun printSelectPeriodMenu() {
    println("Chose period:");
    println("1. All the time");
    println("2. Current day");
    println("3. Current month");
    println("4. Current year");
}

