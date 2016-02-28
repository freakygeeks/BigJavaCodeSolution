package gol.test;

import static org.junit.Assert.*;

import java.util.Random;

import gol.data.BooleanMap;
import gol.data.IMap;
import gol.data.InefficientBooleanMap;

import org.junit.BeforeClass;
import org.junit.Test;

public class PerformanceAndCorrectnessTest {
	
	static IMap boolMap, ineffBoolMap;
	static int width = 400, height = 300, testSize = 10000;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		boolMap = new BooleanMap(width, height);
		fill(boolMap, 42);
		ineffBoolMap = new InefficientBooleanMap(width, height);
		fill(ineffBoolMap, 42);
	}
	
	static void fill(IMap map, long seed) {
		Random random = new Random(seed);
		for (int x = 0; x < map.getWidth(); x++) {
			for (int y = 0; y < map.getHeight(); y++) {
				map.set(x, y, random.nextBoolean());
			}
		}
	}
	
	@Test
	public void testBooleanMap() {
		try {
			calcGenerations(boolMap);
		} catch (Throwable t) {
			fail("Exception caught. This should not happen.");
			return;
		}
		assertTrue("Successfully calculated a few generations.", true);
	}
	
	@Test
	public void testInefficientBooleanMap() {
		try {
			calcGenerations(ineffBoolMap);
		} catch (Throwable t) {
			fail("Exception caught. This should not happen.");
			return;
		}
		assertTrue("Successfully calculated a few generations.", true);
	}
	
	static void calcGenerations(IMap map) throws Throwable {
		for (int i = 0; i < testSize; i++) {
			map.calcNextGeneration();
		}
	}
	
	@Test
	public void testResults() {
		assertTrue("Equality of map width", boolMap.getWidth() == ineffBoolMap.getWidth());
		assertTrue("Equality of map height", boolMap.getHeight() == ineffBoolMap.getHeight());
		for (int x = 0; x < boolMap.getWidth(); x++) {
			for (int y = 0; y < boolMap.getHeight(); y++) {
				assertTrue("Equality of map data at (" + x + "," + y + ")",
						boolMap.get(x, y) == ineffBoolMap.get(x, y));
			}
		}
	}

}
