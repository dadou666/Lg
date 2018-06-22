package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import generer.Generateur;

public class TestGenererType {

	@Test
	public void test() {
		List<Class> classes = new ArrayList<Class>();
		classes.add(A.class);
		classes.add(B.class);
		classes.add(U.class);
	   System.out.println(Generateur.genererTypes(classes));
	}

}
