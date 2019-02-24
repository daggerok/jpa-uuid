package com.gituhb.daggerok.jpauuid.rest;

import com.gituhb.daggerok.jpauuid.auto.MyAutoEntity;
import com.gituhb.daggerok.jpauuid.auto.MyAutoRepository;
import com.gituhb.daggerok.jpauuid.manual.MyManualEntity;
import com.gituhb.daggerok.jpauuid.manual.MyManualRepository;
import io.vavr.collection.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MyRestResource {
  final MyAutoRepository myAutoRepository;
  final MyManualRepository myManualRepository;

  @GetMapping("/auto/**")
  public Collection findAllAuto() {
    return myAutoRepository.findAll();
  }

  @PostMapping("/auto/**")
  public MyAutoEntity createNewAuto(@RequestBody MyAutoEntity request) {
    return myAutoRepository.save(MyAutoEntity.of(UUID.randomUUID(), request.getMessage()));
  }

  @GetMapping("/manual/**")
  public Collection findAllManual() {
    return myManualRepository.findAll();
  }

  @PostMapping("/manual/**")
  public MyManualEntity createNewManual(@RequestBody MyAutoEntity request) {
    return myManualRepository.save(MyManualEntity.of(UUID.randomUUID(), request.getMessage()));
  }

  @GetMapping("/**")
  public Map root() {
    return HashMap.of("find all auto", "http :8080/auto",
                      "create new auto", "http :8080/auto message=new-auto",
                      "find all manual", "http :8080/manual",
                      "create new manual", "http :8080/auto message=new-manual").toJavaMap();
  }
}
