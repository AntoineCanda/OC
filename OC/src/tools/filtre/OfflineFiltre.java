package tools.filtre;

import java.util.List;

import algo.AbstractSolution;
import tools.filtre.AbstractFiltre;

public class OfflineFiltre extends AbstractFiltre {

	public OfflineFiltre(List<AbstractSolution> solutions) {
		super(solutions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void filtre(AbstractSolution s ,List<AbstractSolution> ens) {
		// TODO Auto-generated method stub
		int index = 0;
		while(index < ens.size() && this.domine(s, ens.get(index))){
			if(s.isDomineFort()){
				ens.remove(index);
				s.setDomineFort(false);
			}
			else{
				index++;
			}
		}
		if(index == ens.size()){
			this.getFrontPareto().add(s);
		}
	}
	
	public void filtre(){
		while(!this.getNewSolutions().isEmpty()){
			AbstractSolution s = this.getNewSolutions().remove(0);
			this.filtre(s,this.getNewSolutions());
		}
	}

}
