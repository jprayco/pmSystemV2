package com.pms.pmSystem.entity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Attachment {

    @Column(name = "NAME")
    private String name;

    @Column(name="PATH")
    private String path;

}
