package com.pms.pmSystem.entity.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pms.pmSystem.entity.AbstractAuditableModel;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PROJECT")
public class Project extends AbstractAuditableModel {

    @Column(name = "PROJ_NAME")
    private String proj_name;

    @Column(name = "PROJ_DES")
    private String proj_des;

    @Column(name = "PROJ_CODE")
    private String proj_code;

    @Column(name = "PROJ_CLIENT_NAME")
    private String proj_client_name;

    @Column(name = "PROJ_PO_DATE")
    private LocalDateTime proj_po_date;

    @Column(name = "PROJ_KICK_OFF_DATE")
    private LocalDateTime proj_kick_off_date;
    
    @Column(name = "PROJ_IMPLEM_START_DATE")
    private LocalDateTime proj_implem_start_date;
    
    @Column(name = "PROJ_CURRENT_TASK")
    private String proj_current_task;
    
    @Column(name = "PROJ_CURRENT_TASK_STATUS")
    private String proj_current_task_status;
    
    @Column(name = "PROJ_NEXT_TASK")
    private String proj_next_task;
    
    @Column(name = "PROJ_NEXT_TASK_TARGET_START_DATE")
    private String proj_next_task_target_start_date;
    
    @Column(name = "PROJ_HEALTH")
    private String proj_health;
    
    @Column(name = "PROJ_RESOURCE")
    private String proj_resource;
    
    @Column(name = "PROJ_DEPLY_DATE")
    private LocalDateTime proj_deply_date;
    
    @Column(name = "PROJ_TRAINING_DATE")
    private LocalDateTime proj_training_date;
    
    @Column(name = "PROJ_KWONLEGDE_TRANS_DATE")
    private LocalDateTime proj_knowlegde_trans_date;
    
    @Column(name = "PROJ_COSCO_DATE")
    private LocalDateTime proj_cocso_date;
    
    @Column(name = "PROJ_OVERALL_COMPLETION")
    private String proj_overall_completion;

    @Column(name = "PROJ_CONTRACT_PERIOD_DATE")
    private LocalDateTime proj_contract_period_date;

    @CollectionTable(name = "PROJECT_ATTACHMENT", joinColumns=@JoinColumn(name = "ID"))
    @ElementCollection
    private List<Attachment> attachments = new ArrayList<>();
}
