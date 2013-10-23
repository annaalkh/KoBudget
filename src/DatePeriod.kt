/**
 * Created by Anna on 24.10.13.
 */

import java.util.Date

public class DatePeriod(dateStart: Date, dateEnd: Date) {
    var dateStart:Date = dateStart;
    set(start: Date) {
        if (start.after(dateEnd)) dateStart = dateEnd;
            else dateStart = start;
        numberOfDays = getDiffInDays(dateStart, dateEnd);
    }

    var dateEnd: Date = dateEnd;
    set(end: Date) {
        if (end.before(dateStart)) dateEnd = dateStart;
            else dateEnd = end;
        numberOfDays = getDiffInDays(dateStart, dateEnd);
    }

    var numberOfDays:Long = getDiffInDays(dateStart, dateEnd);
}
