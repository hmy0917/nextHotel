package com.future.nexthotel.model.domain.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
public class HotelUser {
    @Id
    @JsonProperty("_id")
    private String id;
    private String userName;
    private String userPassword;


}
