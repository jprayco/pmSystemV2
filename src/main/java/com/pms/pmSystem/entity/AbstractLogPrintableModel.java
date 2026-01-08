package com.pms.pmSystem.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;

public abstract class AbstractLogPrintableModel implements LogPrintableModel {

    @Override
    public String toString() {
        if (logger().isTraceEnabled()) {
            return printTrace();

        } else if (logger().isDebugEnabled()) {
            return printDebug();

        } else {
            return printInfo();
        }
    }

    protected abstract Logger logger();

    @Override
    public String printDebug() {
        return printInfo();
    }

    @Override
    public String printInfo() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }

    @Override
    public String printTrace() {
        return printDebug();
    }

}
