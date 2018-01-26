package calc;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class BombField {

	HashSet<Integer> bombs=new HashSet<Integer>();
	SingleField minefield[][];
	
	public BombField(int fieldSize,int bombNum) {
		SingleField minefields[][]= new SingleField[fieldSize][fieldSize]; 
		minefield=minefields;
		
		for (int i=0;i<fieldSize;i++) {
			for(int j=0;j<fieldSize;j++) {
				minefield[i][j]= new SingleField();
			}
			}
		
		Random rand = new Random();
		for(int i=0; i<bombNum; i++) {
			bombs.add(rand.nextInt(fieldSize*fieldSize) + 1);
		}		

		for(Iterator<Integer> it = bombs.iterator(); it.hasNext(); ) {
			Integer bomb = it.next();
			int r=bomb%fieldSize;
			int c=(bomb-r)/fieldSize;
			
			if(r>1){	
				if(c>1){minefield[r-1][c-1].addCount();}
			minefield[r-1][c].addCount();
				if(c<fieldSize-1) {minefield[r-1][c+1].addCount();}
			
			
			if(c>1){minefield[r][c-1].addCount();}
			minefield[r][c].setMine();
			if(c<fieldSize-1) {minefield[r][c+1].addCount();}
			
			if(r<fieldSize-1) {
				if(c>1){minefield[r+1][c-1].addCount();}
			minefield[r+1][c].addCount();
				if(c<fieldSize-1) {minefield[r+1][c+1].addCount();}}
			}}
		
		}
	
	public SingleField getField(int X, int Y) {
		if(minefield[1].length>0) {
		return minefield[X][Y];}
		else {return new SingleField();}
	}
	}
	

