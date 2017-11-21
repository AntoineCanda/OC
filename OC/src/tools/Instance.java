package tools;

import java.util.ArrayList;
import java.util.List;

public class Instance {

	private List<int[][]> matrices;
	
	public Instance(List<int[][]> matrices){
		this.matrices = matrices;
	}
	
	public List<Integer> getPoids(int i, int j){
		List<Integer> poids = new ArrayList<Integer>();
		for(int k = 0; k< matrices.size(); k++){
			poids.add(this.matrices.get(k)[i][j]);
			//System.out.println("k = " + k + " score = "+this.matrices.get(k)[i][j]);

		}
		/*
		String s = new String();
		for(int p: poids){
			s.concat("poids = "+p+" ");
		}
		System.out.println(s);
*/
		return poids;
	}
	
	public int evaluerSolution(List<Integer> permutation){
		int score = 0;
		
		for(int i = 0; i < permutation.size(); i++){
			score += permutation.get(i);
		}
		
		return score;
	}
	
	public List<Integer> evaluerMultiObjectif(List<List<Integer>> permutations){
		List<Integer> scores = new ArrayList<Integer>();
		List<List<Integer>> permObjectif = this.createListePermutation(permutations);
		
		for(List<Integer> l : permObjectif){
			scores.add(this.evaluerSolution(l));
		}
		
		return scores;
	}

	private List<List<Integer>> createListePermutation(List<List<Integer>> permutations) {
		// TODO Auto-generated method stub
		List<List<Integer>> perm = new ArrayList<List<Integer>>();
		int n = permutations.get(0).size();
		
		for(int i = 0 ; i < n; i++){
			perm.add(new ArrayList<Integer>(permutations.size()));
		}
		
		for(int i = 0; i < permutations.size(); i++){
			for(int j = 0 ; j < n; j++){
				perm.get(j).add(permutations.get(i).get(j));
			}
		}
		
		return perm;
	}
}
