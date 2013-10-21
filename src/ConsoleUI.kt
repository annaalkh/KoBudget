/**
 * Created by Anna on 20.10.13.
 */

import java.util.Scanner
import java.util.Date
import java.io.File

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
    println("4. Exit");
}

public fun selectNextOperation(): String {
    var theIn:Scanner=Scanner(System.`in`);
    printConsoleMenu();
    var userInput: String = theIn.next();
    if (userInput.equals("1")) return "addOUT";
    if (userInput.equals("2")) return "addIN";
    if (userInput.equals("3")) return "show";
    if (userInput.equals("4")) return "exit";
    return "exit";
}

public fun printAllData() {
    var theIn:Scanner=Scanner(File("outgoings"));
    while (theIn.hasNext()) {
        println(theIn.nextLine());
    }
    println();
}