/**
 * Created by Anna on 20.10.13.
 */

import java.util.Date

public class Incoming(title: String = "", sum: Double = 0.0, date: Date = Date(), comment: String = "", source: String = ""): FinanceFlow("IN", title, sum, date, comment) {
    var source: String = source;
    override val inputTitleMessage = "Input title of incoming:";

    override fun toString():String {
        return "IN ${dateToString(date)} $title $sum $comment";
    }
}
