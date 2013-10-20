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
    var theIn:Scanner=Scanner(System.`in`);
    var out:FileWriter = FileWriter("outgoings", true);

    var title: String;
    var sum: Double;
    var continueTest: String;
    var currentDate: Date;


    while (continueAdd) {
        currentDate = Date();
        println("Input title of outgoing");
        title = theIn.next();
        println("Input sum");
        sum = theIn.nextDouble();
        out.write("${dateToString(currentDate)} $title $sum");
        out.write("\n");
        println("Print y if you would like to continue, press any other key to exit");
        continueTest = theIn.next();
        if (continueTest=="y") continueAdd = true; else continueAdd = false;
    }
    out.close();
}


fun dateToString(theDate: Date): String {
    var theCalendar: Calendar = Calendar.getInstance();
    theCalendar.setTime(theDate);
    theCalendar.get(Calendar.DATE);
    var result:String = "${theCalendar.get(Calendar.DATE)}.${theCalendar.get(Calendar.MONTH)}.${theCalendar.get(Calendar.YEAR)}"
    return result;
}