package com.Titan.throne.springBoot_rest.model;



import java.util.List;

import com.Titan.throne.springBoot_rest.StringListConverter;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class JobPost {
    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;
    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "json")
    private List<String> postTechStack;


//    public String getPostDesc() {
//        return postDesc;
//    }
//
//    public void setPostDesc(String postDesc) {
//        this.postDesc = postDesc;
//    }
//
//    public String getPostProfile() {
//        return postProfile;
//    }
//
//    public void setPostProfile(String postProfile) {
//        this.postProfile = postProfile;
//    }
//
//    public List<String> getPostTechStack() {
//        return postTechStack;
//    }
//
//    public void setPostTechStack(List<String> postTechStack) {
//        this.postTechStack = postTechStack;
//    }
//
//    public Integer getReqExperience() {
//        return reqExperience;
//    }
//
//    public void setReqExperience(Integer reqExperience) {
//        this.reqExperience = reqExperience;
//    }
//
    public int getPostId() {
        return postId;
    }
//
//    public void setPostId(int postId) {
//        this.postId = postId;
//    }
}
