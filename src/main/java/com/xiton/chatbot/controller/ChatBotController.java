package com.xiton.chatbot.controller;

import com.xiton.chatbot.bean.Question;
import com.xiton.chatbot.service.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chmj
 * @description
 * @date 2023/04/04
 */

@RestController
@RequestMapping("/chat")
public class ChatBotController {

    @Autowired
    private ChatBotService chatBotService;


    @PostMapping("/answer")
    public String doAnswer(@RequestBody Question answer) {
        return chatBotService.completions(answer.getQuestion());
    }

}
