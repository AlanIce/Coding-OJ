public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        if (maxWidth == 0) {
            lines.add("");
            return lines;
        }
        fullJustify(words, maxWidth, 0, lines);
        return lines;
    }

    private void fullJustify(String[] words, int maxWidth, int index, List<String> lines) {
        if (index >= words.length) return;
        int width = words[index].length();
        int nextIndex = index + 1;
        while (width <= maxWidth && nextIndex < words.length) {
            width += words[nextIndex++].length() + 1;
        }
        if (nextIndex != words.length || width > maxWidth) width -= words[--nextIndex].length() + 1;
        StringBuilder sb = new StringBuilder();
        sb.append(words[index]);
        if (nextIndex - index - 1 == 0) {
            for (int i = 0; i < maxWidth - width; i++) sb.append(' ');
        } else if (nextIndex == words.length) {
            for (int i = 1; i < nextIndex - index; i++) {
                sb.append(' ');
                sb.append(words[i + index]);
            }
            for (int i = 0; i < maxWidth - width; i++) sb.append(' ');
        } else {
            int average = (maxWidth - width) / (nextIndex - index - 1) + 1;
            int surplus = (maxWidth - width) % (nextIndex - index - 1);
            for (int i = 1; i < nextIndex - index; i++) {
                if (i <= surplus) sb.append(' ');
                for (int j = 0; j < average; j++) sb.append(' ');
                sb.append(words[i + index]);
            }
        }
        lines.add(sb.toString());
        fullJustify(words, maxWidth, nextIndex, lines);
    }
}