package com.naga.elastic.elasticsearchexample.repo;

import com.naga.elastic.elasticsearchexample.model.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends ElasticsearchRepository<Student,Integer> {
}
