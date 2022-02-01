package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

//    URI versioning
    @GetMapping(value="/person/param")
    public PersonV1 personV1(){
        return  new PersonV1("Bob Charlie");
    }

    @GetMapping(value="/person/param" )
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

//    Request parameter versioning
//    localhost:8080/person/param?version=2
    @GetMapping(value="/person/param", params="version=1")
    public PersonV1 paramV1(){
        return  new PersonV1("Bob Charlie");
    }

    @GetMapping(value="/person/param", params="version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

//    Header versioning
    @GetMapping(value="/person/header", headers="X-API-VERSION=1")
    public PersonV1 headerV1(){
        return  new PersonV1("Bob Charlie");
    }

    @GetMapping(value="/person/header", headers="X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

//    Main type versioning / Accept versioning / content negotiation
    @GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return  new PersonV1("Bob Charlie");
    }

    @GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
