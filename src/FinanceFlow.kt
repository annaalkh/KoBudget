/**
 * Created by Anna on 20.10.13.
 */

import java.util.Date

public open class FinanceFlow(flowType: String = "OUT", title: String = "", sum: Double =0.0, date: Date = Date(), comment: String = "") {
    var title: String = title;
    var sum: Double = sum;
    var date: Date = date;
    var comment: String = comment;
    open val inputTitleMessage = "Input title of flow:"


    open fun toString():String {
        return "${dateToString(date)} $title $sum $comment";
    }


}