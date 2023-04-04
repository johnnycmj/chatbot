package com.xiton.chatbot.service;

import com.xiton.chatbot.config.OpenAiConfig;
import com.xiton.chatbot.openai.OpenAiApi;
import com.xiton.chatbot.openai.model.CreateCompletionRequest;
import com.xiton.chatbot.openai.model.CreateCompletionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chmj
 * @description
 * @date 2023/04/04
 */

@Service
@Slf4j
public class ChatBotService {

    @Autowired
    private OpenAiApi openAiApi;

    @Autowired
    private OpenAiConfig openAiConfig;

    public String completions(String prompt) {
        CreateCompletionRequest request = new CreateCompletionRequest();
        request.setPrompt(prompt);
        request.setModel(openAiConfig.getModel());
        request.setTemperature(0);
        request.setMax_tokens(1024);
        CreateCompletionResponse response = openAiApi.createCompletion(request, openAiConfig.getApiKey());
        List<CreateCompletionResponse.ChoicesItem> choicesItemList = response.getChoices();
        String answer = choicesItemList.stream()
                .map(CreateCompletionResponse.ChoicesItem::getText)
                .collect(Collectors.joining());
        log.info("OpenAiAnswerer 回答成功 \n 答案：{}", answer);
        return answer;
    }

}
