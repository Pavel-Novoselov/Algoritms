package lesson8;

public class LinearProbingHashMap<Key, Value> {
    private int capacity = 16;
    private int size = 0;
    private Key isDeleted;

    public LinearProbingHashMap(Key isDeleted) {
        this.isDeleted = isDeleted;
    }

    private Key[] keys = (Key[]) new Object[capacity];
    private Value[] values = (Value[]) new Object[capacity];

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public final int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public final int hash2(Key key) {
        return 7 - (key.hashCode() & 0x7fffffff) % 7;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private void isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (size == capacity - 1) {
            throw new RuntimeException("Места нет ");
        }

        int i;
        for (i = hash(key); keys[i] != null && keys[i] != isDeleted && i<keys.length; i++) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public boolean delete(Key key){
        isKeyNotNull(key);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (key.equals(keys[i])) {
                keys[i] = isDeleted; //ошибка
                size--;
                return true;
            }
        }
        return false;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        for (int i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i <capacity ; i++) {
            sb.append(keys[i]).append(", ");
        }
        return sb.toString();
    }
}
