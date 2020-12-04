package Practice_25_26;

public class Node<K,V> {

	private int hash;
	private K key;
	private V value;

	Node(K key,V value)
	{
		this.key=key;
		this.value=value;
		this.hash=key.hashCode();
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
