package com.ndp.campaignmanagement.utils.splittingCID;

import java.util.Arrays;
import java.util.List;

public class SplittingCustomerID {
    public static List<String> splitId(String strListIds) {
        String raw = strListIds;

        String[] ids = raw.split(";");

        List<String> finalIds = Arrays.asList(ids);

        return finalIds;
    }
}
