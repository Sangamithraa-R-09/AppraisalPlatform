package com.appraisalplatform.appraisalplatform.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Role")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    private Long roleId;

    private String roleName;
}
