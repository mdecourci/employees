package co.uk.netpod.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//@Repository
public interface DataValueRepository extends MongoRepository<DataValue, Long> {
    List<DataValue> findByDocument(Document pDocument);
}
