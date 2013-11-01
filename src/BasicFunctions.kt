/**
 * Created by Anna on 20.10.13.
 */

import java.util.Scanner
import java.io.File
import java.io.FileWriter
import java.util.Date
import java.util.Calendar
import DataWriters.AbstractFinanceFlowsWriter
import DataWriters.FileFinanceFlowWriter

fun main(args: Array<String>) {
    var continueAdd:Boolean = true;

    var dataWriter: AbstractFinanceFlowsWriter = FileFinanceFlowWriter();

    var currentFlow: FinanceFlow;

    var userAction: String;


    while (continueAdd) {
        userAction = selectNextOperation();

        when (userAction) {
            "addOUT" -> {
                currentFlow = inputFlow("OUT")
                dataWriter.writeFlow(currentFlow);
            };
            "addIN" -> {
                currentFlow = inputFlow("IN")
                dataWriter.writeFlow(currentFlow);
            };
            "show" -> {
                printAllData();
            };
            "commonStatistics" -> {
                printCommonStatistics();
            };
            "advancedStatistics" -> {
                printAdvancedStatistics();
            };
             else -> continueAdd = false;
        }
    }
}

