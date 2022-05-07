package com.tvstechie.videostreamdemoreactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class VideoStreamDemoReactiveApplication {
	@Autowired
	private StreamService streamService;
	
	@GetMapping(path ="/video/{title}", produces = "video/mp4")
	public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range){
		System.out.println("Range: "+range);
		return streamService.getVideo(title);
	}

	
	@GetMapping(path ="/test")
	public String getVideo1(){
		System.out.println("Range: ");
		return "test";
	}

	
	public static void main(String[] args) {
		SpringApplication.run(VideoStreamDemoReactiveApplication.class, args);
	}

}
