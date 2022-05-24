package com.citrys.app.simplehashmap;

class SimpleHashMap<T> {
    private final StoredItem[] hashtable;

    SimpleHashMap(Class<T> dataType, int size) {
        this.hashtable = (StoredItem[]) java.lang.reflect.Array.newInstance(dataType, size);
    }

    void putItem(String key, T item) {
        int index = hashFunc(key);
        if (isTaken(index)) {
            int stopIndex = index;
            if (index == hashtable.length - 1) {
                index = 0;
            } else {
                index++;
            }

            while (isTaken(index) && index != stopIndex) {
                index = (index + 1) % hashtable.length;
            }
        }

        if (isTaken(index)) {
            System.out.println("Item is already taken");
        } else {
            hashtable[index] = new StoredItem<>(index, item);
        }
    }

    StoredItem getItem(String key) {
        int hashKey = findKey(key);
        if (hashKey == -1) {
            return null;
        }
        return (StoredItem) hashtable[hashKey].getItem();
    }

    int findKey(String key) {
        int hashKey = hashFunc(key);
        if (hashtable[hashKey] != null && hashtable[hashKey].getKey() == hashKey) {
            return hashKey;
        }

        int stopIndex = hashKey;
        if (hashKey == hashtable.length - 1) {
            hashKey = 0;
        } else {
            hashKey++;
        }

        while ( hashKey != stopIndex && hashtable[hashKey] != null && hashtable[hashKey].getKey() != hashKey) {
            hashKey = (hashKey + 1) % hashtable.length;
        }
        if (stopIndex == hashKey) {
            return -1;
        }
        return hashKey;
    }

    private int hashFunc(String a) {
        return a.length() % hashtable.length;
    }

    private boolean isTaken(int index) {
        return hashtable[index] != null;
    }

    void listItems() {
        for (StoredItem a : hashtable) {
            System.out.println(a.getItem());
        }
    }
}

class ValueObj {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "ValueObj{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    ValueObj(String n, int a) {
        this.name = n;
        this.age = a;
    }
}

class Test {
    public static void main(String[] args) {

        SimpleHashMap<ValueObj> test = new SimpleHashMap<>(ValueObj.class, 20);
        try {
            test.putItem("Some1", new ValueObj("Some1", 12));
            test.putItem("Some1232", new ValueObj("Some2", 15));
            test.putItem("Some1232", new ValueObj("Some2", 15));
            test.putItem("Some123212312", new ValueObj("Some1231232", 16));
            test.putItem("So", new ValueObj("So", 7));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        test.listItems();
    }
}