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

    @PostMapping("/post-call/{query}") // Post
    public Item postCall(@PathVariable String query, @RequestBody UserRequestDto requestDto) {
        return itemService.postCall(query, requestDto);
    }

    @PostMapping("/exchange-call") // Post
    public ItemResponseDto exchangeCall(@RequestHeader("X-Authorization") String token, @RequestBody UserRequestDto requestDto) {
        // Header에 X-Authorization으로 key를 넣어주었으므로 받아올 때도 똑같이 받아옴
        return itemService.exchangeCall(token, requestDto);
    }
}
