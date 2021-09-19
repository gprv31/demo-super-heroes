package com.demo.heroes.adapter.output.h2.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AuditEntity {

  @Column(name = "enabled")
  private Boolean enabled;

  @Column(name = "creation_date")
  private LocalDateTime creationDate;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @Column(name = "updated_by")
  private String updatedBy;

  @PrePersist
  public void prePersist() {
    creationDate = LocalDateTime.now();
    enabled = Boolean.TRUE;
  }
}
