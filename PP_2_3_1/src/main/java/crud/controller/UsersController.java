package crud.controller;

import crud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import crud.service.UserService;
import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class UsersController {
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping()
	public String showAllUsers(ModelMap model) {
		model.addAttribute("users", userService.getUsers());

		return "allUsers";
	}

	@GetMapping("/addNewUser")
	public String addNewUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "user-info";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "user-info";

		userService.saveUser(user);

		return "redirect:/";
	}

	@PatchMapping("/{id}")
	public String updateUser(@PathVariable("id") int id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);

		return "user-info";
	}

	@DeleteMapping("/{id}/delete")
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);

		return "redirect:/";
	}
}