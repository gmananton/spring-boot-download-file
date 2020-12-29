package com.gman.repository;

import com.gman.domain.BlogPost;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by Anton Mikhaylov on 24.12.2020.
 */
public interface BlogRepository extends ElasticsearchRepository<BlogPost, String> {

//    Page<BlogPost> find
}
