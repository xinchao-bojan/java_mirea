package Practice_25_26;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyHashMap<K, V> implements HashMapInterface<K, V> {
	private final int size;
	private ArrayList<ArrayList<Node<K, V>>> myHash;

	MyHashMap(int size) {
		this.size = size;
		myHash = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			myHash.add(new ArrayList<>());
		}
	}

	@Override
	public void add(K key, V value) {
		Node bufNode = new Node<K, V>(key, value);
		int index = bufNode.getHash() % size;
		boolean added = false;
		if (myHash.get(index).size() != 0) {
			for (Node node : myHash.get(index)) {
				if (node.getKey().equals(bufNode.getKey())) {
					node.setValue(bufNode.getValue());
					added = true;
					break;
				}
			}
		}
		if (!added) {
			myHash.get(index).add(bufNode);
		}
	}

	private Node<K, V> searchByKey(int i, K key) {
		if (i >= 0) {
			if (myHash.get(key.hashCode() % size).get(i).getKey().equals(key))
				return myHash.get(key.hashCode() % size).get(i);
			return searchByKey(i - 1, key);
		}
		return null;
	}

	private Node<K, V> getObject(K key) {
		if (myHash.get(key.hashCode() % size).size() != 0)
			return searchByKey(myHash.get(key.hashCode() % size).size() - 1, key);
		throw new NullPointerException("Wrong key");
	}

	@Override
	public V get(K key) {
		return getObject(key).getValue();
	}

	@Override
	public V remove(K key) {
		V value = get(key);
		myHash.get(key.hashCode() % size).remove(getObject(key));
		return value;
	}

	@Override
	public Iterator<V> iterator() {
		return new CustomIterator<V>();
	}

	private class CustomIterator<V> implements Iterator<V> {
		int higherIndex = 0;
		int lowerIndex = 0;

		@Override
		public boolean hasNext() {
			while (higherIndex < size && lowerIndex == myHash.get(higherIndex).size()) {
				lowerIndex = 0;
				higherIndex++;
			}
			return higherIndex < size;
		}

		@Override
		public V next() {
			return (V) myHash.get(higherIndex).get(lowerIndex++).getValue();
		}
	}
	/*private class CustomIterator<V> implements Iterator<V>
	{
		private int lowerIndex=0;
		private int higherIndex=0;
		@Override
		public boolean hasNext() {

			if(higherIndex==size-1)
				return false;

			while (myHash.get(higherIndex+1).size()==0){
				higherIndex++;
				lowerIndex=0;
				if(higherIndex==size-1)
					return false;
			}

			if(lowerIndex==myHash.get(higherIndex).size()) {
				higherIndex++;
				lowerIndex=0;
			}
			return (higherIndex<size) &&
					(lowerIndex < myHash.get(higherIndex).size());
		}
		@Override
		public V next() {
			return myHash.get(higherIndex).get(lowerIndex++).getValue();
		}
	}*/
}




