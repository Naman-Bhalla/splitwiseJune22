package com.scaler.splitwisejune22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Currency extends BaseModel {
    private String name;
}
