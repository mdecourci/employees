package co.uk.netpod.application.repository;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DATA_KEY")
@Builder
@Data
public class DataKey {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DATA_GEN")
    @SequenceGenerator(name = "DATA_GEN", sequenceName = "DATA_SEQ")
    @Column(name = "META_ID")
    private Long id;
    @Column
    private String key;
    
//    @OneToOne
////    @JoinTable(name = "DATA_VALUE", joinColumns = @JoinColumn(name = "META_ID"))
//    @JoinColumn(name = "META_ID")
//    private DataValue dataValue;
    
}

