package priv.alanice.coding.leetcode.contest;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AlanIce on 2017/6/4.
 */
public class Item035003 {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    public List<List<String>> findDuplicate(String[] paths) {
        int count = 0;
        for (String path : paths) {
            FileHolder fileHolder = getInfo(path);
            for (int i = 0; i < fileHolder.file.size(); i++) {
                String singleFile = fileHolder.file.get(i);
                String singleContent = fileHolder.content.get(i);
                if (map.get(singleContent) == null) {
                    List<String> list = new ArrayList<String>();
                    list.add(singleFile);
                    map.put(singleContent, list);
                } else {
                    map.get(singleContent).add(singleFile);
                }
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }

    class FileHolder {
        String directory;
        List<String> file = new ArrayList<String>();
        List<String> content = new ArrayList<String>();
    }

    public FileHolder getInfo(String info) {
        String[] infos = info.split(" ");
        FileHolder fileHolder = new FileHolder();
        fileHolder.directory = infos[1];
        Pattern pattern = Pattern.compile("([\\d|a-z|A-Z]*?\\.txt)\\((.*?)\\)");
        for (int i = 0; i < infos.length; i++) {
            Matcher matcher = pattern.matcher(infos[i]);
            if (matcher.find()) {
                fileHolder.file.add(fileHolder.directory + "/" + matcher.group(1));
                fileHolder.content.add(matcher.group(2));
            } else
                throw new RuntimeException("Can't match!");
        }
        return fileHolder;
    }


}
