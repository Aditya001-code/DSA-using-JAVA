class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }
            
            // Build key representation based on character frequencies
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
//Is code ka main goal yeh hai ki aise words ko ek group mein daalna jo same letters se bane hain (jinhe hum Anagrams kehte hain), jaise "eat", "tea", aur "ate".

// Java
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
// Line 1-2: Hum ek Magic Box (Class/Method) bana rahe hain jiska naam hai groupAnagrams. Yeh words ki ek list (strs) leta hai aur groups bana kar result return karta hai.

// Java
//         if (strs == null || strs.length == 0) return new ArrayList<>();
// Line 3: Safety Check! Agar humein mili hui words ki list bilkul khaali (empty) hai ya usme kuch hai hi nahi, toh chup-chap ek khaali result (empty list) bhej do. Koi mehnat karne ki zaroorat nahi!

// Java
//         Map<String, List<String>> map = new HashMap<>();
// Line 5: Yahan hum ek Folder System (HashMap) bana rahe hain.

// Is folder ke baahar ek Secret Tag/Code (Key) likha hoga.

// Is folder ke andar same letters wale words ki list (Value) rakhi jayegi.

// Java
//         for (String s : strs) {
// Line 7: Yeh ek Loop hai. Hum har ek word ko ek-ek karke uthate hain aur uske saath aage ka kaam karte hain.

// Java
//             int[] count = new int[26];
// Line 8: Humne 26 boxes ka ek Letter Counter Array banaya. ABCD mein total 26 letters hote hain (a se lekar z tak), toh yeh counter yaad rakhega ki kaunsa letter kitni baar aaya hai. Starting mein sabhi 26 boxes mein 0 rakha hota hai.

// Java
//             for (char c : s.toCharArray()) {
//                 count[c - 'a']++;
//             }
// Line 9-11: Ab hum us word ke har ek letter par jaate hain aur uski jagah par +1 kar dete hain.

// E.g., agar word hai "cat":

// 'a' - 'a' = Index 0 -> yahan +1 kar do.

// 'b' - 'a' = Index 1

// 'c' - 'a' = Index 2 -> yahan +1 kar do.

// Result: Humare counter ko pata chal gaya ki is word mein konse letters kitni baar hain!

// Java
//             StringBuilder sb = new StringBuilder("");
//             for (int i = 0; i < 26; i++) {
//                 sb.append('#');
//                 sb.append(count[i]);
//             }
//             String key = sb.toString();
// Line 14-20: Ab hum is word ke liye ek Unique Secret Recipe Code bana rahe hain!

// Hum har count ke aage # laga kar ek string banate hain (E.g., #1#0#0#1...).

// Magic: Sabhi anagram words (jaise "eat", "tea", "ate") ka Secret Code bilkul SAME banega, kyunki sabme letters aur unke counts same hain!

// Java
//             map.putIfAbsent(key, new ArrayList<>());
//             map.get(key).add(s);
// Line 22-23:

// Line 22: Hum HashMap se poochte hain — "Kya is Secret Code ka koi folder pehle se bana hai?" Agar nahi bana, toh ek naya khaali folder (ArrayList) bana do.

// Line 23: Phir hum us word (s) ko us Secret Code wale folder ke andar daal dete hain!

// Java
//         }
// Line 24: Loop khatam! Ab humne saare words ko unke respective Secret Folders mein baant diya hai.

// Java
//         return new ArrayList<>(map.values());
//     }
// }
// Line 26-28: HashMap ke andar jitne bhi folders (groups of anagrams) bane hain, un sabhi folders ko ek saath pack karke final answer ke roop mein return kar dete hain. Game finished! 🎉