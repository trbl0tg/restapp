package ua.legendarytec.restapp.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.legendarytec.restapp.domain.Message;
import ua.legendarytec.restapp.repos.MessageRepo;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("message")
public class MessageController{

    private final MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }


    @GetMapping
    public List<Message> list(){
        return messageRepo.findAll();
    }


//    @GetMapping("{id}")
//    public Map<String, String> getOneMessage(@PathVariable String id){
//        return getMessageFormDb(id);
//    }

    @PostMapping
    public Message create(@RequestBody Message message){
        message.setCreationDate(LocalDateTime.now());
        return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public Message update(
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message){
        BeanUtils.copyProperties(message, messageFromDb, "id");
        return messageRepo.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message){
        messageRepo.delete(message);
    }
}





