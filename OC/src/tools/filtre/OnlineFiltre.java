package tools.filtre;

import java.util.List;

import algo.AbstractSolution;

public class OnlineFiltre extends AbstractFiltre {

	public OnlineFiltre(List<AbstractSolution> solutions) {
		super(solutions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void filtre(AbstractSolution s, List<AbstractSolution> ens) {
		// TODO Auto-generated method stub

		int index = 0;
		while (index < ens.size() && this.domine(s, ens.get(index))) {
			if (s.isDomineFort()) {
				ens.remove(index);
				s.setDomineFort(false);
			} else {
				index++;
			}
		}
		
		if(index == ens.size()){
			ens.add(s);
		}
	}
	
	public void filtre(){
		int index;
		AbstractSolution s;
		// Filtre l'ensemble des solutions dans le cas ou on a plusieurs nouvelles solutions a tester contre archive
		if(this.getNewSolutions().size() > 1){
			index = 0;
			while(index < this.getNewSolutions().size()){
				s = this.getNewSolutions().remove(index);
				this.filtre(s,this.getNewSolutions());
				index++;
			}
		}
		
		index = 0;
		while(index < this.getNewSolutions().size()){
			s = this.getNewSolutions().get(index);
			this.filtre(s, this.getFrontPareto());
			index++;
		}
		this.getNewSolutions().clear();
	}

}
