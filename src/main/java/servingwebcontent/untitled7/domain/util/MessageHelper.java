package servingwebcontent.untitled7.domain.util;

import servingwebcontent.untitled7.domain.User;

public class MessageHelper {
    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}
