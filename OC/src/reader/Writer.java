package reader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import algo.AbstractSolution;

public class Writer {

	private String fileName;
	private List<AbstractSolution> sol;
	
	public Writer(){
		this.fileName = null;
		this.sol = null;
	}
	
	public void setFileName(String name){
		this.fileName = name;
	}
	
	public String getFileName(){
		return this.fileName;
	}
	
	public List<AbstractSolution> getSol() {
		return sol;
	}

	public void setSol(List<AbstractSolution> sol) {
		this.sol = sol;
	}

	
	public void writeFile(){
		if(fileName.equals(null) || this.sol == null){
			System.out.println("Vous devez ajouter un nom de fichier et une liste de donnee avant d'ecrire le fichier");
		}
		else{
		File f = new File(this.fileName);
		try {
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter((fw));
			bw.write("# Donnee representant les scores obtenus pour les fonctions f1 a fn\n");
			bw.flush();
			for(AbstractSolution a : sol){
				StringBuilder sb = new StringBuilder();
				for(int i=0; i < a.getScore().size(); i++){
					int s = a.getScore().get(i);
					if(i+1 == a.getScore().size())
						sb.append(s);
					else
						sb.append(s+"\t");
				}
				sb.append("\n");
				bw.write(sb.toString());
				bw.flush();
			}
			
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
}
