package org.cbs.data.admin.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class CarWashOwner {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
