package com.spring.bluecoding.repo;

import com.spring.bluecoding.entity.ShortUrl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface UrlRepo extends CrudRepository<ShortUrl, Long> {


    Optional<ShortUrl> findByShortUrl (String shortUrl);

    @Query(nativeQuery = true, value = " select * from short_url order by clicks limit 100")
    Optional<List<ShortUrl>> findFrequently();

}
