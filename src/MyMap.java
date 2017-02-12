public interface MyMap<K,V> {
	
	public boolean containsKey(K key);
	public V put(K key, V value);
	public V get(K key);
	public V remove(K key);
	public int size();
	public String toString();
	public java.util.Set<K> keySet();
	
}