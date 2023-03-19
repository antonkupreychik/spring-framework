package com.javarush.context.lesson9.controller;

import com.javarush.context.lesson5.dto.UserDTO;
import com.javarush.context.lesson9.listener.event.AccessType;
import com.javarush.context.lesson9.listener.event.EntityEvent;
import com.javarush.context.lesson9.repository.CountryRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller
@SessionAttributes(value = "user")
@RequiredArgsConstructor
public class GreetingController {

    private final ApplicationEventPublisher publisher;

    @GetMapping("/hello")
    public ModelAndView hello(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
        modelAndView.setViewName("hello");
        log.info("{}", httpServletRequest.getSession().getId());
        var user = new UserDTO(1L, "Anton", "email@email.com");
        modelAndView.addObject("user", user);
        publisher.publishEvent(new EntityEvent(user, AccessType.DELETE));
        return modelAndView;
    }

    @GetMapping("/greeting/{name2}")
    public ModelAndView greetings(@PathVariable String name2,
                                  @RequestParam(required = false, defaultValue = "World") String name,
                                  @RequestParam(required = false, defaultValue = "12") Integer age,
                                  @RequestHeader(name = "User-Agent", required = false) String header,
                                  @CookieValue(name = "JSESSIONID", required = false) String cookieJSession,
                                  HttpServletRequest httpRequest,
                                  HttpServletResponse httpResponse,
                                  CountryRepository countryRepository,
                                  ModelAndView modelAndView) {
        modelAndView.setViewName("greeting");
        modelAndView.addObject("name", name2);
        return modelAndView;
    }

    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserDTO user,
                      HttpServletRequest request) {
        request.setAttribute("name", user.name());
        return "bye";
    }

    @GetMapping("/hello2")
    public String hello2(Model model, UserDTO userDTO) {
        model.addAttribute("user", userDTO);
        return "hello";
    }


}
