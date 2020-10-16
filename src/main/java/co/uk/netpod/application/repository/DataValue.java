package co.uk.netpod.application.repository;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DATA_VALUE")
@Builder
@Data
public class DataValue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DATA_GEN")
    @SequenceGenerator(name = "DATA_GEN", sequenceName = "DATA_SEQ")
    private Long Id;

    @Column(name = "META_ID", insertable = false, updatable = false)
    private Long metaId;
    
    @Column
    private String value;

    @Column
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "META_ID")
    private DataKey dataKey;
    
    @ManyToOne
//    @JoinTable(name = "DOCUMENT", joinColumns = @JoinColumn(name = "DOCUMENT_ID"))
    @JoinColumn(name = "DOCUMENT_ID")
    private Document document;
}
