package com.pms.pmSystem.data.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pms.pmSystem.entity.model.Attachment;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
public class ProjectCreateRequestDTO {
    public Long id;

    private String proj_name;


    private String proj_des;

    private String proj_code;

    private String proj_client_name;

    private LocalDateTime proj_po_date;

    private LocalDateTime proj_kick_off_date;

    private LocalDateTime proj_implem_start_date;

    private String proj_current_task;

    private String proj_current_task_status;

    private String proj_next_task;

    private String proj_next_task_target_start_date;

    private String proj_health;

    private String proj_resource;

    private LocalDateTime proj_deply_date;

    private LocalDateTime proj_training_date;

    private LocalDateTime proj_knowlegde_trans_date;

    private LocalDateTime proj_cocso_date;

    private String proj_overall_completion;

    private LocalDateTime proj_contract_period_date;

    private List<AttachmentDTO> attachments;

}
