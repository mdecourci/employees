package co.uk.netpod.application.repository;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Table(name = "DOCUMENT")
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DATA_GEN")
    @SequenceGenerator(name = "DATA_GEN", sequenceName = "DATA_SEQ")
    @Column(name = "DOCUMENT_ID")
    private Long documentId;
    @Column
    private Integer sort_order;
    @Column
    private String description;
    @Column
    private String data_source_type;

//    @OneToMany
//    @JoinTable(name = "DATA_VALUE", joinColumns = @JoinColumn(name = "META_ID"))
//    private Set<DataValue> dataValues = new HashSet<>();
}
