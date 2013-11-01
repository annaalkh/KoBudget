/**
 * Created by Anna on 20.10.13.
 */

import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit

public fun dateToString(theDate: Date): String {
    var theCalendar: Calendar = Calendar.getInstance();
    theCalendar.setTime(theDate);
    theCalendar.get(Calendar.DATE);
    var result:String = "${theCalendar.get(Calendar.DATE)}.${theCalendar.get(Calendar.MONTH)}.${theCalendar.get(Calendar.YEAR)}"
    return result;
}

public fun stringToDate(dateString: String): Date {
    var theCalendar: Calendar = Calendar.getInstance();
    var dateArray: Array<String> = dateString.split('.');
    var date: Int = dateArray.get(0).toInt();
    var month: Int = dateArray.get(1).toInt();
    var year: Int = dateArray.get(2).toInt();

    theCalendar.set(year, month, date, 0, 0, 0);

    return theCalendar.getTime();
}

public fun getCurrentYear(): DatePeriod {
    var theCalendar: Calendar = Calendar.getInstance();
    theCalendar.set(Calendar.HOUR_OF_DAY, 0);
    theCalendar.set(Calendar.MINUTE, 0);
    theCalendar.set(Calendar.SECOND, 0);

    theCalendar.set(Calendar.DATE, 1);
    theCalendar.set(Calendar.MONTH, Calendar.JANUARY);
    var dateStart: Date = theCalendar.getTime();

    theCalendar.set(Calendar.MONTH, Calendar.DECEMBER);
    theCalendar.set(Calendar.DATE, 31);
    theCalendar.set(Calendar.HOUR_OF_DAY, 23);
    theCalendar.set(Calendar.MINUTE, 59);
    theCalendar.set(Calendar.SECOND, 59);
    var dateEnd: Date = theCalendar.getTime();

    var result = DatePeriod(dateStart, dateEnd);
    return result;
}


public fun getCurrentMonth(): DatePeriod {
    var theCalendar: Calendar = Calendar.getInstance();
    theCalendar.set(Calendar.HOUR_OF_DAY, 0);
    theCalendar.set(Calendar.MINUTE, 0);
    theCalendar.set(Calendar.SECOND, 0);

    theCalendar.set(Calendar.DATE, 1);
    var dateStart: Date = theCalendar.getTime();

    var maxDay: Int = theCalendar.getActualMaximum(Calendar.DATE);
    theCalendar.set(Calendar.DATE, maxDay);
    theCalendar.set(Calendar.HOUR_OF_DAY, 23);
    theCalendar.set(Calendar.MINUTE, 59);
    theCalendar.set(Calendar.SECOND, 59);
    var dateEnd: Date = theCalendar.getTime();

    var result = DatePeriod(dateStart, dateEnd);

    return result;
}

public fun getCurrentDay(): DatePeriod {
    var theCalendar: Calendar = Calendar.getInstance();
    theCalendar.set(Calendar.HOUR_OF_DAY, 0);
    theCalendar.set(Calendar.MINUTE, 0);
    theCalendar.set(Calendar.SECOND, 0);

    var dateStart: Date = theCalendar.getTime();

    theCalendar.set(Calendar.HOUR_OF_DAY, 23);
    theCalendar.set(Calendar.MINUTE, 59);
    theCalendar.set(Calendar.SECOND, 59);

    var dateEnd: Date = theCalendar.getTime();

    var result = DatePeriod(dateStart, dateEnd);

    return result;
}

public fun getDiffInDays(dateStart: Date, dateEnd: Date): Long {
    var timeStart = dateStart.getTime();
    var timeEnd = dateEnd.getTime();
    var diffInTime = timeEnd - timeStart;
    var diffInDays = TimeUnit.MILLISECONDS.toDays(diffInTime);
    return diffInDays+1;
}

fun getQuarterMonths(theCalendar: Calendar): Array<Int> {
    var result: Array<Int> = Array(2, {i -> 0});

    when (theCalendar.get(Calendar.MONTH)) {
        Calendar.MARCH, Calendar.APRIL,Calendar.MAY -> {
            result.set(0, Calendar.MARCH);
            result.set(1, Calendar.MAY);
        }
        Calendar.JUNE, Calendar.JULY, Calendar.AUGUST-> {
            result.set(0, Calendar.JUNE);
            result.set(1, Calendar.AUGUST);
        }
        Calendar.SEPTEMBER, Calendar.OCTOBER, Calendar.NOVEMBER -> {
            result.set(0, Calendar.SEPTEMBER);
            result.set(1, Calendar.NOVEMBER);
        }
        Calendar.DECEMBER, Calendar.JANUARY, Calendar.FEBRUARY -> {
            result.set(0, Calendar.DECEMBER);
            result.set(1, Calendar.JANUARY);
        }
    }

    return result;
}