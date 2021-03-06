/**
 * Copyright � 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.virtualnetwork.validation;

import java.io.Serializable;
import java.util.Comparator;

/**
 * The Class Inet4RangeComparator.
 */
public class Inet4RangeComparator implements Comparator<ValidatedInet4Range>, Serializable {

    private static final long serialVersionUID = 1L;


    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(ValidatedInet4Range o1, ValidatedInet4Range o2) {
        return o1.compareTo(o2);
    }

}
