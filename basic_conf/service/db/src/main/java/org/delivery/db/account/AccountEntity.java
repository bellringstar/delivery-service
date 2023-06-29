package org.delivery.db.account;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@Data
@EqualsAndHashCode(callSuper = true) //객체비교시 사용되는데 부모에 있는 값까지 포함해서 비교
@SuperBuilder //부모가 가지고있는 변수도 빌드 가능
public class AccountEntity extends BaseEntity {
}
