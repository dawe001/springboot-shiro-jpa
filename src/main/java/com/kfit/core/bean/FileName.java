package com.kfit.core.bean;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by davi on 2017/7/16.
 */
@Embeddable
public class FileName {
    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String extension;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileName fileName1 = (FileName) o;
        return Objects.equal(fileName, fileName1.fileName) &&
                Objects.equal(extension, fileName1.extension);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fileName, extension);
    }
}
