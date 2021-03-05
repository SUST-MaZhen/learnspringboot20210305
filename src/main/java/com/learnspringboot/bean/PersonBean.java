package com.learnspringboot.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @ClassName PersonBean
 * @Author User
 * @date 2021.03.02 14:05
 */
@ApiModel(value = "PersonBean", description = "PersonBean返回对象")
public class PersonBean {
    @ApiModelProperty(value="人的类型", name="type", example="she-males", required = true)
    private String type;
    @ApiModelProperty(value="人的描述", name="description", example="不是男人也不是女人")
    private String description;

    public PersonBean(){}

    public PersonBean(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "type:'" + type + '\'' +
                ", description:'" + description + '\'' +
                '}';
    }
}
