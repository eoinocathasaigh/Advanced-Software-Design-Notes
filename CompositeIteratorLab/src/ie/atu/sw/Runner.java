package ie.atu.sw;

public class Runner {
	/*
	 *  Use the composite pattern to build a tree-like structure. The
	 *  syntax for constructing hierarchical structures is verbose and
	 *  is one of the reasons why most GUI frameworks allow the 
	 *  composites, controls and layouts to be declared in an XML file
	 *  or something similar.
	 */
	private Composite<String> ireland = new Composite<>("Ireland");
	private Tree<String> tree = new Tree<>(ireland); //This is our "data structure"

	public Runner() {
		buildTree();
		
		Iterator<String> i = tree.iterator();
		while (i.hasNext()) {
			String county = i.next();
			System.out.println(county);
		}	
	}
	
	private void buildTree() {
		Composite<String> connacht = new Composite<>("Connacht");
		Node<String> galway = new Node<>("Galway");
		Node<String> leitrim = new Node<>("Leitrim");
		Node<String> mayo = new Node<>("Mayo");
		tree.add(connacht, ireland);
		tree.add(galway, connacht);
		tree.add(leitrim, connacht);
		tree.add(mayo, connacht);
		
		Composite<String> munster = new Composite<>("Munster");
		Node<String> limerick = new Node<>("Limerick");
		Node<String> kerry = new Node<>("Kerry");
		tree.add(munster, ireland);
		tree.add(limerick, munster);
		tree.add(kerry, munster);
		
		Composite<String> ulster = new Composite<>("Ulster");
		Node<String> antrim = new Node<>("Antrim");
		Node<String> armagh = new Node<>("Armagh");
		Node<String> derry = new Node<>("Derry");
		tree.add(antrim, ulster);
		tree.add(armagh, ulster);
		tree.add(derry, ulster);
		tree.add(ulster, ireland);

		Composite<String> leinster = new Composite<>("Leinster");
		Node<String> wicklow = new Node<>("Wicklow");
		Node<String> wexford = new Node<>("Wexford");
		Node<String> louth = new Node<>("Louth");
		tree.add(wicklow, leinster);
		tree.add(wexford, leinster);
		tree.add(louth, leinster);
		tree.add(leinster, ireland);
	}
	
	public static void main(String[] args) {
		new Runner();
	}
}