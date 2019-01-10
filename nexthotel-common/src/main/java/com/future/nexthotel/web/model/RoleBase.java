package com.future.nexthotel.web.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/9
 * @time 4:43 PM
 **/
@Document
@Data
public class RoleBase {

    private String phone;
    private Long createAt;
    private String userType;
}
