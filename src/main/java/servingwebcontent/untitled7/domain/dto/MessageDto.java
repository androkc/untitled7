package servingwebcontent.untitled7.domain.dto;

import lombok.Getter;
import lombok.ToString;
import servingwebcontent.untitled7.domain.Message;
import servingwebcontent.untitled7.domain.User;
import servingwebcontent.untitled7.domain.util.MessageHelper;

@Getter
@ToString(exclude = {"text","tag","filename"})
public final class MessageDto {
    private Long id;
    private String text;
    private String tag;
    private User author;
    private String filename;
    private Long likes;
    private Boolean meLiked;

    public MessageDto(Message message, Long likes, Boolean meLiked) {
        this.id = message.getId();
        this.text = message.getText();
        this.tag = message.getTag();
        this.author = message.getAuthor();
        this.filename = message.getFilename();
        this.likes = likes;
        this.meLiked = meLiked;
    }
    public String getAuthorName() {
        return MessageHelper.getAuthorName(author);
    }
}
