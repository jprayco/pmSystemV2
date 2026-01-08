package com.pms.pmSystem.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.type.YesNoConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractRootModel extends AbstractLogPrintableModel implements RootModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DELETED")
    @Convert(converter = YesNoConverter.class)
    private Boolean deleted = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    @Override
    public boolean isNew() {
        return null == getId();
    };

    @Override
    public String printInfo() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("id", getId())
                .toString();
    }

    @Override
    public boolean equals(final Object obj) {
        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        AbstractRootModel rhs = (AbstractRootModel) obj;

        if (getId() == null && rhs.getId() == null) {
            return super.equals(rhs);

        } else {
            return new EqualsBuilder()
                    .append(getId(), rhs.getId())
                    .append(getVersion(), rhs.getVersion())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        if (getId() == null) {
            return super.hashCode();

        } else {
            return new HashCodeBuilder(7, 17)
                    .append(getId())
                    .append(getVersion())
                    .toHashCode();
        }
    }

}
