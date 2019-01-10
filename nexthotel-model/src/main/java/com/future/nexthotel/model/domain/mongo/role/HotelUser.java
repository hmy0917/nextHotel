package com.future.nexthotel.model.domain.mongo.role;

import javax.validation.constraints.NotNull;

import com.future.nexthotel.web.model.RoleBase;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/10/30
 * @time 6:32 PM
 **/

@Document(collection = "nexthotelusers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelUser extends RoleBase {
    @Id
    @JsonProperty("_id")
    private String id;

    @NotNull(message = "用户名不能为空")
    private String userName;
    @NotNull(message = "密码不能为空")
    private String password;
    /**
     * 身份证ID 进行加密后存储
     */
    private String cardId;
    private String lastName;
    private String firstName;
    private Long birthday;
}
