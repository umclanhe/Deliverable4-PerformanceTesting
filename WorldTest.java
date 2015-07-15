package com.laboon;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.Random;

public class WorldTest {

	// Test the printing out result when there is no cell in the world.
	 
	@Test
	public void testWorldSize0() {
		
	     World w = new World(0,1,10);
	     String st = "  "+"\n";	     
	     String result = w.toString();
		 assertEquals(result,st);
	}
	
	// Test the method toString when there is only one cell 
	// and its state is dead in the world.
	
	@Test
	public void testWorldSize1() {
		 Cell cn = mock(Cell.class);
		 when(cn.getStateRep()).thenReturn('.');
		 Cell[][] cells = new Cell[1][1];
		 cells[0][0] = cn;
		 Random rng = new Random(20);		 
		 World wd = new World(cells,rng);
		 String str = "  "+"0"+"\n"+"0"+" "+'.'+"\n";	     
	     String result = wd.toString();
		 assertEquals(result,str);
	}	

	// Test the method toString when there is only one cell
	// and its state is alive in the world
	
	@Test
	public void testWorldSize1L() {
		 Cell cn = mock(Cell.class);
		 when(cn.getStateRep()).thenReturn('X');
		 Cell[][] cells = new Cell[1][1];
		 cells[0][0] = cn;
		 Random rng = new Random(10);		 
		 World wd = new World(cells,rng);
		 String str = "  "+"0"+"\n"+"0"+" "+'X'+"\n";	     
	     String result = wd.toString();
		 assertEquals(result,str);
	}	
	
	// Test the method toString when there are four cells 
	// and their states are alive in the world
	
	@Test
	public void testWorldSize2() {
		 Cell cn = mock(Cell.class);
		 when(cn.getStateRep()).thenReturn('X');
		 Cell[][] cells = new Cell[2][2];
		 for(int i=0; i <=1; i++) 
		 {
		 for(int j=0; j<=1; j++)
		 cells[i][j] = cn;
		 }
		 
		 Random rng = new Random(5);		 
		 World wd = new World(cells,rng);
		 String str = "  "+"0"+"1"+"\n"+"0"+" "+'X'+'X'+"\n"+"1"+" "+'X'+'X'+"\n";	     
	     String result = wd.toString();
		 assertEquals(result,str);
	}
	
	// Test the method toString when there are two cells
	// and their states are mixed (alive dead) in the world
	
	@Test
	public void testWorldSize2M() {
		 Cell cn = mock(Cell.class);
		 when(cn.getStateRep()).thenReturn('X');
		 Cell cl = mock(Cell.class);
		 when(cl.getStateRep()).thenReturn('.');
		 Cell[][] cells = new Cell[2][2];
		 for(int i=0; i <=1; i++) 
		 {
		  cells[i][0]=cn;
		  cells[i][1]=cl;
		 }
		 
		 Random rng = new Random(43);		 
		 World wd = new World(cells,rng);
		 String str = "  "+"0"+"1"+"\n"+"0"+" "+'X'+'.'+"\n"+"1"+" "+'X'+'.'+"\n";	     
	     String result = wd.toString();
		 assertEquals(result,str);
	}
	
}
