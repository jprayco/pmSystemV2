package com.pms.pmSystem.entity;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

public interface RootModel extends Persistable<Long>, Serializable {
    Long getVersion();
}
