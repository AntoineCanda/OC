package main;

import java.util.ArrayList;
import java.util.List;

import algo.AbstractSolution;
import algo.SolutionAleatoire;
import reader.Reader;
import reader.Writer;
import tools.Instance;
import tools.filtre.OfflineFiltre;
import tools.filtre.OnlineFiltre;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = Integer.parseInt(args[0]);
		int taille = Integer.parseInt(args[1]);
		Reader r = new Reader(taille);
		List<int[][]> matrices = new ArrayList<int[][]>();
		
		for(int i = 0; i<n; i++){
			r.setFileName(args[i+2]);
			r.resetMatrice();
			r.parseFile();
			matrices.add(r.getMatrice());
		}
				
		Instance i = new Instance(matrices);
	
		List<AbstractSolution> solutions = new ArrayList<AbstractSolution>(500);
		
		for(int j = 0; j < 500; j++){
			SolutionAleatoire sol = new SolutionAleatoire(i,taille);
			sol.setScores();
			solutions.add(sol);
		}
		
		Writer w = new Writer();
		w.setFileName("scores-sol.data");
		w.setSol(solutions);
		w.writeFile();
		
		/*
		OfflineFiltre offline = new OfflineFiltre(solutions);
		offline.filtre();
		List<AbstractSolution> pareto = offline.getFrontPareto();
		*/
		StringBuilder sb = new StringBuilder("Solution du front pareto obtenu : ");

		List<List<AbstractSolution>> solDecoupee = new ArrayList<List<AbstractSolution>>();
		List<AbstractSolution> l1 = new ArrayList<AbstractSolution>();
		List<AbstractSolution> l2 = new ArrayList<AbstractSolution>();
		List<AbstractSolution> l3 = new ArrayList<AbstractSolution>();
		List<AbstractSolution> l4 = new ArrayList<AbstractSolution>();
		List<AbstractSolution> l5 = new ArrayList<AbstractSolution>();
		List<AbstractSolution> l6 = new ArrayList<AbstractSolution>();
		List<AbstractSolution> l7 = new ArrayList<AbstractSolution>();
		List<AbstractSolution> l8 = new ArrayList<AbstractSolution>();
		List<AbstractSolution> l9 = new ArrayList<AbstractSolution>();
		List<AbstractSolution> l10 = new ArrayList<AbstractSolution>();


		for(int j = 0; j < solutions.size(); j++){
			switch(j%10){
			case 0 : 
				l1.add(solutions.get(j));
				break;
			case 1 : 
				l2.add(solutions.get(j));
				break;
			case 2 : 
				l3.add(solutions.get(j));
				break;
			case 3 : 
				l4.add(solutions.get(j));
				break;
			case 4 : 
				l5.add(solutions.get(j));
				break;
			case 5 : 
				l6.add(solutions.get(j));
				break;
			case 6 : 
				l7.add(solutions.get(j));
				break;
			case 7 : 
				l8.add(solutions.get(j));
				break;
			case 8 : 
				l9.add(solutions.get(j));
				break;
			case 9 : 
				l10.add(solutions.get(j));
				break;
			default:
				System.out.println("Erreur");
			}
		}
		solDecoupee.add(l1);
		solDecoupee.add(l2);
		solDecoupee.add(l3);
		solDecoupee.add(l4);
		solDecoupee.add(l5);
		solDecoupee.add(l6);
		solDecoupee.add(l7);
		solDecoupee.add(l8);
		solDecoupee.add(l9);
		solDecoupee.add(l10);

		OnlineFiltre online = new OnlineFiltre(solDecoupee.get(0));
		online.filtre();
		
		
		for(int j=1; j < solDecoupee.size() ;j++){
			online.setNewSolutions(solDecoupee.get(j));
			online.filtre();
		}
		
		List<AbstractSolution> pareto = online.getFrontPareto();

		for(AbstractSolution a : pareto){
			sb.append("\n");
			for(int s : a.getScore()){
				sb.append("score = "+s+"\t");
			}
		}
		
		System.out.println(sb.toString());
		
	
		
		w.setFileName("scores-pareto.data");
		w.setSol(pareto);
		w.writeFile();
	}

}
