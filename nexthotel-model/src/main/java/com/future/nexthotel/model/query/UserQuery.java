package com.future.nexthotel.model.query;

import lombok.Data;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/27
 * @time 2:14 PM
 **/
@Data
public class UserQuery {
    private String cardId;
    private String phone;
    private String firstName;
    private String lastName;
}
