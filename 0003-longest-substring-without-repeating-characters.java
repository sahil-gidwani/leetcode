class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Stores the next index after the last occurrence of each character.
        // 0 means the character has never appeared.
        int[] lastSeen = new int[128];

        int left = 0, ans = 0;

        // EXPAND: Move right to include one new character in the window.
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // CONTRACT: If this character already exists in our current window,
            // move left just past its previous occurrence.
            // Math.max ensures left never moves backwards.
            left = Math.max(left, lastSeen[c]);

            // Current valid window is [left, right].
            // Update the maximum length found so far.
            ans = Math.max(ans, right - left + 1);

            // Update the last seen position of this character.
            // Store right + 1 so that 0 can represent "never seen".
            lastSeen[c] = right + 1;
        }

        return ans;
    }
}
