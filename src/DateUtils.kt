/**
 * Created by Anna on 20.10.13.
 */

import java.util.Calendar
import java.util.Date

public fun dateToString(theDate: Date): String {
    var theCalendar: Calendar = Calendar.getInstance();
    theCalendar.setTime(theDate);
    theCalendar.get(Calendar.DATE);
    var result:String = "${theCalendar.get(Calendar.DATE)}.${theCalendar.get(Calendar.MONTH)}.${theCalendar.get(Calendar.YEAR)}"
    return result;
}