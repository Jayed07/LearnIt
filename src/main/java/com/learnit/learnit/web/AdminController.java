package com.learnit.learnit.web;

import com.learnit.learnit.model.binding.AnswerAddBindingModel;
import com.learnit.learnit.model.entity.UserEntity;
import com.learnit.learnit.model.entity.UserRoleEntity;
import com.learnit.learnit.model.entity.enums.UserRole;
import com.learnit.learnit.model.service.AnswerAddServiceModel;
import com.learnit.learnit.repository.QuestionRepository;
import com.learnit.learnit.repository.UserRepository;
import com.learnit.learnit.repository.UserRoleRepository;
import com.learnit.learnit.service.AnswerService;
import com.learnit.learnit.service.QuestionService;
import com.learnit.learnit.service.UserService;
import com.learnit.learnit.view.QuestionViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;
    private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public AdminController(UserService userService, QuestionRepository questionRepository, QuestionService questionService, AnswerService answerService, ModelMapper modelMapper, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userService = userService;
        this.questionRepository = questionRepository;
        this.questionService = questionService;
        this.answerService = answerService;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @GetMapping("/admin")
    public String adminPanel() {
        return "admin";
    }

    @GetMapping("/admin-user")
    public String adminUser(Model model) {

        model.addAttribute("users", userRepository.findAll());



        return "admin-user";
    }

    @GetMapping("/admin-user/{id}")
    public String changeUserRole(@PathVariable Long id) {

        userService.changeUserRoleByUserId(id);


        return "redirect:/admin-user";
    }

    @GetMapping("/admin-contact")
    public String adminContact(Model model) {

        model.addAttribute("questions", questionRepository.findAll());

        return "admin-contact";
    }

    @GetMapping("/admin-answer/{id}")
    public String adminAnswer(@PathVariable Long id, Model model) {

        if (!model.containsAttribute("answerAddBindingModel")) {
            model.addAttribute("answerAddBindingModel", new AnswerAddBindingModel());
        }


        QuestionViewModel questionViewModel = questionService.findById(id);

        model.addAttribute("question", questionViewModel);

        return "admin-answer";
    }

    @PostMapping("/admin-answer/{id}")
    public String adminAnswerConfirm(@PathVariable Long id,@Valid AnswerAddBindingModel answerAddBindingModel,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("answerAddBindingModel", answerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.answerAddBindingModel", bindingResult);

            return "redirect:/admin-answer/{id}";
        }

        answerService
                .add(modelMapper.map(answerAddBindingModel, AnswerAddServiceModel.class), questionRepository.findById(id).orElse(null));



        return "redirect:/admin";
    }



}
