package com.future.nexthotel.model.domain.mongo.role;

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
 * @date 2019/1/8
 * @time 12:05 PM
 **/
@Document(collection = "nexthotelworkers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelWorker extends RoleBase {
    @Id
    @JsonProperty("_id")
    private String id;
    /**
     * 员工编号
     */
    private String workerId;

    /**
     * 员工姓名
     */
    private String workerName;
}
