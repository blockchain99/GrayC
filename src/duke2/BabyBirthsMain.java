package duke2;

import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirthsMain {

	public static void main(String[] args) {
		BabyBirths bb = new BabyBirths();
		//bb.printNames();
		FileResource fr = new FileResource();
		bb.totalBirths(fr);

	}

}
