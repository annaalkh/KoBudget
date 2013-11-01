package DataWriters

import java.io.FileWriter

/**
 * Created by Anna on 01.11.13.
 */

public class FileFinanceFlowWriter: AbstractFinanceFlowsWriter {
    val fileName = "outgoings";

    override fun writeFlow(flow: FinanceFlow) {
        var out:FileWriter = FileWriter(fileName, true);

        flow.title = flow.title.replace(' ', '_');

        out.write(flow.toString());
        out.write("\n");

        out.close();}
}