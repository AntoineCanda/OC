package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

	
	private int matrice[][];
	private List<String> l;
	private int n;
	private String fileName;
	
	public Reader(int n){
		this.n = n;
		this.matrice = new int[n][n];
		this.fileName = null;
		this.l = new ArrayList<String>();
	}

	public int[][] getMatrice() {
		return matrice;
	}

	public void resetMatrice() {
		this.matrice = new int[this.n][this.n];
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void parseFile(){
	
		File f = new File(this.fileName);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader buff = new BufferedReader(fr);
			String tmp = null;
			int value = 0;
			
			for(int i = 0 ; i< 7; i++ ){
				tmp = buff.readLine();
				if(tmp != null)
					l.add(tmp);
			}
			
			for(int i = 0; i < this.n; i++){
				for(int j = i; j < this.n; j++){
					
					tmp = buff.readLine();
					
					if(tmp != null)
						value = Integer.parseInt(tmp);
					
					this.matrice[i][j] = value;
					this.matrice[j][i] = value;
				}
			}
			
			buff.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printMatrice(){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < this.n ; i++){
			sb.append("[");
			for(int j = 0; j < this.n; j++){
				sb.append("|"+this.matrice[i][j]);
			}
			sb.append("]\n");
		}
		
		System.out.println("Matrice obtenue = \n"+sb.toString());
	}
}
