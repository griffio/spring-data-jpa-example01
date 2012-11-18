package org.example.dao.domain;

import com.google.common.base.Objects;
import org.springframework.data.domain.Persistable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * <code>AbstractPersistableSequence</code>
 * The actual sequence is overridden in subclasses
 */
@MappedSuperclass
public class AbstractPersistableSequence implements Persistable<Long> {

    private static final long serialVersionUID = -42L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return getId() == null;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("id", getId()).toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        AbstractPersistableSequence that = (AbstractPersistableSequence) obj;

        return Objects.equal(this.getId(), that.getId());

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

}

