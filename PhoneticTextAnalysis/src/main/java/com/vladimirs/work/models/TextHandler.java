package com.vladimirs.work.models;

import com.vladimirs.work.controllers.RootLayoutController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class TextHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(TextHandler.class);

    private static final HashMap<Character, Integer> phoneticLevelDictionary =
            new HashMap<Character, Integer>(){{
        put('а', 10);
        put('о', 9); put('э', 9);
        put('и', 8); put('ы', 8); put('у', 8);
        put('л', 7); put('р', 7);
        put('м', 6); put('н', 6);
        put('б', 5); put('д', 5); put('г', 5);
        put('ц', 4); put('ч', 4);
        put('в', 3); put('з', 3); put('ж', 3);
        put('т', 2); put('п', 2); put('к', 2);
        put('ш', 1);  put('с', 1);  put('ф', 1);  put('щ', 1);  put('х', 1);
    }};

    public void handle(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            char ch = charSequence.charAt(i);
            Integer level = phoneticLevelDictionary.get(ch);
            LOGGER.debug("character: {}, level: {}", ch, level);
        }
    }
}
