package io.gjorovski.author.domain.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 16/10/2021 - 4:46 PM
 * @project mindware
 */
public class ListUtils {

    public static <T> List<T> empty() {
        return new ArrayList<>();
    }
}
