package com.xiton.chatbot.controller;

import com.xiton.chatbot.bean.Question;
import com.xiton.chatbot.service.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/answer")
    public String doAnswer(@RequestParam("question") String question) {
        return chatBotService.completions(question);
    }

}
