package datastructures.hashtable;

import java.util.*;

public class Main {
    public static void main(String [] args){
        HashTable hashTable = new HashTable();

        hashTable.set("Hello", 5);
        hashTable.set("World", 3);
        hashTable.set("From", 4);
        hashTable.set("Youssef", 1);
        System.out.println(hashTable.get("World") + "\n\n");
        ArrayList<String> keys = hashTable.keys();

        System.out.println(keys);

        int[] array1 = new int[3];
        array1[0] = 2;
        array1[1] = 3;
        array1[2] = 5;

        int[] array2 = new int[3];
        array2[0] = 1;
        array2[1] = 4;
        array2[2] = 6;

        System.out.println("Do arrays 1 & 2 have item in common? " + itemInCommon(array1, array2));
    }
    public static boolean itemInCommon(int[] array1, int[] array2){
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i: array1)
            map.put(i, false);
        for(int j: array2) {
            if (map.get(j) == null)
                continue;
            return true;
        }
        return false;
    }

    public static List<Integer> findDuplicates(int[] nums){
        List<Integer> duplicatesList = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for(int number: nums){
            if(map.containsKey(number))
                map.put(number, true);
            else{
                map.put(number, false);
            }
        }
        for(int number: map.keySet()){
            if(map.get(number))
                duplicatesList.add(number);
        }
        return duplicatesList;
    }

    public static Character firstNonRepeatingChar(String s){
        char[] characters = s.toCharArray();

        HashMap<Character, Boolean> map = new HashMap<>();
        for(char c: characters){
            if(map.containsKey(c))
                map.put(c, true);
            else
                map.put(c, false);
        }
        for(char character: map.keySet())
            if(!map.get(character))
                return character;
        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strings){
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strings){
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            String string = new String(characters);
            if(!map.containsKey(string)){
                map.put(string, new ArrayList<>());
            }
            map.get(string).add(s);
        }
        List<List<String>> list = new ArrayList<>();
        for(String string: map.keySet()){
            list.add(map.get(string));
        }
        return list;
    }

    public static int[] twoSum(int[] array, int target){
        HashMap<Integer, ArrayList<Integer>> numberIndex = new HashMap<>();
        int[] nums = new int[2];

        for(int i = 0; i < array.length ; i++){
            if(!numberIndex.containsKey(array[i])){
                numberIndex.put(array[i], new ArrayList<>());
            }
            numberIndex.get(array[i]).add(i);
        }
        for(int i = 0 ; i < numberIndex.size() ; i++){
            int sum = target - array[i];
            if(numberIndex.containsKey(sum)){
                if(sum ==  array[i]){
                    if(numberIndex.get(sum).size() > 1){
                        nums[0] = i;
                        nums[1] = numberIndex.get(sum).get(1);
                        return nums;
                    }
                }
                else{
                    nums[0] = i;
                    nums[1] = numberIndex.get(sum).get(0);
                    return nums;
                }
            }
        }
        return new int[]{};
    }

    public static int[] subarraySum(int[] nums1, int target1) {
        int sum = 0;
        int[] startEnd = new int[2];
        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        for(int i = 0 ; i < nums1.length ; i++){
            sum += nums1[i];
            if(sumIndex.containsKey(sum-target1)){
                startEnd[0] = sumIndex.get(sum-target1) + 1;
                startEnd[1] = i;
                return startEnd;
            }
            sumIndex.put(sum, i);
        }
        return new int[]{};
    }
}
