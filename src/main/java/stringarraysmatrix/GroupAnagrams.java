package stringarraysmatrix;


import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        GroupAnagrams solution = new GroupAnagrams();

//        String[] in = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] in = new String[] {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"}; //[["doc"],["bar"],["buy"],["ill"],["may"],["tin"],["cab"],["pew"],["max"],["duh"]]
        String[] in = new String[] {"hos","boo","nay","deb","wow","bop","bob","brr","hey","rye","eve","elf","pup","bum","iva","lyx","yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye","ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab"}; //[["doc"],["bar"],["buy"],["ill"],["may"],["tin"],["cab"],["pew"],["max"],["duh"]]
        //[["sol"],["wow"],["gap"],["hem"],["yap"],["bum"],["ugh","ugh"],["aha"],["jab"],["eve"],["bop"],["lyx"],["jed"],["iva"],["rod"],["boo"],["brr"],["hog"],["nay"],["mir"],["deb","deb"],["aft"],["dis"],["yea"],["hos"],["rye"],["hey"],["doc"],["bob"],["eel"],["pen"],["job"],["max"],["oho"],["lye"],["ram"],["nap"],["elf"],["qua"],["pup","pup"],["let"],["gym"],["nam"],["bye"],["lon"]]

        List<List<String>> result = solution.groupAnagramsBy_GroupComparision(in);
        System.out.println(result);
    }

    public List<List<String>> groupAnagramsByHas(String[] strs) { //does not work alwys e.g. duh = ill

        Map<Integer, List<String>> hashToAnagramList = new HashMap<>();

        for (String current : strs) {
            int hash = 0;
            for (char c: current.toCharArray()) {
                hash += c;
            }
            List<String> anaList = hashToAnagramList.get(hash);
            if (anaList == null) {
                anaList = new ArrayList<>();
            } else {
                hashToAnagramList.remove(hash);
            }
            anaList.add(current);
            hashToAnagramList.put(hash, anaList);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(hashToAnagramList.values());

        return result;
    }

    public List<List<String>> groupAnagramsByBits(String[] strs) {
        Map<Integer, List<String>> hashToAnagramList = new HashMap<>();

        for (String current : strs) {
            String lowerCase = current.toLowerCase();
            int hash = 0;
            for (char c : lowerCase.toCharArray()) {
                hash = hash | 1 << (c - 'a');
            }
            List<String> anaList = hashToAnagramList.get(hash);
            if (anaList == null) {
                anaList = new ArrayList<>();
            } else {
                hashToAnagramList.remove(hash);
            }
            anaList.add(lowerCase);
            hashToAnagramList.put(hash, anaList);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(hashToAnagramList.values());
        return result;
    }

    public List<List<String>> groupAnagramsBy_GroupComparision(String[] strs) {
        Map<Integer, Map<String, List<String>>> hashToAnagramList = new HashMap<>();

        for (String current : strs) {
            int[] alpha = new int[26];
            int hash = 0;
            for (char c : current.toCharArray()) {
                alpha[c - 'a']+= 1;
                hash = hash | (1 << c - 'a');
            }
            Map<String, List<String>> anaMap = hashToAnagramList.get(hash);
            if (anaMap == null) {
                anaMap = new HashMap<>();
                hashToAnagramList.put(hash, anaMap);
            }

            List<String> groupFound = null;
            for (Map.Entry<String, List<String>> entry: anaMap.entrySet()) {
                String anaGroupRepr = entry.getKey();
                int[] anaGroupReprAlpha = new int[26];
                for (char c : anaGroupRepr.toCharArray()) {
                    anaGroupReprAlpha[c - 'a']+= 1;
                }
                boolean isCurrentAnagramOfThisGroupRepr = true;
                for (int i=0; i<26; i++) {
                    if (alpha[i] != anaGroupReprAlpha[i]) {
                        isCurrentAnagramOfThisGroupRepr = false;
                        break;
                    }
                }

                if (isCurrentAnagramOfThisGroupRepr) {
                    groupFound = entry.getValue();
                    break;
                }
            }

            if (groupFound == null) {
                anaMap.put(current, new ArrayList<String>(){{add(current);}});
            } else {
                groupFound.add(current);
            }
        }


        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, Map<String, List<String>>> hashToAnagramListEntry: hashToAnagramList.entrySet()) {
            Map<String, List<String>> anaMap = hashToAnagramListEntry.getValue();
            result.addAll(anaMap.values());
        }
        return result;
    }
}