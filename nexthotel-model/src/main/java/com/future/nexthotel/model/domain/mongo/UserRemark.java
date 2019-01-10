package com.future.nexthotel.model.domain.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/7
 * @time 5:18 PM
 **/
@Document(collection = "nexthoteluserremark")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRemark {
    @Id
    @JsonProperty("_id")
    private String id;
    /**
     * 备注内容
     */
    private String text;
    /**
     * 创建时间
     */
    private Long createAt;
    /**
     * 顾客id
     */
    private String userId;
    /**
     * 创建员工ID
     */
    private String workerId;
}
