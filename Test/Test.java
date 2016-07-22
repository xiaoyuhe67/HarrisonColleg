import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import DBUtil.Dataget;
import model.Hclass;

public class Test {

	@org.junit.Test
	public void test() {
		List<Hclass> allsearchclasses=Dataget.searchClassesbystudentid("32245", 1);
		
		System.out.println(allsearchclasses.get(0).getCrnnumber());
	}

}
