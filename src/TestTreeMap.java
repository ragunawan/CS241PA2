//  Test TreeMap implementations
//  mas 2015.10.13

public class TestTreeMap {
	public static void main(String[] args) {
		new TestTreeMap(args);
	}
	
	public TestTreeMap(String[] args){
		// create tree
		MyMap<String,Integer> t=new MyTreeMap<>();

		// test put
		t.put("C",5);
		System.out.println(t);
		t.put("X",7);
		System.out.println(t);
		t.put("A",2);
		System.out.println(t);
		t.put("J",8);
		System.out.println(t);
		t.put("P",5);
		System.out.println(t);
		System.out.println("put J again: "+t.put("J",42));
		System.out.println(t);
	
		// test size
		System.out.println("size: "+t.size());

		// test containsKey
		System.out.println("containsKey(A): "+t.containsKey("A"));
		System.out.println("containsKey(B): "+t.containsKey("B"));

		// test get
		System.out.println("get(X): "+t.get("X"));		
		System.out.println("get(P): "+t.get("P"));		
		System.out.println("get(Z): "+t.get("Z"));		

		// test remove
		System.out.println("remove(A): "+t.remove("A"));
		System.out.println(t);
		System.out.println("remove(B): "+t.remove("B"));
		System.out.println(t);
		System.out.println("remove(J): "+t.remove("J"));
		System.out.println(t);
		System.out.println("size: "+t.size());

		// test keySet
		t.put("K",9);
		t.put("M",4);
		System.out.println(t);
		System.out.println("key list: ");
		for(String key:t.keySet()) System.out.print(key);
		System.out.println();
	}

}