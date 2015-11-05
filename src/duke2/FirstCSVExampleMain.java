package duke2;
import org.apache.commons.csv.*;

import edu.duke.*;
public class FirstCSVExampleMain {

	public static void main(String[] args) {
//		FileResource fr = new FileResource();
//		CSVParser parserO = fr.getCSVParser();
		FirstCSVExamle fcsv = new FirstCSVExamle();
		//fcsv.readFood();
		//fcsv.checkExport();
        //fcsv.listExporters(parserO, "coffee");
		//fcsv.whoExports();
		//fcsv.whatCountryInfo();
		//fcsv.whatTwoItemCountry();
		//fcsv.numberOfCountryItem();
		fcsv.whatBigExporters();
	}

}
