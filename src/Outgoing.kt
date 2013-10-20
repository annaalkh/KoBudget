/**
 * Created by Anna on 20.10.13.
 */

import java.util.Date

public class Outgoing(flowType: String = "OUT", title: String = "", sum: Double = 0.0, date: Date = Date(), comment: String = ""): FinanceFlow("OUT", title, sum, date, comment) {
    override val inputTitleMessage = "Input title of outgoing:";

    override fun toString():String {
        return "OUT ${dateToString(date)} $title $sum $comment";
    }
}