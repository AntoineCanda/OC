package tools.filtre;

import java.util.ArrayList;
import java.util.List;

import algo.AbstractSolution;

public abstract class AbstractFiltre {

	private List<AbstractSolution> frontPareto;
	private List<AbstractSolution> newSolutions;
	
	public AbstractFiltre(List<AbstractSolution> solutions){
		this.frontPareto = new ArrayList<AbstractSolution>();
		this.newSolutions = solutions;
	}

	public List<AbstractSolution> getFrontPareto() {
		return frontPareto;
	}

	public void setFrontPareto(List<AbstractSolution> frontPareto) {
		this.frontPareto = frontPareto;
	}

	public List<AbstractSolution> getNewSolutions() {
		return newSolutions;
	}

	public void setNewSolutions(List<AbstractSolution> newSolutions) {
		this.newSolutions = newSolutions;
	}
	
	public boolean domine(AbstractSolution s1, AbstractSolution s2){
		boolean res = false, test = false;
		int cpt = 0;
		List<Integer> score1 = s1.getScore();
		List<Integer> score2 = s2.getScore();
		for(int i = 0; i < score1.size(); i++){
			test = (score1.get(i) < score2.get(i));
			if(test)
				cpt++;
			
			res = res || test; 
		}
		
		if(cpt == score1.size()){
			s1.setDomineFort(true);
		}
		
		return res;
	}
	
	public abstract void filtre(AbstractSolution s, List<AbstractSolution> ens);
}
