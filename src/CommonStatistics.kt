/**
 * Created by Anna on 22.10.13.
 */

public class CommonStatistics {

    var mean: Double = 0.0;
    var max: Double = 0.0;
    var min: Double = 0.0;
    var sum: Double = 0.0;

    var meanIN: Double = 0.0;
    var maxIN: Double = 0.0;
    var minIN: Double = 0.0;
    var sumIN: Double = 0.0;

    var meanOUT: Double = 0.0;
    var maxOUT: Double = 0.0;
    var minOUT: Double = 0.0;
    var sumOUT: Double = 0.0;

    public fun toString(): String {
        var result: String;
        result = "Sum of flow: \t $sum \n Sum of outgoings: \t $sumOUT \n Sum of incomings: \t $sumIN \n" +
                 "Net income: \t ${sumIN-sumOUT} \n" +
                 "Average flow: \t $mean \n Average outgoing: \t $meanOUT \n Average incoming: \t $meanIN \n" +
                 "Max flow: \t $max \n Max outgoing: \t $maxOUT \n Max incoming: \t $maxIN \n" +
                 "Min flow: \t $min \n Min outgoing: \t $minOUT \n Min incoming: \t $minIN \n";
        return result;
    }

}