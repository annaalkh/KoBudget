package DataProviders

import java.util.ArrayList
import java.io.File
import java.util.Scanner
import java.util.Date

/**
 * Created by Anna on 21.10.13.
 */

public class FileFinanceFlowsProvider: AbstractFinanceFlowsProvider {

    override fun getAllFlows(): ArrayList<FinanceFlow> {

        var resultList:ArrayList<FinanceFlow> = ArrayList();

        var theIn: Scanner = Scanner(File("outgoings"));
        var currentString: String;
        var currentFlow: FinanceFlow;

        var flowType: String;
        var date: Date;
        var title: String;
        var sum: Double;

        while (theIn.hasNext()) {
            currentString = theIn.nextLine();

            var s: Array<String> = currentString.split(" ");

            flowType = s.get(0);
            date = Date();
            title = s.get(2);
            sum = s.get(3).toDouble();

            if (flowType.equals("OUT")) {
                currentFlow = Outgoing(title, sum, date);
            } else {
                currentFlow = Incoming(title, sum, date);
            }

            resultList.add(currentFlow);
        }
        return resultList;

    }

    override fun getFlowsForPeriod(periodStartDate: Date, periodEndDate: Date): ArrayList<FinanceFlow> {
        var resultList:ArrayList<FinanceFlow> = ArrayList();

        var theIn: Scanner = Scanner(File("outgoings"));
        var currentString: String;
        var currentFlow: FinanceFlow;

        var flowType: String;
        var date: Date;
        var title: String;
        var sum: Double;

        while (theIn.hasNext()) {
            currentString = theIn.nextLine();

            var s: Array<String> = currentString.split(" ");

            flowType = s.get(0);
            date = Date();
            title = s.get(2);
            sum = s.get(3).toDouble();

            if (date.before(periodEndDate) || date.after(periodEndDate)) continue;

            if (flowType.equals("OUT")) {
                currentFlow = Outgoing(title, sum, date);
            } else {
                currentFlow = Incoming(title, sum, date);
            }

            resultList.add(currentFlow);
        }
        return resultList;
    }
}