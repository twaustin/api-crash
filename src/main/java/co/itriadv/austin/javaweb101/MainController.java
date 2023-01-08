package co.itriadv.austin.javaweb101;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
	public @ResponseBody String addTask(@RequestBody Task data) throws JsonProcessingException {
//		Task t = new Task();
//		t.setTaskText(data.getTaskText());
//		t.setTaskDay(data.getTaskDay());
//		t.setReminder(data.getReminder());
		taskRepository.save(data);
		taskRepository.flush();
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(data);
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.DELETE })
	public @ResponseBody String delTask(@PathVariable(value = "id") Integer id) {

		Task t = new Task();
		t.setId(id);
		taskRepository.delete(t);
		return "Del Successfully";
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.PUT })
	public @ResponseBody String updateTask(@RequestBody Task data) throws JsonProcessingException {
		taskRepository.save(data);
		taskRepository.flush();
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(data);
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.GET })
	public @ResponseBody Task getImageNode(@PathVariable(value = "id") Integer id) {

		return taskRepository.findById(id).get();
	}

}
