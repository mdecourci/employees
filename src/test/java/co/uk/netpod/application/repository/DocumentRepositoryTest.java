package co.uk.netpod.application.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Ignore
public class DocumentRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private DocumentRepository documentRepository;
    
    @Autowired
    private DataValueRepository dataValueRepository;
    
    @Test
    public void shouldFindDocument() {
    
        // create key
        DataKey dataKey = DataKey.builder().key("settlement").build();
        entityManager.persist(dataKey);

        // create document
        Document document = Document.builder()
                .data_source_type("jdbc")
                .description("a jdbc document")
                .sort_order(1).build();
    
        document =  entityManager.persist(document);
    
        // create value
        DataValue dataValue = DataValue.builder()
                .metaId(dataKey.getId())
                .value("Morning")
                .description("settlement value")
                .dataKey(dataKey)
                .document(document)
                .build();
        entityManager.persist(dataValue);

        entityManager.flush();

        Optional<Document> d = documentRepository.findById(document.getDocumentId());
    
        List<DataValue> dataValues =  dataValueRepository.findByDocument(document);
        
        System.out.println("hello");
        
    }
    
    @Test
    public void shouldFindDocumentWithManyValues() {
        
        // create key
        DataKey dataKey = DataKey.builder().key("settlement").build();
        DataKey dataKey1 = DataKey.builder().key("environment").build();
        entityManager.persist(dataKey);
        entityManager.persist(dataKey1);
    
        // create document
        Document document = Document.builder()
                .data_source_type("jdbc")
                .description("a jdbc document")
                .sort_order(1).build();
        
        document = entityManager.persist(document);
        
        // create value
        DataValue dataValue = DataValue.builder()
                .metaId(dataKey.getId())
                .value("Morning")
                .description("settlement value")
                .dataKey(dataKey)
                .document(document)
                .build();
        entityManager.persist(dataValue);

        DataValue dataValue1 = DataValue.builder()
                .metaId(dataKey1.getId())
                .value("ECO")
                .description("ECO value")
                .dataKey(dataKey1)
                .document(document)
                .build();
        entityManager.persist(dataValue);
        entityManager.persist(dataValue1);
    
        entityManager.flush();
        
        Optional<Document> d = documentRepository.findById(document.getDocumentId());
        
        List<DataValue> dataValues = dataValueRepository.findByDocument(document);
        
        System.out.println("hello");
        
    }
    
    @Test
    public void shouldFindManyDocumentsWithManyValues() {
        
        // create key
        DataKey dataKey = DataKey.builder().key("settlement").build();
        DataKey dataKey1 = DataKey.builder().key("environment").build();
        DataKey dataKey2 = DataKey.builder().key("cash").build();
        DataKey dataKey3 = DataKey.builder().key("balance").build();
        entityManager.persist(dataKey);
        entityManager.persist(dataKey1);
        entityManager.persist(dataKey2);
        entityManager.persist(dataKey3);
    
        // create document
        Document document = Document.builder()
                .data_source_type("jdbc")
                .description("a jdbc document")
                .sort_order(1).build();
        
        document = entityManager.persist(document);

        Document document1 = Document.builder()
                .data_source_type("jpa")
                .description("a jpa document")
                .sort_order(2).build();
    
        document1 = entityManager.persist(document1);
    
        // create value
        DataValue dataValue = DataValue.builder()
                .metaId(dataKey.getId())
                .value("Morning")
                .description("settlement value")
                .dataKey(dataKey)
                .document(document)
                .build();
        entityManager.persist(dataValue);
        
        DataValue dataValue1 = DataValue.builder()
                .metaId(dataKey1.getId())
                .value("ECO")
                .description("ECO value")
                .dataKey(dataKey1)
                .document(document)
                .build();
    
        DataValue dataValue2 = DataValue.builder()
                .metaId(dataKey2.getId())
                .value("GBP")
                .description("Pounds")
                .dataKey(dataKey2)
                .document(document)
                .build();
    
        DataValue dataValued1 = DataValue.builder()
                .metaId(dataKey1.getId())
                .value("Hostile")
                .description("Hostile value")
                .dataKey(dataKey1)
                .document(document1)
                .build();
    
        DataValue dataValued11 = DataValue.builder()
                .metaId(dataKey2.getId())
                .value("US")
                .description("US dollars")
                .dataKey(dataKey2)
                .document(document1)
                .build();
    
        DataValue dataValued12 = DataValue.builder()
                .metaId(dataKey3.getId())
                .value("Debit")
                .description("200.0")
                .dataKey(dataKey3)
                .document(document1)
                .build();
    
        entityManager.persist(dataValue);
        entityManager.persist(dataValue1);
        entityManager.persist(dataValue2);
        entityManager.persist(dataValued1);
        entityManager.persist(dataValued11);
        entityManager.persist(dataValued12);
    
        entityManager.flush();
        
        Optional<Document> d = documentRepository.findById(document.getDocumentId());
        
        List<DataValue> dataValues = dataValueRepository.findByDocument(document);
        List<DataValue> dataValues1 = dataValueRepository.findByDocument(document1);
    
        System.out.println("hello");
        
    }
    
}