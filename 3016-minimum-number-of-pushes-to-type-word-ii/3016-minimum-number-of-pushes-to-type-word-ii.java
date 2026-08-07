class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int res = 0;

        int freq[] = new int[26];

        //count freq of each char
        for(char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }

        // sort the freq array;
        Arrays.sort(freq);

        // Calculation of ans
        int idx = 0;

        for(int i = 25; i >= 0; i--){
            if(freq[i] == 0) continue;

            res += (freq[i] * ((idx/8) + 1));
            idx++;
        }

        return res;
    }
}