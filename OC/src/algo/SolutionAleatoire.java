package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tools.Instance;

public class SolutionAleatoire extends AbstractSolution{

	public SolutionAleatoire(Instance i, int n){
		super(i,n);
		Collections.shuffle(listeVille);
	}
	
	public List<List<Integer>> createPermutation(){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int VilleDepart, v1, v2;
		VilleDepart = listeVille.remove(random.nextInt(listeVille.size()));
		v1 = VilleDepart;
		
		while(!listeVille.isEmpty()){
			v2 = listeVille.remove(random.nextInt(listeVille.size()));
			res.add(instance.getPoids(v1, v2));
			v1 = v2;
		}
		
		res.add(instance.getPoids(v1, VilleDepart));
		return res;
	}
}
