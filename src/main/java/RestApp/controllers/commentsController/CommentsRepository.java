package RestApp.controllers.commentsController;

import RestApp.models.BookComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<BookComment, Integer> {
}
