package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tools.Instance;

public abstract class AbstractSolution {
	protected List<Integer> listeVille;
	protected Instance instance;
	protected Random random = new Random();
	protected List<Integer> scores;
	protected boolean domineFort;
	
	public AbstractSolution(Instance i, int n){
		this.listeVille = this.initialize(n);
		this.instance = i;
		this.scores = new ArrayList<Integer>();
		this.domineFort = false;
	}
	
	public boolean isDomineFort() {
		return domineFort;
	}

	public void setDomineFort(boolean domineFort) {
		this.domineFort = domineFort;
	}

	private List<Integer> initialize(int n) {
		// TODO Auto-generated method stub
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i<n;i++ ){
			res.add(i);
		}
		return res;
	}
	
	public abstract List<List<Integer>> createPermutation();
	
	public void setScores(){
//	public void setScores(List<List<Integer>> permutations){
//		this.scores = instance.evaluerMultiObjectif(permutations);
		this.scores = instance.evaluerMultiObjectif(this.createPermutation());
	}
	
	public List<Integer> getScore(){
		return this.scores;
	}
}
