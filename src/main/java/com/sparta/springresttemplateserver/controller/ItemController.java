package com.sparta.springresttemplateserver.controller;


import com.sparta.springresttemplateserver.dto.ItemResponseDto;
import com.sparta.springresttemplateserver.dto.UserRequestDto;
import com.sparta.springresttemplateserver.entity.Item;
import com.sparta.springresttemplateserver.service.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
public class ItemController {

    // 클라이언트 입장에서 RestTemplate로 보내온 요청을 받는 Controller임

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/get-call-obj")
    public Item getCallObject(@RequestParam String query) {
        return itemService.getCallObject(query);
    }

    @GetMapping("/get-call-list")
    public ItemResponseDto getCallList() {
        return itemService.getCallList();
    }

    @GetMapping("/post-call/{query}")
    public Item postCall(@PathVariable String query, @RequestBody UserRequestDto requestDto) {
        return itemService.postCall(query, requestDto);
    }

    @GetMapping("/exchange-call")
    public ItemResponseDto exchangeCall(@RequestHeader("X-Authorization") String token, @RequestBody UserRequestDto requestDto) {
        return itemService.exchangeCall(token, requestDto);
    }
}
