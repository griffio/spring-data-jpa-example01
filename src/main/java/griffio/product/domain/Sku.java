package griffio.product.domain;

import com.google.common.base.Objects;

import java.io.Serializable;

public class Sku implements Serializable {

    private String code;

    public Sku(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCode());
    }

    @Override
    public boolean equals(Object other) {

        if (null == other) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!getClass().equals(other.getClass())) {
            return false;
        }

        Sku otherSku = (Sku) other;

        return Objects.equal(this.getCode(), otherSku.getCode());
    }

    @Override
    public String toString() {
        return code;
    }
}
