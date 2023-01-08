package co.itriadv.austin.javaweb101;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findByTaskText(String text);

	// 可以客製化SQL語句
	public static final String FIND_PROJECTS = "SELECT task_text, task_day FROM task";

	@Query(value = FIND_PROJECTS, nativeQuery = true)
	public List<Object[]> findProjects();
}
