package co.itriadv.austin.javaweb101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequestMapping(path = "/tasks") // This means URL's start with /demo (after
// Application path)
@CrossOrigin
public class MainController {

	@Autowired
	private TaskRepository taskRepository;

	@RequestMapping(path = "", method = { RequestMethod.GET })
	public @ResponseBody Iterable<Task> getAllTask() {
		return taskRepository.findAll();
	}

	@RequestMapping(path = "", method = { RequestMethod.POST })
	public @ResponseBody String addTask(@RequestParam String text, @RequestParam String day,
			@RequestParam Boolean reminder) {
		Task t = new Task();
		t.setTaskText(text);
		t.setTaskDay(day);
		t.setReminder(reminder);
		taskRepository.save(t);
		return "Save Successfully";
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.DELETE })
	public @ResponseBody String delTask(@PathVariable(value = "id") Integer id) {

		Task t = new Task();
		t.setId(id);
		taskRepository.delete(t);
		return "Del Successfully";
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.PUT })
	public @ResponseBody String updateTask(@PathVariable(value = "id") Integer id) {

		Task t = new Task();
		t.setId(id);
		taskRepository.delete(t);
		return "Update Successfully";
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.GET })
	public @ResponseBody Task getImageNode(@PathVariable(value = "id") Integer id) {

		return taskRepository.findById(id).get();
	}

}
