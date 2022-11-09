package com.hand.spring.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

@FieldNameConstants(prefix = "FIELD_")
//@FieldNameConstants(prefix = "field")
//@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@ToString
//@EqualsAndHashCode
public class Person implements Cloneable{
    private String name;
    private Integer age;
    private String familyRel;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
