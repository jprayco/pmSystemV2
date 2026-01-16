package com.pms.pmSystem.data.enums;

import java.util.Map;

import com.google.common.collect.Maps;

public enum AuditAction {
    CREATE_USER("CREATE_USER", "Create user"),
    UPDATE_USER("UPDATE_USER", "Update user"),
    DELETE_USER("DELETE_USER", "Delete user"),
    CREATE_PROJECT("CREATE_PROJECT", "Create project"),
    UPDATE_PROJECT("UPDATE_PROJECT", "Update project"),
    DELETE_PROJECT("DELETE_PROJECT", "Delete project");

    private String code;
    private String description;

    AuditAction(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private static final Map<String, AuditAction> LOOKUP = Maps.newHashMap();

    static {
        for (AuditAction auditAction : AuditAction.values()) {
            LOOKUP.put(auditAction.code.toLowerCase(), auditAction);
        }
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }

    public static AuditAction get(String code) {
        return LOOKUP.get(code.toLowerCase());
    }
}
