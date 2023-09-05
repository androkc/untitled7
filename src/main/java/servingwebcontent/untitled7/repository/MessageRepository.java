package servingwebcontent.untitled7.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import servingwebcontent.untitled7.domain.Message;

import org.springframework.data.domain.Pageable;
import servingwebcontent.untitled7.domain.User;
import servingwebcontent.untitled7.domain.dto.MessageDto;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    @Query("select new servingwebcontent.untitled7.domain.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "    case when sum(case when ml = :user then 1 else 0 end) > 0 then true else false end" +
            ") " +
            "from Message m left join m.likes ml " +
            "group by m")
    Page<MessageDto> findAll(Pageable pageable, @Param("user") User user);

    @Query("select new servingwebcontent.untitled7.domain.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "    case when sum(case when ml = :user then 1 else 0 end) > 0 then true else false end" +
            ") " +
            "from Message m left join m.likes ml " +
            "where m.tag = :tag " +
            "group by m")
    Page<MessageDto> findByTag(@Param("tag")String tag, Pageable pageable, @Param("user") User user);

    @Query("select new servingwebcontent.untitled7.domain.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "    case when sum(case when ml = :user then 1 else 0 end) > 0 then true else false end" +
            ") " +
            "from Message m left join m.likes ml " +
            "where m.author = :author " +
            "group by m")
    Page<MessageDto> findByUser(Pageable pageable, @Param("author") User author, @Param("user") User user);
}
