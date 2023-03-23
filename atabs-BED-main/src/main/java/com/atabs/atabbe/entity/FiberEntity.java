package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "fibers")
public class FiberEntity {

    @Id
    @GeneratedValue(generator = "fiber_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "fiber_seq", sequenceName = "fiber_sequence", initialValue = 101,allocationSize = 50)
    @Column(name = "fiberId")
    private long fiberId;

    private String name;

    @Column(name="status", nullable = false, columnDefinition="INT NOT NULL DEFAULT 0")
    private int status = 0;
    private LocalDateTime createDate;

    @OneToMany(targetEntity = FiberItemEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fiberId" ,referencedColumnName ="fiberId" )
    private List<FiberItemEntity> items;

    public long getFiberId() {
        return fiberId;
    }

    public void setFiberId(long fiberId) {
        this.fiberId = fiberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<FiberItemEntity> getItems() {
        return items;
    }

    public void setItems(List<FiberItemEntity> items) {
        this.items = items;
    }

    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();
    }

}
