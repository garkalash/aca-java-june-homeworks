package collections;

import java.util.*;

public class HashMapEx<K, V> {

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1002, "Ararat");
        hashMap.put(1005, "Gavar");
        hashMap.put(1004, "Sevan");
        hashMap.put(1001, "Yerevan");
        hashMap.put(1003, "Armavir");


        HashMapEx.getMapKeyValue(hashMap);
        System.out.println(HashMapEx.getMapSize(hashMap));
        Map<Integer, String> hashMap1 = new HashMap<>();
        HashMapEx.copyMapToMap(hashMap1, hashMap);
        HashMapEx.removeAll(hashMap1);
        System.out.println(HashMapEx.isMapEmpty(hashMap1));
        HashMapEx.getMapKeyValue(HashMapEx.shallowCopy(hashMap));
        System.out.println(HashMapEx.containKey(hashMap, 1001));
        System.out.println(HashMapEx.containValue(hashMap, "Ararat"));
        System.out.println(HashMapEx.mapSetView(hashMap));
        System.out.println(HashMapEx.getValueByKey(hashMap, 1001));
        System.out.println(HashMapEx.keySetView(hashMap));
        System.out.println(HashMapEx.valueCollectionView(hashMap).toString());

    }

    public static <K, V> void getMapKeyValue(Map<K, V> map) {
        Set<Map.Entry<K, V>> mapEntry = map.entrySet();
        for (Map.Entry<K, V> entry : mapEntry) {
            System.out.println(entry.getKey() + ":  " + entry.getValue());
        }
    }

    public static <K, V> int getMapSize(Map<K, V> map) {
        return map.size();
    }

    public static <K, V> void copyMapToMap(Map<K, V> map1, Map<? extends K, ? extends V> map2) {
        map1.putAll(map2);
        getMapKeyValue(map1);
    }

    public static <K, V> void removeAll(Map<K, V> map) {
        map.clear();
    }

    public static <K, V> boolean isMapEmpty(Map<K, V> map) {
        return map.isEmpty();
    }

    public static <K, V> Map<K, V> shallowCopy(Map<K, V> map) {
        Map<K, V> map1;
        map1 = map;
        return map1;
    }

    public static <K, V> boolean containKey(Map<? super K, V> map, K key) {
        return map.containsKey(key);
    }

    public static <K, V> boolean containValue(Map<K, ? super V> map, V value) {
        return map.containsValue(value);
    }

    public static <K, V> Set<Map.Entry<K, V>> mapSetView(Map<K, V> map) {
        return map.entrySet();
    }

    public static <K, V> V getValueByKey(Map<K, V> map, K key) {
        return (V) map.get(key);
    }

    public static <K, V> Set<K> keySetView(Map<K, V> map) {
        return map.keySet();
    }

    public static <K, V> Collection<? super V> valueCollectionView(Map<K, V> map) {
        Collection<V> collection = new ArrayList<>();
        Set<Map.Entry<K, V>> entrySet = map.entrySet();

        Iterator<Map.Entry<K, V>> itr = entrySet.iterator();
        while (itr.hasNext()) {
            collection.add(itr.next().getValue());
        }
        return collection;
    }

    public static <K, V> Collection<V> valueCollectionView1(Map<K, ? extends V> map) {
        Collection<V> collection = new ArrayList<>();
        Set<K> keySet = map.keySet();
        Iterator<K> itr = keySet.iterator();
        while (itr.hasNext()) {
            collection.add(map.get(itr.next()));
        }
        return collection;
    }
}
