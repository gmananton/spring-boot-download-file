package com.gman.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anton Mikhaylov on 23.12.2020.
 */
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "blog")
public class BlogPost implements SearchableItem {

    @Id
    private String title;

    private String body;

    @Singular("tag")
    private Set<String> tags;

    @Override
    public String getId() {
        return title;
    }

    @Override
    public String getValue() {
        return body;
    }

    @Override
    public Collection<String> getAdditionalFields() {
        return new HashSet<>() {{
            addAll(tags);
        }};
    }
}
