package com.example.sima.DTO.share;

import java.io.Serializable;

public class HasUserPermissionDTO extends GeneralDTO{
    private boolean hasUserPermission;

    public boolean hasUserPermission() {
        return hasUserPermission;
    }

    public void setHasUserPermission(boolean hasUserPermission) {
        this.hasUserPermission = hasUserPermission;
    }
}
