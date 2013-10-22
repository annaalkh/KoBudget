/**
 * Created by Anna on 20.10.13.
 */

import java.util.Scanner
import java.io.File
import java.io.FileWriter
import java.util.Date
import java.util.Calendar

fun main(args: Array<String>) {
    var continueAdd:Boolean = true;

    var out:FileWriter = FileWriter("outgoings", true);

    var currentFlow: FinanceFlow;

    var userAction: String;


    while (continueAdd) {
        userAction = selectNextOperation();

        when (userAction) {
            "addOUT" -> {
                currentFlow = inputFlow("OUT")
                out.write(currentFlow.toString());
                out.write("\n");
            };
            "addIN" -> {
                currentFlow = inputFlow("IN")
                out.write(currentFlow.toString());
                out.write("\n");
            };
            "show" -> {
                printAllData();
            };
            "commonStatistics" -> {
                printCommonStatistics();
            };
             else -> continueAdd = false;
        }
    }
    out.close();
}

