package com.learnspringboot.controller;

import com.learnspringboot.bean.PersonBean;
import com.learnspringboot.service.IPerson;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


/**
 * @Description
 * @ClassName PersonController
 * @Author User
 * @date 2021.03.01 21:48
 */
@RestController
@RequestMapping("api/v1/person")
@Api(value = "Restful接口文档",tags = "PersonController", description = "人类信息接口")
public class PersonController {

    @Qualifier("womenService")
    @Autowired
    private IPerson womenService;

    @Qualifier("manService")
    @Autowired
    private IPerson manService;

    @GetMapping("/getRealPersonM1")
    @ApiOperation(value = "GET通过query参数方法获取人的本质", notes = "参数形式为?xx=xx1&yy=yy1")
    @ApiImplicitParam(name = "type", value = "类型：women或者man", required = true, dataType = "String", paramType = "query")
    public PersonBean getRealPersonM1(@RequestParam(value = "type", required = true) String type) {
        System.out.println("request:"+"api/v1/person/getRealPersonM1");
        String introduce = null;

        if(type.equals("women")) {
            introduce = womenService.introducePerson();
        }else if(type.equals("man")) {
            introduce = manService.introducePerson();
        }else {
            introduce = "类型错误";
        }
        return new PersonBean(type, introduce);
    }

    @GetMapping("/getRealPersonM2/{type}")
    @ApiOperation(value = "GET通过路径参数获取人的本质", notes = "参数形式为/path/param")
    @ApiImplicitParam(name = "type", value = "类型：women或者man", required = true, paramType = "path")
    public PersonBean getRealPersonM2(@PathVariable("type") String type) {
        System.out.println("request:"+"api/v1/person/getRealPersonM2/{type}");
        String introduce = null;

        if(type.equals("women")) {
            introduce = womenService.introducePerson();
        }else if(type.equals("man")) {
            introduce = manService.introducePerson();
        }else {
            introduce = "类型错误";
        }
        return new PersonBean(type, introduce);
    }

    @PostMapping("/setPersonTypeM1")
    @ApiOperation(value = "POST通过请求体参数增加一种人", notes = "参数形式为{xx:xx1,yy:yy1}")
    public String setPersonTypeM1(@RequestBody() PersonBean person){
          System.out.println("request:"+"api/v1/person/setPersonTypeM1");
        return new PersonBean(person.getType(), person.getDescription()).toString();
    }

    @PostMapping("/setPersonTypeM2")
    @ApiOperation(value = "POST通过query参数增加一种人", notes = "参数形式为/path?xx=xx1&yy=yy1")
    public String setPersonTypeM2(@RequestParam(value = "type", required = true) String type, @RequestParam(value = "description", required = false) String description){
        System.out.println("request:"+"api/v1/person/setPersonTypeM2");
        return new PersonBean(type, description).toString();
    }

}
