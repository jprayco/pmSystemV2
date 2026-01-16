package com.pms.pmSystem.entity.model;

import com.pms.pmSystem.data.enums.AuditAction;
import com.pms.pmSystem.entity.AbstractAuditableModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "AUDIT_LOGS")
public class AuditLogs extends AbstractAuditableModel {

    @Column(name = "AUDIT_ACTION")
    @Enumerated(EnumType.STRING)
    private AuditAction auditAction;

    @Column(name = "ACTOR")
    private String actor;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "DEVICE")
    private String device;

    @Column(name = "OS")
    private String os;

    @Column(name = "BROWSER")
    private String browser;

}
