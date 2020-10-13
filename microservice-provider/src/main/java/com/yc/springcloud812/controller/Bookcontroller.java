package com.yc.springcloud812.controller;


import com.yc.springcloud812.domain.Book;
import com.yc.springcloud812.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("book")
public class Bookcontroller {

    //注入service
    @Autowired
    private BookService bookservice;
    @Resource
    private DiscoveryClient discoveryClient;
    private void show(){
        System.out.println( this.discoveryClient.description() );

        //EurekaDiscoveryClient
        EurekaDiscoveryClient edc=(EurekaDiscoveryClient)this.discoveryClient;
        // 服务器上有有很多服务
        List<String> servicesName=edc.getServices();
        for( String sn:servicesName ){
            System.out.println("服务名:"+ sn );
            List<ServiceInstance> instances=edc.getInstances(  sn );
            for(  ServiceInstance si:instances ){
                System.out.println(  si.getScheme()+" "+  si.getHost() +" "+si.getPort()+" "+ si.getUri()  );
            }
        }
    }
    @GetMapping("{id}")

    public Book getBook(@PathVariable("id") Integer id){
        show();
        return bookservice.getBook(id);
    }
    @GetMapping("findAll")
    public List<Book> findAll(){
        return this.bookservice.findAll();
    }

}
